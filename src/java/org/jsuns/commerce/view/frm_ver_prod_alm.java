package org.jsuns.commerce.view;

//import org.jsuns.commerce.jpa.Articulo;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;
import org.jsuns.util.XUtil;

public class frm_ver_prod_alm extends XPanel{
/*
    private Cl_Varios ven = new Cl_Varios();
//    private Articulo pro = new Articulo();
    private Almacen alm = new Almacen();
    private DefaultTableModel mostrar;
    private String funcion = "producto_almacen";
    private Integer i;

    public frm_ver_prod_alm() {
        initComponents();
        txt_bus.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_productos = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_cer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_ida = new javax.swing.JTextField();
        txt_noma = new javax.swing.JTextField();
        btn_kar = new javax.swing.JButton();
        cbx_bus = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setTitle("Ver Productos en Almacen");

        t_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        });
        jScrollPane1.setViewportView(t_productos);

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busKeyTyped(evt);
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

        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Almacen");

        txt_ida.setEditable(false);
        txt_ida.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_noma.setEditable(false);

        btn_kar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/clipboard_text.png"))); // NOI18N
        btn_kar.setText("Ver Kardex");
        btn_kar.setEnabled(false);
        btn_kar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_karActionPerformed(evt);
            }
        });

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "DISPONIBLES", "POR TERMINAR ", "TERMINADO" }));
        cbx_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_busKeyPressed(evt);
            }
        });

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ida, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_noma, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_kar)
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
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_noma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_kar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_productosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_productosKeyPressed

    }//GEN-LAST:event_t_productosKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        funcion = "material_almacen";
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void btn_karActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_karActionPerformed
        frm_rpt_fechas rpt = new frm_rpt_fechas();
        rpt.rpt = "kardex";
        rpt.pro.setIdArticulo(Integer.parseInt(t_productos.getValueAt(i, 0).toString()));
        rpt.alm.setIdAlmacen(Integer.parseInt(txt_ida.getText()));
        ven.open(rpt);
    }//GEN-LAST:event_btn_karActionPerformed

    private void t_productosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_productosMousePressed
//        i = t_productos.getSelectedRow();
//        btn_kar.setEnabled(true);
    }//GEN-LAST:event_t_productosMousePressed


    
    private void cbx_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_busKeyPressed
//        if (cbx_bus.getSelectedIndex() == 0) {
//            String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
//                    + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
//                    + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
//                    + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' order by p.desc_pro asc";
//            as.mostrar_productos(query);
//        } else if (cbx_bus.getSelectedIndex() == 1) {
//            String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
//                    + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
//                    + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
//                    + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' and pa.cant > p.cant_min order by p.desc_pro asc";
//            as.mostrar_productos(query);
//        } else if (cbx_bus.getSelectedIndex() == 2) {
//            String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
//                    + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
//                    + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
//                    + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' and pa.cant < p.cant_min and pa.cant > 0 order by p.desc_pro asc";
//            as.mostrar_productos(query);
//        } else {
//            String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
//                    + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
//                    + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
//                    + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' and pa.cant = 0 order by p.desc_pro asc";
//            as.mostrar_productos(query);
//        }
        //falta demas oopciones del combo
    }//GEN-LAST:event_cbx_busKeyPressed

    private void txt_busKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyTyped

    }//GEN-LAST:event_txt_busKeyTyped

    private int tot_reg () {
        int tot = 0;
        for (int j = 0; j < t_productos.getRowCount(); j++) {
            tot++;            
        }
        return tot;
    }
    
    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                String texto = txt_bus.getText();
                String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
                        + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos "
                        + "inner join clasificacion as c on p.id_clas=c.id_clas inner join und_medida as u on "
                        + "p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + txt_ida.getText() + "' and (p.desc_pro like '%" + texto + "%' or p.modelo "
                        + "like '%" + texto + "%' or p.serie like '%" + texto + "%' or p.marca like '%" + texto + "%')  order by p.desc_pro asc, p.modelo asc";
//                as.mostrar_productos(query);
                jLabel3.setText(""+tot_reg());
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private FindSelectionListener findSelectionListener;
    
    private void t_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_productosMouseClicked
        if(evt.getClickCount()==2){
            txt_bus.setText("");
            txt_bus.requestFocus();
            btn_kar.setEnabled(true);
            if(findSelectionListener!=null){
                findSelectionListener.valueChanged(new FindSelectionEvent(t_productos,t_productos.getSelectedRows(),0));
                close();
            }
            if (funcion.equals("traslado")) {
                Object fila[] = new Object[5];
                fila[0] = t_productos.getValueAt(i, 0);                                         //COD PRO
                fila[1] = t_productos.getValueAt(i, 1);                                         // DESCRIPCION
                fila[2] = t_productos.getValueAt(i, 2);                                         // MARCA
                fila[3] = "1.00";                                                               // CANTIDAD
                fila[4] = t_productos.getValueAt(i, 4);                                         // UND MED

                frm_reg_traslado_almacen traslado = null;
                int prod = (int) t_productos.getValueAt(i, 0);
                Integer filas_tabla = frm_reg_traslado_almacen.t_detalle.getRowCount();
                Integer copiado = 0;
                if (filas_tabla > 0) {
                    for (int x = 0; x < filas_tabla; x++) {
                        Integer id_pro_tabla;
                        id_pro_tabla = Integer.parseInt(traslado.t_detalle.getValueAt(x, 0).toString());
                        if (id_pro_tabla == prod) {
                            copiado++;
                        }
                    }
                    if (copiado == 0) {
                        frm_reg_traslado_almacen.detalle.addRow(fila);
                        frm_reg_traslado_almacen.t_detalle.setModel(frm_reg_traslado_almacen.detalle);
                        frm_reg_traslado_almacen.btn_reg.setEnabled(true);
                        funcion = "material_almacen";
                        this.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
                    }
                } else {
                    frm_reg_traslado_almacen.detalle.addRow(fila);
                    frm_reg_traslado_almacen.t_detalle.setModel(frm_reg_traslado_almacen.detalle);
                    frm_reg_traslado_almacen.btn_reg.setEnabled(true);
                    funcion = "material_almacen";
                    this.close();
                }
            }
        }
    }//GEN-LAST:event_t_productosMouseClicked

    public FindSelectionListener getFindSelectionListener() {
        return findSelectionListener;
    }

    public void setFindSelectionListener(FindSelectionListener findSelectionListener) {
        this.findSelectionListener = findSelectionListener;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_kar;
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_productos;
    private javax.swing.JTextField txt_bus;
    public static javax.swing.JTextField txt_ida;
    public static javax.swing.JTextField txt_noma;
    // End of variables declaration//GEN-END:variables
    
    private Almacen almacen;
    
    public void setAlmacen(Object aa){
        if(aa instanceof Almacen)
            almacen=(Almacen)aa;
        else{
            almacen=JPA.getInstance().get(Almacen.class,XUtil.intValue(aa));
            JPA.getInstance().close();
        }
        txt_ida.setText(almacen.getIdAlmacen().toString());
        txt_noma.setText(almacen.getNombre());
    }

    public void retrieve(){
        
        DefaultTableModel mostrar=new DefaultTableModel() {
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
        mostrar.addColumn("Cant. Min.");
        mostrar.addColumn("Clasificacion");
        mostrar.addColumn("Tipo Existencia");
        mostrar.addColumn("Estado");
        //        String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.estado, c.desc_clas, "
//                + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos inner join clasificacion as "
//                + "c on p.id_clas=c.id_clas inner join und_medida as u on p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + ida + "' "
//                + "order by p.desc_pro asc";
//        pro.mostrar_productos(query);
//        String query = "select p.idProductos, p.desc_pro, p.modelo, p.serie, p.marca, pa.cant, p.cant_min, pa.precio, p.costo_compra, p.estado, c.desc_clas, "
//                + "u.desc_und, p.grado from producto_almacen as pa inner join productos as p on pa.idProductos=p.idProductos inner join clasificacion as "
//                + "c on p.id_clas=c.id_clas inner join und_medida as u on p.idUnd_Medida=u.idUnd_Medida where pa.idAlmacen = '" + menu.almacen.getIdAlmacen() + "' "
//                + "and pa.cant <= p.cant_min and pa.cant = '0' order by p.desc_pro asc";
//       
        //Creando las filas para el JTable
        Object[] fila = new Object[10];
        for(AlmacenArticulo almacenArticulo:JPA.getInstance().getEntityManager()
                .createQuery("SELECT a FROM AlmacenArticulo a WHERE a.almacenArticuloPK.idAlmacen=:idAlmacen",AlmacenArticulo.class)
                .setParameter("idAlmacen",almacen.getIdAlmacen()).getResultList()){
            Articulo articulo=almacenArticulo.getArticulo();
            fila[0]=articulo.getIdArticulo();
            fila[1]=almacenArticulo.getArticulo().getDescripcion()
                    +" - "+articulo.getModelo()
                    +" - "+articulo.getSerie();
            fila[2]=articulo.getMarca();
            fila[3]=almacenArticulo.getCantidad();
            fila[4]=articulo.getUmedida();
//            if (ofe.precio_oferta(frm_menu.almacen.getIdAlmacen(), rs.getInt("idProductos")) == 0.00) {
//                fila[5] = rs.getDouble("precio");
//            } else {
//                fila[5] = ofe.precio_oferta(frm_menu.almacen.getIdAlmacen(), rs.getInt("idProductos"));
//            }
            fila[6]=articulo.getCantMin();
            fila[7]=articulo.getClasificacion();
            fila[8]=articulo.getGrado();
            if(articulo.getEstado().equals('1')){
                if (almacenArticulo.getCantidad().doubleValue()>articulo.getCantMin().doubleValue()) {
                    fila[9] = "NORMAL";
                }else if (almacenArticulo.getCantidad().doubleValue()<=articulo.getCantMin().doubleValue()) {
                    fila[9] = "POR TERMINAR";
                }else if (almacenArticulo.getCantidad().doubleValue()<= 0) {
                    fila[9] = "NO DISPONIBLE";
                }
            }else{
                fila[9] = "-";
            }
            mostrar.addRow(fila);
        };
        JPA.getInstance().close();
        t_productos.setModel(mostrar);
        ven.centrar_celda(t_productos, 2);
        ven.centrar_celda(t_productos, 8);
        ven.derecha_celda(t_productos, 0);
        ven.derecha_celda(t_productos, 3);
        ven.derecha_celda(t_productos, 5);
        ven.derecha_celda(t_productos, 6);
        t_productos.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_productos.getColumnModel().getColumn(1).setPreferredWidth(350);
        t_productos.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(3).setPreferredWidth(60);
        t_productos.getColumnModel().getColumn(4).setPreferredWidth(100);
        t_productos.getColumnModel().getColumn(5).setPreferredWidth(60);
        t_productos.getColumnModel().getColumn(6).setPreferredWidth(50);
        t_productos.getColumnModel().getColumn(7).setPreferredWidth(100);
        t_productos.getColumnModel().getColumn(8).setPreferredWidth(80);
        t_productos.getColumnModel().getColumn(9).setPreferredWidth(100);
        mostrar.fireTableDataChanged();
        t_productos.updateUI();
    }*/
}
