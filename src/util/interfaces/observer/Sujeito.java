/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.interfaces.observer;

import java.util.List;

/**
 *
 * @author vitor
 */
public interface Sujeito {
    
    public void incluir(Observador obs);
    public void excluir(Observador obs);
    public void notificar();
    public List<Observador> listar();
}
