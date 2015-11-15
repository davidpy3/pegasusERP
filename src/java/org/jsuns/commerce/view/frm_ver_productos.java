package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Clasificacion;
//import org.jsuns.commerce.jpa.Articulo;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.UMedida;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_ver_productos extends XPanel {

    private Clasificacion cla = new Clasificacion();
    private UMedida med = new UMedida();
//    private Articulo pro = new Articulo();

    private String ventana = "productos";
    private DecimalFormatSymbols simbolo = new DecimalFormatSymbols(Locale.US);
    private DecimalFormat formato = new DecimalFormat("####0.00", simbolo);
    private Integer i;
    private DefaultTableModel mostrar;

    public frm_ver_productos() {
        /*initComponents();
        cbx_cla.setStore(Clasificacion.class);
        cbx_cla.load();*/
    }

    private FindSelectionListener findSeleccionListener;

    public FindSelectionListener getFindSeleccionListener() {
        return findSeleccionListener;
    }

    public void setFindSeleccionListener(FindSelectionListener findSeleccionListener) {
        this.findSeleccionListener = findSeleccionListener;
    }

    private void retrieve(String query) {
//        String bus = txt_bus.getText();
//                        String query = "select p.idProductos , p.desc_pro, p.marca, p.modelo, p.serie, p.grado, p.costo_compra, p.precio_venta, c.desc_clas, u.desc_und, p.cant_actual,p.cant_min, p.estado "
//                    + "from productos as p inner join und_medida as u on p.idUnd_medida=u.idUnd_medida inner join clasificacion as c on p.id_clas=c.id_clas "
//                    //+ "WHERE MATCH (p.desc_pro, p.modelo, p.serie, p.marca) AGAINST ('%" + bus + "%') "
//                    + "where p.desc_pro like '%" + bus + "%' "
//                    + "or p.modelo like '%" + bus + "%' or p.serie like '%" + bus + "%' or p.marca like '%" + bus + "%'"
//                    + " order by p.desc_pro asc, p.modelo asc";
        //        if (!ventana.equals("compra_prod")) {
//        String query = "select p.idProductos, p.desc_pro, p.marca, p.modelo, p.serie, p.grado, p.precio_venta, "
//                + "c.desc_clas, u.desc_und, p.cant_actual, p.cant_min, p.estado from productos as p inner join "
//                + "und_medida as u on p.idUnd_medida = u.idUnd_medida inner join clasificacion as c on "
//                + "p.id_clas = c.id_clas  order by p.desc_pro asc, p.modelo asc";
//        ver_productos(query);
//            t_productos.setDefaultRenderer(Object.class, new table_render());
//        }
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        //Establecer como cabezeras el nombre de las colimnas
        mostrar.addColumn("Id");
        mostrar.addColumn("Descripcion");//descripcion modelo serie
        mostrar.addColumn("Marca");
        mostrar.addColumn("Precio");
        mostrar.addColumn("Clasificacion");
        mostrar.addColumn("Cant. Actual");
        mostrar.addColumn("Cant. minima");
        mostrar.addColumn("Und. Medida");
        mostrar.addColumn("Grado");
        mostrar.addColumn("Estado");
        //Creando las filas para el JTable
//            while (rs.next()) {
//                Object[] fila = new Object[10];
//                fila[0] = rs.getObject("idProductos");
//                fila[1] = rs.getObject("desc_pro") + " - " + rs.getObject("modelo") + " - " + rs.getObject("serie");
//                fila[2] = rs.getObject("marca");
//                fila[3] = rs.getObject("precio_venta");
//                fila[4] = rs.getObject("desc_clas");
//                fila[5] = rs.getObject("cant_actual");
//                fila[6] = rs.getObject("cant_min");
//                fila[7] = rs.getObject("desc_und");
//                fila[8] = rs.getObject("grado");
//                if (rs.getString("estado").equals("1")) {
//                    if (rs.getDouble("cant_actual") > rs.getDouble("cant_min")) {
//                        fila[9] = "NORMAL";
//                    }
//                    if (rs.getDouble("cant_actual") <= rs.getDouble("cant_min")) {
//                        fila[9] = "POR TERMINAR";
//                    }
//                    if (rs.getDouble("cant_actual") <= 0) {
//                        fila[9] = "NO DISPONIBLE";
//                    }
//                } else {
//                    fila[9] = "-";
//                }
//
//                mostrar.addRow(fila);
//            }
       // t_productos.setModel(mostrar);
        mostrar.fireTableDataChanged();
    }
