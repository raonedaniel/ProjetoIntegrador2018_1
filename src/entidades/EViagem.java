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
public class EViagem {

    private Integer codigo;
    private String origem;
    private String destino;
    private EPassageiro codigoPassageiro;
    private EMotorista codigoMotorista;
    private EVeiculo codigoVeiculo;
    private String dataViagem;

    public EViagem() {
    }

    public EViagem(String origem, String destino, EPassageiro codigoPassageiro, EMotorista codigoMotorista, EVeiculo codigoVeiculo, String dataViagem) {
        this.origem = origem;
        this.destino = destino;
        this.codigoPassageiro = codigoPassageiro;
        this.codigoMotorista = codigoMotorista;
        this.codigoVeiculo = codigoVeiculo;
        this.dataViagem = dataViagem;
    }

    public EViagem(Integer codigo, String origem, String destino, EPassageiro codigoPassageiro, EMotorista codigoMotorista, EVeiculo codigoVeiculo, String dataViagem) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.codigoPassageiro = codigoPassageiro;
        this.codigoMotorista = codigoMotorista;
        this.codigoVeiculo = codigoVeiculo;
        this.dataViagem = dataViagem;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public EPassageiro getCodigoPassageiro() {
        return codigoPassageiro;
    }

    public void setCodigoPassageiro(EPassageiro codigoPassageiro) {
        this.codigoPassageiro = codigoPassageiro;
    }

    public EMotorista getCodigoMotorista() {
        return codigoMotorista;
    }

    public void setCodigoMotorista(EMotorista codigoMotorista) {
        this.codigoMotorista = codigoMotorista;
    }

    public EVeiculo getCodigoVeiculo() {
        return codigoVeiculo;
    }

    public void setCodigoVeiculo(EVeiculo codigoVeiculo) {
        this.codigoVeiculo = codigoVeiculo;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    @Override
    public String toString() {
        return codigo + "," + origem + "," + destino
                + "," + codigoPassageiro + "," + codigoMotorista + "," + codigoVeiculo + ","
                + dataViagem;
    }

}
