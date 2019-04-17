/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.observer;

import entidades.EMotorista;
import entidades.EPassageiro;
import entidades.EVeiculo;
import entidades.EViagem;

/**
 *
 * @author vitor
 */
public class DadosDeViagem {
    
    private EViagem dados;

    public DadosDeViagem(EViagem dados) {
        this.dados = dados;
    }
    
    public EMotorista getMotorista(){
        return dados.getCodigoMotorista();
    }
    
    public EPassageiro getPassageiro(){
        return dados.getCodigoPassageiro();
    }
    
    public EVeiculo getVeiculo(){
        return dados.getCodigoVeiculo();
    }
    
    public String getOrigem() {
        return dados.getOrigem();
    }
    
    public String getDestino() {
        return dados.getDestino();
    }
}
