/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidades.EViagem;
import entidades.observer.DadosDeViagem;
import static apresentacao.TelaPrincipal.central;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NMotorista;
import negocio.NPassageiro;
import negocio.NVeiculo;
import negocio.NViagem;
import org.joda.time.DateTime;

/**
 *
 * @author vitor
 */
public class TelaViagem extends javax.swing.JInternalFrame {

    private JDesktopPane principal;

    /**
     * Creates new form TelaMatricula2
     */
    public TelaViagem() {
        initComponents();
        listarViagem();
    }

    public TelaViagem(JDesktopPane principal) {
        this();
        this.principal = principal;
        listarViagem();
    }

    private void limparCampos() {
        jTextFieldCODIGO.setText("");
        jTextFieldORIGEM.setText("");
        jTextFieldDESTINO.setText("");
        jComboBoxPASSAGEIRO.setSelectedItem("Selecione um passageiro");
        jComboBoxMMOTORISTA.setSelectedItem("Selecione um motorista");
        jComboBoxVEICULO.setSelectedItem("Selecione um veículo");
        jTextFieldPESQUISAR.setText("");
        jTextFieldPLACA.setText("");
        jDateChooserDATAVIAGEM.setDate(null);
    }

//    private void gravar() throws SQLException {
//       
//    }
    private void listarViagem() {
        try {
            DefaultTableModel model = (DefaultTableModel) jTableLISTAVIAGEM.getModel();
            model.setNumRows(0);
            model.setColumnCount(0);
            model.setColumnIdentifiers(new Object[]{
                "Código",
                "Origem",
                "Destino",
                "Passageiro",
                "Motorista",
                "Veículo",
                "Placa",
                "Data"
            });

            listarPassageiroCombo();
            listarMotoristaCombo();
            listarVeiculoCombo();

            new NViagem().listar().forEachRemaining(listViagem -> {
                model.addRow(new Object[]{
                    listViagem.getCodigo(),
                    listViagem.getOrigem(),
                    listViagem.getDestino(),
                    listViagem.getCodigoPassageiro().getCodigo() + " - "
                    + listViagem.getCodigoPassageiro().getNome(),
                    listViagem.getCodigoMotorista().getCodigo() + " - "
                    + listViagem.getCodigoMotorista().getNome(),
                    listViagem.getCodigoVeiculo().getCodigo() + " - "
                    + listViagem.getCodigoVeiculo().getNome(),
                    listViagem.getCodigoVeiculo().getPlaca(),
                    listViagem.getDataViagem()
                });
            });

//            while (new NViagem().listar().hasNext()) {
//                EViagem listViagem = new NViagem().listar().next();
//                model.addRow(new Object[]{
//                    listViagem.getCodigo(),
//                    listViagem.getOrigem(),
//                    listViagem.getDestino(),
//                    listViagem.getCodigoPassageiro().getCodigo() + " - "
//                    + listViagem.getCodigoPassageiro().getNome(),
//                    listViagem.getCodigoMotorista().getCodigo() + " - "
//                    + listViagem.getCodigoMotorista().getNome(),
//                    listViagem.getCodigoVeiculo().getCodigo() + " - "
//                    + listViagem.getCodigoVeiculo().getNome(),
//                    listViagem.getCodigoVeiculo().getPlaca(),
//                    listViagem.getDataViagem()
//                });
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, método listarViagem = " + e.getMessage());
        }
    }

    private void listarMotoristaCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxMMOTORISTA.getModel();
            model.removeAllElements();

            new NMotorista().listar().forEachRemaining(listMotorista -> {
                model.addElement(listMotorista.getCodigo() + " - " + listMotorista.getNome());
            });

//            while (new NMotorista().listar().hasNext()) {
//                EMotorista listMotorista = new NMotorista().listar().next();
//                model.addElement(listMotorista.getCodigo() + " - " + listMotorista.getNome());
//            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, método listarMotoristaCombo = " + e.getMessage());
        }
    }

    private void listarPassageiroCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxPASSAGEIRO.getModel();
            model.removeAllElements();

            new NPassageiro().listar().forEachRemaining(listPassageiro -> {
                model.addElement(listPassageiro.getCodigo() + " - " + listPassageiro.getNome());
            });