/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_productos = new javax.swing.JTable();
        btn_reg = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        btn_eli = new javax.swing.JButton();
        cbx_cla = new org.jsuns.swing.XComboBox();

        setTitle("Ver Productos");

        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Buscar:");

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busKeyTyped(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        t_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        t_productos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_productos.setRowHeight(20);
        t_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_productosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_productosMousePressed(evt);
            }
        });
        t_productos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_productosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_productosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(t_productos);
        if (t_productos.getColumnModel().getColumnCount() > 0) {
            t_productos.getColumnModel().getColumn(0).setPreferredWidth(20);
            t_productos.getColumnModel().getColumn(1).setPreferredWidth(150);
            t_productos.getColumnModel().getColumn(2).setPreferredWidth(50);
            t_productos.getColumnModel().getColumn(3).setPreferredWidth(20);
            t_productos.getColumnModel().getColumn(4).setPreferredWidth(30);
            t_productos.getColumnModel().getColumn(5).setPreferredWidth(40);
            t_productos.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modifcar");
        btn_mod.setEnabled(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        btn_eli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cross.png"))); // NOI18N
        btn_eli.setText("Eliminar");
        btn_eli.setEnabled(false);
        btn_eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_cla, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_eli)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_cla, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_eli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
*/
    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        /*frm_reg_productos productos = new frm_reg_productos();
        productos.win = "reg";
        productos.subventana = "prod_compra";

        ven.open(productos);
        this.close();*/
    }//GEN-LAST:event_btn_regActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retrieve();
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        /*int id = Integer.parseInt(t_productos.getValueAt(i, 0).toString());
        pro = JPA.getInstance().getEntityManager(true).find(Articulo.class, id);
        if (pro != null) {
            frm_reg_productos prod = new frm_reg_productos();
            prod.setArticulo(pro);
            prod.open();
            retrieve();
        }*/
        
    }//GEN-LAST:event_btn_modActionPerformed

    private void t_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_productosMousePressed
       /* i = t_productos.getSelectedRow();
        btn_eli.setEnabled(true);
        btn_mod.setEnabled(true);*/
    }//GEN-LAST:event_t_productosMousePressed

    private void btn_eliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar el producto?", "Seguridad", JOptionPane.WARNING_MESSAGE);

        if (JOptionPane.OK_OPTION == confirmado) {
            /*pro.setIdArticulo((int) t_productos.getValueAt(i, 0));
            try {
////                    Statement st = con.conexion();
////                    String query = "delete from productos where idProductos ='" + pro.getIdArticulo() + "'";
////                    con.actualiza(st, query);
////                    con.cerrar(st);
////                    String query1 = "select p.idProductos, p.desc_pro, p.marca, p.modelo, p.serie, p.grado, p.precio_venta, c.desc_clas, u.desc_und, p.cant_actual, p.cant_min, p.estado"
////                            + " from productos as p inner join und_medida as u on p.idUnd_medida = u.idUnd_medida inner join clasificacion as c on p.id_clas = c.id_clas  order by p.desc_pro asc";
                retrieve();
                btn_eli.setEnabled(false);
                btn_mod.setEnabled(false);
            } catch (Exception ex) {
                System.out.print(ex + " " + ex.getLocalizedMessage() + " " + ex.getCause());
            }*/
        }
    }//GEN-LAST:event_btn_eliActionPerformed

    private void t_productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_productosKeyPressed

        /*int a = t_productos.getSelectedRow();
        Object[] dato = new Object[6];
        dato[0] = t_productos.getValueAt(a, 0);         //idproducto
        dato[1] = t_productos.getValueAt(a, 1);         //descripcion
        dato[2] = t_productos.getValueAt(a, 2);         //marca
        dato[3] = "1";                                  //cantidad
        dato[4] = t_productos.getValueAt(a, 7);         //und. med
        dato[5] = t_productos.getValueAt(a, 3);         //precio

        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            int i = t_productos.getSelectedRow();
            pro.setIdArticulo(Integer.parseInt(t_productos.getValueAt(i, 0).toString()));
//            try {

            findSeleccionListener.valueChanged(new FindSelectionEvent(t_productos, t_productos.getSelectedRows(), 0));
            if (ventana.equals("compra_productos")) {
                frm_rpt_fechas fec_rpt;
                fec_rpt = new frm_rpt_fechas();
                fec_rpt.pro.setIdArticulo(pro.getIdArticulo());
                fec_rpt.rpt = "compra_producto";
                ven.open(fec_rpt);
            } else {
                this.close();
            }
            ventana = "productos";
        }
*/
    }//GEN-LAST:event_t_productosKeyPressed

    private void t_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_productosMouseClicked

        /*int a = t_productos.getSelectedRow();
        Object[] dato = new Object[6];
        dato[0] = t_productos.getValueAt(a, 0);         //idproducto
        dato[1] = t_productos.getValueAt(a, 1);         //descripcion
        dato[2] = t_productos.getValueAt(a, 2);         //marca
        dato[3] = "1";                                  //cantidad
        dato[4] = t_productos.getValueAt(a, 7);         //und. med
        dato[5] = t_productos.getValueAt(a, 3);         //precio

        if (evt.getClickCount() == 2) {
            if (findSeleccionListener != null) {
                findSeleccionListener.valueChanged(new FindSelectionEvent(t_productos, t_productos.getSelectedRows(), 0));
                close();
            } 
        }
*/

    }//GEN-LAST:event_t_productosMouseClicked

    private void t_productosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_productosKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_t_productosKeyReleased

    private void txt_busKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyTyped

    }//GEN-LAST:event_txt_busKeyTyped
/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_eli;
    public static javax.swing.JButton btn_mod;
    public static javax.swing.JButton btn_reg;
    private org.jsuns.swing.XComboBox cbx_cla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_productos;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
*/
    public void retrieve() {
//    String query = "select p.idProductos, p.desc_pro, p.marca, p.modelo, p.serie, p.grado, p.precio_venta, c.desc_clas, u.desc_und, p.cant_actual, p.cant_min, p.estado"
//                            + " from productos as p inner join und_medida as u on p.idUnd_medida = u.idUnd_medida inner join clasificacion as c on p.id_clas = c.id_clas  order by p.desc_pro asc";

//        String query = "select p.idProductos, p.desc_pro, p.marca, p.modelo, p.serie, p.grado, p.precio_venta, c.desc_clas, u.desc_und, p.cant_actual, p.cant_min, p.estado"
//                + " from productos as p inner join und_medida as u on p.idUnd_medida = u.idUnd_medida inner join clasificacion as c on p.id_clas = c.id_clas  order by p.desc_pro asc, p.modelo asc";
//        ver_productos(query);
        /*btn_reg.setEnabled(false);
        btn_mod.setEnabled(false);
        btn_eli.setEnabled(false);*/
//        prod.btn_enviar.setEnabled(true);
    }
}
