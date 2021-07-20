
package ClassesDados;
import Classes.Produto;
import static ClassesDados.ConexaoDB.con;
import static ClassesDados.ConexaoDB.resultado;
import static ClassesDados.ConexaoDB.stm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lucas
 */
public class ProdutoSQL extends ConexaoDB{
    
    public void addProduto(Produto obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec addProduto ?,?,?,?,?");
            comando.setString(1, obj.getDescricao());
            comando.setInt(2, obj.getEstoque());
            comando.setString(3, obj.getTamanho());
            comando.setFloat(4, obj.getValorCompra());
            comando.setFloat(5, obj.getValorVenda());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateProduto(Produto obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec altProduto ?,?,?,?,?,?,?");
            comando.setInt(1, obj.getProdutoId());
            comando.setString(2, obj.getDescricao());
            comando.setInt(3, obj.getEstoque());
            comando.setString(4, obj.getTamanho());
            comando.setFloat(5, obj.getValorCompra());
            comando.setFloat(6, obj.getValorVenda());
            comando.setInt(7, 1);
            comando.execute();  
            stm.close();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delProduto(Produto obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec excluirProduto ?");
            comando.setInt(1, obj.getProdutoId());
            comando.execute(); 
            stm.close();
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchProduto(JTable grid, String filtro, String pesquisa, boolean compra){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String query ="";
        String sql ="";
        int casaDecimal;
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
            if (compra){
                grid.getColumnModel().getColumn(3).setHeaderValue("Valor de Compra");
                query = "select codigo, descricao, tamanho, valorCompra, estoque from produtos " +
                                    "where produtos.status = 1 and %s like ?";
            }else{
                grid.getColumnModel().getColumn(3).setHeaderValue("Valor de Venda");
                query = "select codigo, descricao, tamanho, valorCompra, valorVenda, estoque from produtos " +
                                    "where produtos.status = 1 and %s like ?";
            }
            
            sql = String.format(query, filtro);
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setString(1, "%"+pesquisa+"%");
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                
                if (compra) {
                    String valorCProduto = resultado.getObject("valorCompra").toString().replace(".",",");
                    casaDecimal = valorCProduto.length() - 2;
                    valorCProduto = valorCProduto.substring(0, casaDecimal);


                    jTabela.addRow(new Object[]{resultado.getObject("codigo").toString(),
                                                resultado.getObject("descricao").toString(),
                                                resultado.getObject("tamanho").toString(),
                                                valorCProduto,
                                                resultado.getObject("estoque").toString()
                                                }
                                   );
                }else{
                    String valorVProduto = resultado.getObject("valorVenda").toString().replace(".",",");
                    casaDecimal = valorVProduto.length() - 2;
                    valorVProduto = valorVProduto.substring(0, casaDecimal);

                    jTabela.addRow(new Object[]{resultado.getObject("codigo").toString(),
                                                resultado.getObject("descricao").toString(),
                                                resultado.getObject("tamanho").toString(),
                                                valorVProduto,
                                                resultado.getObject("estoque").toString()
                                                }
                                   );
                }
                    
                
            }

            stm.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Produto searchProdutoId(JTextField id){
        Produto objProd = new Produto();
        objProd.setEstoque(0);
        objProd.setProdutoId(Integer.parseInt(id.getText()));
        String sql;
        int casaDecimal;
        try{ 
            
            sql = "select descricao, tamanho, valorCompra, valorVenda, estoque from produtos " +
                                    "where produtos.status = 1 and codigo = ?";
            
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setInt(1, objProd.getProdutoId());
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                String valorCProduto = resultado.getObject("valorCompra").toString();
                casaDecimal = valorCProduto.length() - 2;
                valorCProduto = valorCProduto.substring(0, casaDecimal);
                
                String valorVProduto = resultado.getObject("valorVenda").toString();
                casaDecimal = valorVProduto.length() - 2;
                valorVProduto = valorVProduto.substring(0, casaDecimal);
                
                objProd.setDescricao(resultado.getObject("descricao").toString());
                objProd.setTamanho(resultado.getObject("tamanho").toString());
                objProd.setValorCompra(Float.parseFloat(valorCProduto));
                objProd.setValorVenda(Float.parseFloat(valorVProduto));
                objProd.setEstoque(Integer.parseInt(resultado.getObject("estoque").toString()));
            }
            
            stm.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        return objProd;
    }
    
    public String searchPrecoC(int id){
        String sql;
        int casaDecimal;
        String valorCProduto ="";
        try{ 
            sql = "select valorCompra from produtos " +
                                    "where produtos.status = 1 and codigo = ?";
            
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setInt(1, id);
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                
                valorCProduto = resultado.getObject("valorCompra").toString().replace(".",",");
                casaDecimal = valorCProduto.length() - 2;
                valorCProduto = valorCProduto.substring(0, casaDecimal);
                
            }
            
            stm.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        return valorCProduto;
    }
    public void aumentarEstoque(Produto obj){ 
        try {
            comando = con.prepareStatement("exec aumentarEstoque ?,?");
            comando.setInt(1, obj.getProdutoId());
            comando.setInt(2, obj.getEstoque());
            comando.execute();
            stm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public void baixarEstoque(Produto obj){ 
        try {
            comando = con.prepareStatement("exec baixarEstoque ?,?");
            comando.setInt(1, obj.getProdutoId());
            comando.setInt(2, obj.getEstoque());
            comando.execute();
            stm.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public int[] idProdCompraVenda(int id, int qtdItens, boolean compra){
        String sql ="";
        int retorno[] = new int[qtdItens];
        int i=0;
        try{ 
            if (compra) {
                sql = "select produto_id from produtos_compras " +
                                    "where compra_id = ?";
            }else{
                sql = "select produto_id from produtos_vendas " +
                                    "where venda_id = ?";
            }
            
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setInt(1, id);
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                    retorno[i]=Integer.parseInt(resultado.getObject("produto_id").toString());
                    i++;  
            }
            stm.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
        return retorno;
    }
}
