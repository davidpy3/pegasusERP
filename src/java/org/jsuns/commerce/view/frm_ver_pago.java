package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.app.action.ActionTool;
import org.jsuns.app.action.DeleteAction;
import org.jsuns.app.action.CreateAction;
import org.jsuns.app.action.RefreshAction;
import org.jsuns.swing.XPanel;

public class frm_ver_pago extends XPanel {

    DefaultTableModel modelo;
    int i;

    @ActionTool(target = DeleteAction.class)
    private Action deleteAction;

    public frm_ver_pago() {
        initComponents();
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        modelo.addColumn("Id");
        modelo.addColumn("Fecha");
        modelo.addColumn("Dni");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cargo");
        modelo.addColumn("Comision");
        modelo.addColumn("Otros Ingresos");
        modelo.addColumn("Adelantos");
        modelo.addColumn("Otros Descuentos");
        modelo.addColumn("Salario");
        t.setModel(modelo);
        t.getColumnModel().getColumn(0).setPreferredWidth(20);
        t.getColumnModel().getColumn(1).setPreferredWidth(20);
        t.getColumnModel().getColumn(2).setPreferredWidth(20);
        t.getColumnModel().getColumn(3).setPreferredWidth(180);
        t.getColumnModel().getColumn(4).setPreferredWidth(100);
        t.getColumnModel().getColumn(5).setPreferredWidth(20);
        t.getColumnModel().getColumn(6).setPreferredWidth(50);
        t.getColumnModel().getColumn(7).setPreferredWidth(20);
        t.getColumnModel().getColumn(8).setPreferredWidth(50);
        t.getColumnModel().getColumn(9).setPreferredWidth(80);
        retrieve();
    }

    @ActionTool(target = RefreshAction.class)
    public void retrieve() {
        String query = "select p.idpago, p.fecha , p.comisiones, p.otrosingresos, p.adelantos, p.otrosdescuentos"
                + ", p.dni, e.nom_per, e.tel_per, e.tel2_per, c.tipo_cargo, p.salario from pago as p inner join empleados as e "
                + "on p.dni=e.dni inner join cargo as c on e.idCargo=c.idCargo order by p.idpago";

        String bus = txt_bus.getText();
        if (!bus.isEmpty()) {
            if (cbx_bus.getSelectedIndex() == 0) {
                String sql = "select p.idpago, p.fecha , p.comisiones, p.otrosingresos, p.adelantos, p.otrosdescuentos"
                        + ", p.dni, e.nom_per, e.tel_per, e.tel2_per, c.tipo_cargo, p.salario from pago as p inner join empleados as e "
                        + "on p.dni=e.dni inner join cargo as c on e.idCargo=c.idCargo where p.fecha like '%" + bus + "%' order by p.fecha";

            }
            if (cbx_bus.getSelectedIndex() == 1) {
                String sql = "select p.idpago, p.fecha , p.comisiones, p.otrosingresos, p.adelantos, p.otrosdescuentos"
                        + ", p.dni, e.nom_per, e.tel_per, e.tel2_per, c.tipo_cargo, p.salario from pago as p inner join empleados as e "
                        + "on p.dni=e.dni inner join cargo as c on e.idCargo=c.idCargo where p.dni like '%" + bus + "%' order by p.idpago";

            }
            if (cbx_bus.getSelectedIndex() == 2) {
                String sql = "select p.idpago, p.fecha , p.comisiones, p.otrosingresos, p.adelantos, p.otrosdescuentos"
                        + ", p.dni, e.nom_per, e.tel_per, e.tel2_per, c.tipo_cargo, p.salario from pago as p inner join empleados as e "
                        + "on p.dni=e.dni inner join cargo as c on e.idCargo=c.idCargo where e.nom_per like '%" + bus + "%' order by p.idpago";

            }
            if (cbx_bus.getSelectedIndex() == 3) {
                String sql = "select p.idpago, p.fecha , p.comisiones, p.otrosingresos, p.adelantos, p.otrosdescuentos"
                        + ", p.dni, e.nom_per, e.tel_per, e.tel2_per, c.tipo_cargo, p.salario from pago as p inner join empleados as e "
                        + "on p.dni=e.dni inner join cargo as c on e.idCargo=c.idCargo where c.tipo_cargo like '%" + bus + "%' order by c.tipo_cargo";

            }
        }
        String sql = "select p.idpago, "
                + "p.fecha , p.comisiones, p.otrosingresos, p.adelantos, p.otrosdescuentos"
                + ", p.dni, e.nom_per, e.tel_per, e.tel2_per, "
                + "c.tipo_cargo, p.salario "
                + "from pago as p "
                + "inner join empleados as e "
                + "on p.dni=e.dni "
                + "inner join cargo as c on e.idCargo=c.idCargo order by p.idpago";

        try {

            Object[] dato = new Object[10];
//            while (rs.next()) {
//                dato[0] = rs.getObject("idpago");
//                dato[1] =rs.getDate("fecha");
//                dato[2] = rs.getObject("dni");
//                dato[3] = rs.getObject("nom_per");
//                dato[4] = rs.getObject("tipo_cargo");
//                dato[5] = rs.getObject("comisiones");
//                dato[6] = rs.getObject("otrosingresos");
//                dato[7] = rs.getObject("adelantos");
//                dato[8] = rs.getObject("otrosdescuentos");
//                dato[9] = rs.getObject("salario");                             
//                modelo.addRow(dato);
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        cbx_bus = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        t = new javax.swing.JTable();

        setTitle("Pagos a Personal");

        jLabel1.setText("Buscar:");

        txt_bus.setEditable(false);
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fecha", "Dni", "Nombre", "Cargo" }));
        cbx_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_busActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11"
            }
        ));
        t.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retrieve();

        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void cbx_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_busActionPerformed
        txt_bus.setEditable(true);
        txt_bus.requestFocus();
    }//GEN-LAST:event_cbx_busActionPerformed

    @ActionTool(target = DeleteAction.class)
    public void delete() {
        String id = t.getValueAt(i, 0).toString();
        String sql = "delete from pago where idpago= '" + id + "'";

        retrieve();
        deleteAction.setEnabled(false);
    }

    private void tMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMousePressed
        i = t.getSelectedRow();
        deleteAction.setEnabled(true);
    }//GEN-LAST:event_tMousePressed
    @ActionTool(target = CreateAction.class)
    public void create() {
        XPanel.get(frm_reg_pago.class, this).open();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
