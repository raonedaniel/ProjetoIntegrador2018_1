/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.EViagem;
import java.sql.SQLException;
import java.util.Iterator;
import persistencia.PViagem;

/**
 *
 * @author vitor
 */
public class NViagem {

    public void salvar(EViagem viagem, String valorCampo) throws SQLException {

        if (!"".equals(valorCampo)) {
            new PViagem().alterar(viagem);
        } else {
            new PViagem().gravar(viagem);
        }
    }

    public void excluir(EViagem viagem) throws SQLException {
        new PViagem().excluir(viagem);
    }

    public Iterator<EViagem> consultaPorFiltro(boolean opcao, String filtro) throws SQLException {
        return new PViagem().consultaPorFiltro(opcao, filtro);
    }

    public Iterator<EViagem> listar() throws SQLException {
        return new PViagem().consultaTudo();
    }
}
