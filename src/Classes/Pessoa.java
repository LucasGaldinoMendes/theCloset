/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import ClassesDados.PessoaSQL;

public class Pessoa {
    private int pessoaId;
    private String nome;
    private String documento;
    private String telefone;
    private int status;
    
    public void setPessoaId(int pessoaId){
        this.pessoaId = pessoaId;
    }
    public int getPessoaId(){
        return pessoaId;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setDocumento(String documento){
        this.documento = documento;
    }
    public String getDocumento(){
        return documento;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return status;
    }
    
    public void delPessoa(Pessoa obj){
        PessoaSQL objSQL = new PessoaSQL();
        objSQL.delPessoa(obj);
    }
}
