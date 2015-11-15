package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.app.User;
import org.jsuns.app.action.ActionTool;
import org.jsuns.app.action.CreateAction;
import org.jsuns.app.action.RefreshAction;
import org.jsuns.commerce.TipoDocumentoService;
import org.jsuns.data.JPA;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.Cliente;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.commerce.jpa.Pedido;
import org.jsuns.commerce.jpa.TipoDocumento;
import org.jsuns.commerce.jpa.TipoPago;
import org.jsuns.swing.XPanel;
import org.pegasus.patrimonio.jpa.Almacen;

public class frm_ver_venta extends XPanel {

//    Cl_Varios ven = new Cl_Varios();
    Pedido ped = new Pedido();
    TipoPago tipa = new TipoPago();
    TipoDocumento tido = new TipoDocumento();
    private TipoDocumentoService tds = new TipoDocumentoService();
    Almacen alm = new Almacen();
//    Articulo pro = new Articulo();
    Movimiento mov = new Movimiento();
    Cliente cli = new Cliente();
    User usu = new User();
    public static String id;

    DefaultTableModel mostrar;
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols(Locale.US);
    DecimalFormat formato = new DecimalFormat("####0.00", simbolo);
    Integer i;
    Date fecha_hoy;

    public frm_ver_venta() {
//        initComponents();
        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        /*mostrar.addColumn("Id");
        mostrar.addColumn("Fecha Venta");
        mostrar.addColumn("Fecha Pago");
        mostrar.addColumn("Tipo Doc.");
        mostrar.addColumn("D.N.I / R.U.C");
        mostrar.addColumn("Cliente");
        mostrar.addColumn("Total");
        mostrar.addColumn("Tipo Pago");
        mostrar.addColumn("Vendedor");
        mostrar.addColumn("Almacen");
        mostrar.addColumn("Estado");
        t_facturas.setModel(mostrar);
        t_facturas.getColumnModel().getColumn(0).setPreferredWidth(30);
        t_facturas.getColumnModel().getColumn(1).setPreferredWidth(80);
        t_facturas.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_facturas.getColumnModel().getColumn(3).setPreferredWidth(170);
        t_facturas.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_facturas.getColumnModel().getColumn(5).setPreferredWidth(170);
        t_facturas.getColumnModel().getColumn(7).setPreferredWidth(80);
        t_facturas.getColumnModel().getColumn(8).setPreferredWidth(80);
        t_facturas.getColumnModel().getColumn(9).setPreferredWidth(80);
        t_facturas.getColumnModel().getColumn(10).setPreferredWidth(80);
        retrieve();
        txt_bus.requestFocus();*/
    }

