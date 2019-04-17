/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author vitor
 */
public class EPassageiro {

    private Integer codigo;
    private String nome;
    private String telefone;
    private String sexo;
    private String rua;
    private String bairro;
    private String cidade;

    public EPassageiro(Integer codigo, String nome, String telefone, 
            String sexo, String rua, String bairro, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public EPassageiro() {}

    public EPassageiro(String nome, String telefone, String sexo, String rua, String bairro, String cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return codigo + "," + nome + "," 
                + telefone + "," + sexo + "," + rua + "," + bairro + "," + cidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


}
