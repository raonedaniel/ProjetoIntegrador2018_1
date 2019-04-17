/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.EPassageiro;
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
public class PPassageiro extends TPersistencia<EPassageiro> {

    @Override
    public void gravar(EPassageiro passageiro) {
        String sql = "INSERT INTO `teletransporte`.`passageiro` "
                + "(`codigo`, `nome`, `telefone`, `sexo`, `rua`, `bairro`, `cidade`) VALUES "
                + "(" + passageiro.getCodigo() + ", '" + passageiro.getNome() + "', "
                + "'" + passageiro.getTelefone() + "', '" + passageiro.getSexo() + "', "
                + "'" + passageiro.getRua() + "', '" + passageiro.getBairro() + "', '"
                + passageiro.getCidade() + "');";
        Connection conexao = Conexao.getConect();
        try {
            Statement stmt = conexao.createStatement();
            System.out.println(stmt.executeUpdate(sql)); // Para fazer uma inserção no BD
            Conexao.fechar(conexao, stmt); // Se retorna o número 1, inserção efetuada com sucesso
            JOptionPane.showMessageDialog(null, "Registro inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro, método gravar = " + ex.getMessage());
        }
    }

    public void alterar(EPassageiro passageiro) {

        String sql = "UPDATE `teletransporte`.`passageiro` SET "
                + "`nome`='" + passageiro.getNome() + "', "
                + "`telefone`='" + passageiro.getTelefone() + "', "
                + "`sexo`='" + passageiro.getSexo() + "', "
                + "`rua`='" + passageiro.getRua() + "', "
                + "`bairro`='" + passageiro.getBairro() + "', "
                + "`cidade`='" + passageiro.getCidade() + "' "
                + "WHERE `codigo`='" + passageiro.getCodigo() + "' "
                + ";";

        this.alterarOuExcluir(true, passageiro, sql);
    }

    public void excluir(EPassageiro passageiro) {

        String sql = "DELETE FROM `teletransporte`.`passageiro` WHERE `codigo`='"
                + passageiro.getCodigo() + "';";
        
        this.alterarOuExcluir(false, passageiro, sql);
    }

    @Override
    public Iterator<EPassageiro> consultaTudo() {
        String sql = "SELECT * FROM teletransporte.passageiro;";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<EPassageiro> listPassageiro = new ArrayList<>();

            while (rs.next()) {

                EPassageiro passageiro = new EPassageiro(rs.getInt("codigo"), rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("sexo"), rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"));

                listPassageiro.add(passageiro);

            }

            Conexao.fechar(conexao, stmt, rs);
            return listPassageiro.iterator();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro , método consultaTudo = " + e.getMessage());
        }
        return null;
    }

    public static List<EPassageiro> consultaPorNome(String nome) {
        String sql = "SELECT * FROM teletransporte.passageiro where nome like '%" + nome + "%'";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            List<EPassageiro> listPassageiro = new ArrayList<>();

            // Método executeQuery retorna para min um tipo ResultSel
            // Método query significa uma consulta, destinado ao comandos select do BD
            // O Connection estabele o caminho/conexão do código ao BD
            // O Statement estabelece uma ação para ser ocorrida em ambos, ex: insert , update
            // O Result Set é como se fosse o tipo primitivo dos dados que vem do banco
            while (rs.next()) {
                EPassageiro aluno = new EPassageiro(rs.getInt("codigo"), rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("sexo"), rs.getString("rua"),
                        rs.getString("bairro"), rs.getString("cidade"));

                listPassageiro.add(aluno);
            }

            Conexao.fechar(conexao, stmt, rs);
            return listPassageiro;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro, método consultaPorNome = " + e.getMessage());
        }
        return null;
    }

    @Override
    public EPassageiro consultaPorCodigo(int codigo) {
        String sql = "SELECT * FROM teletransporte.passageiro where codigo=" + codigo + ";";
        Connection conexao = Conexao.getConect();

        try {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                return new EPassageiro(rs.getInt("codigo"),
                        rs.getString("nome"), rs.getString("telefone"),
                        rs.getString("sexo"), rs.getString("rua"), rs.getString("bairro"),
                        rs.getString("cidade"));

            }

            Conexao.fechar(conexao, stmt, rs);
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro, método consultaTudo por código = " + e.getMessage());
        }
        return null;
    }

//    public static List<EPassageiro> consultaPorCodigoBusca(int codigo) {
//        String sql = "SELECT * FROM teletransporte.passageiro where codigo=" + codigo + ";";
//        Connection conexao = Conexao.getConect();
//
//        try {
//            Statement stmt = conexao.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//
//            List<EPassageiro> listPassageiro = new ArrayList<>();
//
//            // Método executeQuery retorna para min um tipo ResultSel
//            // Método query significa uma consulta, destinado ao comandos select do BD
//            // O Connection estabele o caminho/conexão do código ao BD
//            // O Statement estabelece uma ação para ser ocorrida em ambos, ex: insert , update
//            // O Result Set é como se fosse o tipo primitivo dos dados que vem do banco
//            while (rs.next()) {
//                EPassageiro aluno = new EPassageiro(rs.getInt("codigo"), rs.getString("nome"),
//                        rs.getString("telefone"),
//                        rs.getString("sexo"), rs.getString("rua"),
//                        rs.getString("bairro"), rs.getString("cidade"));
//
//                listPassageiro.add(aluno);
//            }
//
//            Conexao.fechar(conexao, stmt, rs);
//            return listPassageiro;
//
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro, método consultaPorNome = " + e.getMessage());
//        }
//        return null;
//    }
    @Override
    public Iterator<EPassageiro> consultaPorFiltro(boolean opcao, String filtro) {
        Connection conexao = Conexao.getConect();
        if (opcao) {
            String sql = "SELECT * FROM teletransporte.passageiro where codigo=" + filtro + ";";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EPassageiro> listPassageiro = new ArrayList<>();

                while (rs.next()) {
                    listPassageiro.add(new EPassageiro(rs.getInt("codigo"),
                            rs.getString("nome"), rs.getString("telefone"),
                            rs.getString("sexo"), rs.getString("rua"), rs.getString("bairro"),
                            rs.getString("cidade")));

                }

                Conexao.fechar(conexao, stmt, rs);
                return listPassageiro.iterator();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro, método consultaTudo por código = " + e.getMessage());
            }
        } else {
            String sql = "SELECT * FROM teletransporte.passageiro where nome like '%" + filtro + "%'";
            try {
                Statement stmt = conexao.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                List<EPassageiro> listPassageiro = new ArrayList<>();
                
                while (rs.next()) {
                    EPassageiro aluno = new EPassageiro(rs.getInt("codigo"), rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("sexo"), rs.getString("rua"),
                            rs.getString("bairro"), rs.getString("cidade"));

                    listPassageiro.add(aluno);
                }

                Conexao.fechar(conexao, stmt, rs);
                return listPassageiro.iterator();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na classe PPassageiro, método consultaPorNome = " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean eNulo(EPassageiro passageiro) {
        return passageiro == null || passageiro.getCodigo() == null;
    }

}
