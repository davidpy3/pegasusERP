package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Cliente;
import java.awt.event.KeyEvent;
import org.jsuns.data.JPA;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_reg_cliente extends XPanel {

    Cliente cli = new Cliente();

    public frm_reg_cliente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbx_cli = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txt_ndoc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        txt_tel1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setTitle("Registrar Cliente");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Tipo de Documento:");

        cbx_cli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "RUC" }));
        cbx_cli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_cliKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Nro de Doc:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Nombre Completo:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Direccion:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Telefono:");

        txt_dir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dirKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dirKeyTyped(evt);
            }
        });

        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_telKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disk.png"))); // NOI18N
        btn_reg.setText("Guardar");
        btn_reg.setEnabled(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });
        btn_reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_regKeyPressed(evt);
            }
        });

        txt_tel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tel1KeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("Telefono 2 :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 89, Short.MAX_VALUE))
                            .addComponent(txt_nom)
                            .addComponent(txt_ndoc, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addGap(101, 101, 101)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_cli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private Cliente llenar() {
        cli=new Cliente();
        if (cbx_cli.getSelectedIndex() == 0) {
            cli.setTipoDoc("DNI");
        }
        if (cbx_cli.getSelectedIndex() == 1) {
            cli.setTipoDoc("RUC");
        }
        cli.setNombreCompleto(txt_nom.getText());
        cli.setNroDoc(txt_ndoc.getText());
        cli.setDireccion(txt_dir.getText());
        cli.setTelefono(txt_tel.getText());
        cli.setTelefono2(txt_tel1.getText());
        return cli;
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        cli=llenar();
        JPA.getInstance().getEntityManager(true).persist(cli);
        JPA.getInstance().close();
        findSelectionListener.valueChanged(new FindSelectionEvent(cli, null, 0));
        close();
    }//GEN-LAST:event_btn_regActionPerformed

    public FindSelectionListener getFindSelectionListener() {
        return findSelectionListener;
    }

    public void setFindSelectionListener(FindSelectionListener findSelectionListener) {
        this.findSelectionListener = findSelectionListener;
    }

    FindSelectionListener findSelectionListener;

    private void txt_dirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dirKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_dir.getText().length() > 0) {
                txt_tel.setEditable(true);
                txt_tel.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_dirKeyPressed

    private void txt_telKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_tel.getText().length() > 0) {
                txt_tel1.setEditable(true);
                txt_tel1.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_telKeyPressed

    private void txt_tel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_tel1.getText().length() > 0) {
                btn_reg.setEnabled(true);
                btn_reg.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_tel1KeyPressed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_reg.doClick();
        }
    }//GEN-LAST:event_btn_regKeyPressed

    private void txt_dirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dirKeyTyped
        if (txt_dir.getText().length() == 245) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_dirKeyTyped

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
        if (txt_tel.getText().length() == 9) {
            evt.consume();
        }

    }//GEN-LAST:event_txt_telKeyTyped

    private void txt_tel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel1KeyTyped
        if (txt_tel1.getText().length() == 9) {
            evt.consume();
        }

    }//GEN-LAST:event_txt_tel1KeyTyped

    private void cbx_cliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_cliKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_ndoc.setEditable(true);
            txt_ndoc.requestFocus();
        }
    }//GEN-LAST:event_cbx_cliKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reg;
    private javax.swing.JComboBox cbx_cli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_ndoc;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txt_tel1;
    // End of variables declaration//GEN-END:variables

    public void setCliente(Object cliente) {
        if (cliente instanceof Cliente) {
            cli = (Cliente) cliente;
        } else {
            cli = JPA.getInstance().get(Cliente.class, cliente);
            JPA.getInstance().close();
        }
        cbx_cli.setSelectedItem(cli.getTipoDoc());
        txt_ndoc.setText(cli.getNroDoc());
        txt_nom.setText(cli.getNombreCompleto());
        txt_nom.setEditable(true);
        txt_nom.requestFocus();
        txt_dir.setText(cli.getDirPer());
        txt_tel.setText(cli.getTelPer());
        txt_tel.setEditable(true);
        txt_tel1.setText(cli.getTelefono2());
        txt_tel1.setEditable(true);
        btn_reg.setEnabled(true);
    }
}