    @ActionTool(target = RefreshAction.class)
    private void retrieve() {
        /*fecha_hoy = ven.getFechaActual();
        String ver_ped = "select p.idPedido, p.fec_ped , p.fec_pago,p.idAlmacen,t.desc,p.idTipo_pago,p.total,p.est_ped,td.idtipo_doc,td.desc_tipd , "
                + "p.serie_doc, p.nro_doc, u.nick, a.nom_alm , t.desc , p.est_ped,c.nom_per,p.cli_doc from pedido as p inner join tipo_pago as t "
                + "on p.idTipo_pago=t.idTipo_pago inner join tipo_doc as td on p.idtipo_doc=td.idtipo_doc inner join usuario as u "
                + "on p.nick = u.nick inner join  almacen as a on p.idAlmacen=a.idAlmacen inner join cliente as c on p.cli_doc=c.nro_doc  "
                + "where p.idAlmacen='" + org.jsuns.commerce.frm_menu.almacen.getIdAlmacen() + "' and p.fec_ped='" + fecha_hoy + "' order by p.idPedido asc";
        fecha_hoy = ven.getFechaActual();
        int estado=0;
        switch(jComboBox1.getSelectedIndex()){
            case 0:
                estado=2;break;
            case 1:
                estado=6;break;
            case 2:
                estado=4;break;
            case 3:
                estado=5;break;
            case 4:
                estado=3;break;
        }
        ver_ped = "select p.idPedido, p.fec_ped , p.fec_pago,p.idAlmacen,t.desc,p.idTipo_pago,p.total,p.est_ped,td.idtipo_doc,td.desc_tipd , "
                + "p.serie_doc, p.nro_doc, u.nick, a.nom_alm , t.desc , p.est_ped,c.nom_per,p.cli_doc "
                + "from pedido as p "
                + "inner join tipo_pago as t on p.idTipo_pago=t.idTipo_pago "
                + "inner join tipo_doc as td on p.idtipo_doc=td.idtipo_doc "
                + "inner join usuario as u "
                + "on p.nick = u.nick inner join  almacen as a on p.idAlmacen=a.idAlmacen inner join cliente as c on p.cli_doc=c.nro_doc  "
                + "where p.idAlmacen='" + org.jsuns.commerce.frm_menu.almacen.getIdAlmacen() 
                + "' and p.fec_ped='" + fecha_hoy 
                + (estado>0?"p.est_ped="+estado:"")
                + "' order by p.idPedido asc";

//     if (f_fecha.getDate()!=null){
//where "
//                            + "p.idAlmacen='" + org.jsuns.commerce.frm_menu.almacen.getIdAlmacen() 
//                            + "' and p.fec_ped = '" + XDate.getSQLDate(f_fecha.getDate())+ "'";
//                }else{
        //where p.idAlmacen='" + org.jsuns.commerce.frm_menu.almacen.getIdAlmacen() + "' "
//                            + "and (p.cli_doc like '%" + buscar + "%' or c.nom_per like '%" + buscar + "%') order by p.fec_ped desc, p.idPedido desc";
//                }
        double sum = 0.0;
        //Creando las filas para el JTable
//            while (rs.next()) {
//                Object[] fila = new Object[11];
//                fila[0] = rs.getObject("idPedido");
//                String tido = rs.getString("idtipo_doc");
//                String dtido = rs.getString("desc_tipd");
//                String serie = rs.getString("serie_doc");
//                String nro = rs.getString("nro_doc");
//
//                fila[1] =rs.getDate("fec_ped");
//                fila[2] =rs.getDate("fec_pago");
//                if (tido.equals("1") & serie.equals("000") & nro.equals("0000000")) {
//                    fila[3] = "VENTA SIN DOCUMENTO";
//                } else {
//                    fila[3] = dtido + " / " + serie + " - " + nro;
//                }
//                fila[4]=rs.getObject("cli_doc");
//                fila[5]=rs.getString("nom_per");
//                fila[6]=rs.getDouble("total");
//                fila[7]=rs.getString("desc");
//                fila[8]=rs.getString("nick");
//                fila[9]=rs.getString("nom_alm");
//
//                if (rs.getString("est_ped").equals("1")) {
//                    fila[10]=rs.getString("est_ped").equals("1")?
//                            "PAGADO":(
//                            rs.getString("est_ped").equals("2")?
//                            "SEPARADO":(
//                            rs.getString("est_ped").equals("3")?
//                            "ANULADO":(
//                            rs.getString("est_ped").equals("4")?
//                            "POR RECOGER":(
//                            rs.getString("est_ped").equals("5")?
//                            "ENTREGADO":(
//                            rs.getString("est_ped").equals("6")?
//                            "POR COBRAR":null
//                            )
//                            )
//                            )
//                            )
//                            );
//                }
//                mostrar.addRow(fila);
//            }
        txt_tot.setText(formato.format(sum));
        mostrar.fireTableDataChanged();*/
    }

