/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class Conexao {
    
    private static Connection conectar;
    
    private Conexao(){}
    
    public static Connection getConect() {
        try {
            if (conectar == null || conectar.isClosed()) {
                conectar = Conexao.getConexao();
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return conectar;
    }

    private static Connection getConexao() {
        String url = "jdbc:mysql://127.0.0.1:3306/teletransporte";
        String user = "root";
        String password = "vitor-lenovo";
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não conectou ao banco = " + e.getMessage());
        }
        return null;
    }

    public static void fechar(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe Conexão, método fechar = " + e.getMessage());
        }
    }

    public static void fechar(Connection connection, Statement sttm) {
        fechar(connection);
        try {
            if (sttm != null) {
                sttm.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe Conexão, método fechar = " + e.getMessage());
        }
    }

    public static void fechar(Connection connection, Statement sttm, ResultSet rs) {
        fechar(connection, sttm);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe Conexão, método fechar = " + e.getMessage());
        }
    }
}
