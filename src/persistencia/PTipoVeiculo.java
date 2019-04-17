/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 *
 * @author vitor
 */
public class PTipoVeiculo {
    
    public List<String> consultaDescricao() {
        String sql = "SELECT descricao FROM teletransporte.tipo_veiculo order by codigo;";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<String> listTipoVeiculo = new ArrayList<>();

            while (rs.next()) {
                String tipoVeiculo = rs.getString("descricao");

                listTipoVeiculo.add(tipoVeiculo);
            }

            Conexao.fechar(conexao, stmt, rs);
            return listTipoVeiculo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PTipoVeiculo, método consultaDescricao = " + e.getMessage());
        }
        return null;
    }
}