    void calcula_total() {
        /*double total = 0.0;
        for (int j = 0; j < t_facturas.getRowCount(); j++) {
            if (t_facturas.getValueAt(j, 10).toString().equals("PAGADO")) {
                double subtot = (double) t_facturas.getValueAt(j, 5);
                total += subtot;
            }
        }
        txt_tot.setText(total + "");*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *//*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_bus = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_facturas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JTextField();
        btn_anu = new javax.swing.JButton();
        btn_pagar = new javax.swing.JButton();
        btn_det = new javax.swing.JButton();
        btn_ent = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setTitle("Registro de Ventas");

        jLabel1.setText("Cliente:");

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

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_facturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", "B/001-00025", "C0U944", "LUIS ENRIQUE OYANGUREN GIRON", "S/. 59.00", "Pendiente de Pago", null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Ped.", "Glosa", "Nro Placa.", "Cliente", "Monto", "Estado", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        t_facturas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_facturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_facturasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_facturas);
        if (t_facturas.getColumnModel().getColumnCount() > 0) {
            t_facturas.getColumnModel().getColumn(0).setPreferredWidth(10);
            t_facturas.getColumnModel().getColumn(1).setPreferredWidth(50);
            t_facturas.getColumnModel().getColumn(2).setPreferredWidth(30);
            t_facturas.getColumnModel().getColumn(3).setPreferredWidth(250);
            t_facturas.getColumnModel().getColumn(4).setPreferredWidth(30);
            t_facturas.getColumnModel().getColumn(5).setPreferredWidth(60);
        }

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Total:");

        txt_tot.setEditable(false);
        txt_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totActionPerformed(evt);
            }
        });

        btn_anu.setText("Anular");
        btn_anu.setEnabled(false);
        btn_anu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anuActionPerformed(evt);
            }
        });

        btn_pagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pagar.png"))); // NOI18N
        btn_pagar.setText("Pagar");
        btn_pagar.setEnabled(false);
        btn_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pagarActionPerformed(evt);
            }
        });

        btn_det.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blog.png"))); // NOI18N
        btn_det.setText("Ver Detalle");
        btn_det.setEnabled(false);
        btn_det.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_detActionPerformed(evt);
            }
        });

        btn_ent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deposito.png"))); // NOI18N
        btn_ent.setText("Entregar Producto");
        btn_ent.setEnabled(false);
        btn_ent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Separaciones", "Creditos", "Por Entregar", "Entregados", "Anulados" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha:");

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
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_anu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_det))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_ent)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_bus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_anu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_det, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ent, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
*/
    private void txt_busKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busKeyPressed
       /* String buscar = txt_bus.getText();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_bus.getText().length() > 1) {
                retrieve();

            }
        }*/
    }//GEN-LAST:event_txt_busKeyPressed

    private void btn_anuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anuActionPerformed
        //if (frm_menu.usu.getPve_eli().equals("1")) {
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma anular la venta?");

