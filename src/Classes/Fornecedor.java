
package Classes;
import ClassesDados.FornecedorSQL;
import javax.swing.JTable;

public class Fornecedor extends Pessoa {
    private String descricao;
    
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao (){
        return descricao;
    }
    
    public void addFornecedor (Fornecedor obj){
        FornecedorSQL objSQL = new FornecedorSQL();
        objSQL.addFornecedor(obj);
    }
    public void updateFornecedor (Fornecedor obj){
        FornecedorSQL objSQL = new FornecedorSQL();
        objSQL.updateFornecedor(obj);
    }
    public void delFornecedor (Fornecedor obj){
        FornecedorSQL objSQL = new FornecedorSQL();
        objSQL.delFornecedor(obj);
    }
     public void searchFornecedor(JTable grid, String filtro, String pesquisa){
        FornecedorSQL objSQL = new FornecedorSQL();
        objSQL.searchFornecedor(grid, filtro, pesquisa);
     }
}
