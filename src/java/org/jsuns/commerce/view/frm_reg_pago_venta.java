package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Pedido;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jsuns.X;
import org.jsuns.util.XDate;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.swing.XPanel;
import org.jsuns.util.XUtil;

public class frm_reg_pago_venta extends XPanel {
/*
    private Cl_Varios ven = new Cl_Varios();
    private Pedido ped = new Pedido();
    private Double deuda = 0.00;
    private Double pagado = 0.00;
    private Double restante = 0.00;
    private String funcion = "pagar";
    private String glosa = "";
    private Double queda = 0.00;
    private Double real = 0.00;
    private DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    private DecimalFormat formato = null;

    public frm_reg_pago_venta() {
        initComponents();
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);
        txt_fec.setDate(ven.getFechaActual());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        txt_raz = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_deu = new javax.swing.JTextField();
        txt_pag = new javax.swing.JTextField();
        txt_sal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_real = new javax.swing.JTextField();
        txt_rest = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_tido = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_clo = new javax.swing.JButton();
        cbx_tipa = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txt_fec = new org.jsuns.swing.XDateField();

        setTitle("Pago de Venta");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Cliente:");
        jLabel1.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Fecha:");
        jLabel3.setFocusable(false);

        txt_dni.setEditable(false);
        txt_dni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dni.setFocusable(false);

        txt_raz.setEditable(false);
        txt_raz.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Deuda Total:");
        jLabel2.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Pagos Realizados:");
        jLabel4.setFocusable(false);

        txt_deu.setEditable(false);
        txt_deu.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_deu.setFocusable(false);

        txt_pag.setEditable(false);
        txt_pag.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_pag.setFocusable(false);

        txt_sal.setEditable(false);
        txt_sal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_sal.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Saldo Actual:");
        jLabel5.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(212, 2, 2));
        jLabel6.setText("Pago a Realizar:");
        jLabel6.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(212, 2, 2));
        jLabel7.setText("Restante");
        jLabel7.setFocusable(false);

        txt_real.setEditable(false);
        txt_real.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_real.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_realKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_realKeyTyped(evt);
            }
        });

        txt_rest.setEditable(false);
        txt_rest.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_rest.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(212, 2, 2));
        jLabel8.setText("Tipo Documento:");
        jLabel8.setFocusable(false);

        txt_tido.setEditable(false);
        txt_tido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tido.setFocusable(false);

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/accept.png"))); // NOI18N
        btn_add.setText("Realizar");
        btn_add.setEnabled(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        btn_add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_addKeyPressed(evt);
            }
        });

        btn_clo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_clo.setText("Salir");
        btn_clo.setFocusable(false);
        btn_clo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cloActionPerformed(evt);
            }
        });

        cbx_tipa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "EFECTIVO", "TARJETA" }));
        cbx_tipa.setEnabled(false);
        cbx_tipa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tipaKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(212, 2, 2));
        jLabel9.setText("Tipo de Pago");
        jLabel9.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_raz))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tido))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_deu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_rest, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txt_real, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(cbx_tipa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_clo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbx_tipa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_real, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_rest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txt_deu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btn_clo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cloActionPerformed
        if (funcion.equals("productos")) {
            frm_ver_compras_articulo compras = new frm_ver_compras_articulo();
            ven.open(compras);
        }
        funcion = "pagar";
        this.close();
    }//GEN-LAST:event_btn_cloActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        Date fecha = XDate.getSQLDate(txt_fec.getDate());
        String tipa = cbx_tipa.getSelectedItem().toString();
        ped.setIdPedido(XUtil.intValue(frm_ver_letras_pedido.id));
        Double monto;
        if (queda <= 0.00) {
            String ins_pago = "insert into letras_pedido Values (null, '" + restante + "', '" + fecha + "', '" + ped.getIdPedido() + "', '" + tipa + "')";

            monto = restante;
            String upd_com = "update pedido set est_ped = '4' where idPedido = '" + ped.getIdPedido() + "'";
        } else {
            monto = real;
            pagado = Double.parseDouble(txt_pag.getText());
            String ins_pago = "insert into letras_pedido Values (null, '" + real + "', '" + fecha + "', '" + ped.getIdPedido() + "', '" + tipa + "')";

            pagado = pagado + monto;
            System.out.println(pagado);
            // TICKET DE SEPARACION
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("idped", ped.getIdPedido());
            parametros.put("Adelanto", monto);
            parametros.put("Acumulado", pagado);
            String filename = "rpt_ticket_separacion";
            ven.imp_reporte(filename, parametros);
        }
        //REGISTRO DE MOVIMIENTO EN CAJA
        if (tipa.equals("EFECTIVO")) {
            String glosa = "CUOTA POR SEPARACION / " + txt_tido.getText() + " / " + txt_dni.getText() + " - " + txt_raz.getText();
            Movimiento movimiento = new Movimiento();
            movimiento.setGlosa(glosa);
            movimiento.setFecMov(fecha);
            movimiento.setIngreso(new BigDecimal("" + monto));
            movimiento.setNick(X.getUser());
            movimiento.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
            movimiento.setFlag("C");
            movimiento.setIdCuenta(frm_menu.caja.getIdCaja());
//            em.persist(movimiento);
        } else {
            String glosa = "CUOTA POR SEPARACION / " + txt_tido.getText() + " / " + txt_dni.getText() + " - " + txt_raz.getText();

            Movimiento m = new Movimiento();
            m.setGlosa(glosa);
            m.setFecMov(fecha);
            m.setIngreso(new BigDecimal(monto));
            m.setNick(X.getUser());
            m.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
            m.setFlag("B");
            m.setIdCuenta(frm_menu.caja.getIdCaja());

        }
        this.close();

    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            btn_add.doClick();
//        }
    }//GEN-LAST:event_btn_addKeyPressed

    private void txt_realKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_realKeyTyped
        if (txt_real.getText().length() == 8) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_realKeyTyped

    private void txt_realKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_realKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_real.getText().length() > 1) {
                real = Double.parseDouble(txt_real.getText());
                queda = restante - real;
                txt_rest.setText(formato.format(queda));
                btn_add.setEnabled(true);
                btn_add.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_realKeyPressed

    private void cbx_tipaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tipaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && txt_fec.getDate() != null) {
            txt_real.setEditable(true);
            txt_real.requestFocus();
        }
    }//GEN-LAST:event_cbx_tipaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clo;
    private javax.swing.JComboBox cbx_tipa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_deu;
    private javax.swing.JTextField txt_dni;
    private org.jsuns.swing.XDateField txt_fec;
    private javax.swing.JTextField txt_pag;
    private javax.swing.JTextField txt_raz;
    private javax.swing.JTextField txt_real;
    private javax.swing.JTextField txt_rest;
    private javax.swing.JTextField txt_sal;
    private javax.swing.JTextField txt_tido;
    // End of variables declaration//GEN-END:variables

    public void setPedido(Pedido pedido) {
        txt_dni.setText(pedido.getCliente().getNroDoc());
        txt_raz.setText(pedido.getCliente().getNombreCompleto());
        txt_tido.setText(pedido.getTipoDoc().toString());
//        txt_deu.setText(pedido.ge);

        try {
//            double subtotal = 0;
//            double to = Double.parseDouble(lbl_total.getText());
//            double res;
//            for (int j = 0; j < t_letras.getRowCount(); j++) {
//                subtotal += Double.parseDouble(t_letras.getValueAt(j, 2).toString());
//            }
//            res = to - subtotal;
//            txt_pag.setText(subtotal + "");
//            txt_sal.setText(res + "");
//            restante=res;
        } catch (Exception e) {
            System.out.println(e);
        }
        txt_fec.requestFocus();
    }*/
}
