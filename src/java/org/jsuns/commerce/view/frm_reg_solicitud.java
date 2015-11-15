package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.frm_menu;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_reg_solicitud extends XPanel 
{
/*
    private Cl_Varios ven=new Cl_Varios();
    private Almacen alm=new Almacen();
//    private Articulo pro=new Articulo();
    private Requerimiento req=new Requerimiento();
    private DefaultTableModel detalle;
    private int idsol=0;

    public void retrieve(Object o){
    
            String ver_sol = "select * from "
                    + "solicitud_articulos where "
                    + "idsolicitud = '" + idsol + "'";
//            if (rs.next()) {
//                txt_id_ori.setText(rs.getString("id_alm_ori"));
//                txt_id_des.setText(rs.getString("id_alm_des"));
//                txt_fec.setDate(rs.getDate("fec_sol"));
//                spn_dias.setValue(rs.getInt("plazo"));
//                //btn_env.setEnabled(true);
//                btn_reg.setEnabled(false);
//                btn_reg.setVisible(false);
//            }
        
            detalle.addColumn("Cant. Env.");
   
            String ver_det_ped = "select ds.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, ds.cant_sol, u.desc_und from detalle_solicitud "
                    + "as ds inner join productos as p on ds.idProductos = p.idProductos inner join und_medida as u on p.idUnd_medida=u.idUnd_medida"
                    + " where ds.idsolicitud = '" + idsol + "'";
    
//            while (rs.next()) {
//                Object[] fila = new Object[6];
//                fila[0] = rs.getString("idProductos");
//                fila[1] = rs.getString("p.desc_pro") + " " + rs.getString("p.modelo") + " " + rs.getString("p.serie");
//                fila[2] = rs.getString("p.marca");
//                fila[3] = rs.getString("cant_sol");
//                fila[4] = rs.getString("u.desc_und");
//                fila[5] = '0';
//                detalle.addRow(fila);
//            }
            t_solicitud.setModel(detalle);
            t_solicitud.getColumnModel().getColumn(0).setPreferredWidth(30);
            t_solicitud.getColumnModel().getColumn(1).setPreferredWidth(300);
            t_solicitud.getColumnModel().getColumn(2).setPreferredWidth(90);
            t_solicitud.getColumnModel().getColumn(3).setPreferredWidth(60);
            t_solicitud.getColumnModel().getColumn(4).setPreferredWidth(80);
            t_solicitud.getColumnModel().getColumn(5).setPreferredWidth(60);
        btn_env.setVisible(true);
        t_solicitud.requestFocus();
    }
    
    public frm_reg_solicitud() {
        initComponents();
        txt_id_des.requestFocus();
        detalle = new DefaultTableModel();
// {@Override
//     public boolean isCellEditable (int fila, int columna) {
//         return false;
//     }
// };
        detalle.addColumn("Id");
        detalle.addColumn("Descripcion");
        detalle.addColumn("Marca");
        detalle.addColumn("Cantidad");
        detalle.addColumn("Und. Med.");
        t_solicitud.setModel(detalle);
        t_solicitud.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_solicitud.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_solicitud.getColumnModel().getColumn(2).setPreferredWidth(90);
        t_solicitud.getColumnModel().getColumn(3).setPreferredWidth(60);
        t_solicitud.getColumnModel().getColumn(4).setPreferredWidth(80);
        btn_env.setVisible(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id_ori = new javax.swing.JTextField();
        txt_nom_ori = new javax.swing.JTextField();
        txt_id_des = new javax.swing.JTextField();
        txt_nom_des = new javax.swing.JTextField();
        spn_dias = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_id_pro = new javax.swing.JTextField();
        txt_nom_pro = new javax.swing.JTextField();
        btn_bus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_solicitud = new javax.swing.JTable();
        btn_cer = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        btn_env = new javax.swing.JButton();
        txt_fec = new org.jsuns.swing.XDateField();

        setTitle("Crear Pedido");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("DATOS DEL PEDIDO");
        jLabel1.setToolTipText("");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Almacen Origen:");
        jLabel2.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Almacen Destino:");
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Fecha Solicitud:");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Dias Plazo:");
        jLabel5.setFocusable(false);

        txt_id_ori.setEditable(false);
        txt_id_ori.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_ori.setFocusable(false);

        txt_nom_ori.setEditable(false);
        txt_nom_ori.setFocusable(false);

        txt_id_des.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_des.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_desKeyPressed(evt);
            }
        });

        txt_nom_des.setEditable(false);
        txt_nom_des.setFocusable(false);

        spn_dias.setModel(new javax.swing.SpinnerNumberModel(0, 0, 9, 1));
        spn_dias.setEnabled(false);
        spn_dias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                spn_diasKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Detalle de Articulos:");
        jLabel7.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(212, 2, 2));
        jLabel8.setText("Id:");
        jLabel8.setFocusable(false);

        txt_id_pro.setEditable(false);
        txt_id_pro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_proActionPerformed(evt);
            }
        });
        txt_id_pro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_id_proKeyPressed(evt);
            }
        });

        txt_nom_pro.setEditable(false);
        txt_nom_pro.setFocusable(false);

        btn_bus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/find.png"))); // NOI18N
        btn_bus.setEnabled(false);
        btn_bus.setFocusable(false);
        btn_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busActionPerformed(evt);
            }
        });

        jScrollPane1.setFocusable(false);

        t_solicitud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        t_solicitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_solicitudKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_solicitudKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(t_solicitud);

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        btn_reg.setText("Solicitar");
        btn_reg.setFocusable(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_env.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_env.setText("Enviar Ped.");
        btn_env.setEnabled(false);
        btn_env.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_envActionPerformed(evt);
            }
        });
        btn_env.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_envKeyPressed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nom_pro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_bus)))
                        .addGap(0, 210, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_env)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cer))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_id_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nom_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id_des, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nom_des, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spn_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nom_ori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id_des, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nom_des, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spn_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_id_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_env))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.close();

    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_id_desKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_desKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            alm.setIdAlmacen(Integer.parseInt(txt_id_des.getText()));            
                String ver_alm = "select nom_alm from almacen where idAlmacen = '" + alm.getIdAlmacen() + "'";
            
//                if (rs.next()) {
//                    alm.setNombre(rs.getString("nom_alm"));
//                    txt_nom_des.setText(alm.getNombre());
//                    txt_fec.setDate(ven.getFechaActual());
//                    txt_fec.setEditable(true);
//                    txt_fec.setFocusable(true);
//                    txt_fec.requestFocus();
//                } else {
//                    txt_id_des.setText("");
//                    txt_nom_des.setText("ALMACEN NO EXISTE");
//                    txt_id_des.requestFocus();
//                }
       
       
        }
    }//GEN-LAST:event_txt_id_desKeyPressed

    private void spn_diasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spn_diasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!spn_dias.getValue().equals("0")) {
                txt_id_pro.setEditable(true);
                btn_bus.setEnabled(true);
                txt_id_pro.requestFocus();
            }
        }
    }//GEN-LAST:event_spn_diasKeyPressed

    private void txt_id_proKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_id_proKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_bus.doClick();
        }
    }//GEN-LAST:event_txt_id_proKeyPressed

    private void btn_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busActionPerformed
        frm_ver_prod_alm mat=new frm_ver_prod_alm();
        mat.setAlmacen(frm_menu.almacen);
        mat.setFindSelectionListener(this);
        mat.retrieve();
        ven.open(mat);
    }//GEN-LAST:event_btn_busActionPerformed

    private void t_solicitudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_solicitudKeyReleased
    }//GEN-LAST:event_t_solicitudKeyReleased

    private void txt_id_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_proActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_proActionPerformed

    private void llenar() {
        frm_menu menu = null;
//        req.setAlm_ori(menu.almacen.getIdAlmacen());
//        req.setAlm_des(Integer.parseInt(txt_id_des.getText()));
//        req.setDias(Integer.parseInt(spn_dias.getValue().toString()));
//        req.setFec_rea(new Date());
//        req.setFec_sol(txt_fec.getDate());
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
//grabar pedido
        req.setNick(X.getUser());
        EntityManager em=JPA.getInstance().getEntityManager(true);
        em.persist(req);
        try {
            int nro_filas = t_solicitud.getRowCount();
            for (int j = 0; j < nro_filas; j++) {
                pro.setIdArticulo(Integer.parseInt(t_solicitud.getValueAt(j, 0).toString()));
//                pro.setCan(Double.parseDouble(t_solicitud.getValueAt(j, 3).toString()));
        
                String det_ped = "insert into detalle_solicitud Values ('" + req.getIdSolicitud()+ "', '" + pro.getIdArticulo() + "', '" + pro.getCantActual() + "', '0')";
           
                System.out.println("insertado linea " + j + " con exito \n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        //grabar detalle pedido
        frm_ver_solicitudes soli = new frm_ver_solicitudes();
        ven.open(soli);
        this.close();
    }//GEN-LAST:event_btn_regActionPerformed

    private void t_solicitudKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_solicitudKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int i = t_solicitud.getSelectedRow();
            int idp = Integer.parseInt(t_solicitud.getValueAt(i, 0).toString());
           
             
                String ver_pro = "select idProductos from producto_almacen where"
                        + " idProductos = '" + idp + "' and idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "'";
            
//                if (!rs.next()) {
//                    JOptionPane.showMessageDialog(null, "El Producto no existe en su almacen");
//                    t_solicitud.setValueAt("0", i, 5);
//                    btn_env.setEnabled(false);
//                } else {
//                    btn_env.setEnabled(true);
//                    btn_env.requestFocus();
//                }
             
     
        }
        
        //RECORRER TABLA Y DETECTA PRODUCTOS
        int nro_filas = t_solicitud.getRowCount();
        for (int j = 0; j < nro_filas; j++) {
            int idp = Integer.parseInt(t_solicitud.getValueAt(j, 0).toString());
           
             
                String ver_pro = "select idProductos from producto_almacen where"
                        + " idProductos = '" + idp + "' and idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "'";
             
//                if (!rs.next()) {
//                    JOptionPane.showMessageDialog(null, "El Producto no existe en su almacen");
//                    t_solicitud.setValueAt("0", j, 5);
//                    btn_env.setEnabled(false);
//                } 
        
        
        }
    }//GEN-LAST:event_t_solicitudKeyPressed

    private void btn_envKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_envKeyPressed

    }//GEN-LAST:event_btn_envKeyPressed

    private void btn_envActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_envActionPerformed
        frm_reg_traslado_almacen traslado = new frm_reg_traslado_almacen();
        traslado.setRequerimiento(idsol);
        ven.open(traslado);
        this.close();
    }//GEN-LAST:event_btn_envActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bus;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_env;
    private javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spn_dias;
    private javax.swing.JTable t_solicitud;
    private org.jsuns.swing.XDateField txt_fec;
    private javax.swing.JTextField txt_id_des;
    private javax.swing.JTextField txt_id_ori;
    private javax.swing.JTextField txt_id_pro;
    private javax.swing.JTextField txt_nom_des;
    private javax.swing.JTextField txt_nom_ori;
    private javax.swing.JTextField txt_nom_pro;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(FindSelectionEvent evt){
        int i=evt.getSelectedRows()[0];
        Object fila[] = new Object[5];
//        fila[0] = t_productos.getValueAt(i, 0);                                         //COD PRO
//        fila[1] = t_productos.getValueAt(i, 1);                                         // DESCRIPCION
//        fila[2] = t_productos.getValueAt(i, 2);                                         // MARCA
//        fila[3] = t_productos.getValueAt(i, 6);                                         // CANTIDAD
//        fila[4] = t_productos.getValueAt(i, 4);                                         // UND MED
//        pro.setIdArticulo((int) t_productos.getValueAt(i, 0));
        Integer filas_tabla =t_solicitud.getRowCount();
        Integer copiado = 0;
        if (filas_tabla > 0) {
            for (int x = 0; x < filas_tabla; x++) {
                Integer id_pro_tabla;
                id_pro_tabla = Integer.parseInt(t_solicitud.getValueAt(x, 0).toString());
                if (id_pro_tabla == pro.getIdArticulo()) {
                    copiado++;
                }
            }
            if (copiado == 0) {
                detalle.addRow(fila);
                txt_id_pro.requestFocus();
                btn_reg.setEnabled(true);
                this.close();
            } else {
                JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
            }
        } else {
            detalle.addRow(fila);
            txt_id_pro.requestFocus();
            btn_reg.setEnabled(true);
            this.close();
        }
    }

    public void setAlmacen(Object almacen){
        Almacen a=(Almacen) almacen;
        txt_id_ori.setText("" +a.getIdAlmacen());
        txt_nom_ori.setText(a.getNombre());
        txt_id_des.requestFocus(); 
    }*/
}
