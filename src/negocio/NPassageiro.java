/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.EPassageiro;
import java.sql.SQLException;
import java.util.Iterator;
import persistencia.PPassageiro;

/**
 *
 * @author vitor
 */
public class NPassageiro {

    public void salvar(EPassageiro passageiro, String valorCampo) throws SQLException {

        if (!"".equals(valorCampo)) {
            new PPassageiro().alterar(passageiro);
        } else {
            new PPassageiro().gravar(passageiro);
        }
    }

    public void excluir(EPassageiro passageiro) throws SQLException {
        new PPassageiro().excluir(passageiro);
    }

    public Iterator<EPassageiro> consultaPorFiltro(boolean opcao, String filtro) throws SQLException {
        return new PPassageiro().consultaPorFiltro(opcao, filtro);
    }

    public Iterator<EPassageiro> listar() throws SQLException  {
        return new PPassageiro().consultaTudo();
    }
    
    public EPassageiro consultaPorCodigo(int codigo) throws SQLException {
        return new PPassageiro().consultaPorCodigo(codigo);
    }
    
}
