/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.EVeiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexao;
import util.tipoabstrato.TipoAbstrato;

/**
 *
 * @author vitor
 */
public class PVeiculo extends TPersistencia<EVeiculo> {

    @Override
    public void gravar(EVeiculo veiculo) {
        String sql = "INSERT INTO `teletransporte`.`veiculo` (`codigo`, `nome`, `modelo`, `cor`, `placa`, `tipo_veiculo`) "
                + "VALUES (" + veiculo.getCodigo() + ", '"
                + veiculo.getNome() + "', '"
                + veiculo.getModelo() + "', '"
                + veiculo.getCor() + "', '"
                + veiculo.getPlaca() + 
                "', " + veiculo.getTipoVeiculo().getCodigo() + ");";
        Connection conexao = Conexao.getConect();
        try {
            Statement stmt = conexao.createStatement();
            System.out.println(stmt.executeUpdate(sql));
            Conexao.fechar(conexao, stmt);
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método gravar = " + ex.getMessage());
        }
    }

    public void alterar(EVeiculo veiculo) {

        String sql = "UPDATE `teletransporte`.`veiculo` "
                + "SET `nome`='" + veiculo.getNome() + "', "
                + "`modelo`='" + veiculo.getModelo() + "', "
                + "`cor`='" + veiculo.getCor() + "', "
                + "`placa`='" + veiculo.getPlaca() +
                "', `tipo_veiculo`=" + veiculo.getTipoVeiculo().getCodigo()
                + " WHERE `codigo`=" + veiculo.getCodigo() + ";";

        this.alterarOuExcluir(true, veiculo, sql);
    }

    public void excluir(EVeiculo veiculo) {

        String sql = "DELETE FROM `teletransporte`.`veiculo` WHERE `codigo`='"
                + veiculo.getCodigo() + "';";

        this.alterarOuExcluir(false, veiculo, sql);
    }

    public List<EVeiculo> consultaPorTipo(String descricao) {
        String sql = "SELECT * FROM teletransporte.veiculo as v join"
                + " teletransporte.tipo_veiculo as tv on v.tipo_veiculo = tv.codigo "
                + "where upper(tv.descricao) like '%" + descricao + "%';";
        Connection conexao = Conexao.getConect();

        try {
            
            List<EVeiculo> listTipoVeiculo = new ArrayList<>();
            
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                listTipoVeiculo.add(new EVeiculo(rs.getInt("codigo"),
                        rs.getString("nome"), rs.getString("modelo"),
                        rs.getString("cor"), rs.getString("placa"), 
                        TipoAbstrato.getInstance((rs.getInt("tipo_veiculo") == 1) ? "Carro" : "Moto")));

            }

            Conexao.fechar(conexao, stmt, rs);
            return listTipoVeiculo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaporTipo = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Iterator<EVeiculo> consultaTudo() {
        String sql = "SELECT * FROM teletransporte.veiculo;";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<EVeiculo> listVeiculo = new ArrayList<>();

            while (rs.next()) {
                EVeiculo veiculo = new EVeiculo(rs.getInt("codigo"),
                        rs.getString("nome"), rs.getString("modelo"),
                        rs.getString("cor"), rs.getString("placa"), 
                TipoAbstrato.getInstance(rs.getInt("tipo_veiculo")));

                listVeiculo.add(veiculo);
            }

            Conexao.fechar(conexao, stmt, rs);
            return listVeiculo.iterator();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaTudo = " + e.getMessage());
        }
        return null;
    }

    @Override
    public EVeiculo consultaPorCodigo(int codigo) {
        String sql = "SELECT * FROM teletransporte.veiculo where codigo=" + codigo + ";";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                return new EVeiculo(rs.getInt("codigo"),
                        rs.getString("nome"), rs.getString("modelo"),
                        rs.getString("cor"), rs.getString("placa"), 
                        TipoAbstrato.getInstance(
                                (rs.getInt("tipo_veiculo") == 1) ? "Carro" : "Moto"));

            }

            Conexao.fechar(conexao, stmt, rs);
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaTudo por código = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Iterator<EVeiculo> consultaPorFiltro(boolean opcao, String filtro) {
        Connection conexao = Conexao.getConect();
        if (opcao) {
            String sql = "SELECT * FROM teletransporte.veiculo where upper(nome) like upper('%" + filtro + "%')";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EVeiculo> listVeiculo = new ArrayList<>();

                while (rs.next()) {
                    EVeiculo veiculo = new EVeiculo(rs.getInt("codigo"),
                            rs.getString("nome"), rs.getString("modelo"),
                            rs.getString("cor"), rs.getString("placa"), 
                            TipoAbstrato.getInstance(
                                    (rs.getInt("tipo_veiculo") == 1) ? "Carro" : "Moto"));

                    listVeiculo.add(veiculo);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listVeiculo.iterator();

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaPorNome = " + e.getMessage());
            }
        } else {
            String sql = "SELECT * FROM teletransporte.veiculo where upper(placa) like upper('%" + filtro + "%')";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                
//                String tipo = (rs.getInt("tipo_veiculo") == 1) ? "Carro" : "Moto";

                List<EVeiculo> listVeiculo = new ArrayList<>();

                while (rs.next()) {
                    EVeiculo veiculo = new EVeiculo(rs.getInt("codigo"),
                            rs.getString("nome"), rs.getString("modelo"),
                            rs.getString("cor"), rs.getString("placa"), 
                    TipoAbstrato.getInstance(
                            (rs.getInt("tipo_veiculo") == 1) ? "Carro" : "Moto"));

                    listVeiculo.add(veiculo);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listVeiculo.iterator();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaPorPlaca = " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean eNulo(EVeiculo veiculo) {
        return veiculo == null || veiculo.getCodigo() == null;
    }

//    public static List<EVeiculo> consultaPorNome(String nome) {
//        String sql = "SELECT * FROM teletransporte.veiculo where upper(nome) like upper('%" + nome + "%')";
//        Connection conexao = Conexao.getConect();
//
//        try {
//            Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<EVeiculo> listVeiculo = new ArrayList<>();
//
//            while (rs.next()) {
//                EVeiculo veiculo = new EVeiculo(rs.getInt("codigo"),
//                        rs.getString("nome"), rs.getString("modelo"),
//                        rs.getString("cor"), rs.getString("placa"));
//
//                listVeiculo.add(veiculo);
//            }
//
//            Conexao.fechar(conexao, stmt, rs);
//            return listVeiculo;
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaPorNome = " + e.getMessage());
//        }
//        return null;
//    }
//    public static List<EVeiculo> consultaPorPlaca(String placa) {
//        String sql = "SELECT * FROM teletransporte.veiculo where upper(placa) like upper('%" + placa + "%')";
//        Connection conexao = Conexao.getConect();
//
//        try {
//            Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<EVeiculo> listVeiculo = new ArrayList<>();
//
//            while (rs.next()) {
//                EVeiculo veiculo = new EVeiculo(rs.getInt("codigo"),
//                        rs.getString("nome"), rs.getString("modelo"),
//                        rs.getString("cor"), rs.getString("placa"));
//
//                listVeiculo.add(veiculo);
//            }
//
//            Conexao.fechar(conexao, stmt, rs);
//            return listVeiculo;
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na classe PVeiculo, método consultaPorPlaca = " + e.getMessage());
//        }
//        return null;
//    }
}
