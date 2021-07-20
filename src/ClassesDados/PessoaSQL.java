
package ClassesDados;

import Classes.Pessoa;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucas
 */
public class PessoaSQL extends ConexaoDB{
    public void delPessoa(Pessoa obj){
        try{
            PreparedStatement comando = null;
            comando = con.prepareStatement("exec excluirPessoa ?");
            comando.setInt(1, obj.getPessoaId());
            comando.execute();
            stm.close();
            JOptionPane.showMessageDialog(null, "A pessoa foi excluída com sucesso","Informativo",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro +" + e,"Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
