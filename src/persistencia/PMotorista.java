/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.EMotorista;
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
public class PMotorista extends TPersistencia<EMotorista> {

    @Override
    public void gravar(EMotorista motorista) {
        String sql = "INSERT INTO `teletransporte`.`motorista` "
                + "(`codigo`, `nome`, `telefone`, `sexo`, `rua`, "
                + "`bairro`, `cidade`, `cnh`) VALUES "
                + "(" + motorista.getCodigo() + ", '" + motorista.getNome() + "', "
                + "'" + motorista.getTelefone() + "', '" + motorista.getSexo() + "', "
                + "'" + motorista.getRua() + "', '" + motorista.getBairro()
                + "', '" + motorista.getCidade() + "', '" + motorista.getCnh() + "');";
        Connection conexao = Conexao.getConect();
        try {
            Statement stmt = conexao.createStatement();
            System.out.println(stmt.executeUpdate(sql)); // Para fazer uma inserção no BD
            Conexao.fechar(conexao, stmt); // Se retorna o número 1, inserção efetuada com sucesso
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na classe PMotorista, método gravar = " + ex.getMessage());
        }
    }

    public void alterar(EMotorista motorista) {

        String sql = "UPDATE `teletransporte`.`motorista` SET "
                + "`nome`='" + motorista.getNome() + "', "
                + "`telefone`='" + motorista.getTelefone() + "', "
                + "`sexo`='" + motorista.getSexo() + "', "
                + "`rua`='" + motorista.getRua() + "', "
                + "`bairro`='" + motorista.getBairro() + "', "
                + "`cidade`='" + motorista.getCidade() + "', "
                + "`cnh`='" + motorista.getCnh() + "' "
                + "WHERE `codigo`=" + motorista.getCodigo() + ";";
        
        this.alterarOuExcluir(true, motorista, sql);
    }

    public void excluir(EMotorista motorista) {

        String sql = "DELETE FROM `teletransporte`.`motorista` WHERE `codigo`='"
                + motorista.getCodigo() + "';";
        this.alterarOuExcluir(false, motorista, sql);
    }

    @Override
    public Iterator<EMotorista> consultaTudo() {
        String sql = "SELECT * FROM teletransporte.motorista;";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<EMotorista> listMotorista = new ArrayList<>();

            while (rs.next()) {

                EMotorista motorista = new EMotorista(rs.getInt("codigo"), rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("sexo"), rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("cnh"));

                listMotorista.add(motorista);

            }

            Conexao.fechar(conexao, stmt, rs);
            return listMotorista.iterator();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PMotorista , método consultaTudo = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Iterator<EMotorista> consultaPorFiltro(boolean opcao, String filtro) {
        Connection conexao = Conexao.getConect();
        if (opcao) {
            String sql = "SELECT * FROM teletransporte.motorista where nome like '%" + filtro + "%'";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EMotorista> listMotorista = new ArrayList<>();

                while (rs.next()) {
                    EMotorista motorista = new EMotorista(rs.getInt("codigo"), rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("sexo"), rs.getString("rua"),
                            rs.getString("bairro"), rs.getString("cidade"),
                            rs.getString("cnh"));

                    listMotorista.add(motorista);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listMotorista.iterator();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PMotorista, método consultaPorNome = " + e.getMessage());
            }
        } else {
            String sql = "SELECT * FROM teletransporte.motorista where cnh like '%" + filtro + "%';";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EMotorista> listMotorista = new ArrayList<>();

                while (rs.next()) {
                    EMotorista motorista = new EMotorista(rs.getInt("codigo"), rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("sexo"), rs.getString("rua"),
                            rs.getString("bairro"), rs.getString("cidade"),
                            rs.getString("cnh"));

                    listMotorista.add(motorista);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listMotorista.iterator();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PMotorista, método consultaPorCnh = " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public EMotorista consultaPorCodigo(int codigo) {
        String sql = "SELECT * FROM teletransporte.motorista where codigo=" + codigo + ";";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                return new EMotorista(rs.getInt("codigo"),
                        rs.getString("nome"), rs.getString("telefone"),
                        rs.getString("sexo"), rs.getString("rua"), rs.getString("bairro"),
                        rs.getString("cidade"), rs.getString("cnh"));

            }

            Conexao.fechar(conexao, stmt, rs);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PMotorista, método consultaTudo por código = " + e.getMessage());
        }
        return null;
    }

//    public List<EMotorista> consultaPorCnh(String cnh) {
//        String sql = "SELECT * FROM teletransporte.motorista where cnh='" + cnh + "';";
//        Connection conexao = Conexao.getConect();
//
//        try {
//            Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<EMotorista> listMotorista = new ArrayList<>();
//
//            while (rs.next()) {
//                EMotorista motorista = new EMotorista(rs.getInt("codigo"), rs.getString("nome"),
//                        rs.getString("telefone"),
//                        rs.getString("sexo"), rs.getString("rua"),
//                        rs.getString("bairro"), rs.getString("cidade"),
//                        rs.getString("cnh"));
//
//                listMotorista.add(motorista);
//            }
//
//            Conexao.fechar(conexao, stmt, rs);
//            return listMotorista;
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na classe PMotorista, método consultaPorCnh = " + e.getMessage());
//        }
//        return null;
//    }

    @Override
    public boolean eNulo(EMotorista motorista) {
        return motorista == null || motorista.getCodigo() == null;
    }

}
