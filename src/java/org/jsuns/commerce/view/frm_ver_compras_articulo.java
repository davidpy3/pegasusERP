package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Compra;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.commerce.jpa.AlmacenArticuloPK;
import org.jsuns.commerce.jpa.CompraDetalle;
import org.jsuns.commerce.jpa.CompraQ;
import org.jsuns.commerce.jpa.Kardex;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.commerce.jpa.TipoDocumento;
import org.jsuns.swing.XPanel;
import org.jsuns.util.XMap;

public class frm_ver_compras_articulo extends XPanel{/*
//    Articulo art = new Articulo();
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    DecimalFormat formato = null;
    Integer i;
    String valor;

    public frm_ver_compras_articulo(){
        initComponents();
        t_compras.setStore(CompraQ.class);
        retrieve();
    }

    private void retrieve(){
        String busca=txt_bus.getText();
        XMap m=new XMap();
        if(busca.length()>0){
            busca="%"+busca+"%";
            if(cbx_bus.getSelectedIndex()==0){
                m.put("ruc_pro",busca);
            }else if(cbx_bus.getSelectedIndex()==1){
                m.put("raz_soc_pro",busca);
            }else
                m.put("nro_doc",busca);
        }
        t_compras.retrieve(m);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbx_bus = new javax.swing.JComboBox();
        btn_pagar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        bAnular = new javax.swing.JButton();
        btn_det = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_compras = new org.jsuns.swing.XTable();

        setTitle("Ver Compras de Productos");

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RUC", "RAZON SOCIAL", "NRO. DOC." }));
        cbx_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_busActionPerformed(evt);
            }
        });

        btn_pagar.setText("Pagar");
        btn_pagar.setEnabled(false);
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDIENTE", "PAGADOS", "TODOS" }));

        jLabel1.setText("Buscar por:");

        txt_bus.setEditable(false);
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        btn_reg.setText("Registrar");
        btn_reg.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        bAnular.setText("Anular");
        bAnular.setEnabled(false);
        bAnular.setMargin(new java.awt.Insets(2, 8, 2, 8));
        bAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnularActionPerformed(evt);
            }
        });

        btn_det.setText("Ver Detalle");
        btn_det.setEnabled(false);
        btn_det.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_det)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_bus)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_det, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jScrollPane2.setViewportView(t_compras);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("Ver Compras");
    }// </editor-fold>//GEN-END:initComponents

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        ven.open(new frm_reg_compra_prod());
    }//GEN-LAST:event_btn_regActionPerformed

    private void bAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnularActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar la compra?");
        if (JOptionPane.OK_OPTION == confirmado) {
            com.setIdCompra(Integer.parseInt(t_compras.getValueAt(i, 0).toString()));
            BigDecimal suma_pro =new BigDecimal("0");
            //seleccionar almacen
            EntityManager em=JPA.getInstance().getEntityManager(true);
            com=em.find(Compra.class,com.getIdCompra());
            for(CompraDetalle d:com.getCompraDetalleCollection()){
                suma_pro=suma_pro.add(d.getPrecioCompra()
                        .multiply(d.getCantCompra()));
                Articulo articulo=d.getArticulo();
                articulo.setCantActual(articulo.getCantActual().subtract(d.getCantCompra()));
                AlmacenArticulo almacenArticulo=em.find(AlmacenArticulo.class,new AlmacenArticuloPK(com.getIdAlmacen(),articulo.getIdArticulo()));
                almacenArticulo.setCantidad(almacenArticulo.getCantidad().subtract(d.getCantCompra()));
                em.merge(almacenArticulo);
                em.merge(articulo);
                Kardex k=new Kardex();
                k.setCantSal(d.getCantCompra());
                k.setPreUniSal(d.getPrecioCompra());
                k.setFecha(com.getFechaDoc());
                k.setSerie(com.getSerie());
                k.setNumero(com.getNumero());
                k.setIdTipoDoc(tido);
                k.setIdAlmacen(alm);
                k.setRucPro(pro.getRuc());
                k.setNombre(pro.getRazonSocial());
                em.persist(k);
            }
            //seleccionar detalle de compra, cantidad de productos;
            //calcular monto 
            Double monto=suma_pro.doubleValue()*1.18;
            //  registrar en movimientos. 
            if (t_compras.getValueAt(i, 10).equals("PAGADO")) {
                String glosa = "ANULACION DE COMPRA - " 
                        + t_compras.getValueAt(i, 3) 
                        + " / " + t_compras.getValueAt(i, 4) 
                        + " - " + t_compras.getValueAt(i, 5) 
                        + " - " + pro.getRuc();
                Movimiento m=new Movimiento();
                m.setGlosa(glosa);
                m.setNick(X.getUser());
                m.setFecMov(com.getFechaDoc());
                m.setIngreso(new BigDecimal(monto));
                em.persist(m);
            }
            JPA.getInstance().close();
            retrieve();
            txt_bus.requestFocus();

        }
    }//GEN-LAST:event_bAnularActionPerformed

    private void btn_detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detActionPerformed
        try {
            String id = t_compras.getValueAt(i, 0).toString();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("compra", id);
            ven.ver_reporte("rpt_ver_det_compra", parametros);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btn_detActionPerformed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        frm_ver_cuota_compra cuota=new frm_ver_cuota_compra();
        cuota.setCompra(t_compras.getValueAt(i, 6).toString());
        ven.open(cuota);
        this.close();

    }//GEN-LAST:event_btn_pagarActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)retrieve();
    }//GEN-LAST:event_txt_busKeyPressed

    private void cbx_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_busActionPerformed
        txt_bus.setEditable(true);
        txt_bus.setText("");
        txt_bus.requestFocus();
    }//GEN-LAST:event_cbx_busActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnular;
    private javax.swing.JButton btn_det;
    private javax.swing.JButton btn_pagar;
    private javax.swing.JButton btn_reg;
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jsuns.swing.XTable t_compras;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
*/}
