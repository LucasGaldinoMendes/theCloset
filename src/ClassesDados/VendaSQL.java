
package ClassesDados;

import Classes.Venda;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import microsoft.sql.Types;

public class VendaSQL extends ConexaoDB{
    public int addVenda(Venda obj){  
        int idVenda = 0;
        try{          
            CallableStatement cs = con.prepareCall( " exec addVenda ?,?,?,? ");
            cs.setString(1, obj.getCpf());
            cs.setFloat(2, obj.getValor());
            cs.setInt(3, obj.getVendedorId());
            cs.registerOutParameter("venda_id", java.sql.Types.INTEGER);
            cs.execute();
            idVenda = cs.getInt("venda_id");
            stm.close();           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);    
        }
        return idVenda;
    }
    
    public void addProdVenda(Venda objProdutoVenda, int idVenda){
        try{  
            comando = con.prepareStatement("exec addProdutoVenda ?,?,?,?");
            comando.setInt(1, objProdutoVenda.getQtd());
            comando.setFloat(2, objProdutoVenda.getValorProduto());
            comando.setInt(3, objProdutoVenda.getProdutoId());
            comando.setInt(4,idVenda );
            comando.execute();
            stm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);     
        }     
    }
    
    public void baixarEstoque(Venda objProdutoVenda){ 
        try {
            comando = con.prepareStatement("exec baixarEstoque ?,?");
            comando.setInt(1, objProdutoVenda.getProdutoId());
            comando.setInt(2, objProdutoVenda.getQtd());
            comando.execute();
            stm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);      
        }
        
    }
    
    public void searchVenda(JTable grid, String filtro, String pesquisa){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String query ="", sql ="", data, dataFormatada, hora;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            query = "select v.id, cpf, data, valor, nome from vendas v " +
                        " inner join  pessoas p" +
                        " on v.vendedor_id = p.id " +
                            " where v.status = 1 and %s like ?";
            sql = String.format(query, filtro);
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setString(1, "%"+pesquisa+"%");
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                String valorVenda = resultado.getObject("valor").toString().replace(".",",");
                int casaDecimal = valorVenda.length() - 2;
                valorVenda = valorVenda.substring(0, casaDecimal);
                data = resultado.getObject("data").toString();
                dataFormatada = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4) ;
                hora = data.substring(11, 13)+":"+data.substring(14, 16);
                
                jTabela.addRow(new Object[]{resultado.getObject("id").toString(),
                                            resultado.getObject("cpf").toString(),
                                            valorVenda,
                                            resultado.getObject("nome").toString(),
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
    
    public void searchVendaId(JTable grid, int id){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String sql ="";
        int i = 1, qtd = 0;
        float valorTotal = 0;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            sql = "select descricao, qtd, valor from produtos_vendas pv " +
                        " inner join  produtos p" +
                        " on pv.produto_id = p.codigo " +
                            " where venda_id = ?";
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
                                            String.valueOf(valorTotal).replace(".", ",")+"0"
                                           }
                               );
            }

            stm.close();
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public void delVenda(Venda obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec excluirVenda ?");
            comando.setInt(1, obj.getVendaId());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Venda excluída com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }       
    }
    public float vendaMes(JTable grid, String filtro1, String filtro2){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String sql ="", data = "", hora = "", dataFormatada = "";
        float total = 0;
        int i = 1,qtd = 0;
        float valorTotal = 0;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            sql =   "select v.id, cpf, data, valor, nome from vendas v " +
                        " inner join  pessoas p" +
                        " on v.vendedor_id = p.id " +
                            " where v.status = 1 and data between ? and ? ";
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setTimestamp(1, java.sql.Timestamp.valueOf(filtro1));
            comando.setTimestamp(2, java.sql.Timestamp.valueOf(filtro2));
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                valorTotal += Float.parseFloat(resultado.getObject("valor").toString());
                String valorVenda = resultado.getObject("valor").toString().replace(".",",");
                int casaDecimal = valorVenda.length() - 2;
                valorVenda = valorVenda.substring(0, casaDecimal);
                data = resultado.getObject("data").toString();
                dataFormatada = data.substring(8, 10)+"/"+data.substring(5, 7)+"/"+data.substring(0, 4) ;
                hora = data.substring(11, 13)+":"+data.substring(14, 16);
                
                jTabela.addRow(new Object[]{resultado.getObject("id").toString(),
                                            resultado.getObject("cpf").toString(),
                                            valorVenda,
                                            resultado.getObject("nome").toString(),
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
