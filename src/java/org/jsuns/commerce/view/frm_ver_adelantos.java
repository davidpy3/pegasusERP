package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import javax.persistence.EntityManager;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.app.action.ActionTool;
import org.jsuns.app.action.AddItemAction;
import org.jsuns.app.action.DeleteAction;
import org.jsuns.app.action.CreateAction;
import org.jsuns.app.action.RefreshAction;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Adelanto;
import org.jsuns.swing.XPanel;

public class frm_ver_adelantos extends XPanel {

    private String valor;
    private int i;

    public frm_ver_adelantos() {
        initComponents();
        DefaultTableModel tm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        tm.addColumn("Id");
        tm.addColumn("Fecha");
        tm.addColumn("D.N.I");
        tm.addColumn("Empleado");
        tm.addColumn("Telefono");
        tm.addColumn("Monto");
        t_adelantos.setModel(tm);
        t_adelantos.getColumnModel().getColumn(0).setPreferredWidth(20);
        t_adelantos.getColumnModel().getColumn(1).setPreferredWidth(50);
        t_adelantos.getColumnModel().getColumn(2).setPreferredWidth(50);
        t_adelantos.getColumnModel().getColumn(3).setPreferredWidth(180);
        t_adelantos.getColumnModel().getColumn(4).setPreferredWidth(60);
        t_adelantos.getColumnModel().getColumn(5).setPreferredWidth(60);
        retrieve();
    }

    @ActionTool(target = RefreshAction.class)
    public void retrieve() {
        String bus = txt_bus.getText();
        String query = "select a.idadelanto, a.fecha, a.monto, a.dni as dni, e.nom_per as nombre, e.tel_per as tel "
                + "from adelanto as a inner join empleados as e on a.dni =e.dni order by a.idadelanto";

        if (cbx_bus.getSelectedIndex() == 0) {
            String sql = "select a.idadelanto, a.fecha, a.monto, a.dni as dni, e.nom_per as nombre, e.tel_per as tel "
                    + "from adelanto as a inner join empleados as e on a.dni =e.dni "
                    + "where a.fecha like '%" + bus + "%' "
                    + "order by a.fecha";
        } else {
            String sql = "select a.idadelanto, a.fecha, a.monto, a.dni as dni, e.nom_per as nombre, e.tel_per as tel "
                    + "from adelanto as a "
                    + "inner join empleados as e on a.dni =e.dni where a.dni like '%" + bus + "%' "
                    + "order by a.dni";
        }

        try {

//            ResultSet rs = con.consulta(st, sql);
//            Object[] dato = new Object[6];
//            while (rs.next()) {
//                dato[0] = rs.getObject("idadelanto");
//                dato[1] =rs.getDate("fecha");
//                dato[2] = rs.getObject("dni");
//                dato[3] = rs.getObject("nombre");
//                dato[4] = rs.getObject("tel");
//                dato[5] = rs.getObject("monto");
//                modelo.addRow(dato);
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getLocalizedMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        cbx_bus = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_adelantos = new javax.swing.JTable();

        setTitle("Adelantos");

        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Buscar:");

        txt_bus.setEditable(false);
        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busKeyTyped(evt);
            }
        });

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fecha", "Empleado" }));
        cbx_bus.setSelectedIndex(-1);
        cbx_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_busActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_adelantos.setModel(new javax.swing.table.DefaultTableModel(
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
        t_adelantos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_adelantosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_adelantos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void t_adelantosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_adelantosMousePressed
        i = t_adelantos.getSelectedRow();
        deleteAction.setEnabled(true);
    }//GEN-LAST:event_t_adelantosMousePressed

    private void cbx_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_busActionPerformed
        txt_bus.setText("");
        txt_bus.setEditable(true);
        txt_bus.requestFocus();
    }//GEN-LAST:event_cbx_busActionPerformed

    private void txt_busKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyTyped

    }//GEN-LAST:event_txt_busKeyTyped

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retrieve();
        }
    }//GEN-LAST:event_txt_busKeyPressed

    @ActionTool(target = CreateAction.class)
    public void create() {
        XPanel.get(frm_reg_adelanto.class,this).open();
    }

    @ActionTool(target = DeleteAction.class)
    public Action deleteAction;

    @ActionTool(target = DeleteAction.class)
    public void delete() {
        EntityManager em=JPA.getInstance().getEntityManager(true);
        em.remove(em.find(Adelanto.class,t_adelantos.getValueAt(i, 0)));
        JPA.getInstance().close();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_adelantos;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
