package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Cliente;
import java.text.DecimalFormat;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.app.User;
import org.jsuns.data.JPA;
import org.jsuns.commerce.frm_menu;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_reg_cotizacion extends XPanel  {
/*
    Cl_Varios ven = new Cl_Varios();
    Cotizacion cot = new Cotizacion();
    Cliente per = new Cliente();
    User usu = new User();
    public static DefaultTableModel detalle;
    public static double sub = 0.00;
    public static double igv = 0.00;
    public static double tot = 0.00;
    public static DecimalFormat formato = new DecimalFormat("####.00");
    Integer i;

   
    public frm_reg_cotizacion() {
        initComponents();

        txt_fec.setDate(ven.getFechaActual());
        detalle = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        detalle.addColumn("Id");
        detalle.addColumn("Producto");
        detalle.addColumn("Marca");
        detalle.addColumn("Precio");
        detalle.addColumn("Cantidad");
        tDetalle.setModel(detalle);
        tDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        tDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        tDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        tDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        tDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        detalle.fireTableDataChanged();
        txt_user.setText(frm_menu.lbl_user.getText());
    }

    public void subtotal() {
        int totalRow = tDetalle.getRowCount();
        double suma_sub = 0.00;
        for (int i = 0; i < totalRow; i++) {
            suma_sub += Double.parseDouble(String.valueOf(tDetalle.getValueAt(i, 3))) * Double.parseDouble(String.valueOf(tDetalle.getValueAt(i, 4)));

        }
        if (txt_doc.getText().length() == 8) {
            sub = suma_sub / 1.18;
        } else {
            sub = suma_sub * 1.18;
        }
        txt_sub.setText(formato.format(sub));
    }

    public static void total() {
        igv = sub * 0.18;
        tot = sub + igv;
        txt_igv.setText(formato.format(igv));
        txt_tot.setText(formato.format(tot));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_doc = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        btn_bus = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        txt_tot = new javax.swing.JTextField();
        btn_cc = new javax.swing.JButton();
        txt_sub = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        btn_cp = new javax.swing.JButton();
        btn_el = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_reg = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_fec = new org.jsuns.swing.XDateField();

        setTitle("Registrar Cotizacion");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Cliente:");

        txt_doc.setEditable(false);
        txt_doc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txt_nom.setEditable(false);

        btn_bus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/find.png"))); // NOI18N
        btn_bus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Telefono:");

        txt_tel.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        tDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        tDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tDetalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tDetalle);

        txt_tot.setEditable(false);

        btn_cc.setText("+/-");
        btn_cc.setEnabled(false);
        btn_cc.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ccActionPerformed(evt);
            }
        });

        txt_sub.setEditable(false);

        txt_igv.setEditable(false);

        btn_cp.setText("S/.");
        btn_cp.setEnabled(false);
        btn_cp.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cpActionPerformed(evt);
            }
        });

        btn_el.setText("X");
        btn_el.setEnabled(false);
        btn_el.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(212, 2, 2));
        jLabel10.setText("Total");

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(212, 2, 2));
        jLabel9.setText("IGV");

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cart.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(212, 2, 2));
        jLabel8.setText("Sub Total");

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add.png"))); // NOI18N
        btn_add.setText("Agregar Producto");
        btn_add.setEnabled(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Usuario");

        txt_user.setEditable(false);

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
                        .addComponent(txt_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_bus))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_bus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ccActionPerformed
        Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Cantidad"));
        tDetalle.setValueAt(cantidad, i, 4);
        subtotal();
        total();
    }//GEN-LAST:event_btn_ccActionPerformed

    private void btn_cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cpActionPerformed
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Precio"));
        tDetalle.setValueAt(precio, i, 3);
        subtotal();
        total();
    }//GEN-LAST:event_btn_cpActionPerformed

    private void btn_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elActionPerformed
        detalle.removeRow(i);
        subtotal();
        total();
    }//GEN-LAST:event_btn_elActionPerformed

    private Cotizacion llenar() {
        Cotizacion c=new Cotizacion();
        c.setFecCot(txt_fec.getDate());
        c.setNroDoc(per);
        c.setNick(X.getUser());
        return c;
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        Cotizacion c=llenar();
        EntityManager em=JPA.getInstance().getEntityManager(true);
        em.persist(c);
        //insertar cotizacion
      

        //insertar productos en cotizacion
        int filas = tDetalle.getRowCount();
        for (int j = 0; j <= (filas - 1); j++) {
            String idPro = tDetalle.getValueAt(j, 0).toString();
            Double cantidad = Double.parseDouble(tDetalle.getValueAt(j, 4).toString());
            Double precio = Double.parseDouble(tDetalle.getValueAt(j, 3).toString());
//        try {
//        Statement st = con.conexion();
//        String ins_det_cot = "insert into Detalle_Cotizacion Values ('"+cot.getId()+"', "
//                + "'"+idPro+"', '"+cantidad+"', '"+precio+"')";
//        con.actualiza(st, ins_det_cot);
//        con.cerrar(st);  
//        System.out.print("insertando producto: id: " + idPro + " Cantidad: " + cantidad + " Precio: " + precio + "\n");
//        } catch (Exception ex) {
//            System.out.print(ex);
//        }
        }

    //mostrar cotizacion 
        Connection st = con.conx();
         Map<String, Object> parametros = new HashMap<>();
         parametros.put("cot", cot.getId());
        
         try {
         JasperReport jasperReport;
         JasperPrint jasperPrint;
         jasperReport = JasperCompileManager.compileReport("Reports//rpt_cotizacion.jrxml");
         jasperPrint = JasperFillManager.fillReport(
         jasperReport, parametros, st);
         JasperExportManager.exportReportToPdfFile(
         jasperPrint, "Reports/rpt_cotizacion_"+cot.getId()+".pdf");

         try {
         File file = new File("Reports/rpt_cotizacion_"+cot.getId()+".pdf");
         Desktop.getDesktop().open(file);
         } catch(IOException e) {
         System.out.print(e);
         JOptionPane.showMessageDialog(null, e);
         }
                
         } catch (JRException ex) {
         System.out.print(ex);
         JOptionPane.showMessageDialog(null, ex);
            
         }
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busActionPerformed
ven.open(new frm_ver_cliente());
    }//GEN-LAST:event_btn_busActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        frm_ver_productos productos = new frm_ver_productos();
        productos.setFindSeleccionListener(this);
        ven.open(productos);
    }//GEN-LAST:event_btn_addActionPerformed

    @Override
    public void valueChanged(FindSelectionEvent evt) {
        int a = evt.getSelectedRows()[0];
evt.getSource();
        
        
        int tabla = tDetalle.getRowCount();                   //obtener la cantidad de filas de la tabla cotizacion
        String id = tDetalle.getValueAt(a, 0).toString();         //id del formulario ver_productos(formulario actual)
        String id_prod = "";
        int contar_repetidos = 0;
        Object[] dato = new Object[6];
        dato[0] = tDetalle.getValueAt(a, 0);         //idproducto
        dato[1] = tDetalle.getValueAt(a, 1);         //descripcion
        dato[2] = tDetalle.getValueAt(a, 2);         //marca
        dato[3] = "1";                                  //cantidad
        dato[4] = tDetalle.getValueAt(a, 7);         //und. med
        dato[5] = tDetalle.getValueAt(a, 3);         //precio
        if (tabla > 0) {            //verifica si existen registros
            for (int j = 0; j < tabla; j++) {           //recorremos la tabla reg_cotizaciones
                id_prod = tDetalle.getValueAt(j, 0).toString();// captura el id reg_cotizaciones

                if (id_prod.equals(id)) {
                    contar_repetidos++;
                }
            }
            if (contar_repetidos == 0) {
                detalle.addRow(dato);
                tDetalle.setModel(frm_reg_cotizacion.detalle);
                subtotal();
                total();
                btn_reg.setEnabled(true);
                btn_reg.requestFocus();
                this.close();
            }

        } else {
            detalle.addRow(dato);
            tDetalle.setModel(frm_reg_cotizacion.detalle);
            btn_reg.setEnabled(true);
            btn_reg.requestFocus();
            this.close();
        }
    }

    private void tDetalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDetalleMousePressed
        i = tDetalle.getSelectedRow();
        btn_cc.setEnabled(true);
        btn_cp.setEnabled(true);
        btn_el.setEnabled(true);
    }//GEN-LAST:event_tDetalleMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_add;
    private javax.swing.JButton btn_bus;
    private javax.swing.JButton btn_cc;
    private javax.swing.JButton btn_cp;
    private javax.swing.JButton btn_el;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tDetalle;
    private javax.swing.JTextField txt_doc;
    private org.jsuns.swing.XDateField txt_fec;
    public static javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_nom;
    public static javax.swing.JTextField txt_sub;
    private javax.swing.JTextField txt_tel;
    public static javax.swing.JTextField txt_tot;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
*/
}
