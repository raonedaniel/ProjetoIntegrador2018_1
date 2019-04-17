/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidades.EPassageiro;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NPassageiro;

/**
 *
 * @author vitor
 */
public class TelaPassageiro extends javax.swing.JInternalFrame {

    private JDesktopPane principal;

    /**
     * Creates new form NewJInternalFrame
     */
    public TelaPassageiro() {
        initComponents();
        listarPassageiro();
    }

    public TelaPassageiro(JDesktopPane principal) {
        this();
        this.principal = principal;
    }

    private void limparCampos() {
        jTextFieldCODIGO.setText("");
        jTextFieldNOME.setText("");
        jTextFieldTELEFONE.setText("");
        jTextFieldRUA.setText("");
        jTextFieldBAIRRO.setText("");
        jTextFieldCIDADE.setText("");
        jTextFieldPESQUISAR.setText("");
        jRadioButtonFEMININO.setSelected(false);
        jRadioButtonMASCULINO.setSelected(false);
    }

    private void listarPassageiro() {
        try {

            DefaultTableModel model = (DefaultTableModel) jTableLISTAPASSAGEIRO.getModel();
            model.setNumRows(0);
            model.setColumnCount(0);
            model.setColumnIdentifiers(new Object[]{
                "Código",
                "Nome",
                "Telefône",
                "Sexo",
                "Rua",
                "Bairro",
                "Cidade"
            });

            new NPassageiro().listar().forEachRemaining(listPassageiro -> {
                model.addRow(new Object[]{
                    listPassageiro.getCodigo(),
                    listPassageiro.getNome(),
                    listPassageiro.getTelefone(),
                    listPassageiro.getSexo(),
                    listPassageiro.getRua(),
                    listPassageiro.getBairro(),
                    listPassageiro.getCidade()
                });
            });

//            while (new NPassageiro().listar().hasNext()) {
//                EPassageiro listPassageiro = new NPassageiro().listar().next();
//                model.addRow(new Object[]{
//                    listPassageiro.getCodigo(),
//                    listPassageiro.getNome(),
//                    listPassageiro.getTelefone(),
//                    listPassageiro.getSexo(),
//                    listPassageiro.getRua(),
//                    listPassageiro.getBairro(),
//                    listPassageiro.getCidade()
//                });
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na telaPassageiro, método listarCurso = " + e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLISTAPASSAGEIRO = new javax.swing.JTable();
        jTextFieldPESQUISAR = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonGRAVAR = new javax.swing.JButton();
        jTextFieldCODIGO = new javax.swing.JTextField();
        jTextFieldNOME = new javax.swing.JTextField();
        jButtonEXCLUIR = new javax.swing.JButton();
        jButtonNOVO = new javax.swing.JButton();
        jButtonBUSCAR = new javax.swing.JButton();
        jTextFieldTELEFONE = new javax.swing.JTextField();
        jRadioButtonMASCULINO = new javax.swing.JRadioButton();
        jRadioButtonFEMININO = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCIDADE = new javax.swing.JTextField();
        jTextFieldBAIRRO = new javax.swing.JTextField();
        jTextFieldRUA = new javax.swing.JTextField();
        jRadioButtonCODIGO = new javax.swing.JRadioButton();
        jRadioButtonNOME = new javax.swing.JRadioButton();

        setClosable(true);

        jTableLISTAPASSAGEIRO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableLISTAPASSAGEIRO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLISTAPASSAGEIROMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLISTAPASSAGEIRO);

        jLabel1.setText("INFORME A SUA BUSCA DE ACORDO COM CHECKBOX:");

        jLabel3.setText("CÓDIGO:");

        jLabel4.setText("NOME:");

        jLabel5.setText("TELEFONE:");

        jButtonGRAVAR.setText("GRAVAR");
        jButtonGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGRAVARActionPerformed(evt);
            }
        });

        jTextFieldCODIGO.setEditable(false);

        jButtonEXCLUIR.setText("EXCLUIR");
        jButtonEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEXCLUIRActionPerformed(evt);
            }
        });

        jButtonNOVO.setText("NOVO");
        jButtonNOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNOVOActionPerformed(evt);
            }
        });

        jButtonBUSCAR.setText("BUSCAR");
        jButtonBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBUSCARActionPerformed(evt);
            }
        });

        jRadioButtonMASCULINO.setText("MASCULINO");
        jRadioButtonMASCULINO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMASCULINOActionPerformed(evt);
            }
        });

        jRadioButtonFEMININO.setText("FEMININO");
        jRadioButtonFEMININO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonFEMININOActionPerformed(evt);
            }
        });

        jLabel6.setText("SEXO:");

        jLabel7.setText("RUA:");

        jLabel8.setText("BAIRRO:");

        jLabel9.setText("CIDADE:");

        jRadioButtonCODIGO.setText("CÓDIGO");
        jRadioButtonCODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCODIGOActionPerformed(evt);
            }
        });

        jRadioButtonNOME.setText("NOME");
        jRadioButtonNOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNOMEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextFieldPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonNOME)
                                        .addGap(50, 50, 50)
                                        .addComponent(jButtonBUSCAR))
                                    .addComponent(jRadioButtonCODIGO)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNOME, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(jTextFieldCODIGO, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldTELEFONE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButtonMASCULINO)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButtonFEMININO))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(3, 3, 3)
                                                            .addComponent(jLabel8))
                                                        .addComponent(jLabel7))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextFieldRUA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldBAIRRO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(jButtonGRAVAR)
                                                .addGap(64, 64, 64)
                                                .addComponent(jButtonNOVO)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEXCLUIR)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButtonCODIGO))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBUSCAR))
                    .addComponent(jRadioButtonNOME))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonMASCULINO)
                    .addComponent(jRadioButtonFEMININO)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldRUA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTELEFONE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonGRAVAR)
                    .addComponent(jButtonEXCLUIR)
                    .addComponent(jButtonNOVO))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableLISTAPASSAGEIROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLISTAPASSAGEIROMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableLISTAPASSAGEIRO.getModel();
        jTextFieldCODIGO.setEnabled(false);
        int selecionado = jTableLISTAPASSAGEIRO.getSelectedRow();

        if (model.getValueAt(selecionado, 0) != null) {
            jTextFieldCODIGO.setText(model.getValueAt(selecionado, 0).toString());
        }
        if (model.getValueAt(selecionado, 1) != null) {
            jTextFieldNOME.setText(model.getValueAt(selecionado, 1).toString());
        }
        if (model.getValueAt(selecionado, 2) != null) {
            jTextFieldTELEFONE.setText(model.getValueAt(selecionado, 2).toString());
        }
        if (model.getValueAt(selecionado, 3) != null) {
            if (model.getValueAt(selecionado, 3) == "MASCULINO") {
                jRadioButtonMASCULINO.isSelected();
            } else {
                jRadioButtonFEMININO.isSelected();
            }
        }
        if (model.getValueAt(selecionado, 4) != null) {
            jTextFieldRUA.setText(model.getValueAt(selecionado, 4).toString());
        }
        if (model.getValueAt(selecionado, 5) != null) {
            jTextFieldBAIRRO.setText(model.getValueAt(selecionado, 5).toString());
        }
        if (model.getValueAt(selecionado, 6) != null) {
            jTextFieldCIDADE.setText(model.getValueAt(selecionado, 6).toString());
        }
    }//GEN-LAST:event_jTableLISTAPASSAGEIROMouseClicked

    private void jButtonGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGRAVARActionPerformed
        // TODO add your handling code here:
        try {
            String nome = jTextFieldNOME.getText();
            String telefone = jTextFieldTELEFONE.getText();
            String sexo = null;
            if (jRadioButtonFEMININO.isSelected()) {
                sexo = "FEMININO";
            } else {
                sexo = "MASCULINO";
            }
            String rua = jTextFieldRUA.getText();
            String bairro = jTextFieldBAIRRO.getText();
            String cidade = jTextFieldCIDADE.getText();
            String valor = jTextFieldCODIGO.getText();

            EPassageiro passageiro = new EPassageiro(nome, telefone, sexo,
                    rua, bairro, cidade);

            if (valor.equals("")) {
                new NPassageiro().salvar(passageiro, valor);
            } else {
                passageiro.setCodigo(Integer.parseInt(jTextFieldCODIGO.getText()));
                new NPassageiro().salvar(passageiro, valor);
            }

            listarPassageiro();

            limparCampos();

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na TelaPassageiro, botão gravar = " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonGRAVARActionPerformed

    private void jButtonEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXCLUIRActionPerformed
        // TODO add your handling code here:
        try {
            int codigo = Integer.parseInt(jTextFieldCODIGO.getText());
            String nome = jTextFieldNOME.getText();
            String telefone = jTextFieldTELEFONE.getText();
            String sexo = null;
            if (jRadioButtonFEMININO.isSelected()) {
                sexo = "FEMININO";
            } else {
                sexo = "MASCULINO";
            }
            String rua = jTextFieldRUA.getText();
            String bairro = jTextFieldBAIRRO.getText();
            String cidade = jTextFieldCIDADE.getText();

            EPassageiro passageiro = new EPassageiro(codigo, nome, telefone, sexo,
                    rua, bairro, cidade);

            new NPassageiro().excluir(passageiro);

            listarPassageiro();

            limparCampos();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na telaPassageiro, método excluir = " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonEXCLUIRActionPerformed

    private void jButtonNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNOVOActionPerformed
        // TODO add your handling code here:
        limparCampos();
        listarPassageiro();
    }//GEN-LAST:event_jButtonNOVOActionPerformed

    private void jButtonBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBUSCARActionPerformed
        // TODO add your handling code here:
        try {
            String consulta = jTextFieldPESQUISAR.getText();
            DefaultTableModel model = (DefaultTableModel) jTableLISTAPASSAGEIRO.getModel();
            model.setNumRows(0);
            if (jRadioButtonCODIGO.isSelected()) {

                new NPassageiro().consultaPorFiltro(true, consulta).forEachRemaining(passageiro -> {
                    model.addRow(new Object[]{
                        passageiro.getCodigo(),
                        passageiro.getNome(),
                        passageiro.getTelefone(),
                        passageiro.getSexo(),
                        passageiro.getRua(),
                        passageiro.getBairro(),
                        passageiro.getCidade()
                    });
                });

//                while (new NPassageiro().consultaPorFiltro(true, consulta).hasNext()) {
//                    EPassageiro passageiro = new NPassageiro().consultaPorFiltro(true, consulta).next();
//                    model.addRow(new Object[]{
//                        passageiro.getCodigo(),
//                        passageiro.getNome(),
//                        passageiro.getTelefone(),
//                        passageiro.getSexo(),
//                        passageiro.getRua(),
//                        passageiro.getBairro(),
//                        passageiro.getCidade()
//                    });
//                }

            } else if (jRadioButtonNOME.isSelected()) {
                
                new NPassageiro().consultaPorFiltro(false, consulta).forEachRemaining(passageiro -> {
                    model.addRow(new Object[]{
                        passageiro.getCodigo(),
                        passageiro.getNome(),
                        passageiro.getTelefone(),
                        passageiro.getSexo(),
                        passageiro.getRua(),
                        passageiro.getBairro(),
                        passageiro.getCidade()
                    });
                });
                
//                while (new NPassageiro().consultaPorFiltro(false, consulta).hasNext()) {
//                    EPassageiro passageiro = new NPassageiro().consultaPorFiltro(false, consulta).next();
//                    model.addRow(new Object[]{
//                        passageiro.getCodigo(),
//                        passageiro.getNome(),
//                        passageiro.getTelefone(),
//                        passageiro.getSexo(),
//                        passageiro.getRua(),
//                        passageiro.getBairro(),
//                        passageiro.getCidade()
//                    });
//                }
            } else {
                listarPassageiro();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na TelaPassageiro, botão buscar = " + ex.getMessage());
        }

    }//GEN-LAST:event_jButtonBUSCARActionPerformed

    private void jRadioButtonMASCULINOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMASCULINOActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonMASCULINO.isSelected()) {
            jRadioButtonFEMININO.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonMASCULINOActionPerformed

    private void jRadioButtonFEMININOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonFEMININOActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonFEMININO.isSelected()) {
            jRadioButtonMASCULINO.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonFEMININOActionPerformed

    private void jRadioButtonCODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCODIGOActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonCODIGO.isSelected()) {
            jRadioButtonNOME.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonCODIGOActionPerformed

    private void jRadioButtonNOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNOMEActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonNOME.isSelected()) {
            jRadioButtonCODIGO.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonNOMEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonBUSCAR;
    private javax.swing.JButton jButtonEXCLUIR;
    private javax.swing.JButton jButtonGRAVAR;
    private javax.swing.JButton jButtonNOVO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonCODIGO;
    private javax.swing.JRadioButton jRadioButtonFEMININO;
    private javax.swing.JRadioButton jRadioButtonMASCULINO;
    private javax.swing.JRadioButton jRadioButtonNOME;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLISTAPASSAGEIRO;
    private javax.swing.JTextField jTextFieldBAIRRO;
    private javax.swing.JTextField jTextFieldCIDADE;
    private javax.swing.JTextField jTextFieldCODIGO;
    private javax.swing.JTextField jTextFieldNOME;
    private javax.swing.JTextField jTextFieldPESQUISAR;
    private javax.swing.JTextField jTextFieldRUA;
    private javax.swing.JTextField jTextFieldTELEFONE;
    // End of variables declaration//GEN-END:variables
}
