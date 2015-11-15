package org.jsuns.commerce.view;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Compra;
import org.jsuns.commerce.jpa.CompraPago;
import org.jsuns.swing.XPanel;

public class frm_ver_cuota_compra extends XPanel{
/*
    public Compra com = new Compra();
    public DefaultTableModel mostrar;
    private DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    private DecimalFormat formato = null;
    private String origen;
    private int i;

    public frm_ver_cuota_compra() {
        initComponents();
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);
    }

    public double tot_cuotas() {
        double total = 0;
        int filas = t_cuotas.getRowCount();
        for (int j = 0; j < filas; j++) {
            total += Double.parseDouble(t_cuotas.getValueAt(j, 3).toString());
        }
        return total;
    }

    public double pendiente() {
        double pendiente = 0;
        double total = Double.parseDouble(txt_dtot.getText());
        pendiente = total - tot_cuotas();
        return pendiente;
    }

    public double pagado() {
        double pagado = 0;
        int filas = t_cuotas.getRowCount();
        for (int j = 0; j < filas; j++) {
            if (t_cuotas.getValueAt(j, 4).equals("Pagado")) {
                pagado += Double.parseDouble(t_cuotas.getValueAt(j, 3).toString());
            }
        }
        return pagado;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        txt_raz = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_cont = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_tipd = new javax.swing.JTextField();
        txt_sndoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fec = new org.jsuns.swing.XDateField();
        jPanel3 = new javax.swing.JPanel();
        btn_addc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_cuotas = new javax.swing.JTable();
        btn_elic = new javax.swing.JButton();
        btn_verd = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        btn_regp = new javax.swing.JButton();
        txt_dtot = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_pag = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_pen = new javax.swing.JTextField();

        setTitle("Ver Cuotas por Pagos de Compras");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Datos del Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Proveedor.");

        txt_ruc.setEditable(false);
        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_raz.setEditable(false);

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Contacto:");

        txt_cont.setEditable(false);

        txt_tel.setEditable(false);
        txt_tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_raz))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Documento:");

        txt_tipd.setEditable(false);

        txt_sndoc.setEditable(false);
        txt_sndoc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Fecha de Compra");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tipd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_sndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tipd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sndoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cuotas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.red)); // NOI18N

        btn_addc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add.png"))); // NOI18N
        btn_addc.setText("Agregar Cuotas");
        btn_addc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcActionPerformed(evt);
            }
        });

        t_cuotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nro. Cuota", "Fec. Pago", "Fec. Venc.", "Monto", "Estado"
            }
        ));
        t_cuotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_cuotasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_cuotas);

        btn_elic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cross.png"))); // NOI18N
        btn_elic.setText("Eliminar");
        btn_elic.setEnabled(false);
        btn_elic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elicActionPerformed(evt);
            }
        });

        btn_verd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/clipboard_text.png"))); // NOI18N
        btn_verd.setText("Ver Detalle de Pago");

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_regp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/coins.png"))); // NOI18N
        btn_regp.setText("Registrar Pago");
        btn_regp.setEnabled(false);
        btn_regp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regpActionPerformed(evt);
            }
        });

        txt_dtot.setEditable(false);
        txt_dtot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Deuda Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_regp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_addc))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_elic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_verd)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_dtot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cer)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_regp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_dtot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_elic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_verd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Total Cuotas:");

        txt_tot.setEditable(false);
        txt_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Monto Pagado:");

        txt_pag.setEditable(false);
        txt_pag.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Monto Pendiente:");

        txt_pen.setEditable(false);
        txt_pen.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_pen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcActionPerformed
        frm_reg_cuota reg=new frm_reg_cuota();
        reg.setCompra(com);
        reg.open();
    }//GEN-LAST:event_btn_addcActionPerformed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        if (origen.equals("paga_producto")) {
            frm_ver_compras_articulo producto = new frm_ver_compras_articulo();
            ven.open(producto);
        }
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void t_cuotasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_cuotasMousePressed
        i = t_cuotas.getSelectedRow();
        String estado = t_cuotas.getValueAt(i, 4).toString();
        if (estado.equals("Pendiente")) {
            btn_regp.setEnabled(true);
            btn_elic.setEnabled(true);
            btn_verd.setEnabled(true);
        } else {
            btn_regp.setEnabled(false);
        }

    }//GEN-LAST:event_t_cuotasMousePressed

    private void btn_regpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regpActionPerformed
        frm_reg_pago_compra pagar = new frm_reg_pago_compra();
        pagar.setCompra(com);
        pagar.setPago(t_cuotas.getValueAt(i, 0).toString());
        ven.open(pagar);
        this.close();
    }//GEN-LAST:event_btn_regpActionPerformed

    private void btn_elicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elicActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar la compra?");
        if (JOptionPane.OK_OPTION == confirmado) {
            int id = Integer.parseInt(t_cuotas.getValueAt(i, 0).toString());
            if (t_cuotas.getValueAt(i, 4).equals("Pendiente")){
                    EntityManager em=JPA.getInstance().getEntityManager(true);
                    em.remove(em.find(CompraPago.class,id));
                    JPA.getInstance().close();
            } 
            retrieve();
        }
    }//GEN-LAST:event_btn_elicActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addc;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_elic;
    private javax.swing.JButton btn_regp;
    private javax.swing.JButton btn_verd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_cuotas;
    private javax.swing.JTextField txt_cont;
    private javax.swing.JTextField txt_dtot;
    public org.jsuns.swing.XDateField txt_fec;
    private javax.swing.JTextField txt_pag;
    private javax.swing.JTextField txt_pen;
    private javax.swing.JTextField txt_raz;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_sndoc;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txt_tipd;
    private javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables

    public void setCompra(Object compra){
        if(compra instanceof Compra)
            this.com=(Compra)compra;
        else
            this.com=JPA.getInstance().get(Compra.class,compra);
        txt_ruc.setText(com.getRuc());
        txt_tipd.setText(com.getTipoDoc().getDescripcion());
        txt_sndoc.setText(com.getSerie()+" - "+com.getNumero());
        txt_fec.setValue(com.getFechaDoc());
        Proveedor proveedor=JPA.getInstance().get(Proveedor.class,com.getRucPro());
        txt_raz.setText(proveedor.getRazonSocial());
        txt_cont.setText(proveedor.getContacto());
        txt_tel.setText(proveedor.getTelefono1()+" - "+proveedor.getTelefono2());
        
        retrieve();
        txt_dtot.setText(formato.format(com.getTotal()));
        txt_tot.setText(formato.format(tot_cuotas()));
        txt_pen.setText(formato.format(pendiente()));
        txt_pag.setText(formato.format(pagado()));
        origen = "paga_producto";
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        mostrar.addColumn("Nro Cuota");
        mostrar.addColumn("Fecha Pago");
        mostrar.addColumn("Fec. Venc.");
        mostrar.addColumn("Monto");
        mostrar.addColumn("Estado");
        for(CompraPago c:JPA.getInstance().getEntityManager()
                .createQuery("SELECT c FROM CompraPago c WHERE c.idCompra=:compra",
                CompraPago.class).setParameter("compra",com).getResultList()){
                           Object fila[] = new Object[5];
            fila[0] =c.getIdPago();
            fila[1]=c.getFecPago();
            fila[2]=c.getFecVenc();
            fila[3]=c.getMonto();
            fila[4]=c.getEstado()==0?"Pendiente":"Pagado";
            mostrar.addRow(fila); 
        }
        JPA.getInstance().close();
        t_cuotas.setModel(mostrar);
        txt_dtot.setText(formato.format(com.getTotal()));
        txt_tot.setText(formato.format(tot_cuotas()));
        txt_pen.setText(formato.format(pendiente()));
        txt_pag.setText(formato.format(pagado()));
    }

    public void retrieve() {
            DefaultTableModel mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            mostrar.addColumn("Nro Cuota");
            mostrar.addColumn("Fecha Pago");
            mostrar.addColumn("Fec. Venc.");
            mostrar.addColumn("Monto");
            mostrar.addColumn("Estado");
            for(CompraPago compraPago:JPA.getInstance().getEntityManager().createQuery("SELECT p FROM CompraPago p WHERE p.idCompra=:compra",CompraPago.class).setParameter("compra",com).getResultList()){
                Object fila[] = new Object[5];
                fila[0] =compraPago.getIdPago();
                fila[1] =compraPago.getFecPago();
                fila[2] =compraPago.getFecVenc();
                fila[3] =compraPago.getMonto();
                fila[4] =compraPago.getEstado()==0?"Pendiente":"Pagado";
                mostrar.addRow(fila);
            }
            JPA.getInstance().close();
            t_cuotas.setModel(mostrar);
            t_cuotas.updateUI();
                        ven.centrar_celda(t_cuotas, 1);
            ven.centrar_celda(t_cuotas, 2);
            ven.derecha_celda(t_cuotas, 3);
            ven.centrar_celda(t_cuotas, 4);

        txt_dtot.setText(formato.format(com.getTotal()));
        txt_tot.setText(formato.format(tot_cuotas()));
        txt_pen.setText(formato.format(pendiente()));
        txt_pag.setText(formato.format(pagado()));
    }*/
}
