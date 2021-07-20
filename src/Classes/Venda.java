
package Classes;

import ClassesDados.VendaSQL;
import javax.swing.JTable;

public class Venda {
    private int vendaId;
    private String cpf;
    private String data;
    private float valor;
    private int vendedorId;
    private int qtd;
    private float valorProduto;
    private int produtoId;
    private int status;
    
    public void setVendaId(int vendaId){
        this.vendaId = vendaId;
    }
    public int getVendaId(){
        return vendaId;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getCpf(){
        return cpf;
    }
    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return data;
    }
    public void setValor(float valor){
        this.valor = valor;
    }
    public float getValor(){
        return valor;
    }
    public void setVendedorId(int vendedorId){
        this.vendedorId = vendedorId;
    }
    public int getVendedorId(){
        return vendedorId;
    }
    public void setQtd(int qtd){
        this.qtd = qtd;
    }
    public int getQtd(){
        return qtd;
    }
    public void setValorProduto(float valorProduto){
        this.valorProduto = valorProduto;
    }
    public float getValorProduto(){
        return valorProduto;
    }
    public void setProdutoId(int produtoId){
        this.produtoId = produtoId;
    }
    public int getProdutoId(){
        return produtoId;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
    
    public int addVenda(Venda obj){
        VendaSQL objSQL = new VendaSQL();
        return objSQL.addVenda(obj);
    }
    
    public void addProdVenda(Venda objProdutoVenda, int idVenda){
        VendaSQL objSQL = new VendaSQL();
        objSQL.addProdVenda(objProdutoVenda, idVenda);
    }
    
    public void searchVenda(JTable grid, String filtro, String pesquisa){
         VendaSQL objSQL = new VendaSQL();
         objSQL.searchVenda(grid, filtro, pesquisa);
    }
    
    public void searchVendaId(JTable grid, int id){
         VendaSQL objSQL = new VendaSQL();
         objSQL.searchVendaId(grid, id);
    }
    
    public void delVenda(Venda obj){
        VendaSQL objSQL = new VendaSQL();
        objSQL.delVenda(obj);
    }
    
    public float vendaMes(JTable grid, String filtro1, String filtro2){
        VendaSQL objSQL = new VendaSQL();
        return objSQL.vendaMes(grid, filtro1, filtro2);
    }
}
