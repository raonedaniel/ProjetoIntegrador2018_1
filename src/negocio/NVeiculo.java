/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.EVeiculo;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import persistencia.PVeiculo;

/**
 *
 * @author vitor
 */
public class NVeiculo {

    public void salvar(EVeiculo veiculo, String valorCampo) throws SQLException {

        if (!"".equals(valorCampo)) {
            new PVeiculo().alterar(veiculo);
        } else {
            new PVeiculo().gravar(veiculo);
        }
    }

    public void excluir(EVeiculo veiculo) throws SQLException {
        new PVeiculo().excluir(veiculo);
    }

    public Iterator<EVeiculo> consultaPorFiltro(boolean opcao, String nome) throws SQLException {
        return new PVeiculo().consultaPorFiltro(opcao, nome);
    }

    public EVeiculo consultaPorCodigo(int codigo) throws SQLException {
        return new PVeiculo().consultaPorCodigo(codigo);
    }

    public List<EVeiculo> consultaPorTipo(String descricao) throws SQLException {
        return new PVeiculo().consultaPorTipo(descricao);
    }
    
    public Iterator<EVeiculo> listar() throws SQLException {
        return new PVeiculo().consultaTudo();
    }
}
