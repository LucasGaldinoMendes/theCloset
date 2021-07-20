
package Classes;

import ClassesDados.CompraSQL;
import javax.swing.JTable;

public class Compra {
    private int compraId;
    private String data;
    private float valor;
    private int fornecedorId;
    private int qtd;
    private float valorProduto;
    private int produtoId;
    private int status;
    
    public void setCompraId(int compraId){
        this.compraId = compraId;
    }
    public int getCompraId(){
        return compraId;
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
    public void setFornecedorId(int fornecedorId){
        this.fornecedorId = fornecedorId;
    }
    public int getFornecedorId(){
        return fornecedorId;
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
    
    public int addCompra(Compra obj){
        CompraSQL objSQL = new CompraSQL();
        return objSQL.addCompra(obj);
    }
    public void addProdCompra(Compra objProdutoCompra, int idCompra){
        CompraSQL objSQL = new CompraSQL();
        objSQL.addProdCompra(objProdutoCompra, idCompra);
    }
    public void searchCompra(JTable grid, String filtro, String pesquisa){
        CompraSQL objSQL = new CompraSQL();
        objSQL.searchCompra(grid, filtro, pesquisa);
    }
    public void searchCompraId(JTable grid, int id){
        CompraSQL objSQL = new CompraSQL();
        objSQL.searchCompraId(grid, id);
    }
    public void delCompra(Compra obj){
        CompraSQL objSQL = new CompraSQL();
        objSQL.delCompra(obj);
    }
    public float compraMes(JTable grid, String filtro1, String filtro2){
        CompraSQL objSQL = new CompraSQL();
        return objSQL.compraMes(grid, filtro1, filtro2);
    }
}
