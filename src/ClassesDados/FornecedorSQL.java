
package ClassesDados;

import Classes.Fornecedor;
import static ClassesDados.ConexaoDB.con;
import static ClassesDados.ConexaoDB.resultado;
import static ClassesDados.ConexaoDB.stm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FornecedorSQL extends ConexaoDB{
    
    public void addFornecedor(Fornecedor obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec addFornecedor ?,?,?,?");
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getDocumento());
            comando.setString(3, obj.getTelefone());
            comando.setString(4, obj.getDescricao());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
         }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    public void updateFornecedor(Fornecedor obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec altFornecedor ?,?,?,?,?,?");
            comando.setInt(1, obj.getPessoaId());
            comando.setString(2, obj.getNome());
            comando.setString(3, obj.getDocumento());
            comando.setString(4, obj.getTelefone());
            comando.setInt(5, 1);
            comando.setString(6, obj.getDescricao());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delFornecedor(Fornecedor obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec excluirFornecedor ?");
            comando.setInt(1, obj.getPessoaId());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchFornecedor(JTable grid, String filtro, String pesquisa){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String query ="";
        String sql ="";
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            query = "select id, nome, descricao,documento, telefone from fornecedores " +
                                                "inner join pessoas " +
                                                 "on pessoas.id = fornecedores.pessoa_id " +
                                                    "where pessoas.status = 1 and %s like ?";
            sql = String.format(query, filtro);
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setString(1, "%"+pesquisa+"%");
            this.resultado = comando.executeQuery();
            while(resultado.next()){

                jTabela.addRow(new Object[]{resultado.getObject("id").toString(),
                                            resultado.getObject("nome").toString(),
                                            resultado.getObject("descricao").toString(),
                                            resultado.getObject("documento").toString(),
                                            resultado.getObject("telefone").toString()
                                            }
                               );
            }

            stm.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
     
}
