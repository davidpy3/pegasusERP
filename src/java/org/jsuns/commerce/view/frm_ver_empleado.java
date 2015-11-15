package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Empleado;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.swing.Action;
import javax.swing.table.DefaultTableModel;
import org.jsuns.app.action.ActionTool;
import org.jsuns.app.action.CreateAction;
import org.jsuns.app.action.EditAction;
import org.jsuns.app.action.RefreshAction;
import org.jsuns.data.JPA;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_ver_empleado extends XPanel {

    Empleado emp = new Empleado();
    Integer i;
    DefaultTableModel mostrar;
    DecimalFormatSymbols sim = new DecimalFormatSymbols(Locale.US);
    DecimalFormat formato = new DecimalFormat("####0.00", sim);

    public frm_ver_empleado() {
        initComponents();
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        mostrar.addColumn("DNI");
        mostrar.addColumn("Nombre Completo");
        mostrar.addColumn("Cargo");
        mostrar.addColumn("Telefono 1");
        mostrar.addColumn("Telefono 2");
        mostrar.addColumn("Almacen");
        mostrar.addColumn("Estado");
        t_empleado.setModel(mostrar);
        t_empleado.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_empleado.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_empleado.getColumnModel().getColumn(2).setPreferredWidth(190);
        t_empleado.getColumnModel().getColumn(3).setPreferredWidth(80);
        t_empleado.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_empleado.getColumnModel().getColumn(5).setPreferredWidth(80);
        t_empleado.getColumnModel().getColumn(6).setPreferredWidth(80);
        retrieve();
    }

    @ActionTool(target = RefreshAction.class)
    private void retrieve() {
        DefaultTableModel model = (DefaultTableModel) t_empleado.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        String buscar = txt_bus.getText();
        String parameter = cbx_tipo.getSelectedIndex() == 0 ? "dni" : "nombreCompleto";
        for (Empleado e : JPA.getInstance().getEntityManager().createQuery("SELECT "
                + "e "
                + "FROM Empleado e "
                + "WHERE TRIM(e." + parameter + ") like :" + parameter + " "
                + "ORDER BY e.nombreCompleto ASC,dni", Empleado.class)
                .setParameter(parameter, "%" + buscar + "%").getResultList()) {
            Object[] fila = new Object[7];
            fila[0] = e.getDni();
            fila[1] = e.getNombreCompleto();
            fila[3] = e.getTelefono();
            fila[4] = e.getTelefono2();
            /*Almacen almacen = e.getAlmacen();
            if (almacen != null) {
                fila[5] = almacen.getNombre();
            }
            Cargo cargo = e.getCargo();
            if (cargo != null) {
                fila[2] = cargo.getTipoCargo();
            }
            Character estado = e.getEstPer();
            if (estado != null && estado.equals('1')) {
                fila[6] = "ACTIVO";
            } else {
                fila[6] = "-";
            }
            model.addRow(fila);*/
        }
        JPA.getInstance().close();
        model.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_empleado = new javax.swing.JTable();
        btn_ret = new javax.swing.JButton();
        btn_act = new javax.swing.JButton();
        cbx_tipo = new javax.swing.JComboBox();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        jLabel1.setText("Buscar");

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_empleado.setModel(new javax.swing.table.DefaultTableModel(
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
        t_empleado.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_empleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_empleadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_empleadoMousePressed(evt);
            }
        });
        t_empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_empleadoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_empleado);
        if (t_empleado.getColumnModel().getColumnCount() > 0) {
            t_empleado.getColumnModel().getColumn(0).setPreferredWidth(30);
            t_empleado.getColumnModel().getColumn(1).setPreferredWidth(200);
            t_empleado.getColumnModel().getColumn(2).setPreferredWidth(190);
            t_empleado.getColumnModel().getColumn(3).setPreferredWidth(50);
            t_empleado.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        btn_ret.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/asterisk_orange.png"))); // NOI18N
        btn_ret.setText("Retirar");
        btn_ret.setEnabled(false);
        btn_ret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retActionPerformed(evt);
            }
        });

        btn_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/asterisk_orange.png"))); // NOI18N
        btn_act.setText("Re-Ingresar");
        btn_act.setEnabled(false);
        btn_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actActionPerformed(evt);
            }
        });

        cbx_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "Nombre" }));
        cbx_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_tipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ret)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_act)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(481, 481, 481)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ret, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_act, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @ActionTool(target = EditAction.class)
    private Action editAction;

    @ActionTool(target = CreateAction.class)
    public void create() {
//        XPanel.get(frm_reg_empleado.class, this).open();
    }
    private void t_empleadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_empleadoMousePressed
        i = t_empleado.getSelectedRow();
        editAction.setEnabled(true);
        String estado = t_empleado.getValueAt(i, 6).toString();
        if (estado.equals("-")) {
            btn_act.setEnabled(true);
            btn_ret.setEnabled(false);
        } else {
            btn_act.setEnabled(false);
            btn_ret.setEnabled(true);
        }
    }//GEN-LAST:event_t_empleadoMousePressed
    @ActionTool(target = EditAction.class)
    public void edit() {
//        frm_reg_empleado empleado = new frm_reg_empleado();
//        empleado.setEmpleado(t_empleado.getValueAt(i, 0));
//        empleado.open();
    }
    private void btn_retActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retActionPerformed
        emp.setDni((int) t_empleado.getValueAt(i, 0));
        String retira = "update empleados set est_per = '0' where dni = '" + emp.getDni() + "'";
        retrieve();
        //} else {
        //  JOptionPane.showMessageDialog(null, "Ud. No tiene permisos");
        //}
    }//GEN-LAST:event_btn_retActionPerformed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        try {

            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

                retrieve();

            }
        } catch (Exception e) {
            System.out.println("error " + e.getMessage() + " en " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void btn_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actActionPerformed
        EntityManager em = JPA.getInstance().getEntityManager(true);
        emp = em.find(Empleado.class, t_empleado.getValueAt(i, 0));
        emp.setEstPer('1');
        em.merge(emp);
        JPA.getInstance().close();
        retrieve();
    }//GEN-LAST:event_btn_actActionPerformed

    private void cbx_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_tipoActionPerformed
        txt_bus.setText("");
        txt_bus.requestFocus();
    }//GEN-LAST:event_cbx_tipoActionPerformed

    private void t_empleadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_empleadoKeyPressed

    }//GEN-LAST:event_t_empleadoKeyPressed

    private FindSelectionListener findSelectionListener;

    public FindSelectionListener getFindSelectionListener() {
        return findSelectionListener;
    }

    public void setFindSelectionListener(FindSelectionListener findSelectionListener) {
        this.findSelectionListener = findSelectionListener;
    }

    private void t_empleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_empleadoMouseClicked
        if (evt.getClickCount() == 2) {
            findSelectionListener.valueChanged(new FindSelectionEvent(
                    JPA.getInstance().get(Empleado.class, t_empleado.getValueAt(i, 0)), null, 0
            ));
            close();
        }
    }//GEN-LAST:event_t_empleadoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_act;
    private javax.swing.JButton btn_ret;
    private javax.swing.JComboBox cbx_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_empleado;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
