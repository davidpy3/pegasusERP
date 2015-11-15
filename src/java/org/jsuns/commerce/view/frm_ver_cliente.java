package org.jsuns.commerce.view;

import java.awt.event.ActionEvent;
import org.jsuns.commerce.jpa.Cliente;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.app.action.ActionTool;
import org.jsuns.app.action.CreateAction;
import org.jsuns.app.action.DeleteAction;
import org.jsuns.app.action.EditAction;
import org.jsuns.app.action.RefreshAction;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_ver_cliente extends XPanel 
{
/*
    private Cliente cliente = new Cliente();
    private String ventana = "cliente";
    private String win = "reg";
    private String rpt;
    private Integer i;
    private DefaultTableModel mostrar;

    public frm_ver_cliente() {
        initComponents();
        popup.registerForContextMenu(table);
        retrieve();
    }

    @ActionTool(target = RefreshAction.class)
    private void retrieve() {
        String buscar = txt_bus.getText();
        String query = "select nro_doc, nom_per, tel_per,tel2_per, "
                + "est_per from cliente "
                + "where nom_per like '%" + buscar + "%' "
                + "or nro_doc like '%" + buscar + "%' order by nom_per asc";

        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
            //La cantidad de columnas que tiene la consulta
        //Establecer como cabezeras el nombre de las colimnas
        mostrar.addColumn("Nro Doc.");
        mostrar.addColumn("Nombre Completo");
        mostrar.addColumn("Telefono 1");
        mostrar.addColumn("Telefono 2");
        mostrar.addColumn("Estado");

        //Creando las filas para el JTable
//            while (rs.next()) {
//                Object[] fila = new Object[5];
//                fila[0] = rs.getObject("nro_doc");
//                fila[1] = rs.getObject("nom_per");
//                fila[2] = rs.getObject("tel_per");
//                fila[3] = rs.getObject("tel2_per");
//                String estado = rs.getString("est_per");
//                if (estado.equals("1")) {
//                    fila[4] = "Activo";
//                } else {
//                    fila[4] = "-";
//                }
//
//                mostrar.addRow(fila);
//            }
        table.setModel(mostrar);
        mostrar.fireTableDataChanged();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup = new org.jsuns.swing.XPopup();
        m_ver_reporte = new javax.swing.JMenuItem();
        m_ver_historial = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_historial = new javax.swing.JButton();

        m_ver_reporte.setText("Ver Reporte");
        m_ver_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_ver_reporteActionPerformed(evt);
            }
        });
        popup.add(m_ver_reporte);

        m_ver_historial.setText("Ver Historial");
        popup.add(m_ver_historial);

        setTitle("Ver Clientes");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        jLabel1.setText("Buscar:");

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_busKeyTyped(evt);
            }
        });

        table.setBackground(new java.awt.Color(254, 254, 254));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"46993209", "LUIS ENRIQUE OYANGUREN GIRON", "947396729", "Normal"},
                {"10469932091", "LEOG SYSTEMS ", "947396729", "Normal"},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nro. Doc", "Nombre o Razon Social", "Telefono", "Estado"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btn_historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blog.png"))); // NOI18N
        btn_historial.setText("Ver Historial");
        btn_historial.setEnabled(false);
        btn_historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_historialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(btn_historial)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_historial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    @ActionTool(target = EditAction.class)
    private Action editAction;
    @ActionTool(target = DeleteAction.class)
    private Action deleteAction;

    @ActionTool(target = CreateAction.class)
    public void create() {
        frm_reg_cliente r = XPanel.get(frm_reg_cliente.class, this);
        r.setFindSelectionListener(this);
        r.open();
    }
    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        i = table.getSelectedRow();
        editAction.setEnabled(true);
        deleteAction.setEnabled(true);
        btn_historial.setEnabled(true);
        cliente.setNroDoc(table.getValueAt(i, 0).toString());
//        if (ventana.equals("venta")) {
//            frm_reg_venta.txt_nrod.setText(t_clientes.getValueAt(i, 0).toString());
//            frm_reg_venta.txt_nomc.setText(t_clientes.getValueAt(i, 1).toString());
//            frm_reg_venta.txt_fec.requestFocus();
//            frm_reg_venta.btn_add_pro.setEnabled(true);
//            ventana = "cliente";
//            this.dispose();
//        }
//        
//        if (ventana.equals("cotizacion")) {
//            frm_reg_cotizacion.txt_doc.setText(t_clientes.getValueAt(i, 0).toString());
//            frm_reg_cotizacion.txt_nom.setText(t_clientes.getValueAt(i, 1).toString());
//            frm_reg_cotizacion.txt_tel.setText(t_clientes.getValueAt(i, 2).toString());
//            frm_reg_cotizacion.txt_fec.setText(ven.getFechaActual());
//            frm_reg_cotizacion.txt_fec.setEditable(true);
//            frm_reg_cotizacion.txt_fec.requestFocus();
//            frm_reg_cotizacion.btn_add.setEnabled(true);
//            ventana = "cliente";
//            this.dispose();
//        }
    }//GEN-LAST:event_tableMousePressed

    private void txt_busKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyTyped

    }//GEN-LAST:event_txt_busKeyTyped

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            retrieve();
        }
    }//GEN-LAST:event_txt_busKeyPressed

    @ActionTool(target = EditAction.class)
    public void edit() {
        frm_reg_cliente cliente = new frm_reg_cliente();
        cliente.setCliente(table.getValueAt(i, 0).toString());
        cliente.open();
    }

    @ActionTool(target = DeleteAction.class)
    public void delete() {
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar el cliente?");

        if (JOptionPane.OK_OPTION == confirmado) {
            try {

                String eli_cli = "delete from cliente where nro_doc = '" + cliente.getNroDoc() + "'";

                retrieve();
            } catch (Exception ex) {
                System.out.print(ex);
                JOptionPane.showMessageDialog(null, "Error al Eliminar!");
            }
        } else {
            System.out.print("no hago nada!");
        }
    }
    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

    }//GEN-LAST:event_tableKeyPressed

    private void btn_historialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_historialActionPerformed
        frm_ver_historial_cliente historial = new frm_ver_historial_cliente();
        cliente.setNroDoc(table.getValueAt(i, 0).toString());
        cliente.setNombreCompleto(table.getValueAt(i, 1).toString());
        historial.setCliente(cliente);
        ven.open(historial);
        this.close();
    }//GEN-LAST:event_btn_historialActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() > 1) {
            if (ventana.equals("cotizacion")) {
                frm_reg_cotizacion coti = null;
                cliente.setNroDoc(table.getValueAt(i, 0).toString());

                String ver_pro = "select * from cliente where nro_doc = '" + cliente.getNroDoc() + "'";

//                if (rs.next()) {
//                    coti.txt_doc.setText(cliente.getNroDoc() + "");
//                    coti.txt_nom.setText(rs.getString("nom_per"));
//                    coti.txt_tel.setText(rs.getString("tel_per") + " - " + rs.getString("tel2_per"));
//                    coti.btn_add.setEnabled(true);
//                    coti.btn_add.requestFocus();
//                    this.close();
//                }
            }
            //clientes
            if (ventana.equals("reg_venta")) {
                frm_reg_venta venta = null;
                cliente.setNroDoc(table.getValueAt(i, 0).toString());

                String ver_pro = "select nro_doc, nom_per from cliente where nro_doc = '" + cliente.getNroDoc() + "'";

//                if (rs.next()) {
//                        //venta.txt_nrod.setText(cli.getNroDoc() + "");
//                    //venta.txt_nomc.setText(rs.getString("nom_per"));                        
//                    frm_reg_venta.cbx_tipd.setEnabled(true);
//                    frm_reg_venta.cbx_tipd.requestFocus();
//                    this.close();
//                }
            }
            //ENVIAR ID PARA REPORTE
            if (rpt.equals("rpt_cliente")) {

            }
            ventana = "cliente";
        }
    }//GEN-LAST:event_tableMouseClicked

    private void m_ver_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_ver_reporteActionPerformed
        cliente.setNroDoc(table.getValueAt(i, 0).toString());
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("cliente", cliente.getNroDoc());
        ven.ver_reporte("rpt_ventas_cliente", parametros);
        this.close();
    }//GEN-LAST:event_m_ver_reporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_historial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem m_ver_historial;
    private javax.swing.JMenuItem m_ver_reporte;
    private org.jsuns.swing.XPopup popup;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(FindSelectionEvent evt) {
        cliente = (Cliente) evt.getSource();
        retrieve();
    }
*/
}
