package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jsuns.commerce.jpa.Oferta;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;
import org.pegasus.patrimonio.jpa.Almacen;

public class frm_reg_ofertas extends XPanel implements FindSelectionListener{

//    private Cl_Varios ven = new Cl_Varios();
    private Oferta ofe = new Oferta();
    private Almacen alm = new Almacen();
    private String ventana = "oferta";
    private String win = "reg";
    private DefaultTableModel modelo;
    private int i;

    public frm_reg_ofertas() {
        //initComponents();
        ver_detalle_oferta();
        ver_almacen();
    }

    public void ver_detalle_oferta() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 5) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        modelo.addColumn("Id");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Marca");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Und. Medida");
        modelo.addColumn("Precio");
       /* t_oferta.setModel(modelo);
        t_oferta.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_oferta.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_oferta.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_oferta.getColumnModel().getColumn(3).setPreferredWidth(50);
        t_oferta.getColumnModel().getColumn(4).setPreferredWidth(90);
        t_oferta.getColumnModel().getColumn(5).setPreferredWidth(90);
        //alineado de columnas*/
    }

    private void ver_almacen() {
        ArrayList almacen = new ArrayList();
        String query = "select nom_alm from almacen order by idAlmacen asc";
//            while (rs.next()) {
//                almacen.add(rs.getString("nom_alm"));
//            }
       /* if (almacen.size() > 0) {
            for (int j = 0; j < almacen.size(); j++) {
                cbx_alm.addItem(almacen.get(j));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista de Almacen no disponible");
        }*/
    }

    public void llenar(){
        /*ofe.setNomOfer(txt_des_ofer.getText());
        ofe.setFechaOfer(txt_fec_ini.getDate());
        ofe.setFechaVenc(txt_fec_fin.getDate());
        alm.setIdAlmacen(cbx_alm.getSelectedIndex() + 1);*/
    }

    private void limpiar() {
       /* txt_des_ofer.setText("");
        txt_des_ofer.requestFocus();
        txt_fec_ini.setDate(null);
        txt_fec_ini.setEditable(false);
        txt_fec_ini.setDate(ven.getFechaActual());
        txt_fec_fin.setDate(null);
        txt_fec_fin.setEditable(false);
        txt_id_pro.setText("");
        txt_des_pro.setText("");*/
    }

    void limpiar_tabla() {
        for (int j = 0; j < modelo.getRowCount(); j++) {
            modelo.removeRow(j);
        }
    }
/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_bus_pro = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_oferta = new javax.swing.JTable();
        txt_id_pro = new javax.swing.JTextField();
        txt_des_pro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_des_ofer = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        btn_cc = new javax.swing.JButton();
        btn_cp = new javax.swing.JButton();
        btn_el = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbx_alm = new javax.swing.JComboBox();
        txt_fec_fin = new org.jsuns.swing.XDateField();
        txt_fec_ini = new org.jsuns.swing.XDateField();

        setToolTipText("");
        setTitle("Registrar Oferta");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Descripción de Oferta:");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Fec. Ini.");

        btn_bus_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_bus_pro.setEnabled(false);
        btn_bus_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bus_proActionPerformed(evt);
            }
        });
        btn_bus_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_bus_proKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Producto:");

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_oferta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        t_oferta.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_oferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_ofertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_oferta);

        txt_id_pro.setEditable(false);
        txt_id_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_proActionPerformed(evt);
            }
        });

        txt_des_pro.setEditable(false);
        txt_des_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_des_proActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Fec. Fin");

        txt_des_ofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_des_oferActionPerformed(evt);
            }
        });
        txt_des_ofer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_des_oferKeyPressed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disk.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_cc.setText("+/-");
        btn_cc.setEnabled(false);
        btn_cc.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ccActionPerformed(evt);
            }
        });

        btn_cp.setText("S/.");
        btn_cp.setEnabled(false);
        btn_cp.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cpActionPerformed(evt);
            }
        });

        btn_el.setText("X");
        btn_el.setEnabled(false);
        btn_el.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Tienda:");

        cbx_alm.setEnabled(false);
        cbx_alm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_almKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txt_id_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_des_pro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_bus_pro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_des_ofer, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btn_cp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_alm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fec_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fec_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_des_ofer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_fec_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fec_ini, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_id_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_des_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_bus_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
