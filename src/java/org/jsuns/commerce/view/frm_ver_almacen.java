package org.jsuns.commerce.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.swing.XPanel;

public class frm_ver_almacen extends XPanel{
/*
    Cl_Varios ven = new Cl_Varios();
//    Articulo pro = new Articulo();
    Almacen alm = new Almacen();
    DefaultTableModel mostrar;
    Integer i;
    public static String ventana = "almacen";

    public frm_ver_almacen(){
        initComponents();
        ver_almacen();
    }

    private void ver_almacen(){
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        mostrar.addColumn("Id");
        mostrar.addColumn("Nombre");
        mostrar.addColumn("Direccion");
        mostrar.addColumn("Ruc");
        mostrar.addColumn("Razon Social");
        mostrar.addColumn("Ciudad");
        mostrar.addColumn("Estado");
        for(Almacen almacen:JPA.getInstance().getEntityManager().createQuery("SELECT a "
                + "FROM Almacen a ORDER BY a.nombre",Almacen.class).getResultList()){
            Object[] fila = new Object[7];
            fila[0]=almacen.getIdAlmacen();
            fila[1]=almacen.getNombre();
            fila[2]=almacen.getDireccion();
            fila[3]=almacen.getRuc();
            fila[4]=almacen.getRazonSocial();
            fila[5]=almacen.getCiudad();
            fila[6]=almacen.getEstado().equals('1')?"ACTIVO":"-";
            mostrar.addRow(fila);
        }
        JPA.getInstance().close();
        t_almacen.setModel(mostrar);
        t_almacen.getColumnModel().getColumn(0).setPreferredWidth(20);
        t_almacen.getColumnModel().getColumn(1).setPreferredWidth(100);
        t_almacen.getColumnModel().getColumn(2).setPreferredWidth(250);
        t_almacen.getColumnModel().getColumn(3).setPreferredWidth(100);
        t_almacen.getColumnModel().getColumn(4).setPreferredWidth(250);
        t_almacen.getColumnModel().getColumn(5).setPreferredWidth(80);
        t_almacen.getColumnModel().getColumn(6).setPreferredWidth(80);
        mostrar.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_almacen = new javax.swing.JTable();
        btn_pred = new javax.swing.JButton();
        btn_ver = new javax.swing.JButton();

        setTitle("Ver Almacen");

        jLabel1.setText("Buscar:");

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_almacen.setModel(new javax.swing.table.DefaultTableModel(
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
        t_almacen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        t_almacen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_almacenMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_almacenMousePressed(evt);
            }
        });
        t_almacen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_almacenKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_almacen);

        btn_pred.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/house.png"))); // NOI18N
        btn_pred.setText("Predeterminar");
        btn_pred.setEnabled(false);
        btn_pred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_predActionPerformed(evt);
            }
        });

        btn_ver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sockets.png"))); // NOI18N
        btn_ver.setText("Ver Materiales");
        btn_ver.setEnabled(false);
        btn_ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_pred)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ver)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_pred, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_almacenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_almacenMousePressed
        i = t_almacen.getSelectedRow();
        btn_pred.setEnabled(true);
        btn_ver.setEnabled(true);
    }//GEN-LAST:event_t_almacenMousePressed

    private void btn_predActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_predActionPerformed
        try {
            alm.setNombre(t_almacen.getValueAt(i, 1).toString());
            String ruta = "almacen.txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            if (archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(alm.getNombre());
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(alm.getNombre());
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Se ha establecido correctamente.\nReingrese al Sistema");
            System.exit(0);
        } catch (IOException ex) {
            System.out.print(ex);
        }
    }//GEN-LAST:event_btn_predActionPerformed


    
    private void btn_verActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verActionPerformed
        frm_ver_prod_alm mat=new frm_ver_prod_alm();
        mat.setAlmacen(t_almacen.getValueAt(i, 0).toString());
        mat.retrieve();
        ven.open(mat);
        this.close();

    }//GEN-LAST:event_btn_verActionPerformed

    private void t_almacenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_almacenKeyPressed

    }//GEN-LAST:event_t_almacenKeyPressed

    private void t_almacenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_almacenMouseClicked
        if (evt.getClickCount() == 2) {

            if (ventana.equals("rpt_venta_alm")) {
                frm_rpt_fechas fec = new frm_rpt_fechas();
                fec.rpt = "venta_almacen";
                int id = (int) t_almacen.getValueAt(i, 0);
                fec.alm.setIdAlmacen(id);
                ven.open(fec);
                ventana = "";
                this.close()
            }
            // REPORTE DE PRODUCTO EN ALMACEN
            if (ventana.equals("rpt_prod_alm")) {
                int id = (int) t_almacen.getValueAt(i, 0);
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("idalm", id);
                ven.ver_reporte("rpt_prod_alm", parametros);
                this.close();
            }
            // VALORIZADO DE ARTICULOS EN ALMACEN
            if (ventana.equals("rpt_ganancia_almacen")) {
                int id = (int) t_almacen.getValueAt(i, 0);
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("idalm", id);
                ven.ver_reporte("rpt_utilidad_almacen", parametros);
                this.close();
            }

            // GANANCIA DE VENTAS POR ALMACEN
            if (ventana.equals("rpt_gana_venta")) {
                /*frm_rpt_fechas fec = new frm_rpt_fechas();
                fec.rpt = "ganancia_venta";
                int id = (int) t_almacen.getValueAt(i, 0);
                fec.alm.setIdAlmacen(id);
                ven.open(fec);
                ventana = "";
                this.close();
            }
        }

    }//GEN-LAST:event_t_almacenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pred;
    private javax.swing.JButton btn_ver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_almacen;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
*/
}
