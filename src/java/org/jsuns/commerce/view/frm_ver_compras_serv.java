package org.jsuns.commerce.view;


import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
//import org.jsuns.commerce.jpa.Compra;
import org.jsuns.swing.XPanel;

public class frm_ver_compras_serv extends XPanel{

    /*private Cl_Varios ven=new Cl_Varios();
    private Compra com=new Compra();
    private Proveedor pro=new Proveedor();
    private TipoDocumento tido = new TipoDocumento();
    private Almacen alm = new Almacen();
//    private Articulo mat = new Articulo();
    private DefaultTableModel mostrar;
    private DecimalFormatSymbols simbolo=new DecimalFormatSymbols(Locale.US);
    private DecimalFormat formato=new DecimalFormat("####0.00", simbolo);
    private Integer i;

    public frm_ver_compras_serv() {
        initComponents();
        retrive();
        t_compras.setDefaultRenderer(Object.class, new table_render());
    }

    private void retrive() {
        String query = "select c.idCompra, c.glosa, c.fecha_doc, c.fecha_pago, c.total, t.desc_tipd, c.serie_doc, c.estado, c.nro_doc, c.ruc_pro, p.raz_soc_pro, a.nom_alm from compra as c "
                + "inner join tipo_doc as t on c.idtipo_doc=t.idtipo_doc inner join proveedor as p on c.ruc_pro=p.ruc_pro "
                + "inner join almacen as a on c.idAlmacen=a.idAlmacen where c.tipo_compra = 'S' order by c.fecha_doc desc, c.idCompra desc";

            mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            mostrar.addColumn("Id");
            mostrar.addColumn("glosa");
            mostrar.addColumn("Fec. Compra");
            mostrar.addColumn("Fec. Pago");
            mostrar.addColumn("Tipo Doc.");
            mostrar.addColumn("Serie");
            mostrar.addColumn("Nro.");
            mostrar.addColumn("RUC");
            mostrar.addColumn("Razon Social");
            mostrar.addColumn("Total");
            mostrar.addColumn("Almacen");
            mostrar.addColumn("Estado");

//            while (rs.next()) {
//                Object fila[] = new Object[12];
//                fila[0] = rs.getString("idCompra");
//                fila[1] = rs.getString("glosa");
//                fila[2] =rs.getDate("fecha_doc");
//                try {
//                    Statement st1 = con.conexion();
//                    String ver_fec = "select fec_venc from pago_compras where idCompra =  '" + rs.getString("idCompra") + "' and estado = '0' limit 1";
//                    ResultSet rs1 = con.consulta(st1, ver_fec);
//                    if (rs1.next()) {
//                        fila[3] =rs1.getDate("fec_venc");
//                    } else {
//                        fila[3] =rs.getDate("fecha_pago");
//                    }
//                    con.cerrar(rs1);
//                    con.cerrar(st1);
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//                fila[4] = rs.getString("desc_tipd");
//                fila[5] = rs.getString("serie_doc");
//                fila[6] = rs.getString("nro_doc");
//                fila[7] = rs.getString("ruc_pro");
//                fila[8] = rs.getString("raz_soc_pro");
//                fila[9] = formato.format(rs.getDouble("total"));
//                fila[10] = rs.getString("nom_alm");
//                if (rs.getString("estado").equals("1")) {
//                    fila[11] = "PAGADO";
//                } else {
//                    fila[11] = "PENDIENTE";
//                }
//                mostrar.addRow(fila);
//            }
            t_compras.setModel(mostrar);
            t_compras.getColumnModel().getColumn(0).setPreferredWidth(30);
            t_compras.getColumnModel().getColumn(1).setPreferredWidth(400);
            t_compras.getColumnModel().getColumn(2).setPreferredWidth(75);
            t_compras.getColumnModel().getColumn(3).setPreferredWidth(75);
            t_compras.getColumnModel().getColumn(4).setPreferredWidth(80);
            t_compras.getColumnModel().getColumn(5).setPreferredWidth(35);
            t_compras.getColumnModel().getColumn(6).setPreferredWidth(70);
            t_compras.getColumnModel().getColumn(7).setPreferredWidth(90);
            t_compras.getColumnModel().getColumn(8).setPreferredWidth(250);
            t_compras.getColumnModel().getColumn(9).setPreferredWidth(60);
            t_compras.getColumnModel().getColumn(10).setPreferredWidth(90);
            t_compras.getColumnModel().getColumn(11).setPreferredWidth(80);
            ven.derecha_celda(t_compras, 0);
            ven.centrar_celda(t_compras, 2);
            ven.centrar_celda(t_compras, 3);
            ven.centrar_celda(t_compras, 4);
            ven.centrar_celda(t_compras, 5);
            ven.centrar_celda(t_compras, 6);
            ven.centrar_celda(t_compras, 7);
            ven.derecha_celda(t_compras, 9);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_anu = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        cbx_bus = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_compras = new javax.swing.JTable();
        btn_pagar = new javax.swing.JButton();

        setTitle("Ver Compras de Servicios");

        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Buscar por:");

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_anu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/bin_closed.png"))); // NOI18N
        btn_anu.setText("Anular");
        btn_anu.setEnabled(false);
        btn_anu.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_anu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anuActionPerformed(evt);
            }
        });

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        cbx_bus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RUC", "Razon Social", "Nro Doc." }));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_compras.setModel(new javax.swing.table.DefaultTableModel(
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
        t_compras.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        t_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_comprasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_compras);

        btn_pagar.setText("Pagar");
        btn_pagar.setEnabled(false);
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_anu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cer)
                        .addGap(9, 9, 9))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_anu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        frm_reg_compra_serv compra = new frm_reg_compra_serv();
        ven.open(compra);
        this.close();
    }//GEN-LAST:event_btn_regActionPerformed

    private void t_comprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_comprasMousePressed
        i = t_compras.getSelectedRow();
        btn_anu.setEnabled(true);
        btn_pagar.setEnabled(true);
    }//GEN-LAST:event_t_comprasMousePressed

    private void btn_anuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anuActionPerformed
//    int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar la compra?");
//    if (JOptionPane.OK_OPTION == confirmado) {
//        String lote = "-";
//        com.setIdAlmacen(Integer.parseInt(t_compras.getValueAt(i, 0).toString()));
//        Double suma_pro = 0.00;
//        //seleccionar almacen
//        try {
//            Statement st = con.conexion();
//            String ver_alm = "select c.idTipo_Documento, c.serie_doc, c.ruc_pro, p.raz_soc_pro, c.nro_doc, c.fec_com, "
//                    + "c.idAlmacen from Compra as c inner join proveedor as p on c.ruc_pro=p.ruc_pro where c.idCompra = '"+com.getIdAlmacen()+"'";
//            ResultSet rs = con.consulta(st, ver_alm);
//            if (rs.next()) {
//                com.setFechaDoc(rs.getString("fec_com"));
//                pro.setRuc(rs.getString("ruc_pro"));
//                pro.setRaz_soc(rs.getString("raz_soc_pro"));
//                alm.setIdAlmacen(rs.getInt("idAlmacen"));
//                tido.setIdAlmacen(rs.getInt("idTipo_Documento"));
//                tido.setSerie(rs.getInt("serie_doc"));
//                tido.setNroDoc(rs.getInt("nro_doc"));
//            }
//            con.cerrar(rs);
//            con.cerrar(st);
//        } catch (SQLException ex) {
//            System.out.print(ex);
//        }
//        
//        //seleccionar detalle de compra, cantidad de productos;
//        try {
//            Statement st = con.conexion();
//            String ver_ped = "select idMaterial, precio_com, cant_mat, lote from Detalle_Compra where idCompra = '"+com.getIdAlmacen()+"'";
//            ResultSet rs = con.consulta(st, ver_ped);
//            int nro = 0;
//            while (rs.next()) {
//                nro++;
//                System.out.print(nro + "\n");
//                mat.setIdAlmacen(rs.getInt("idMaterial"));
//                mat.setCantActual(rs.getDouble("cant_mat"));
//                mat.setPre(rs.getDouble("precio_com"));
//                lote = rs.getString("lote");
//                suma_pro = suma_pro + (mat.getCantActual() * mat.getPre());
//                Double pro_can = 0.00;
//                Double new_can = 0.00;
//                Double pro_can_alm = 0.00;
//                Double new_can_alm = 0.00;
//                try {
//                    Statement st1 = con.conexion();
//                    String ver_pro = "select cant_actual from Material where idMaterial = '"+mat.getIdAlmacen()+"'";
//                    ResultSet rs1 = con.consulta(st1, ver_pro);
//                    if (rs1.next()) {
//                        pro_can = rs1.getDouble("cant_actual");
//                    }
//                    con.cerrar(rs1);
//                    con.cerrar(st1);
//                    new_can = pro_can - mat.getCantActual();
//                 } catch (SQLException ex1) {
//                     System.out.print(ex1);
//                 }
//                System.out.print("Cantidad actual: " + pro_can + " Producto: " + mat.getIdAlmacen() + "\n");
//                
//                try {
//                    Statement st1 = con.conexion();
//                    String ver_pro = "select cant_mat from Material_Almacen where idMaterial = '"+mat.getIdAlmacen()+"' and idAlmacen = '"+alm.getIdAlmacen()+"'";
//                    ResultSet rs1 = con.consulta(st1, ver_pro);
//                    if (rs1.next()) {
//                        pro_can_alm = rs1.getDouble("cant_mat");
//                    }
//                    con.cerrar(rs1);
//                    con.cerrar(st1);
//                    new_can_alm = pro_can_alm - mat.getCantActual();
//                 } catch (SQLException ex1) {
//                     System.out.print(ex1);
//                 }
//                System.out.print("Cantidad actual: " + pro_can_alm + " Producto: " + mat.getIdAlmacen() + " en Almacen: " + alm.getIdAlmacen() + "\n");
//                
//                try {
//                    Statement st1 = con.conexion();
//                    String upt_pro_alm = "update Material_Almacen set cant_mat = '"+new_can_alm+"' where idMaterial = '"+mat.getIdAlmacen()+"' and idAlmacen = '"+alm.getIdAlmacen()+"'";
//                    con.actualiza(st1, upt_pro_alm);
//                    con.cerrar(st1);
//                 } catch (Exception ex1) {
//                     System.out.print(ex1);
//                 }
//                System.out.print("Cantidad nueva: " + new_can_alm  + " Producto: " + mat.getIdAlmacen() + " en Almacen: " + alm.getIdAlmacen() + "\n");
//                
//                try {
//                    Statement st1 = con.conexion();
//                    String upt_pro = "update Material set cant_actual = '"+new_can+"' where idMaterial = '"+mat.getIdAlmacen()+"'";
//                    con.actualiza(st1, upt_pro);
//                    con.cerrar(st1);
//                 } catch (Exception ex1) {
//                     System.out.print(ex1);
//                 }
//                System.out.print("Cantidad nueva: " + new_can  + " Producto: " + mat.getIdAlmacen() + "\n");
//
//                try {
//                    Statement st1 = con.conexion();
//                    String ins_kardex = "insert into Kardex Values (null, '"+mat.getIdAlmacen()+"', '"+alm.getIdAlmacen()+"', '"+pro.getRuc()+"', '"+pro.getRaz_soc()+"', '"+com.getFechaDoc()+"', "
//                            + "'"+tido.getIdAlmacen()+"', '"+tido.getSerie()+"', '"+tido.getNumero()+"', '6',  '0.00', '0.00', '"+mat.getCantActual()+"', '"+mat.getPre()+"', '-', '"+lote+"')";
//                    con.actualiza(st1, ins_kardex);
//                    con.cerrar(st1);          
//                } catch (Exception ex) {
//                    System.out.print(ex);
//                }
//                System.out.print("Agregando al Kardex: Producto: " + mat.getIdAlmacen() + " - " + com.getFechaDoc()+ " - " + mat.getCantActual()+ "\n");
//                
//            }
//            
//        } catch (SQLException ex) {
//            System.out.print(ex);
//        }
//        
//        //calcular monto 
//        Double monto = 0.00;
//            monto = suma_pro; 
//
//        
//        try {
//            Statement st1 = con.conexion();
//            String del_ped = "delete from Detalle_Compra where idCompra = '"+com.getIdAlmacen()+"'";
//            con.actualiza(st1, del_ped);
//            con.cerrar(st1);
//         } catch (Exception ex1) {
//             System.out.print(ex1);
//         }
//        System.out.print("Eliminando compra" + "\n");
//        
//        try {
//            Statement st1 = con.conexion();
//            String del_ped = "delete from Compra where idCompra = '"+com.getIdAlmacen()+"'";
//            con.actualiza(st1, del_ped);
//            con.cerrar(st1);
//         } catch (Exception ex1) {
//             System.out.print(ex1);
//         }
//        System.out.print("Eliminando detalle de compra \n");
//        
//        String query = "select c.idCompra, c.fec_com, c.fec_pago, t.nom_doc, c.serie_doc, c.nro_doc, c.ruc_pro, p.raz_soc_pro, a.nom_alm from Compra as c "
//                + "inner join Tipo_Documento as t on c.idTipo_Documento=t.idTipo_Documento inner join Proveedor as p on c.ruc_pro=p.ruc_pro "
//                + "inner join Almacen as a on c.idAlmacen=a.idAlmacen order by c.fec_com desc, c.idCompra desc";
//        ver_compras(query);
//        
//        System.out.print("Mostrando lista \n");
//        txt_bus.requestFocus();
//        
//    }
    }//GEN-LAST:event_btn_anuActionPerformed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
//  VER CUOTAS
        frm_ver_cuota_compra cuota = new frm_ver_cuota_compra();
        cuota.setCompra(t_compras.getValueAt(i,0));
        //ven.open(cuota);
        this.close();
    }//GEN-LAST:event_btn_pagarActionPerformed

    public class table_render extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_tabla = null;
            Date fecha_actual = null;
            try {
                fecha_tabla = formateador.parse((String) table.getValueAt(row, 3));
               // fecha_actual=ven.getFechaActual();
            } catch (ParseException ex) {
                Logger.getLogger(frm_ver_compras_articulo.class.getName()).log(Level.SEVERE, null, ex);
            }
            if ((fecha_tabla.before(fecha_actual) || fecha_tabla.equals(fecha_actual)) && String.valueOf(table.getValueAt(row, 11)).equals("PENDIENTE")) {
                setBackground(Color.YELLOW);
                setForeground(Color.black);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
            
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            return this;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anu;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_pagar;
    private javax.swing.JButton btn_reg;
    private javax.swing.JComboBox cbx_bus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_compras;
    private javax.swing.JTextField txt_bus;
    // End of variables declaration//GEN-END:variables
*/
}
