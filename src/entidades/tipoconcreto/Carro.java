/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.tipoconcreto;

import entidades.EVeiculo;
import java.util.List;
import persistencia.PVeiculo;
import util.tipoabstrato.TipoAbstrato;

/**
 *
 * @author vitor
 */
public class Carro extends TipoAbstrato {

    public Carro() {
        codigo = 1;
        descricao = "CARRO";
    }
    
    @Override
    public List<EVeiculo> getListaDeVeiculos() {
        try {
            return new PVeiculo().consultaPorTipo(descricao);
        } catch (Exception e) {
            return null;
        }
    }
    
}
