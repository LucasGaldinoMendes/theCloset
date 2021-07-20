
package ClassesDados;
import Classes.Vendedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VendedorSQL extends ConexaoDB{
    
    public void addVendedor(Vendedor obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec addVendedor ?,?,?,?");
            comando.setString(1, obj.getNome());
            comando.setString(2, obj.getDocumento());
            comando.setString(3, obj.getTelefone());
            comando.setFloat(4, obj.getSalario());
            comando.execute();   
            stm.close();
            JOptionPane.showMessageDialog(null, "Vendedor cadastrado com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateVendedor(Vendedor obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec altVendedor ?,?,?,?,?,?");
            comando.setInt(1, obj.getPessoaId());
            comando.setString(2, obj.getNome());
            comando.setString(3, obj.getDocumento());
            comando.setString(4, obj.getTelefone());
            comando.setInt(5, 1);
            comando.setFloat(6, obj.getSalario());
            comando.execute(); 
            stm.close();
            JOptionPane.showMessageDialog(null, "Vendedor alterado com sucesso!","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    public void searchVendedor(JTable grid, String filtro, String pesquisa){
        DefaultTableModel jTabela = (DefaultTableModel)grid.getModel();
        String query ="";
        String sql ="";
        try{ 
        
            while(jTabela.getRowCount() > 0){
                jTabela.removeRow(0);
            }
        
            query = "select id, nome, documento, telefone from vendedores " +
                                                "inner join pessoas " +
                                                 "on pessoas.id = vendedores.pessoa_id " +
                                                    "where pessoas.status = 1 and %s like ?";
            sql = String.format(query, filtro);
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setString(1, "%"+pesquisa+"%");
            this.resultado = comando.executeQuery();
            while(resultado.next()){

                jTabela.addRow(new Object[]{resultado.getObject("id").toString(),
                                            resultado.getObject("nome").toString(),
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
    
    public void searchSalario(int id, JTextField txtSalario){
        String sql ="";
        try{       
            sql = "select salario from vendedores " +
                    "where pessoa_id = ?";
            
            PreparedStatement comando = null;
            comando = con.prepareStatement(sql); 
            comando.setInt(1, id);
            this.resultado = comando.executeQuery();
            while(resultado.next()){
                String salario = resultado.getObject("salario").toString().replace(".", ",");
                int tamanho = salario.length();
                salario = salario.substring(0, tamanho-2);
                txtSalario.setText(salario);
            }
            stm.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
}