        if (JOptionPane.OK_OPTION == confirmado) {
            //ped.setIdPedido((int) t_facturas.getValueAt(i, 0));
            //cli.setNombreCompleto(t_facturas.getValueAt(i, 5).toString());
            Double suma_pro = 0.00;
            //ver datos de pedido 
            ped = JPA.getInstance().get(Pedido.class, ped.getIdPedido());
            JPA.getInstance().close();
            //actualizar pedido a anulado
            try {

                String act_ped = "update pedido set est_ped = '3', descuento = '0.00', idTipo_pago='1' where idPedido = '" + ped.getIdPedido() + "'";

            } catch (Exception ex) {
                System.out.print(ex);
            }

            //seleccionar detalle de pedido, cantidad de productos;
            /*for (PedidoDetalle pd : ped.getPedidoDetalleCollection()) {
                pro = pd.getArticulo();
                suma_pro = pro.getCantActual().doubleValue()
                        * pro.getPrecioVenta().doubleValue();
                Double pro_can = 0.00;
                Double new_can = 0.00;
                Double pro_can_alm = 0.00;
                Double new_can_alm = 0.00;
                try {

                    String ver_pro = "select cant_actual from productos where idProductos = '" + pro.getIdArticulo() + "'";

//                    if (rs1.next()) {
//                        pro_can = rs1.getDouble("cant_actual");
//                    }
                    new_can = pro.getCantActual().doubleValue() + pro_can;
                    System.out.println("Cantidad actual" + new_can + " del producto " + pro.getIdArticulo() + "\n");

                    ver_pro = "select cant from producto_almacen where idProductos = '" + pro.getIdArticulo() + "' and idAlmacen = '" + alm.getIdAlmacen() + "'";

//                    if (rs1.next()) {
//                        pro_can_alm = rs1.getDouble("cant");
//                    }
                    new_can_alm = pro.getCantActual().doubleValue() + pro_can_alm;
                    System.out.println("Cantidad Nueva" + new_can_alm + " del producto " + pro.getIdArticulo() + "en el almacen " + alm.getIdAlmacen() + "\n");

                    String upt_pro_alm = "update producto_almacen set cant = '" + new_can_alm + "' where idProductos = '" + pro.getIdArticulo() + "' and idAlmacen = '" + alm.getIdAlmacen() + "'";

                    System.out.println("actualizando cantidad del producto " + pro.getIdArticulo() + " en el almacen " + alm.getIdAlmacen() + "\n");

                    String upt_pro = "update productos set cant_actual = '" + new_can + "' where idProductos = '" + pro.getIdArticulo() + "'";

                    System.out.println("atualizando cantidad total del producto " + pro.getIdArticulo() + "\n");

                    String ins_kardex = "insert into kardex Values (null, '" + ped.getFecha() + "', '" + pro.getIdArticulo() + "', '" + pro.getCantActual() + "', '" + pro.getPrecioVenta() + "', '0.00', '0.00',"
                            + "'" + ped.getSerie() + "', '" + ped.getNumero() + "', '" + tido.getIdTipoDoc() + "', '" + alm.getIdAlmacen() + "', '" + cli.getNroDoc() + "', '" + cli.getNombreCompleto() + "', '5')";

                    System.out.println("insertando producto en el kardex \n");
                } catch (Exception ex) {
                    System.out.print(ex);
                }
            }
*/
            //calcular monto 
            //devolver dinero pagado 
            String ver_let_ped = "select monto, tipo_pago, fecha from letras_pedido where idPedido = '" + ped.getIdPedido() + "'";

//                while (rs.next()) {
//                    if (rs.getString("tipo_pago").equals("EFECTIVO")) {
//                        try {
//                            mov.setGlosa("DEVOLUCION POR VENTA ANULADA - " +ped.getSerie() + " - " +ped.getNumero() + " / " + cli.getNroDoc());
//                            mov.setFecMov(rs.getDate("fecha"));
//                            mov.setEgreso(rs.getBigDecimal("monto"));
//                            Statement st1 = con.conexion();
//                            String ins_mov = "insert into movimiento Values (null, '" + mov.getGlosa() + "', '" + mov.getFecMov() + "' , "
//                                    + "'0.00', '" + mov.getEgreso() + "' , '" + org.jsuns.commerce.frm_menu.lbl_user.getText() + "', "
//                                    + "'" + alm.getIdAlmacen() + "', 'C', '" + frm_menu.caja.getIdCaja() + "')";
//                            con.actualiza(st1, ins_mov);
//                            con.cerrar(st1);
//                        } catch (Exception ex) {
//                            System.out.print(ex);
//                        }
//                    } else {
//                        try {
//                            mov.setGlosa("DEVOLUCION POR VENTA ANULADA - " +ped.getSerie() + " - " +ped.getNumero() + " / " + cli.getNroDoc());
//                            mov.setFecMov(rs.getDate("fecha"));
//                            mov.setEgreso(rs.getBigDecimal("monto"));
//                            Statement st1 = con.conexion();
//                            String ins_mov = "insert into movimiento Values (null, '" + mov.getGlosa() + "', '" + mov.getFecMov() + "' , "
//                                    + "'0.00', '" + mov.getEgreso() + "' , '" + org.jsuns.commerce.frm_menu.lbl_user.getText() + "', "
//                                    + "'" + alm.getIdAlmacen() + "', 'B', '" + frm_menu.caja.getIdCaja() + "')";
//                            con.actualiza(st1, ins_mov);
//                            con.cerrar(st1);
//                        } catch (Exception ex) {
//                            System.out.print(ex);
//                        }
//                    }
//                }
            retrieve();
            //txt_bus.requestFocus();

        }
//        } else {
//            JOptionPane.showMessageDialog(null, "Ud. No tiene permisos");
//        }
    }//GEN-LAST:event_btn_anuActionPerformed

    private void t_facturasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_facturasMousePressed
       /*i = t_facturas.getSelectedRow();
        String est = t_facturas.getValueAt(i, 10).toString();
        switch (est) {
            case "PAGADO":
                btn_anu.setEnabled(true);
                btn_det.setEnabled(true);
                btn_ent.setEnabled(false);
                btn_pagar.setEnabled(false);
                break;
            case "ANULADO":
                btn_anu.setEnabled(false);
                btn_det.setEnabled(false);
                btn_ent.setEnabled(false);
                btn_pagar.setEnabled(false);
                break;
            case "SEPARADO":
                btn_anu.setEnabled(true);
                btn_det.setEnabled(true);
                btn_ent.setEnabled(false);
                btn_pagar.setEnabled(true);
                break;
            case "POR RECOGER":
                btn_anu.setEnabled(false);
                btn_det.setEnabled(true);
                btn_ent.setEnabled(true);
                btn_pagar.setEnabled(false);
                break;
            case "ENTREGADO":
                btn_anu.setEnabled(false);
                btn_det.setEnabled(true);
                btn_ent.setEnabled(false);
                btn_pagar.setEnabled(false);
                break;
            case "POR COBRAR":
                btn_anu.setEnabled(true);
                btn_det.setEnabled(true);
                btn_ent.setEnabled(false);
                btn_pagar.setEnabled(true);
                break;
        }*/
    }//GEN-LAST:event_t_facturasMousePressed

    private void btn_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pagarActionPerformed
        /*frm_ver_letras_pedido letras = new frm_ver_letras_pedido();
        letras.setPedido(t_facturas.getValueAt(i, 0));
        ven.open(letras);*/
    }//GEN-LAST:event_btn_pagarActionPerformed

    private void btn_detActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detActionPerformed
      /*  frm_ver_det_venta detalle = new frm_ver_det_venta();
        detalle.setPedido(t_facturas.getValueAt(i,0));
        ven.open(detalle);*/
    }//GEN-LAST:event_btn_detActionPerformed


    private void btn_entActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entActionPerformed
        //seleccionar datos de la separacion
       // String separacion = t_facturas.getValueAt(i, 0).toString();

        //String ver_ped = "select cli_doc, cli_nom, nick, total from pedido where idPedido = '" + separacion + "'";

