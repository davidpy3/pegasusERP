package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.swing.XPanel;

public class frm_ver_prod_alm_det extends XPanel {

//    private Articulo pro = new Articulo();
//    private Almacen almacen = new Almacen();
    private DefaultTableModel mostrar;
    private String funcion = "prod_alm_det";
    private Integer i;

    public frm_ver_prod_alm_det() {
        initComponents();
        txt_bus.requestFocus();
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        mostrar.addColumn("Id");
        mostrar.addColumn("Descripcion");
        mostrar.addColumn("Marca");
        mostrar.addColumn("Cant. Act.");
        mostrar.addColumn("Und. Med.");
        mostrar.addColumn("Precio");
        mostrar.addColumn("Clasificacion");
        mostrar.addColumn("Grado");
        mostrar.addColumn("Almacen");
        mostrar.addColumn("Estado");
        t_productos.setModel(mostrar);
        mostrar.fireTableDataChanged();
        retrieve();
        ver_almacen();
    }

    private void retrieve() {
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        //Establecer como cabezeras el nombre de las colimnas
        mostrar.addColumn("Id");
        mostrar.addColumn("Descripcion");
        mostrar.addColumn("Marca");
        mostrar.addColumn("Cant. Act.");
        mostrar.addColumn("Und. Med.");
        mostrar.addColumn("Precio");
        mostrar.addColumn("Clasificacion");
        mostrar.addColumn("Grado");
        mostrar.addColumn("Almacen");
        mostrar.addColumn("Estado");
        t_productos.setModel(mostrar);
        t_productos.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_productos.getColumnModel().getColumn(1).setPreferredWidth(350);
        t_productos.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(3).setPreferredWidth(60);
        t_productos.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(5).setPreferredWidth(60);
        t_productos.getColumnModel().getColumn(6).setPreferredWidth(50);
        t_productos.getColumnModel().getColumn(7).setPreferredWidth(100);
        t_productos.getColumnModel().getColumn(8).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(9).setPreferredWidth(90);
        mostrar.fireTableDataChanged();

//        String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant,"
//                + " p.cant_min, pa.precio, p.estado, c.desc_clas, u.desc_und, "
//                + "p.grado,a.nom_alm from producto_almacen as pa inner join productos as p "
//                + "on pa.idProductos=p.idProductos inner join clasificacion as c "
//                + "on p.id_clas=c.id_clas inner join und_medida as u "
//                + "on p.idUnd_Medida=u.idUnd_Medida  inner join almacen as a"
//                + " on pa.idAlmacen=a.idAlmacen where pa.idAlmacen = '" + cbx_clas.getSelectedIndex() + "' and (p.desc_pro like '%" + texto + "%' or "
//                + "p.modelo like '%" + texto + "%' or p.serie like '%" + texto + "%' or p.marca like '%" + texto + "%' "
//                + "or pa.precio like '%" + texto + "%') order by p.desc_pro asc, p.modelo asc;";
        /*for (AlmacenArticulo almacenArticulo : JPA.getInstance().getEntityManager()
                .createQuery("select a from "
                        + "AlmacenArticulo a "
                        + "WHERE a.almacen=:almacen", AlmacenArticulo.class)
                .setParameter("almacen", almacen)
                .getResultList()) {
            /*Articulo articulo = almacenArticulo.getArticulo();
            Object[] fila = new Object[10];
            fila[0] = articulo.getIdArticulo();
            fila[1] = articulo.getDescripcion()
                    + " - " + articulo.getModelo()
                    + " - " + articulo.getSerie();
            fila[2] = articulo.getMarca();
            fila[3] = almacenArticulo.getCantidad();
            fila[4] = articulo.getUmedida();
            fila[5] = articulo.getPrecioVenta();
            fila[6] = articulo.getClasificacion();
            fila[7] = articulo.getGrado();
            fila[8] = almacenArticulo.getAlmacen();
            if (articulo.getEstado().equals('1')) {
                if (almacenArticulo.getCantidad().doubleValue() > articulo.getCantMin().doubleValue()) {
                    fila[9] = "NORMAL";
                } else if (almacenArticulo.getCantidad().doubleValue() <= articulo.getCantMin().doubleValue()) {
                    fila[9] = "POR TERMINAR";
                } else if (almacenArticulo.getCantidad().doubleValue() <= 0) {
                    fila[9] = "NO DISPONIBLE";
                }
            } else {
                fila[9] = "-";
            }
            mostrar.addRow(fila);
        }*/
        JPA.getInstance().close();
        t_productos.setModel(mostrar);
        t_productos.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_productos.getColumnModel().getColumn(1).setPreferredWidth(350);
        t_productos.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(3).setPreferredWidth(60);
        t_productos.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(5).setPreferredWidth(60);
        t_productos.getColumnModel().getColumn(6).setPreferredWidth(50);
        t_productos.getColumnModel().getColumn(7).setPreferredWidth(100);
        t_productos.getColumnModel().getColumn(8).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(9).setPreferredWidth(90);
        mostrar.fireTableDataChanged();
    }

    private void ver_almacen() {
        /*for (Almacen a : JPA.getInstance().getEntityManager()
                .createQuery("select a from Almacen a order by a.idAlmacen asc", Almacen.class).getResultList()) {
            cbx_clas.addItem(a);
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_productos = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cer = new javax.swing.JButton();
        cbx_clas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        btn_mod = new javax.swing.JButton();

        setTitle("Ver Productos en los Almacen");

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        t_productos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_productos.setRowHeight(20);
        t_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_productosMousePressed(evt);
            }
        });
        t_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_productosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_productos);

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Buscar:");

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        cbx_clas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS" }));
        cbx_clas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_clasActionPerformed(evt);
            }
        });
        cbx_clas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_clasKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Ver por Tienda");

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_clas, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_mod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_clas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_productosKeyPressed
    }//GEN-LAST:event_t_productosKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cbx_clas.getSelectedIndex() == 0) {
                String texto = txt_bus.getText();
                retrieve();
            } else {
                Integer idclas = cbx_clas.getSelectedIndex();
                String texto = txt_bus.getText();
                retrieve();
            }
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        funcion = "material_almacen";
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void t_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_productosMousePressed
        i = t_productos.getSelectedRow();
        btn_mod.setEnabled(true);
    }//GEN-LAST:event_t_productosMousePressed

    private void cbx_clasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_clasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_clasKeyPressed

    private void cbx_clasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_clasActionPerformed
        if (cbx_clas.getSelectedItem().equals("TODOS")) {
            retrieve();
        } else {
            retrieve();
        }

    }//GEN-LAST:event_cbx_clasActionPerformed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        int ida = 0;
        String nom_alm = t_productos.getValueAt(i, 8).toString();

        try {

            String query = "select idAlmacen from almacen where nom_alm = '" + nom_alm + "' ";

//                if (rs.next()) {
//                    ida = rs.getInt("idAlmacen");
//                }
        } catch (Exception e) {
            System.out.println(e);
        }
        /*frm_reg_productos prod = new frm_reg_productos();
        int id = Integer.parseInt(t_productos.getValueAt(i, 0).toString());
        prod.setArticulo(id);
        prod.setAlmacen(ida);
        prod.retrieve();
        ven.open(prod);
        this.close();*/
    }//GEN-LAST:event_btn_modActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_mod;
    private javax.swing.JComboBox cbx_clas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_productos;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