//            while (new NPassageiro().listar().hasNext()) {
//                EPassageiro listPassageiro = new NPassageiro().listar().next();
//                model.addElement(listPassageiro.getCodigo() + " - " + listPassageiro.getNome());
//            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, método listarPassageiroCombo = " + erro.getMessage());
        }
    }

    private void listarVeiculoCombo() {
        try {
            DefaultComboBoxModel model = (DefaultComboBoxModel) jComboBoxVEICULO.getModel();
            model.removeAllElements();

            new NVeiculo().listar().forEachRemaining(listVeiculo -> {
                model.addElement(listVeiculo.getCodigo() + " - " + listVeiculo.getNome());
            });

//            while (new NVeiculo().listar().hasNext()) {
//                EVeiculo listVeiculo = new NVeiculo().listar().next();
//                model.addElement(listVeiculo.getCodigo() + " - " + listVeiculo.getNome());
//            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, método listarVeiculoCombo = " + erro.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLISTAVIAGEM = new javax.swing.JTable();
        jTextFieldPESQUISAR = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButtonGRAVAR = new javax.swing.JButton();
        jTextFieldCODIGO = new javax.swing.JTextField();
        jComboBoxPASSAGEIRO = new javax.swing.JComboBox<>();
        jComboBoxMMOTORISTA = new javax.swing.JComboBox<>();
        jButtonEXCLUIR = new javax.swing.JButton();
        jButtonNOVO = new javax.swing.JButton();
        jButtonFECHAR = new javax.swing.JButton();
        jButtonBUSCAR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldORIGEM = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDESTINO = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxVEICULO = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooserDATAVIAGEM = new com.toedter.calendar.JDateChooser();
        jTextFieldPLACA = new javax.swing.JTextField();
        jRadioButtonORIGEM = new javax.swing.JRadioButton();
        jRadioButtonDESTINO = new javax.swing.JRadioButton();

        setRequestFocusEnabled(false);

        jPanel1.setToolTipText("");

        jTableLISTAVIAGEM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableLISTAVIAGEM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLISTAVIAGEMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLISTAVIAGEM);

        jLabel1.setText("INFORME A SUA BUSCA DE ACORDO COM CHECKBOX:");

        jLabel3.setText("CÓDIGO:");

        jLabel4.setText("PASSAGEIRO:");

        jLabel5.setText("MOTORISTA:");

        jButtonGRAVAR.setText("GRAVAR");
        jButtonGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGRAVARActionPerformed(evt);
            }
        });

        jTextFieldCODIGO.setEditable(false);

        jComboBoxPASSAGEIRO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxMMOTORISTA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMMOTORISTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMMOTORISTAActionPerformed(evt);
            }
        });

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

        jButtonFECHAR.setText("FECHAR");
        jButtonFECHAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFECHARActionPerformed(evt);
            }
        });

        jButtonBUSCAR.setText("BUSCAR");
        jButtonBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBUSCARActionPerformed(evt);
            }
        });

        jLabel6.setText("ORIGEM:");

        jLabel7.setText("DESTINO:");

        jLabel8.setText("VEÍCULO:");

        jComboBoxVEICULO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxVEICULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVEICULOActionPerformed(evt);
            }
        });

        jLabel9.setText("PLACA:");

        jLabel10.setText("DATA DA VIAGEM:");

        jTextFieldPLACA.setEditable(false);

        jRadioButtonORIGEM.setText("Origem");
        jRadioButtonORIGEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonORIGEMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxVEICULO, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxMMOTORISTA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel3)
                                    .addGap(56, 56, 56))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDESTINO)
                            .addComponent(jTextFieldCODIGO, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldORIGEM)
                            .addComponent(jComboBoxPASSAGEIRO, javax.swing.GroupLayout.Alignment.TRAILING, 0, 306, Short.MAX_VALUE))))
                .addGap(96, 96, 96)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPLACA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButtonNOVO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonGRAVAR)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEXCLUIR))
                            .addComponent(jLabel10)
                            .addComponent(jDateChooserDATAVIAGEM, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFECHAR))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonORIGEM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButtonBUSCAR))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addComponent(jButtonFECHAR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPESQUISAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonORIGEM)
                    .addComponent(jButtonBUSCAR))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPLACA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldORIGEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldDESTINO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jDateChooserDATAVIAGEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPASSAGEIRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxMMOTORISTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxVEICULO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNOVO)
                    .addComponent(jButtonGRAVAR)
                    .addComponent(jButtonEXCLUIR))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jRadioButtonDESTINO.setText("Destino");
        jRadioButtonDESTINO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDESTINOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(572, Short.MAX_VALUE)
                .addComponent(jRadioButtonDESTINO)
                .addGap(120, 120, 120))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonDESTINO)
                .addContainerGap(549, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxVEICULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVEICULOActionPerformed
    }//GEN-LAST:event_jComboBoxVEICULOActionPerformed

    private void jButtonBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBUSCARActionPerformed
        // TODO add your handling code here:
        try {
            String consulta = jTextFieldPESQUISAR.getText();
            DefaultTableModel model = (DefaultTableModel) jTableLISTAVIAGEM.getModel();
            model.setNumRows(0);
            if (jRadioButtonORIGEM.isSelected()) {
//                Iterator<EViagem> listaViagem = new NViagem().consultaPorFiltro(true, consulta);

                new NViagem().consultaPorFiltro(true, consulta).forEachRemaining(listViagem -> {
                    model.addRow(new Object[]{
                        listViagem.getCodigo(),
                        listViagem.getOrigem(),
                        listViagem.getDestino(),
                        listViagem.getCodigoPassageiro().getNome(),
                        listViagem.getCodigoMotorista().getNome(),
                        listViagem.getCodigoVeiculo().getNome(),
                        listViagem.getCodigoVeiculo().getPlaca(),
                        listViagem.getDataViagem()
                    });
                });

//                while (listaViagem.hasNext()) {
//                    EViagem listViagem = listaViagem.next();
//                    model.addRow(new Object[]{
//                        listViagem.getCodigo(),
//                        listViagem.getOrigem(),
//                        listViagem.getDestino(),
//                        listViagem.getCodigoPassageiro().getNome(),
//                        listViagem.getCodigoMotorista().getNome(),
//                        listViagem.getCodigoVeiculo().getNome(),
//                        listViagem.getCodigoVeiculo().getPlaca(),
//                        listViagem.getDataViagem()
//                    });
//                }
            } else if (jRadioButtonDESTINO.isSelected()) {
//                Iterator<EViagem> listaViagem = new NViagem().consultaPorFiltro(false, consulta);

                new NViagem().consultaPorFiltro(false, consulta).forEachRemaining(listViagem -> {
                    model.addRow(new Object[]{
                        listViagem.getCodigo(),
                        listViagem.getOrigem(),
                        listViagem.getDestino(),
                        listViagem.getCodigoPassageiro().getNome(),
                        listViagem.getCodigoMotorista().getNome(),
                        listViagem.getCodigoVeiculo().getNome(),
                        listViagem.getCodigoVeiculo().getPlaca(),
                        listViagem.getDataViagem()
                    });
                });

//                while (new NViagem().consultaPorFiltro(false, consulta).hasNext()) {
//                    EViagem listViagem = listaViagem.next();
//                    model.addRow(new Object[]{
//                        listViagem.getCodigo(),
//                        listViagem.getOrigem(),
//                        listViagem.getDestino(),
//                        listViagem.getCodigoPassageiro().getNome(),
//                        listViagem.getCodigoMotorista().getNome(),
//                        listViagem.getCodigoVeiculo().getNome(),
//                        listViagem.getCodigoVeiculo().getPlaca(),
//                        listViagem.getDataViagem()
//                    });
//                }
            } else {
                listarViagem();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, botão Buscar = " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonBUSCARActionPerformed

    private void jButtonFECHARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFECHARActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonFECHARActionPerformed

    private void jButtonNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNOVOActionPerformed
        // TODO add your handling code here:
        limparCampos();
        listarViagem();
    }//GEN-LAST:event_jButtonNOVOActionPerformed

    private void jButtonEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEXCLUIRActionPerformed
        // TODO add your handling code here:
        try {
            int codigoViagem = Integer.parseInt(jTextFieldCODIGO.getText());
            String origem = jTextFieldORIGEM.getText();
            String destino = jTextFieldDESTINO.getText();
            String passageiro = jComboBoxPASSAGEIRO.getSelectedItem().toString();
            int codigoPassageiro = Integer.parseInt(passageiro.split(" ")[0]);

            String motorista = (String) jComboBoxMMOTORISTA.getSelectedItem();
            int codigoMotorista = Integer.parseInt(motorista.split(" ")[0]);
            String veiculo = (String) jComboBoxVEICULO.getSelectedItem();
            int codigoVeiculo = Integer.parseInt(veiculo.split(" ")[0]);
            String dataViagem = null;
            if (jDateChooserDATAVIAGEM.getDate() != null) {
                String datePattern = "yyyy-MM-dd";
                SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
                dataViagem = dateFormatter.format(jDateChooserDATAVIAGEM.getDate());
            }

            EViagem viagem = new EViagem(codigoViagem, origem, destino,
                    new NPassageiro().consultaPorCodigo(codigoPassageiro),
                    new NMotorista().consultaPorCodigo(codigoMotorista),
                    new NVeiculo().consultaPorCodigo(codigoVeiculo), dataViagem);

            new NViagem().excluir(viagem);

            listarViagem();

            limparCampos();
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, botão Excluir = " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonEXCLUIRActionPerformed

    private void jComboBoxMMOTORISTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMMOTORISTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMMOTORISTAActionPerformed

    private void jButtonGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGRAVARActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextFieldCODIGO.getText().length() == 0) {
                String origem = jTextFieldORIGEM.getText();
                String destino = jTextFieldDESTINO.getText();
                String passageiro = jComboBoxPASSAGEIRO.getSelectedItem().toString();
                int codigoPassageiro = Integer.parseInt(passageiro.split(" ")[0]);

                String motorista = (String) jComboBoxMMOTORISTA.getSelectedItem();
                int codigoMotorista = Integer.parseInt(motorista.split(" ")[0]);
                String veiculo = (String) jComboBoxVEICULO.getSelectedItem();
                int codigoVeiculo = Integer.parseInt(veiculo.split(" ")[0]);
                String dataViagem = null;
                if (jDateChooserDATAVIAGEM.getDate() != null) {
                    String datePattern = "yyyy-MM-dd";
                    SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
                    dataViagem = dateFormatter.format(jDateChooserDATAVIAGEM.getDate());
                }

                EViagem viagem = new EViagem(origem, destino,
                        new NPassageiro().consultaPorCodigo(codigoPassageiro),
                        new NMotorista().consultaPorCodigo(codigoMotorista),
                        new NVeiculo().consultaPorCodigo(codigoVeiculo), dataViagem);
                String valor = jTextFieldCODIGO.getText();
                DadosDeViagem dados = new DadosDeViagem(viagem);

                new NViagem().salvar(viagem, valor);
                central.setDados(dados);

                listarViagem();

                limparCampos();
            } else {
                int codigoViagem = Integer.parseInt(jTextFieldCODIGO.getText());
                String origem = jTextFieldORIGEM.getText();
                String destino = jTextFieldDESTINO.getText();
                String passageiro = jComboBoxPASSAGEIRO.getSelectedItem().toString();
                int codigoPassageiro = Integer.parseInt(passageiro.split(" ")[0]);

                String motorista = (String) jComboBoxMMOTORISTA.getSelectedItem();
                int codigoMotorista = Integer.parseInt(motorista.split(" ")[0]);
                String veiculo = (String) jComboBoxVEICULO.getSelectedItem();
                int codigoVeiculo = Integer.parseInt(veiculo.split(" ")[0]);
                String dataViagem = null;
                if (jDateChooserDATAVIAGEM.getDate() != null) {
                    String datePattern = "yyyy-MM-dd";
                    SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
                    dataViagem = dateFormatter.format(jDateChooserDATAVIAGEM.getDate());
                }

                EViagem viagem = new EViagem(codigoViagem, origem, destino,
                        new NPassageiro().consultaPorCodigo(codigoPassageiro),
                        new NMotorista().consultaPorCodigo(codigoMotorista),
                        new NVeiculo().consultaPorCodigo(codigoVeiculo), dataViagem);
                String valor = jTextFieldCODIGO.getText();
                DadosDeViagem dados = new DadosDeViagem(viagem);

                new NViagem().salvar(viagem, valor);
                central.setDados(dados);

                listarViagem();

                limparCampos();
            }

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na TelaViagem, botão gravar = " + e.getMessage());
        }
    }//GEN-LAST:event_jButtonGRAVARActionPerformed

    private void jTableLISTAVIAGEMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLISTAVIAGEMMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableLISTAVIAGEM.getModel();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        jTextFieldCODIGO.setEnabled(false);
        int selecionado = jTableLISTAVIAGEM.getSelectedRow();

        if (model.getValueAt(selecionado, 0) != null) {
            jTextFieldCODIGO.setText(model.getValueAt(selecionado, 0).toString());
        }
        if (model.getValueAt(selecionado, 1) != null) {
            jTextFieldORIGEM.setText(model.getValueAt(selecionado, 1).toString());
        }
        if (model.getValueAt(selecionado, 2) != null) {
            jTextFieldDESTINO.setText(model.getValueAt(selecionado, 2).toString());
        }
        if (model.getValueAt(selecionado, 3) != null) {
            jComboBoxPASSAGEIRO.setSelectedItem(model.getValueAt(selecionado, 3).toString());
        }
        if (model.getValueAt(selecionado, 4) != null) {
            jComboBoxMMOTORISTA.setSelectedItem(model.getValueAt(selecionado, 4).toString());
        }
        if (model.getValueAt(selecionado, 5) != null) {
            jComboBoxVEICULO.setSelectedItem(model.getValueAt(selecionado, 5).toString());
        }
        if (model.getValueAt(selecionado, 6) != null) {
            jTextFieldPLACA.setText(model.getValueAt(selecionado, 6).toString());
        }
        if (model.getValueAt(selecionado, 7) != null) {
            try {
                DateTime data = DateTime.parse(model.getValueAt(selecionado, 7).toString());
                Date data2 = data.toDate();
                jDateChooserDATAVIAGEM.setDate(data2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTableLISTAVIAGEMMouseClicked

    private void jRadioButtonORIGEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonORIGEMActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonORIGEM.isSelected()) {
            jRadioButtonDESTINO.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonORIGEMActionPerformed

    private void jRadioButtonDESTINOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDESTINOActionPerformed
        // TODO add your handling code here:
        if (jRadioButtonDESTINO.isSelected()) {
            jRadioButtonORIGEM.setSelected(false);
        }
    }//GEN-LAST:event_jRadioButtonDESTINOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBUSCAR;
    private javax.swing.JButton jButtonEXCLUIR;
    private javax.swing.JButton jButtonFECHAR;
    private javax.swing.JButton jButtonGRAVAR;
    private javax.swing.JButton jButtonNOVO;
    private javax.swing.JComboBox<String> jComboBoxMMOTORISTA;
    private javax.swing.JComboBox<String> jComboBoxPASSAGEIRO;
    private javax.swing.JComboBox<String> jComboBoxVEICULO;
    private com.toedter.calendar.JDateChooser jDateChooserDATAVIAGEM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonDESTINO;
    private javax.swing.JRadioButton jRadioButtonORIGEM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLISTAVIAGEM;
    private javax.swing.JTextField jTextFieldCODIGO;
    private javax.swing.JTextField jTextFieldDESTINO;
    private javax.swing.JTextField jTextFieldORIGEM;
    private javax.swing.JTextField jTextFieldPESQUISAR;
    private javax.swing.JTextField jTextFieldPLACA;
    // End of variables declaration//GEN-END:variables
}
