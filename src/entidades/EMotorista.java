/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import entidades.observer.Central;
import entidades.observer.DadosDeViagem;
import util.interfaces.observer.MostrarDados;
import util.interfaces.observer.Observador;

/**
 *
 * @author vitor
 */
public class EMotorista implements Observador, MostrarDados {

    private Integer codigo;
    private String nome;
    private String telefone;
    private String sexo;
    private String rua;
    private String bairro;
    private String cidade;
    private String cnh;
    private Central central;
    private DadosDeViagem dados;

    public EMotorista(Central central) {
        this.central = central;
        this.central.incluir(this);
    }

    public EMotorista(Integer codigo, String nome, String telefone,
            String sexo, String rua, String bairro, String cidade, String cnh) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cnh = cnh;
    }

    public EMotorista() {
    }

    public EMotorista(String nome, String telefone, String sexo, String rua,
            String bairro, String cidade, String cnh) {
        this.nome = nome;
        this.telefone = telefone;
        this.sexo = sexo;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return codigo + "," + nome + "," + telefone + "," + sexo + "," + rua + "," + bairro
                + "," + cidade + "," + cnh;
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

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public void atualizar(DadosDeViagem dados) {
        this.dados = dados;
        mostrar();
    }

    @Override
    public void mostrar() {
        System.out.println();
        System.out.println("------//--------//------");
        System.out.println("        Central         ");
        System.out.println("");
        System.out.println("Motorista " + dados.getMotorista().getNome() + ",");
        System.out.print("você foi alocado para buscar o passageiro " + 
                dados.getPassageiro().getNome() + " na ");
        System.out.println("origem: " + dados.getOrigem());
        System.out.println(" e leva-lo ao destino: " + dados.getDestino());
        System.out.println("------//--------//------");
    }

}
