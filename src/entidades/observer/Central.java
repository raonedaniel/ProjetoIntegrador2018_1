/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.observer;

import java.util.ArrayList;
import java.util.List;
import util.interfaces.observer.Observador;
import util.interfaces.observer.Sujeito;

/**
 *
 * @author vitor
 */
public class Central implements Sujeito {

    private List<Observador> lista;
    private DadosDeViagem dados;

    public Central() {
        lista = new ArrayList<>();
    }

    @Override
    public void incluir(Observador obs) {
        lista.add(obs);
    }

    @Override
    public void excluir(Observador obs) {
        if (lista.contains(obs)) {
            lista.remove(obs);
        }
    }

    @Override
    public void notificar() {
        for (int i = 0; i < lista.size(); i++) {
            Observador obs = lista.get(i);
            obs.atualizar(dados);
        }
    }

    @Override
    public List<Observador> listar() {
        return lista;
    }

    public void setDados(DadosDeViagem dados) {
        this.dados = dados;
        notificar();
    }
    
}
