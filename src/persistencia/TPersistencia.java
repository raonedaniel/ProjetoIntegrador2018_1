/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 *
 * @author vitor
 */
public abstract class TPersistencia<T> {
    
    public abstract void gravar(T obj);
    
    public abstract Iterator<T> consultaTudo();
    
    public abstract T consultaPorCodigo(int codigo);
    
    public abstract Iterator<T> consultaPorFiltro(boolean opcao, String filtro);
    
    public abstract boolean eNulo(T obj);
    
    public void alterarOuExcluir(boolean opcao, T obj, String sql){
        if (eNulo(obj)) {
            JOptionPane.showMessageDialog(null, "Não foi possível fazer a alteração");
            return;
        }
        
        Connection conexao = Conexao.getConect();
        try {
            Statement sttm = conexao.createStatement();
            System.out.println(sttm.executeUpdate(sql));
            Conexao.fechar(conexao, sttm);
            if (opcao) {
                JOptionPane.showMessageDialog(null, "Registro alterado com sucesso");
            } else 
                JOptionPane.showMessageDialog(null, "Registro excluído com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na classe TPersistencia "
                    + "método alterarOuExcluir = " + e.getMessage());
        }
    }
}
