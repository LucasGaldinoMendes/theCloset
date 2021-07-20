package ClassesDados;


import Classes.Compra;
import static ClassesDados.ConexaoDB.con;
import static ClassesDados.ConexaoDB.stm;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;

/**
 *
 * @author Lucas
 */
public class CompraSQL extends ConexaoDB{
    
    public int addCompra(Compra obj){
        int idCompra = 0; 
        try{
            CallableStatement cs = con.prepareCall( " exec addCompra ?,?,? ");
            cs.setFloat(1, obj.getValor());
            cs.setInt(2, obj.getFornecedorId());
            cs.registerOutParameter("compra_id", java.sql.Types.INTEGER);
            cs.execute();
            idCompra = cs.getInt("compra_id");
            stm.close();    
            JOptionPane.showMessageDialog(null, "Compra cadastrada com sucesso!");  
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        } 
        return idCompra;
    }
    public void addProdCompra(Compra objProdutoCompra, int idCompra){
        try{  
            comando = con.prepareStatement("exec addProdutoCompra ?,?,?,?");
            comando.setInt(1, objProdutoCompra.getQtd());
            comando.setFloat(2, objProdutoCompra.getValorProduto());
            comando.setInt(3, objProdutoCompra.getProdutoId());
            comando.setInt(4,idCompra );
            comando.execute();
            stm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }     
    }
    
    public void searchCompra(JTable grid, String filtro, String pesquisa){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String query ="", sql ="", data, dataFormatada, hora;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            query = "select compras.id, data, valor, nome from compras " +
                        " inner join  pessoas " +
                        " on compras.fornecedor_id = pessoas.id " +
                            " where compras.status = 1 and %s like ?";
            sql = String.format(query, filtro);
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setString(1, "%"+pesquisa+"%");
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                String valorCompra = resultado.getObject("valor").toString().replace(".",",");
                int casaDecimal = valorCompra.length() - 2;
                valorCompra = valorCompra.substring(0, casaDecimal);
                data = resultado.getObject("data").toString();
                dataFormatada = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4) ;
                hora = data.substring(11, 13)+":"+data.substring(14, 16);
                jTabela.addRow(new Object[]{resultado.getObject("id").toString(),
                                            resultado.getObject("nome").toString(),
                                            valorCompra,
                                            dataFormatada,
                                            hora                                                        
                                            }
                               );
            }

            stm.close();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchCompraId(JTable grid, int id){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String sql ="";
        int i = 1,qtd = 0;
        float valorTotal = 0;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            sql = "select descricao, qtd, valor from produtos_compras pc " +
                        " inner join  produtos p" +
                        " on pc.produto_id = p.codigo " +
                            " where compra_id = ?";
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setInt(1, id);
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                qtd = Integer.parseInt(resultado.getObject("qtd").toString());
                valorTotal = qtd * Float.parseFloat(resultado.getObject("valor").toString());
                String valorProduto = resultado.getObject("valor").toString().replace(".",",");
                int casaDecimal = valorProduto.length() - 2;
                valorProduto = valorProduto.substring(0, casaDecimal);
                jTabela.addRow(new Object[]{i++,
                                            resultado.getObject("descricao").toString(),
                                            qtd,
                                            valorProduto,
                                            valorTotal
                                           }
                               );
            }

            stm.close();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delCompra(Compra obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec excluirCompra ?");
            comando.setInt(1, obj.getCompraId());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Compra excluída com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public float compraMes(JTable grid, String filtro1, String filtro2){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String sql ="", data = "", hora = "", dataFormatada = "";
        float total = 0;
        int i = 1,qtd = 0;
        float valorTotal = 0;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            sql = 
                    "select compras.id, data, valor, nome from compras " +
                        " inner join  pessoas " +
                        " on compras.fornecedor_id = pessoas.id " +
                            " where compras.status = 1 and data between ?  and ? ";
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setTimestamp(1, java.sql.Timestamp.valueOf(filtro1));
            comando.setTimestamp(2, java.sql.Timestamp.valueOf(filtro2));
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                String valorCompra = resultado.getObject("valor").toString().replace(".",",");
                int casaDecimal = valorCompra.length() - 2;
                valorCompra = valorCompra.substring(0, casaDecimal);
                valorTotal += Float.parseFloat(resultado.getObject("valor").toString());
                data = resultado.getObject("data").toString();
                dataFormatada = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4) ;
                hora = data.substring(11, 13)+":"+data.substring(14, 16);
                jTabela.addRow(new Object[]{resultado.getObject("id").toString(),
                                            resultado.getObject("nome").toString(),
                                            valorCompra,
                                            dataFormatada,
                                            hora                                                        
                                            }
                               );
            }

            stm.close();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        return valorTotal;
    }
}
