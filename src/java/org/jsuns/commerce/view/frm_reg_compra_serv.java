package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Compra;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.commerce.jpa.TipoDocumento;
import org.jsuns.swing.XPanel;

public class frm_reg_compra_serv extends XPanel{
/*
    Cl_Varios ven = new Cl_Varios();
    Proveedor pro = new Proveedor();
    Compra com = new Compra();
    Almacen alm = new Almacen();
    TipoDocumento tido = new TipoDocumento();
    TipoPago tipa = new TipoPago();
    public static DefaultTableModel detalle;
    public static DecimalFormat formato = new DecimalFormat("####0.00");
    Integer i;

    public frm_reg_compra_serv() {
        initComponents();
        txt_fec_com.setDate(ven.getFechaActual());
        txt_fec_pag.setDate(ven.getFechaActual());
        cbx_alm.setStore(Almacen.class);
        cbx_alm.load();
        cbx_tido.setStore(TipoDocumento.class);
        cbx_tido.load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_raz = new javax.swing.JTextField();
        btn_busp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_glosa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_sub = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        txt_tot = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_ser = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_nro = new javax.swing.JTextField();
        cbx_tipa = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_fec_com = new org.jsuns.swing.XDateField();
        txt_fec_pag = new org.jsuns.swing.XDateField();
        cbx_alm = new org.jsuns.swing.XComboBox();
        cbx_tido = new org.jsuns.swing.XComboBox();

        setTitle("Registrar Gasto Directo");

        jLabel1.setBackground(new java.awt.Color(254, 254, 254));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("RUC:");
        jLabel1.setFocusable(false);

        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rucKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(254, 254, 254));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Razon Social:");
        jLabel2.setFocusable(false);

        txt_raz.setEditable(false);
        txt_raz.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_raz.setFocusable(false);

        btn_busp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_busp.setFocusable(false);
        btn_busp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buspActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(254, 254, 254));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Fecha de Compra:");
        jLabel4.setFocusable(false);

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Fecha de Pago:");
        jLabel5.setFocusable(false);

        jLabel6.setBackground(new java.awt.Color(254, 254, 254));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(212, 2, 2));
        jLabel6.setText("Direccion:");
        jLabel6.setFocusable(false);

        txt_dir.setEditable(false);
        txt_dir.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_dir.setFocusable(false);

        jLabel7.setBackground(new java.awt.Color(254, 254, 254));
        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(212, 2, 2));
        jLabel7.setText("Telefono:");
        jLabel7.setFocusable(false);

        txt_tel.setEditable(false);
        txt_tel.setFocusable(false);

        jLabel10.setBackground(new java.awt.Color(254, 254, 254));
        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(212, 2, 2));
        jLabel10.setText("Glosa.");
        jLabel10.setFocusable(false);

        txt_glosa.setEditable(false);
        txt_glosa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_glosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_glosaKeyPressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(254, 254, 254));
        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(212, 2, 2));
        jLabel11.setText("Sub Total:");
        jLabel11.setFocusable(false);

        jLabel12.setBackground(new java.awt.Color(254, 254, 254));
        jLabel12.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(212, 2, 2));
        jLabel12.setText("IGV");
        jLabel12.setFocusable(false);

        jLabel13.setBackground(new java.awt.Color(254, 254, 254));
        jLabel13.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(212, 2, 2));
        jLabel13.setText("Total:");
        jLabel13.setFocusable(false);

        txt_sub.setEditable(false);
        txt_sub.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_sub.setFocusable(false);
        txt_sub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_subKeyPressed(evt);
            }
        });

        txt_igv.setEditable(false);
        txt_igv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_igv.setFocusable(false);

        txt_tot.setEditable(false);
        txt_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totActionPerformed(evt);
            }
        });
        txt_tot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totKeyPressed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        btn_reg.setText("Aceptar");
        btn_reg.setEnabled(false);
        btn_reg.setMargin(new java.awt.Insets(2, 8, 2, 8));
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

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(254, 254, 254));
        jLabel14.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(212, 2, 2));
        jLabel14.setText("Tipo de Documento:");
        jLabel14.setFocusable(false);

        jLabel15.setBackground(new java.awt.Color(254, 254, 254));
        jLabel15.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(212, 2, 2));
        jLabel15.setText("Serie:");
        jLabel15.setFocusable(false);

        txt_ser.setEditable(false);
        txt_ser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_serKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(254, 254, 254));
        jLabel16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(212, 2, 2));
        jLabel16.setText("Nro. Doc:");
        jLabel16.setFocusable(false);

        txt_nro.setEditable(false);
        txt_nro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nroKeyTyped(evt);
            }
        });

        cbx_tipa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONTADO", "CREDITO" }));
        cbx_tipa.setEnabled(false);
        cbx_tipa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tipaKeyPressed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(254, 254, 254));
        jLabel17.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(212, 2, 2));
        jLabel17.setText("Tipo de Pago:");

        jLabel18.setBackground(new java.awt.Color(254, 254, 254));
        jLabel18.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(212, 2, 2));
        jLabel18.setText("Tienda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(25, 25, 25)
                                .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_cer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_glosa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_raz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_busp))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx_tipa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nro, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_fec_pag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(55, 55, 55)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_busp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_tipa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fec_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_tido, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_glosa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sub)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_alm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_busp.doClick();
        }else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pro.setRuc(txt_ruc.getText());
            pro=JPA.getInstance().getEntityManager().find(Proveedor.class,txt_ruc.getText());
            if(pro!=null){
                txt_raz.setText(pro.getRazonSocial());
                txt_dir.setText(pro.getDireccion());
                txt_tel.setText(pro.getTelefono());
                btn_bus_emp.setEnabled(true);
                btn_bus_emp.requestFocus();
            }else{
                txt_ruc.setText("");
                txt_ruc.requestFocus();
                JOptionPane.showMessageDialog(null, "El Proveedor no existe \nPor favor ingrese otro nro de RUC");
            }
            JPA.getInstance().close();
            cbx_tipa.setEnabled(true);
            cbx_tipa.requestFocus();
        }
    }//GEN-LAST:event_txt_rucKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        frm_ver_compras_serv compra = new frm_ver_compras_serv();
        ven.open(compra);
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_serKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_ser.getText().isEmpty()) {
                txt_nro.setEditable(true);
                txt_nro.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_serKeyPressed

    private void txt_nroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_nro.getText().isEmpty()) {
                txt_glosa.setEditable(true);
                txt_glosa.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_nroKeyPressed

    private void btn_buspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buspActionPerformed
        frm_ver_proveedores proveedor = new frm_ver_proveedores();
        proveedor.funcion = "compra_serv";
        ven.open(proveedor);
    }//GEN-LAST:event_btn_buspActionPerformed

    private void llenar() {
        com.setGlosa(txt_glosa.getText());
        com.setFechaDoc(txt_fec_com.getDate());
        com.setFechaPago(txt_fec_pag.getDate());
        tido.setIdTipoDoc(cbx_tido.getSelectedIndex() + 1);
        tipa.setIdTipoPago(cbx_tipa.getSelectedIndex() + 1);
        com.setSerie(Integer.parseInt(txt_ser.getText()));
        com.setNroDoc(Integer.parseInt(txt_nro.getText()));
        pro.setRuc(txt_ruc.getText());
        com.setEstado("" + (cbx_tipa.getSelectedIndex() + 1));
        com.setTotal(new BigDecimal(txt_tot.getText()));
        alm.setIdAlmacen(cbx_alm.getSelectedIndex() + 1);
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        //Registrar Compra
        com.setNick(frm_menu.lbl_user.getText());
        com.setIdAlmacen(alm.getIdAlmacen());
        com.setIdTipoDoc(tido);
        com.setIdTipoPago(tipa.getIdTipoPago());
        com.setEstado("S");
        EntityManager em=JPA.getInstance().getEntityManager(true);
        em.persist(com);
        //registrar en movimientos. 
        if (cbx_tipa.getSelectedItem().equals("CONTADO")) {
            String glosa = "COMPRA DE SERVICIOS - " + cbx_tido.getSelectedItem().toString() + " / " + com.getSerie() + " - " + com.getNumero() + " - " + pro.getRuc();
            Movimiento movimiento=new Movimiento();
            movimiento.setGlosa(glosa);
            movimiento.setFecMov(com.getFechaDoc());
            movimiento.setEgreso(com.getTotal());
            movimiento.setNick(X.getUser());
            movimiento.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
            movimiento.setFlag("C");
            //            m.setidCAja();
            em.persist(movimiento);
        }
        JPA.getInstance().close();
        // Mostrar Vista Compras Servicios
        ven.open(new frm_ver_compras_serv());
        this.close();
    }//GEN-LAST:event_btn_regActionPerformed

    private void txt_rucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyTyped
        if (txt_ruc.getText().length() == 11) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_rucKeyTyped

    private void txt_serKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyTyped
        if (txt_ser.getText().length() == 3) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_serKeyTyped

    private void txt_nroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroKeyTyped
        if (txt_nro.getText().length() == 7) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nroKeyTyped

    private void txt_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totActionPerformed

    private void cbx_tipaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tipaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_fec_com.setEditable(true);
            txt_fec_com.requestFocus();
        }
    }//GEN-LAST:event_cbx_tipaKeyPressed

    private void txt_glosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_glosaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_glosa.getText().isEmpty()) {
                cbx_alm.setEnabled(true);
                cbx_alm.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_glosaKeyPressed

    private double igv() {
        double igv = 0.00;
        igv = com.getTotal().doubleValue() / 1.18 * 0.18;
        return igv;
    }

    private double sub() {
        double sub = 0.00;
        sub = com.getTotal().doubleValue() / 1.18;
        return sub;
    }


    private void txt_subKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_subKeyPressed

    }//GEN-LAST:event_txt_subKeyPressed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_reg.doClick();
        }
    }//GEN-LAST:event_btn_regKeyPressed

    private void txt_totKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_tot.getText().isEmpty()) {
                com.setTotal(new BigDecimal(txt_tot.getText()));
                txt_igv.setText(formato.format(igv()));
                txt_sub.setText(formato.format(sub()));
                btn_reg.setEnabled(true);
                btn_reg.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_totKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_busp;
    private javax.swing.JButton btn_cer;
    public static javax.swing.JButton btn_reg;
    private org.jsuns.swing.XComboBox cbx_alm;
    private org.jsuns.swing.XComboBox cbx_tido;
    public static javax.swing.JComboBox cbx_tipa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JTextField txt_dir;
    private org.jsuns.swing.XDateField txt_fec_com;
    private org.jsuns.swing.XDateField txt_fec_pag;
    private javax.swing.JTextField txt_glosa;
    public static javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_nro;
    public static javax.swing.JTextField txt_raz;
    public static javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_ser;
    public static javax.swing.JTextField txt_sub;
    public static javax.swing.JTextField txt_tel;
    public static javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables
*/}
