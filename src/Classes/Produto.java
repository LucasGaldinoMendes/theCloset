
package Classes;

import ClassesDados.ProdutoSQL;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Produto {
    private int produtoId;
    private String descricao;
    private int estoque;
    private String tamanho;
    private float valorVenda;
    private float valorCompra;
    private int status;
    
    public void setProdutoId(int produtoId){
        this.produtoId = produtoId;
    }
    public int getProdutoId (){
        return produtoId;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    public int getEstoque(){
        return estoque;
    }
    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }
    public String getTamanho(){
        return tamanho;
    }
    public void setValorCompra(float valorCompra){
        this.valorCompra = valorCompra;
    }
    public float getValorCompra(){
        return valorCompra;
    }
    public void setValorVenda(float valorVenda){
        this.valorVenda = valorVenda;
    }
    public float getValorVenda(){
        return valorVenda;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
    
    public void addProduto(Produto obj){
        ProdutoSQL objSQL = new ProdutoSQL();
        objSQL.addProduto(obj);
    }
    public void updateProduto (Produto obj){
        ProdutoSQL objSQL = new ProdutoSQL();
        objSQL.updateProduto(obj);
    }
    public void delProduto (Produto obj){
        ProdutoSQL objSQL = new ProdutoSQL();
        objSQL.delProduto(obj);
    }
    public void searchProduto (JTable grid, String filtro, String pesquisa, boolean compra){
        ProdutoSQL objSQL = new ProdutoSQL();
        objSQL.searchProduto(grid, filtro, pesquisa, compra);
    }
    public Produto searchProdutoId(JTextField id){
        ProdutoSQL objSQL = new ProdutoSQL();
        return objSQL.searchProdutoId(id);
    }
    public String searchPrecoC(int id){
        ProdutoSQL objSQL = new ProdutoSQL();
        return objSQL.searchPrecoC(id);
    }
    public void aumentarEstoque(Produto obj){ 
        ProdutoSQL objSQL = new ProdutoSQL();
        objSQL.aumentarEstoque(obj);
    }
    public void baixarEstoque(Produto obj){ 
        ProdutoSQL objSQL = new ProdutoSQL();
        objSQL.baixarEstoque(obj);
    }
    public int[] idProdCompraVenda(int id, int qtdItens, boolean compra){
        ProdutoSQL objSQL = new ProdutoSQL();
        return objSQL.idProdCompraVenda(id, qtdItens, compra);
    }
}
