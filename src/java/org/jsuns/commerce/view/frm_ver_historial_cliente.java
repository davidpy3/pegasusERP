
package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Cliente;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.swing.XPanel;

public class frm_ver_historial_cliente extends XPanel{
    /*
    Cl_Varios ven = new Cl_Varios();
    
    int i;
    public frm_ver_historial_cliente() {
        initComponents();
    }

    public void setCliente(Cliente cliente){
        txt_doc.setText(cliente.getNroDoc());
        txt_nom.setText(cliente.getNombreCompleto());
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha");
        modelo.addColumn("Tipo Doc.");
        modelo.addColumn("Serie - Nro");
        modelo.addColumn("Producto");
        modelo.addColumn("Marca");
        modelo.addColumn("Precio");
        modelo.addColumn("Cant.");
        modelo.addColumn("SubTotal");

        String ver_historia = "select p.fec_ped, td.desc_tipd, p.serie_doc, p.nro_doc, dp.idProductos, pr.desc_pro, "
                + "pr.modelo, pr.serie, pr.marca, dp.precio, dp.cantidad from pedido as p inner join detalle_pedido as "
                + "dp on p.idPedido=dp.idPedido inner join tipo_doc as td on p.idtipo_doc=td.idtipo_doc inner join productos"
                + " as pr on dp.idProductos = pr.idProductos where p.nro_doc = '" + cliente.getNroDoc() + "' order by p.fec_ped desc, dp.idProductos asc";
        

//        try{
//            while(rs.next()){
//                Object[] fila = new Object[8];
//                fila[0] = rs.getString("p.fec_ped");
//                fila[1] = rs.getString("td.desc_tipd");
//                fila[2] = rs.getString("p.serie_doc") + " - " + rs.getString("p.nro_doc");
//                fila[3] = rs.getString("pr.desc_pro") + " - " + rs.getString("pr.modelo") + " - " + rs.getString("pr.serie");
//                fila[4] = rs.getString("pr.marca");
//                fila[5] = rs.getDouble("dp.precio");
//                fila[6] = rs.getDouble("dp.cantidad");
//                fila[7] = rs.getDouble("dp.cantidad") * rs.getDouble("dp.precio");
//                modelo.addRow(fila);
//            }
//        }catch(SQLException ex){
//            Logger.getLogger(frm_ver_historial_cliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
   
        t_historial.setModel(modelo);
        t_historial.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_historial.getColumnModel().getColumn(1).setPreferredWidth(100);
        t_historial.getColumnModel().getColumn(2).setPreferredWidth(90);
        t_historial.getColumnModel().getColumn(3).setPreferredWidth(250);
        t_historial.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_historial.getColumnModel().getColumn(5).setPreferredWidth(70);
        t_historial.getColumnModel().getColumn(6).setPreferredWidth(60);
        t_historial.getColumnModel().getColumn(7).setPreferredWidth(70);
        ven.centrar_celda(t_historial, 0);
        ven.centrar_celda(t_historial, 2);
        ven.centrar_celda(t_historial, 4);
        ven.derecha_celda(t_historial, 5);
        ven.derecha_celda(t_historial, 6);
        ven.derecha_celda(t_historial, 7);
        t_historial.updateUI();
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_historial = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_doc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_tel1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(254, 254, 254));
        setTitle("Listar Ventas por Producto y Cliente");

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jScrollPane1MousePressed(evt);
            }
        });

        t_historial.setModel(new javax.swing.table.DefaultTableModel(
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
        t_historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_historialMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_historial);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/exportar.png"))); // NOI18N
        jButton2.setText("Exportar a PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Nro. Doc:");

        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Telefono 2");

        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Nombre o Razon Social:");

        txt_doc.setEditable(false);

        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Telefono 1");

        txt_nom.setEditable(false);

        jLabel6.setForeground(new java.awt.Color(212, 2, 2));
        jLabel6.setText("Direccion:");

        txt_dir.setEditable(false);

        txt_tel.setEditable(false);

        txt_tel1.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nom))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_dir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frm_ver_cliente cliente = new frm_ver_cliente();
        ven.open(cliente);
        this.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String id= txt_doc.getText();
            Map<String,Object> parametros = new HashMap<>();
             parametros.put("cliente", id);            
            ven.ver_reporte("rpt_ventas_cliente",parametros);
            System.out.println("Impresion correcta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error: "+e.getLocalizedMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jScrollPane1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MousePressed
        
    }//GEN-LAST:event_jScrollPane1MousePressed

    private void t_historialMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_historialMousePressed
        i=t_historial.getSelectedRow();
    }//GEN-LAST:event_t_historialMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_historial;
    public static javax.swing.JTextField txt_dir;
    public static javax.swing.JTextField txt_doc;
    public static javax.swing.JTextField txt_nom;
    public static javax.swing.JTextField txt_tel;
    public static javax.swing.JTextField txt_tel1;
    // End of variables declaration//GEN-END:variables
*/
}
