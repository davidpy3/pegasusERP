package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.app.action.ActionTool;
import org.jsuns.app.action.CreateAction;
import org.jsuns.app.action.DeleteAction;
import org.jsuns.app.action.RefreshAction;
import org.jsuns.commerce.jpa.Oferta;
import org.jsuns.swing.XPanel;

public class frm_ver_ofertas extends XPanel {

    Oferta ofe = new Oferta();
    public static String ventana = "oferta";
    public static String win = "reg";
    public String bus;
    DefaultTableModel modelo;
    int i;

    public frm_ver_ofertas() {
        initComponents();
        retrieve();

    }

    @ActionTool(target = RefreshAction.class)
    public void retrieve() {
        String query1 = "select o.idOferta, a.nom_alm, o.nom_ofer, o.fecha_ofer, o.fecha_venc, o.estado from oferta as o "
                + "inner join almacen as a on o.idAlmacen = a.idAlmacen order by o.idOferta";

        String val = txt_bus.getText();
        String query = "select * from oferta where " + bus + " like '%" + val + "%' order by fecha_ofer asc";

        query = "select o.idOferta, a.nom_alm, o.nom_ofer, o.fecha_ofer, o.fecha_venc, o.estado from oferta as o "
                + "inner join almacen as a on o.idAlmacen = a.idAlmacen order by o.idOferta";

        modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };

        modelo.addColumn("Id");
        modelo.addColumn("Tienda");
        modelo.addColumn("Descripcion");//descripcion modelo serie
        modelo.addColumn("Fec. Ini.");
        modelo.addColumn("Fec. Fin");
        modelo.addColumn("Estado");

            //Creando las filas para el JTable
//            while (rs.next()) {
//                Object[] fila = new Object[6];
//                fila[0] = rs.getObject("idOferta");
//                fila[1] = rs.getObject("nom_alm");
//                fila[2] = rs.getObject("nom_ofer");
//                fila[3] =rs.getDate("fecha_ofer");
//                fila[4] =rs.getDate("fecha_venc");
//
//                if (rs.getString("estado").equals("1")) {
//                    fila[5] = "ACTIVO";
//                } else {
//                    fila[5] = "INHABILITADO";
//                }
//
//                modelo.addRow(fila);
//            }
        this.t_oferta.setModel(modelo);
        t_oferta.getColumnModel().getColumn(0).setPreferredWidth(10);
        t_oferta.getColumnModel().getColumn(1).setPreferredWidth(40);
        t_oferta.getColumnModel().getColumn(2).setPreferredWidth(300);
        t_oferta.getColumnModel().getColumn(3).setPreferredWidth(50);
        t_oferta.getColumnModel().getColumn(4).setPreferredWidth(50);
        t_oferta.getColumnModel().getColumn(5).setPreferredWidth(30);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_oferta = new javax.swing.JTable();
        txt_bus = new javax.swing.JTextField();
        cbx_busca = new javax.swing.JComboBox();

        setToolTipText("");
        setTitle("Oferta");

        jLabel2.setText("Buscar");

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_oferta.setModel(new javax.swing.table.DefaultTableModel(
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
        t_oferta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_ofertaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_oferta);

        txt_bus.setEditable(false);
        txt_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_busActionPerformed(evt);
            }
        });
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        cbx_busca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fecha", "Nombre" }));
        cbx_busca.setSelectedIndex(1);
        cbx_busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_buscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_busca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retrieve();
        }
    }//GEN-LAST:event_txt_busKeyPressed
    @ActionTool(target = CreateAction.class)
    public void create() {
        XPanel.get(frm_reg_ofertas.class, this).open();
    }

    @ActionTool(target = DeleteAction.class)
    private Action deleteAction;

    @ActionTool(target = DeleteAction.class)
    public void delete() {
        //eliminar detalle_oferta
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar la oferta?", "Seguridad", JOptionPane.WARNING_MESSAGE);
        ofe.setIdOferta((int) t_oferta.getValueAt(i, 0));
        if (JOptionPane.OK_OPTION == confirmado) {
            try {

                String sql = "delete from detalle_oferta where idOferta ='" + ofe.getIdOferta() + "'";

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Imposible eliminar: " + e + " en: " + e.getLocalizedMessage());
                System.out.println("no se elimino el registro: " + ofe.getIdOferta());
            }

            //eliminar oferta
            try {

                String query = "delete from oferta where idOferta ='" + ofe.getIdOferta() + "'";

                retrieve();
                deleteAction.setEnabled(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
                System.out.print(ex + " " + ex.getLocalizedMessage() + " " + ex.getCause());
            }
        }
    }

    private void t_ofertaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_ofertaMouseClicked
        i = t_oferta.getSelectedRow();
        deleteAction.setEnabled(true);
        System.out.println("selecciono la fila :" + i);
    }//GEN-LAST:event_t_ofertaMouseClicked

    private void cbx_buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_buscaActionPerformed
        if (cbx_busca.getSelectedIndex() == 0) {
            bus = "fecha_ofer";
            txt_bus.setEditable(true);
            txt_bus.requestFocus();
        } else {
            bus = "nom_ofer";
            txt_bus.setEditable(true);
            txt_bus.requestFocus();
        }
    }//GEN-LAST:event_cbx_buscaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbx_busca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_oferta;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
