package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.persistence.EntityManager;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Compra;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.CompraPago;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.commerce.jpa.TipoPago;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_reg_pago_compra extends XPanel{
/*
    private Cl_Varios ven = new Cl_Varios();
    private Compra com = new Compra();
    private String idpago;
    private Double deuda = 0.00;
    private Double pagado = 0.00;
    private Double restante = 0.00;
    private String funcion = "pagar";
    private String glosa = "";
    private Double queda = 0.00;
    private Double real = 0.00;
    private DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    private DecimalFormat formato = null;

    public frm_reg_pago_compra() {
        initComponents();
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);
        txt_fec.setDate(ven.getFechaActual());
        cbx_tipopago.setStore(TipoPago.class);
        cbx_tipopago.load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        txt_ser = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_clo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_fec = new org.jsuns.swing.XDateField();
        cbx_tipopago = new org.jsuns.swing.XComboBox();

        setTitle("Pago de Compras");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Proveedor:");
        jLabel1.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Fecha:");
        jLabel3.setFocusable(false);

        txt_ruc.setEditable(false);
        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc.setFocusable(false);

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

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(212, 2, 2));
        jLabel9.setText("Documento:");
        jLabel9.setFocusable(false);

        txt_ser.setEditable(false);
        txt_ser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ser.setFocusable(false);

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

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(212, 2, 2));
        jLabel10.setText("Forma de Pago");

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
                                .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_raz))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_deu, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_real, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_rest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_add)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_clo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_tipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cbx_tipopago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_deu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_real, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_rest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        EntityManager em=JPA.getInstance().getEntityManager(true);
        CompraPago pago=em.find(CompraPago.class,idpago);
        pago.setFecPago(txt_fec.getDate());
        pago.setMonto(real);
        pago.setEstado(1);
        em.merge(pago);
        if (queda <= 0) {
            com=em.find(Compra.class,com.getIdCompra());
            com.setFechaPago(pago.getFecPago());
            com.setEstado("1");
        }
        Movimiento movimiento=new Movimiento();
        movimiento.setGlosa(glosa);
        movimiento.setFecMov(pago.getFecPago());
        movimiento.setEgreso(new BigDecimal(real));
        movimiento.setNick(X.getUser());
        movimiento.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
        movimiento.setFlag(cbx_tipopago.getSelectedIndex() == 0?"C":"B");
        movimiento.setDestino(""+(cbx_tipopago.getSelectedIndex()==0?
                frm_menu.caja.getIdCaja():frm_menu.cue.getIdCuenta()));
        em.persist(movimiento);
        JPA.getInstance().close();
        findSelectionListener.valueChanged(new FindSelectionEvent(this,null,0));
        this.close();
    }//GEN-LAST:event_btn_addActionPerformed

    private FindSelectionListener findSelectionListener;

    public FindSelectionListener getFindSelectionListener() {
        return findSelectionListener;
    }

    public void setFindSelectionListener(FindSelectionListener findSelectionListener) {
        this.findSelectionListener = findSelectionListener;
    }
    
    private void btn_addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_addKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_add.doClick();
        }
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clo;
    private org.jsuns.swing.XComboBox cbx_tipopago;
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
    private javax.swing.JTextField txt_deu;
    public org.jsuns.swing.XDateField txt_fec;
    protected javax.swing.JTextField txt_pag;
    private javax.swing.JTextField txt_raz;
    private javax.swing.JTextField txt_real;
    private javax.swing.JTextField txt_rest;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_sal;
    private javax.swing.JTextField txt_ser;
    private javax.swing.JTextField txt_tido;
    // End of variables declaration//GEN-END:variables

    public void setCompra(Object c) {
        this.com=(Compra)c;
        txt_ruc.setText(com.getRuc());
//        txt_raz.setText(com.get);
        txt_tido.setText(com.getTipoCompra().toString());
        txt_ser.setText(com.getSerie()+"-"+com.getNumero());
        txt_deu.setText(com.getTotal().toString());
//        Double actual = 0.0;
//        Double pagado = 0.0;
//        actual = Double.parseDouble(txt_dtot.getText());
//        pagado=(Double)JPA.getInstance().getEntityManager().createQuery("select sum(p.monto) from CompraPago p "
//                + "where p.idCompra =:compra and p.estado=1").setParameter("compra",com).getSingleResult();
//        txt_pag.setText(formato.format(pagado));
//        Double res = 0.0;
//        res = actual - pagado;
//        txt_fec.setValue(ven.getFechaActual());
//        txt_sal.setText(formato.format(res));
//        restante = res;
        glosa = "PAGO DE COMPRA - " +com.getTipoDoc()+ " / "+txt_ser.getText() + " - " + txt_ruc.getText();
    }

    public void setPago(Object idPago) {
        idpago=(String)idPago;
    }*/
}