//            if (rs.next()) {
//                cli.setNroDoc(rs.getString("cli_doc"));
//                cli.setNombreCompleto(rs.getString("cli_nom"));
//                usu.setNick(rs.getString("nick"));
//                ped.setTotal(rs.getDouble("total"));
//            }
        //Variables para registrar
       /* ped.setFechaPago(ven.getFechaActual());
        ped.setFecha(ven.getFechaActual());
        tipa.setIdTipoPago(1);
        tipa.setDesc("EFECTIVO");
        tido.setIdTipoDoc(2);
        tido.setDescripcion("BOLETA");
        ped.setSerie(tds.ver_ser(2, frm_menu.almacen.getIdAlmacen()));
        ped.setNumero(tds.ver_num(2, frm_menu.almacen.getIdAlmacen()));
        ped.setDescuento(new BigDecimal(0));
        ped.setEstado('1');

        String upd_com = "update pedido set est_ped = '5' where idPedido = '" + separacion + "'";

        EntityManager em = JPA.getInstance().getEntityManager(true);
        //registrar venta en tabla pedido
        ped.setTipoDoc(tido);
        ped.setTipoPago(tipa);
        ped.setAlmacen(alm);
        ped.setCliente(cli);
        em.persist(ped);

        tds.act_doc(ped.getSerie(), ped.getNumero() + 1, frm_menu.almacen.getIdAlmacen(), tido.getIdTipoDoc());
        //registrar detalle de venta

        String det_ped = "select idProductos, cantidad, precio "
                + "from detalle_pedido "
                + "where idPedido = '" + separacion + "'";

//            while (rs.next()) {
//                //copiar datos de separacion a pedido entregado
////                pro.setCantidad(rs.getBigDecimal("cantidad"));
////                pro.setIdArticulo(rs.getInt("idProductos"));
////                pro.setPrecio(rs.getDouble("precio"));
//                try {
//               
//                    String ins_det_ped = "insert into detalle_pedido Values ('" + pro.getIdArticulo() + "', '" + ped.getIdPedido() + "', '" + pro.getPrecioVenta() + "', '" + pro.getCantActual() + "')";
//                
//            
//           
//                    String ins_kardex = "insert into kardex Values (null, '" + XDate.getSQLDate(ped.getFecha()) + "', '" + pro.getIdArticulo() + "', '0.00', '0.00', '"
//                            + pro.getCantActual() + "', '" + pro.getPrecioVenta() + "','" +ped.getSerie() + "', '" +ped.getNumero() + "', '" + tido.getTipoDoc() + "',"
//                            + " '" + frm_menu.almacen.getIdAlmacen() + "','" + cli.getNroDoc() + "', '" + cli.getNombreCompleto() + "','1')";
//                
//                } catch (Exception ex) {
//                    System.err.print("Error en: " + ex.getLocalizedMessage());
//                }
//                Double cant_actual = 0.00;
//                Double cant_nueva = 0.00;
//                try {
//                    Statement st1 = con.conexion();
//                    String bus_pro = "select cant_actual from productos where idProductos = '" + pro.getIdArticulo() + "'";
//                    ResultSet rs1 = con.consulta(st1, bus_pro);
//                    if (rs1.next()) {
//                        cant_actual = rs.getDouble("cant_actual");
//                    }
//                    System.out.print("Seleccionando cantidad actual del producto: " + pro.getIdArticulo() + " cantidad: " + cant_actual + "\n");
//                 
//                    cant_nueva = cant_actual - pro.getCantActual().doubleValue();
//           
//                
//                    String act_pro = "update productos set cant_actual = '" + cant_nueva + "' where idProductos = '" + pro.getIdArticulo() + "' ";
//                
//                    System.out.print("actualizando cantidad actual Prod:" + pro.getIdArticulo() + " cantidad: " + cant_nueva + "\n");
//          
//                
//                    String ver_prod_alm = "select idProductos, cant from producto_almacen where idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "' and idProductos = '" + pro.getIdArticulo() + "'";
//             
//                    if (rs1.next()) {
//                        //si producto existe actualizar cantidad
//                        Double cant = rs1.getDouble("cant");
//                        Double cant_act = cant - pro.getCantActual().doubleValue();
//                 
//                        String act_pro_alm = "update producto_almacen set cant = '" + cant_act + "' where idProductos = '" + pro.getIdArticulo() + "' and idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "'";
//            
//                    } else {
//                        //si producto no existe agregar
//                     
//                        String add_pro_alm = "insert into producto_almacen Values ('" + pro.getIdArticulo() + "', '" + frm_menu.almacen.getIdAlmacen() + "', '" + pro.getCantActual() + "','" + pro.getPrecioVenta() + "')";
//                 
//                    }
//                } catch (SQLException e) {
//                    System.out.println(e.getLocalizedMessage());
//                }
//            }
        new Cl_Hilo_Imprime().print("rpt_ticket_boleta", ped.getIdPedido());

        retrieve();*/

    }//GEN-LAST:event_btn_entActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //seleccionar ventas
        retrieve();

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txt_totActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totActionPerformed

    private void txt_busActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_busActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_busActionPerformed
/*

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anu;
    private javax.swing.JButton btn_det;
    private javax.swing.JButton btn_ent;
    private javax.swing.JButton btn_pagar;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_facturas;
    private javax.swing.JTextField txt_bus;
    private javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables
*/}
