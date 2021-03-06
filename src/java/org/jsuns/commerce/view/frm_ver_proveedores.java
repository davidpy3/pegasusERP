package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.swing.XPanel;

public class frm_ver_proveedores extends XPanel{

    //Cl_Varios ven = new Cl_Varios();
    //Proveedor pro = new Proveedor();
    DefaultTableModel mostrar;
    public static String funcion = "proveedor";
    int i;

    public frm_ver_proveedores() {
        initComponents();
        txt_bus.requestFocus();
        retrieve();
    }

    private void retrieve(){
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        //La cantidad de columnas que tiene la consulta
        //Establecer como cabezeras el nombre de las colimnas
        mostrar.addColumn("RUC");
        mostrar.addColumn("Razon Social");
        mostrar.addColumn("Telefono");
        mostrar.addColumn("Contacto");
        mostrar.addColumn("Estado");
        String bus=txt_bus.getText();
        String q="SELECT p FROM Proveedor p "
                +"WHERE p.ruc like :w or "
                    + " p.razonSocial like :w "
                        + " ORDER BY p.razonSocial";
       /* for(Proveedor proveedor:JPA.getInstance().getEntityManager()
                .createQuery(q,Proveedor.class).setParameter("w","%"+bus+"%").getResultList()){
            Object[] fila=new Object[5];
            fila[0]=proveedor.getRuc();
            fila[1]=proveedor.getRazonSocial();
            fila[2]=proveedor.getTelefono();
            fila[3]=proveedor.getContacto();
            fila[4]=(proveedor.getEstado()!=null&&proveedor.getEstado()=='1')?"ACTIVO":"-";
            mostrar.addRow(fila);
        }*/
        t_proveedor.setModel(mostrar);
        t_proveedor.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_proveedor.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_proveedor.getColumnModel().getColumn(2).setPreferredWidth(150);
        t_proveedor.getColumnModel().getColumn(3).setPreferredWidth(60);
        mostrar.fireTableDataChanged();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_mod = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_proveedor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt_bus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Ver Proveedor");

        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_proveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        t_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_proveedorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_proveedorMousePressed(evt);
            }
        });
        t_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_proveedorKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_proveedor);

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_bus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_busKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_bus, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new frm_reg_proveedor().open();
        retrieve();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_proveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_proveedorKeyPressed
        int i = t_proveedor.getSelectedRow();

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            txt_bus.setText("");
            txt_bus.requestFocus();
        }

    }//GEN-LAST:event_t_proveedorKeyPressed

    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            retrieve();
        }
    }//GEN-LAST:event_txt_busKeyPressed

    private void t_proveedorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_proveedorMousePressed

    }//GEN-LAST:event_t_proveedorMousePressed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
         
                frm_reg_proveedor prove = new frm_reg_proveedor();
               /// pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
            
             //   String ver_prov = "select * from proveedor where ruc_pro = '" + pro.getRuc() + "'";
           
//                if (rs.next()) {
//                    prove.txt_ruc.setText(pro.getRuc());
//                    prove.txt_raz.setText(rs.getString("raz_soc_pro"));
//                    prove.txt_contacto.setText(rs.getString("contacto"));
//                    prove.txt_dir.setText(rs.getString("dir_pro"));
//                    prove.txt_email.setText(rs.getString("email_contacto"));
//                    prove.txt_tel.setText(rs.getString("tel_pro"));
//                    prove.txt_tel1.setText(rs.getString("tel_contacto"));
//                    prove.txt_tel2.setText(rs.getString("tel2_contacto"));
//                    prove.txt_web.setText(rs.getString("web"));
//                    prove.txt_ruc.setEditable(false);
//                    prove.txt_raz.setEditable(true);
//                    prove.txt_contacto.setEditable(true);
//                    prove.txt_dir.setEditable(true);
//                    prove.txt_email.setEditable(true);
//                    prove.txt_web.setEditable(true);
//                    prove.txt_tel.setEditable(true);
//                    prove.txt_tel1.setEditable(true);
//                    prove.txt_tel2.setEditable(true);
//                    prove.btn_reg.setEnabled(true);
//                    prove.accion = "mod";
//                }
              
                //ven.open(prove);
                this.close();
      
    }//GEN-LAST:event_btn_modActionPerformed

    private void t_proveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_proveedorMouseClicked
        int i;
        i = t_proveedor.getSelectedRow();
        //pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
        btn_mod.setEnabled(true);

        if (evt.getClickCount() == 2) {
            txt_bus.setText("");
            txt_bus.requestFocus();

            if (funcion.equals("compra_prod")) {
                frm_reg_compra_prod compra_pro = null;
               
                  
                  //  String ver_pro = "select * from proveedor where ruc_pro = '" + pro.getRuc() + "'";
               
//                    if (rs.next()) {
//                        compra_pro.txt_ruc.setText(pro.getRuc());
//                        compra_pro.txt_raz.setText(rs.getString("raz_soc_pro"));
//                        compra_pro.txt_dir.setText(rs.getString("dir_pro"));
//                        compra_pro.btn_bus_emp.setEnabled(true);
//                        compra_pro.btn_bus_emp.requestFocus();
//                        this.close();
//                    }
                
            }

            if (funcion.equals("compra_serv")) {
                frm_reg_compra_serv compra_serv = null;
              //  pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
            
                   
                    //String ver_pro = "select * from proveedor where ruc_pro = '" + pro.getRuc() + "'";
                  
//                    if (rs.next()) {
//                        compra_serv.txt_ruc.setText(pro.getRuc());
//                        compra_serv.txt_raz.setText(rs.getString("raz_soc_pro"));
//                        compra_serv.txt_dir.setText(rs.getString("dir_pro"));
//                        compra_serv.txt_tel.setText(rs.getString("tel_pro"));
//                        compra_serv.cbx_tipa.setSelectedIndex(0);
//                        compra_serv.cbx_tipa.setEnabled(true);
//                        compra_serv.cbx_tipa.requestFocus();
//                        this.close();
//                    }
                

            }
            if (funcion.equals("compras_prov")) {
                /*pro.setRuc(t_proveedor.getValueAt(i, 0).toString());
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("proveedor", pro.getRuc());
                ven.ver_reporte("rpt_compras_proveedor", parametros);
                this.close();*/
            }
            funcion = "proveedor";
        }
    }//GEN-LAST:event_t_proveedorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_proveedor;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
}