*/
    private void txt_id_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_proActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_proActionPerformed

    private void txt_des_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_des_proActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_des_proActionPerformed

    private void txt_des_oferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_des_oferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_des_oferActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       /* frm_ver_ofertas ofe = new frm_ver_ofertas();
        ven.open(ofe);
        this.close();*/
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       /* txt_des_ofer.setEditable(true);
        txt_des_ofer.requestFocus();*/
    }//GEN-LAST:event_formInternalFrameActivated

    private void txt_des_oferKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_des_oferKeyPressed
        /*if (!txt_des_ofer.getText().isEmpty()) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                cbx_alm.setEnabled(true);
//                String fechita = txt_des_getText();
//                System.out.println(ven.fechabase(fechita));
                cbx_alm.requestFocus();
            }
        }*/
    }//GEN-LAST:event_txt_des_oferKeyPressed

    private void btn_bus_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bus_proActionPerformed
       /* frm_ver_productos prod = new frm_ver_productos();
        prod.setFindSeleccionListener(this);
        prod.retrieve();
        ven.open(prod);*/
    }//GEN-LAST:event_btn_bus_proActionPerformed

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        /*llenar();

   
            String insert_ofe = "insert oferta Values (null, '" + alm.getIdAlmacen() + "','" + ofe.getNomOfer() + "', '" + ofe.getFechaOfer() + "', "
                    + "'" + ofe.getFechaVenc()+ "', '" + ofe.getEstado() + "')";


        //insertar productos en detalle_oferta
        try {
            int filas = t_oferta.getRowCount();
            for (int j = 0; j <= (filas - 1); j++) {
                String idPro = t_oferta.getValueAt(j, 0).toString();
                Double precio = Double.parseDouble(t_oferta.getValueAt(j, 5).toString());
                Double cantidad = Double.parseDouble(t_oferta.getValueAt(j, 3).toString());

                //Statement st = con.conexion();
         
                String ins_det_cot = "insert into detalle_oferta Values ('" + idPro + "', '" + ofe.getIdOferta() + "', '" + precio + "', '" + cantidad + "')";
       
                System.out.print("insertando producto: id: " + idPro + " Cantidad: " + cantidad + " Precio: " + precio + "\n");
            }
            JOptionPane.showMessageDialog(null, "Datos grabados satisfactoriamente");
            limpiar_tabla();
            limpiar();
            btn_reg.setEnabled(false);
        } catch (Exception e) {
            System.out.println("Error " + e.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error " + e.getLocalizedMessage());
        }*/
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_bus_proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_bus_proKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_bus_pro.doClick();
        }*/
    }//GEN-LAST:event_btn_bus_proKeyPressed

    private void t_ofertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_ofertaMouseClicked
        /*i = t_oferta.getSelectedRow();
        btn_el.setEnabled(true);
        btn_cc.setEnabled(true);
        btn_cp.setEnabled(true);*/
    }//GEN-LAST:event_t_ofertaMouseClicked

    private void btn_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ccActionPerformed
      /*  Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Cantidad"));
        t_oferta.setValueAt(cantidad, i, 3);*/
    }//GEN-LAST:event_btn_ccActionPerformed

    private void btn_cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cpActionPerformed
        /*Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Precio"));
        t_oferta.setValueAt(precio, i, 5);*/

    }//GEN-LAST:event_btn_cpActionPerformed

    private void btn_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elActionPerformed
        /*modelo.removeRow(i);
        btn_el.setEnabled(false);
        btn_cc.setEnabled(false);
        btn_cp.setEnabled(false);*/
    }//GEN-LAST:event_btn_elActionPerformed

    private void cbx_almKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_almKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // MOSTRAR FECHA ACTUAL FORMATEADA
            txt_fec_ini.setDate(ven.getFechaActual());
            txt_fec_ini.setEditable(true);
            txt_fec_ini.requestFocus();
        }*/
    }//GEN-LAST:event_cbx_almKeyPressed

/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bus_pro;
    private javax.swing.JButton btn_cc;
    private javax.swing.JButton btn_cp;
    private javax.swing.JButton btn_el;
    private javax.swing.JButton btn_reg;
    private javax.swing.JComboBox cbx_alm;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_oferta;
    private javax.swing.JTextField txt_des_ofer;
    public static javax.swing.JTextField txt_des_pro;
    private org.jsuns.swing.XDateField txt_fec_fin;
    private org.jsuns.swing.XDateField txt_fec_ini;
    public static javax.swing.JTextField txt_id_pro;
    // End of variables declaration//GEN-END:variables
*/
    //@Override
    public void valueChanged(FindSelectionEvent evt) {
        /*JTable t_productos=(JTable) evt.getSource();
        int a = t_productos.getSelectedRow();
        Object[] dato = new Object[6];
        dato[0] = t_productos.getValueAt(a, 0);         //idproducto
        dato[1] = t_productos.getValueAt(a, 1);         //descripcion
        dato[2] = t_productos.getValueAt(a, 2);         //marca
        dato[3] = "1";                                  //cantidad
        dato[4] = t_productos.getValueAt(a, 7);         //und. med
        dato[5] = t_productos.getValueAt(a, 3);         //precio
                int tabla =t_oferta.getRowCount();                   //obtener la cantidad de filas de oferta                                                                                                                                                   
                String id = t_productos.getValueAt(a, 0).toString();         //id del formulario ver_productos
                String id_prod = "";
                int contar_repetidos = 0;
                if (tabla > 0) {            //verifica si existen registros
                    for (int j = 0; j < tabla; j++) {           //recorremos la tabla reg_cotizaciones
                        id_prod =t_oferta.getValueAt(j, 0).toString();// captura el id reg_oferta

                        if (id_prod.equals(id)) {
                            contar_repetidos++;
                        }
                    }

                    if (contar_repetidos == 0) {
                        modelo.addRow(dato);
                        t_oferta.setModel(modelo);
                        btn_reg.setEnabled(true);
                        this.close();
                    }

                } else {
                    modelo.addRow(dato);
                    t_oferta.setModel(modelo);
                    txt_id_pro.setText(t_productos.getValueAt(a, 0).toString());
                    txt_des_pro.setText(t_productos.getValueAt(a, 1).toString());
                    btn_reg.setEnabled(true);
                    this.close();
                }*/
    }
}
