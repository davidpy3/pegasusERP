package org.jsuns.commerce.view;

import org.jsuns.commerce.view.frm_ver_cuota_compra;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import javax.persistence.EntityManager;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Compra;
import org.jsuns.commerce.jpa.CompraPago;
import org.jsuns.swing.XPanel;
import org.jsuns.util.XDate;

public class frm_reg_cuota extends XPanel{
/*
    Cl_Varios ven = new Cl_Varios();
    private Compra com = new Compra();
    public double monto;
    public String fec_pag;
    public Date fec_venc;
    public String est;
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    DecimalFormat formato = null;

    public frm_reg_cuota() {
        initComponents();
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        txt_fec = new org.jsuns.swing.XDateField();

        setBackground(new java.awt.Color(254, 254, 254));
        setAutoDelete(false);
        setTitle("Registrar Cuota");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Fecha de Vencimiento");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Monto:");

        txt_monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_montoKeyPressed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_reg.setText("Agregar");
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

        txt_fec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fecKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_monto, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_reg)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_montoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (txt_monto.getText().length() > 1) {
                btn_reg.setEnabled(true);
                btn_reg.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_montoKeyPressed

    private void llenar(){
        fec_venc=XDate.getSQLDate((Date)txt_fec.getValue());
        monto=Double.parseDouble(txt_monto.getText());
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        EntityManager em=JPA.getInstance().getEntityManager(true);
        CompraPago c=new CompraPago();
        c.setMonto(monto);
        c.setCompra(com);
        c.setFecVenc(fec_venc);
        c.setFecPago(new Date());
        c.setEstado(0);
        em.persist(c);
        JPA.getInstance().close();
        frm_ver_cuota_compra cuota =new frm_ver_cuota_compra();
        cuota.setCompra(com);
        cuota.retrieve();
        cuota.open();
//            cuota.txt_tot.setText(formato.format(cuota.tot_cuotas()));
//            cuota.txt_pen.setText(formato.format(cuota.pendiente()));
//            cuota.txt_pag.setText(formato.format(cuota.pagado()));
        btn_reg.setEnabled(false);
        close();
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            btn_reg.doClick();
        }
    }//GEN-LAST:event_btn_regKeyPressed

    private void txt_fecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecKeyPressed
        
        
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (txt_fec.getValue()!=null) {
                txt_monto.setEditable(true);
                txt_monto.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_fecKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private org.jsuns.swing.XDateField txt_fec;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables

    public void setCompra(Object com) {
        if(com instanceof Compra)
            this.com=(Compra)com;
    }*/
}
