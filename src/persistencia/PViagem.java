/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.EViagem;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 *
 * @author vitor
 */
public class PViagem extends TPersistencia<EViagem> {

    @Override
    public void gravar(EViagem viagem) {
        String sql = "INSERT INTO `teletransporte`.`viagem` "
                + "(`codigo`, `origem`, `destino`, `codigo_passageiro`, `codigo_motorista`,"
                + " `codigo_veiculo`, `data_viagem`) VALUES ("
                + viagem.getCodigo() + ", '"
                + viagem.getOrigem() + "', '"
                + viagem.getDestino() + "', "
                + viagem.getCodigoPassageiro().getCodigo() + " ,"
                + viagem.getCodigoMotorista().getCodigo() + ", "
                + viagem.getCodigoVeiculo().getCodigo() + ", '" + viagem.getDataViagem() + "');";
        Connection conexao = Conexao.getConect();
        try {
            Statement stmt = conexao.createStatement();
            System.out.println(stmt.executeUpdate(sql));
            Conexao.fechar(conexao, stmt);
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na classe PViagem, método gravar = " + ex.getMessage());
        }
    }

    public void alterar(EViagem viagem) {

        String sql = "UPDATE `teletransporte`.`viagem` SET "
                + "`origem`='" + viagem.getOrigem() + "', "
                + "`destino`='" + viagem.getDestino() + "', "
                + "`codigo_passageiro`=" + viagem.getCodigoPassageiro().getCodigo() + ", "
                + "`codigo_motorista`=" + viagem.getCodigoMotorista().getCodigo() + ", "
                + "`codigo_veiculo`=" + viagem.getCodigoVeiculo().getCodigo() + ", "
                + "`data_viagem`='" + viagem.getDataViagem()
                + "' WHERE `codigo`=" + viagem.getCodigo() + ";";

        this.alterarOuExcluir(true, viagem, sql);
    }

    public void excluir(EViagem viagem) {

        String sql = "DELETE FROM `teletransporte`.`viagem` "
                + "WHERE `codigo`=" + viagem.getCodigo() + ";";

        this.alterarOuExcluir(false, viagem, sql);
    }

    @Override
    public Iterator<EViagem> consultaTudo() {
        String sql = "SELECT * FROM teletransporte.viagem;";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<EViagem> listViagem = new ArrayList<>();

            while (rs.next()) {

                EViagem viagem = new EViagem(rs.getInt("codigo"), rs.getString("origem"),
                        rs.getString("destino"), 
                        new PPassageiro().consultaPorCodigo(rs.getInt("codigo_passageiro")),
                        new PMotorista().consultaPorCodigo(rs.getInt("codigo_motorista")),
                        new PVeiculo().consultaPorCodigo(rs.getInt("codigo_veiculo")),
                        rs.getString("data_viagem"));

                listViagem.add(viagem);

            }

            Conexao.fechar(conexao, stmt, rs);
            return listViagem.iterator();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PViagem , método consultaTudo = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Iterator<EViagem> consultaPorFiltro(boolean opcao, String filtro) {
        Connection conexao = Conexao.getConect();
        if (opcao) {
            String sql = "SELECT * FROM teletransporte.viagem where origem like '%" + filtro + "%'";

            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EViagem> listViagem = new ArrayList<>();

                while (rs.next()) {
                    EViagem viagem = new EViagem(rs.getInt("codigo"), rs.getString("origem"),
                            rs.getString("destino"),
                            new PPassageiro().consultaPorCodigo(rs.getInt("codigo_passageiro")),
                            new PMotorista().consultaPorCodigo(rs.getInt("codigo_motorista")),
                            new PVeiculo().consultaPorCodigo(rs.getInt("codigo_veiculo")),
                            rs.getString("data_viagem"));

                    listViagem.add(viagem);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listViagem.iterator();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PViagem, método consultaPorOrigem = " + e.getMessage());
            }
        } else {
            String sql = "SELECT * FROM teletransporte.viagem where destino like '%" + filtro + "%'";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EViagem> listViagem = new ArrayList<>();

                while (rs.next()) {
                    EViagem viagem = new EViagem(rs.getInt("codigo"), rs.getString("origem"),
                            rs.getString("destino"),
                            new PPassageiro().consultaPorCodigo(rs.getInt("codigo_passageiro")),
                            new PMotorista().consultaPorCodigo(rs.getInt("codigo_motorista")),
                            new PVeiculo().consultaPorCodigo(rs.getInt("codigo_veiculo")),
                            rs.getString("data_viagem"));

                    listViagem.add(viagem);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listViagem.iterator();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PViagem, método consultaPorDestino = " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public EViagem consultaPorCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eNulo(EViagem viagem) {
        return viagem == null || viagem.getCodigo() == null;
    }

//    public static List<EViagem> consultaPorDestino(String destino) {
//        String sql = "SELECT * FROM teletransporte.viagem where destino like '%" + destino + "%'";
//        Connection conexao = Conexao.getConect();
//
//        try {
//            Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<EViagem> listViagem = new ArrayList<>();
//
//            while (rs.next()) {
//                EViagem viagem = new EViagem(rs.getInt("codigo"), rs.getString("origem"),
//                        rs.getString("destino"),
//                        PPassageiro.consultaPorCodigo(rs.getInt("codigo_passageiro")),
//                        PMotorista.consultaPorCodigo(rs.getInt("codigo_motorista")),
//                        PVeiculo.consultaPorCodigo(rs.getInt("codigo_veiculo")),
//                        rs.getString("data_viagem"));
//
//                listViagem.add(viagem);
//            }
//
//            Conexao.fechar(conexao, stmt, rs);
//            return listViagem;
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na classe PViagem, método consultaPorDestino = " + e.getMessage());
//        }
//        return null;
//    }
}
