
package Classes;

import ClassesDados.VendedorSQL;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Vendedor extends Pessoa {
    
    private float salario;
    
    public void setSalario(Float salario){
        this.salario = salario;
    }
    public float getSalario(){
        return salario;
    }
    
    public void addVendedor(Vendedor obj){
        VendedorSQL objSQL = new VendedorSQL();
        objSQL.addVendedor(obj);
    }
    
    public void updateVendedor(Vendedor obj){
        VendedorSQL objSQL = new VendedorSQL();
        objSQL.updateVendedor(obj);
    }
      
    public void searchVendedor(JTable grid, String filtro, String pesquisa){
        VendedorSQL objSQL = new VendedorSQL();
        objSQL.searchVendedor(grid, filtro, pesquisa);
    }
    
    public void searchSalario(int id, JTextField txtSalario){
        VendedorSQL objSQL = new VendedorSQL();
        objSQL.searchSalario(id, txtSalario);
    }
    
}
