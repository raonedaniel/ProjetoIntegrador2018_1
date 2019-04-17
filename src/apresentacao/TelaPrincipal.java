/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidades.observer.Central;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    static Central central = new Central();

    /**
     * Creates new form Principal2
     */
    public TelaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    private void sair() {

        try {

            int resposta = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente sair?", "Aviso!", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro no JMenuSair, Tela Principal: " + e.getMessage());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanePRINCIPAL = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuSERVICOS = new javax.swing.JMenu();
        jMenuItemPASSAGEIRO = new javax.swing.JMenuItem();
        jMenuItemVEICULO = new javax.swing.JMenuItem();
        jMenuItemMOTORISTA = new javax.swing.JMenuItem();
        jMenuItemVIAGEM = new javax.swing.JMenuItem();
        jMenuSAIR = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jMenuSERVICOS.setText("Serviços");

        jMenuItemPASSAGEIRO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemPASSAGEIRO.setText("Passageiro");
        jMenuItemPASSAGEIRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPASSAGEIROActionPerformed(evt);
            }
        });
        jMenuSERVICOS.add(jMenuItemPASSAGEIRO);

        jMenuItemVEICULO.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemVEICULO.setText("Veículo");
        jMenuItemVEICULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVEICULOActionPerformed(evt);
            }
        });
        jMenuSERVICOS.add(jMenuItemVEICULO);

        jMenuItemMOTORISTA.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemMOTORISTA.setText("Motorista");
        jMenuItemMOTORISTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMOTORISTAActionPerformed(evt);
            }
        });
        jMenuSERVICOS.add(jMenuItemMOTORISTA);

        jMenuItemVIAGEM.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemVIAGEM.setText("Viagem");
        jMenuItemVIAGEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVIAGEMActionPerformed(evt);
            }
        });
        jMenuSERVICOS.add(jMenuItemVIAGEM);

        jMenuBar1.add(jMenuSERVICOS);

        jMenuSAIR.setText("Sair");
        jMenuSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSAIRActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuSAIR);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePRINCIPAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePRINCIPAL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemVEICULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVEICULOActionPerformed
        // TODO add your handling code here:
        try {
            TelaVeiculo janela = new TelaVeiculo(this.jDesktopPanePRINCIPAL);
            this.jDesktopPanePRINCIPAL.add(janela);
            janela.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no jMenuItemVeiculo, na TelaPrincipal: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItemVEICULOActionPerformed

    private void jMenuSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSAIRActionPerformed
        // TODO add your handling code here:
        sair();
    }//GEN-LAST:event_jMenuSAIRActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.sair();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItemPASSAGEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPASSAGEIROActionPerformed
        // TODO add your handling code here:
        try {
            TelaPassageiro janela = new TelaPassageiro(this.jDesktopPanePRINCIPAL);
            this.jDesktopPanePRINCIPAL.add(janela);
            janela.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no jMenuItemPassageiro, na TelaPrincipal: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItemPASSAGEIROActionPerformed

    private void jMenuItemMOTORISTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMOTORISTAActionPerformed
        // TODO add your handling code here:
        try {
            TelaMotorista janela = new TelaMotorista(this.jDesktopPanePRINCIPAL);
            this.jDesktopPanePRINCIPAL.add(janela);
            janela.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no jMenuItemMotorista, na TelaPrincipal: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItemMOTORISTAActionPerformed

    private void jMenuItemVIAGEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVIAGEMActionPerformed
        // TODO add your handling code here:
        try {
            TelaViagem janela = new TelaViagem(this.jDesktopPanePRINCIPAL);
            this.jDesktopPanePRINCIPAL.add(janela);
            janela.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no jMenuItemViagem, na TelaPrincipal: " + e.getMessage());
        }
    }//GEN-LAST:event_jMenuItemVIAGEMActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePRINCIPAL;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemMOTORISTA;
    private javax.swing.JMenuItem jMenuItemPASSAGEIRO;
    private javax.swing.JMenuItem jMenuItemVEICULO;
    private javax.swing.JMenuItem jMenuItemVIAGEM;
    private javax.swing.JMenu jMenuSAIR;
    private javax.swing.JMenu jMenuSERVICOS;
    // End of variables declaration//GEN-END:variables
}