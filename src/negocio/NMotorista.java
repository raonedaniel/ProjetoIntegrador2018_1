/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.EMotorista;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import persistencia.PMotorista;

/**
 *
 * @author vitor
 */
public class NMotorista {

    public void salvar(EMotorista motorista, String valorCampo) throws SQLException {

        if (!"".equals(valorCampo)) {
            new PMotorista().alterar(motorista);
        } else {
            new PMotorista().gravar(motorista);
        }
    }

    public void excluir(EMotorista motorista) throws SQLException {
        new PMotorista().excluir(motorista);
    }

    public Iterator<EMotorista> consultaPorFiltro(boolean opcao, String filtro) throws SQLException {
        return new PMotorista().consultaPorFiltro(opcao, filtro);
    }

    public EMotorista consultaPorCodigo(int codigo) throws SQLException {
        return new PMotorista().consultaPorCodigo(codigo);
    }

    public Iterator<EMotorista> listar() throws SQLException {
        return new PMotorista().consultaTudo();
    }
}
