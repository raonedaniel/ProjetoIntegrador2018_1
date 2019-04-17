/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import util.tipoabstrato.TipoAbstrato;

/**
 *
 * @author vitor
 */
public class EVeiculo {

    private Integer codigo;
    private String nome; // Colocar marca e nome do carro
    private String modelo; // ex: 2010/2011
    private String cor;
    private String placa;
    private TipoAbstrato tipoVeiculo;
    
    public EVeiculo() {
    }

    public EVeiculo(Integer codigo, String nome, String modelo, String cor, 
            String placa, TipoAbstrato tipoVeiculo) {
        this.codigo = codigo;
        this.nome = nome;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    public EVeiculo(String nome, String modelo, String cor, String placa, TipoAbstrato tipoVeiculo) {
        this.nome = nome;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoAbstrato getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = TipoAbstrato.getInstance(tipoVeiculo);
    }

}
