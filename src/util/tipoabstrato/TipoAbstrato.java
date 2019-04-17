/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.tipoabstrato;

import entidades.EVeiculo;
import entidades.tipoconcreto.Carro;
import entidades.tipoconcreto.Moto;
import java.util.ArrayList;
import java.util.List;
import persistencia.PTipoVeiculo;

/**
 *
 * @author vitor
 */
public abstract class TipoAbstrato {
    
    protected int codigo;
    protected String descricao;

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static List<String> getListaDeTipos() {
        return new PTipoVeiculo().consultaDescricao();
    }
    
    public abstract List<EVeiculo> getListaDeVeiculos();
    
    public static TipoAbstrato getInstance(String tipo) {
        switch (tipo.toUpperCase()){
            case "CARRO":
                return new Carro();
            case "MOTO":
                return new Moto();
            default: return null;
        }
    }
    
    public static TipoAbstrato getInstance(int codigo) {
        switch (codigo){
            case 1:
                return new Carro();
            case 2:
                return new Moto();
            default: return null;
        }
    }
    
}
