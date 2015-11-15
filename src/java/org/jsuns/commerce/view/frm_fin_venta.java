package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Cliente;
import org.jsuns.commerce.jpa.Pedido;
import org.jsuns.commerce.jpa.TipoDocumento;
import org.jsuns.commerce.jpa.TipoPago;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.TipoDocumentoService;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.commerce.jpa.AlmacenArticuloPK;
import org.jsuns.commerce.jpa.LetraPedido;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.commerce.jpa.PedidoDetalle;
import org.jsuns.swing.XPanel;

public class frm_fin_venta extends XPanel {

    //Cl_Varios ven = new Cl_Varios();
    Cliente cli = new Cliente();
    public static Pedido pedido = new Pedido();
    TipoDocumento tido = new TipoDocumento();
    TipoPago tipa = new TipoPago();
  
   // Proveedor prov = new Proveedor();
    public static String accion = "venta";
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    DecimalFormat formato = null;
    double comision;
    double m_efect;
    double m_tarj;
    double m_tarj_com;

    public frm_fin_venta() {
        initComponents();
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        lbl_tot = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_add_nota = new javax.swing.JButton();
        lbl_doc = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_subt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chk_incluir = new javax.swing.JCheckBox();
        txt_efec = new javax.swing.JTextField();
        txt_tarj = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbx_plazo = new javax.swing.JComboBox();
        btn_cerrar = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        txt_com = new javax.swing.JTextField();
        btn_cont = new javax.swing.JRadioButton();
        btn_cred = new javax.swing.JRadioButton();

        setTitle("Finalizar Venta");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Total");

        lbl_tot.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_tot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tot.setText("S/. 1,888.00");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Documento:");

        btn_add_nota.setText("+Nota");
        btn_add_nota.setFocusable(false);
        btn_add_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_notaActionPerformed(evt);
            }
        });

        lbl_doc.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_doc.setText("Boleta / 0001 - 0000354");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txt_subt.setEditable(false);
        txt_subt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("Entregado:");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Tarjeta:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Efectivo:");

        chk_incluir.setBackground(new java.awt.Color(255, 255, 255));
        chk_incluir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        chk_incluir.setText("Incluir 5%");
        chk_incluir.setEnabled(false);
        chk_incluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_incluirActionPerformed(evt);
            }
        });

        txt_efec.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_efec.setEnabled(false);
        txt_efec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_efecKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efecKeyTyped(evt);
            }
        });

        txt_tarj.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_tarj.setEnabled(false);
        txt_tarj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tarjKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tarjKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_subt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tarj, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_efec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_incluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_efec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tarj, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_incluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_subt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Plazo (dias)");

        cbx_plazo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "a 15 dias", "a 30 dias", "a 45 dias" }));
        cbx_plazo.setEnabled(false);
        cbx_plazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_plazoKeyPressed(evt);
            }
        });

        btn_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cerrar.setText("Cerrar");
        btn_cerrar.setFocusable(false);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });
        btn_reg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_regKeyPressed(evt);
            }
        });

        txt_com.setEditable(false);
        txt_com.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_com.setText("Comision 5%");
        txt_com.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_plazo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_com, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cerrar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_plazo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_com, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btn_cont.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_cont);
        btn_cont.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_cont.setForeground(new java.awt.Color(204, 0, 0));
        btn_cont.setText("Contado");
        btn_cont.setFocusable(false);
        btn_cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_contActionPerformed(evt);
            }
        });

        btn_cred.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(btn_cred);
        btn_cred.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btn_cred.setForeground(new java.awt.Color(204, 0, 0));
        btn_cred.setText("Credito");
        btn_cred.setFocusable(false);
        btn_cred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_credActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_doc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_add_nota))
                    .addComponent(lbl_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cont))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cred)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_add_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cred, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cont, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        this.close();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private TipoDocumentoService tds = new TipoDocumentoService();

    private void llenar() {
//        tido.setIdTipoDoc(frm_reg_venta.cbx_tipd.getSelectedIndex() + 1);
//        tido.setDescripcion(frm_reg_venta.cbx_tipd.getSelectedItem().toString());
//        ped.setSerie(tds.ver_ser(tido.getTipoDoc(), frm_menu.almacen.getAlmacen()));
//        ped.setNumero(tds.ver_num(tido.getTipoDoc(), frm_menu.almacen.getAlmacen()));
//        ped.setFecha(frm_reg_venta.txt_fec.getDate());
//        ped.setFechaPago(ped.getFecha());
//        tipa.setIdTipoPago(btn_cont.isSelected()?1:2);
//        ped.setDescuento(new BigDecimal(0));
//        if (frm_reg_venta.cbx_tip_venta.getSelectedItem().equals("VENTA") && btn_cont.isSelected()) {
//            ped.setEstado('1');
//        }else if (frm_reg_venta.cbx_tip_venta.getSelectedItem().equals("SEPARACION")) {
//            ped.setEstado('2');
//        }else if (frm_reg_venta.cbx_tip_venta.getSelectedItem().equals("VENTA") && btn_cred.isSelected()) {
//            ped.setEstado('6');
//        }
//        usu.setNick(frm_reg_venta.cbx_vendedor.getSelectedItem().toString());
//        cli.setNroDoc(frm_reg_venta.txt_nro_doc.getText());
//        cli.setNombreCompleto(frm_reg_venta.txt_nom.getText());
//        ped.setTotal(ped.getTotal() + comision);
    }


    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        /*Cl_Hilo_Imprime imprime = new Cl_Hilo_Imprime();
        EntityManager em = JPA.getInstance().getEntityManager(true);
        if (accion.equals("venta")) {
            //crear pedido
            pedido.setAlmacen(frm_menu.almacen);
            pedido.setTipoPago(tipa);
            pedido.setTipoDoc(tido);
            pedido.setNick(X.getUser());
            pedido.setCliente(cli);
            tds.act_doc(pedido.getSerie(), pedido.getNumero() + 1, frm_menu.almacen.getIdAlmacen(), tido.getIdTipoDoc());

            em.persist(pedido);
            //registrar detalle de venta
            int filas = frm_reg_venta.t_detalle.getRowCount();
            System.out.println(filas + "\n");
            for (int j = 0; j < filas; j++) {

//                pro = em.find(Articulo.class, Integer.parseInt(frm_reg_venta.t_detalle.getValueAt(j, 0).toString()));
//                PedidoDetalle pedidoDetalle = new PedidoDetalle(pedido.getIdPedido(), pro.getIdArticulo());
//                pedidoDetalle.setCantidad(new BigDecimal(frm_reg_venta.t_detalle.getValueAt(j, 3).toString()));
//                pedidoDetalle.setPrecio(new BigDecimal(frm_reg_venta.t_detalle.getValueAt(j, 5).toString()));
//                em.persist(pedidoDetalle);
//                //insertar datos en kardex
//                try {
//
//                    String ins_kardex = "insert into kardex Values (null, '" + pedido.getFecha() + "', '" + pro.getIdArticulo() + "', '0.00', '0.00', '"
//                            + pro.getCantActual() + "', '" + pro.getPrecioVenta() + "','" + pedido.getSerie() + "', '" + pedido.getNumero() + "', '" + tido.getIdTipoDoc() + "',"
//                            + " '" + frm_menu.almacen.getIdAlmacen() + "','" + cli.getNroDoc() + "', '" + cli.getNombreCompleto() + "','1')";
//                    System.out.println(ins_kardex);
//                    ;
//                } catch (Exception ex) {
//                    System.err.print("Error en: " + ex.getLocalizedMessage());
//                }
//                //seleccionar cantidad de producto y restar
//                pro.setCantActual(pro.getCantActual().subtract(BigDecimal.ZERO));
//                AlmacenArticulo almacenArticulo = em.find(AlmacenArticulo.class, new AlmacenArticuloPK(pedido.getIdAlmacen().getIdAlmacen(), pro.getIdArticulo()));
//                almacenArticulo.setCantidad(almacenArticulo.getCantidad().add(pedidoDetalle.getCantidad()));
//                em.merge(almacenArticulo);
            }
            //registrar movimiento
            switch (pedido.getEstado()) {
                case '1':
                    System.out.println("Venta con Pago al Contado \n");
                    //registro de pago en efectivo
                    if (Double.parseDouble(txt_efec.getText()) > 0) {
                        String glosa = "VENTA EN EFECTIVO / " + tido.getDescripcion() + " / " + pedido.getSerie() + " - " + pedido.getNumero() + " / " + cli.getNombreCompleto();
                        try {
                            Movimiento m = new Movimiento();
                            m.setGlosa(glosa);
                            m.setFecMov(pedido.getFecha());
                            m.setIngreso(new BigDecimal(txt_efec.getText()));
                            m.setNick(X.getUser());
                            m.setFlag("C");
                            m.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
                            m.setIdCuenta(frm_menu.caja.getIdCaja());
                        } catch (Exception ex) {
                            System.err.print("Error en:" + ex.getLocalizedMessage());

                        }
                        //registrar pago en detalle_pago
                        try {

                            String add_mov_caja = "insert into letras_pedido Values (null, '" + txt_efec.getText() + "', '" + pedido.getFecha() + "', '" + pedido.getIdPedido() + "', 'EFECTIVO')";
                            System.out.println(add_mov_caja + "\n");

                        } catch (Exception ex) {
                            System.err.print("Error en:" + ex.getLocalizedMessage());

                        }

                    }
                    //registro de pago con tarjeta
                    if (Double.parseDouble(txt_tarj.getText()) > 0) {
                        String glosa = "VENTA CON TARJETA / " + tido.getDescripcion() + " / " + pedido.getSerie() + " - " + pedido.getNumero() + " / " + cli.getNombreCompleto();
                        Movimiento m = new Movimiento();
                        m.setGlosa(glosa);
                        m.setFecMov(pedido.getFecha());
                        m.setIngreso(new BigDecimal(txt_tarj.getText()));
                        m.setNick(X.getUser());
                        m.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
                        m.setIdCuenta(frm_menu.cue.getIdCuenta());
                        m.setFlag("B");
                        em.persist(m);
                        //registrar pago en detalle_pago
                        LetraPedido l = new LetraPedido();
                        l.setFecha(pedido.getFecha());
                        l.setMonto(m.getIngreso());
                        l.setIdPedido(pedido.getIdPedido());
                        l.setIdLetraPedido(0);
                        em.persist(l);
                    }

                    //imprimir ticket de venta
                    imprime.set_tipv(tido.getDescripcion());
                    imprime.set_idped(pedido.getIdPedido());
                    System.out.println(imprime.get_idped() + " - " + imprime.get_tipv());
                    imprime.start();
                    break;

                case '6':
                    // cambiar fecha de pago 
                    int dias = 0;
                    if (cbx_plazo.getSelectedIndex() == 0) {
                        dias = 15;
                    } else if (cbx_plazo.getSelectedIndex() == 1) {
                        dias = 30;
                    } else {
                        dias = 45;
                    }
                    pedido.setFechaPago(ven.suma_dia(pedido.getFecha(), dias));
                    em.merge(pedido);
                    //imprimir ticket de venta
                    imprime.set_tipv(tido.getDescripcion());
                    imprime.set_idped(pedido.getIdPedido());
                    System.out.println(imprime.get_idped() + " - " + imprime.get_tipv());
                    imprime.start();
                    break;
            }

        } else {
            //registrar separacion
            pedido = new Pedido();
            pedido.setNick(X.getUser());
            pedido.setTipoPago(tipa);
            pedido.setTipoDoc(tido);
            pedido.setAlmacen(frm_menu.almacen);
            pedido.setCliente(cli);
            JPA.getInstance().getEntityManager(true).persist(pedido);
            //insertar detalle pedido en separacion
            int filas = frm_reg_venta.t_detalle.getRowCount();
            for (int j = 0; j < filas; j++) {
//                pro = em.find(Articulo.class, Integer.parseInt(frm_reg_venta.t_detalle.getValueAt(j, 0).toString()));
//                PedidoDetalle pedidoDetalle = new PedidoDetalle(pedido.getIdPedido(), pro.getIdArticulo());
//                pedidoDetalle.setCantidad(new BigDecimal(frm_reg_venta.t_detalle.getValueAt(j, 3).toString()));
//                pedidoDetalle.setPrecio(new BigDecimal(frm_reg_venta.t_detalle.getValueAt(j, 5).toString()));
//                em.persist(pedidoDetalle);
            }
            Double ent_efec;
            Double ent_tarj;
            ent_efec = Double.parseDouble(txt_efec.getText());
            ent_tarj = Double.parseDouble(txt_tarj.getText());

            //pago en efectivo
            if (Double.parseDouble(txt_efec.getText()) > 0) {
                String glosa = "ADELANTO DE SEPARACION EN EFECTIVO/ " + tido.getDescripcion() + " / " + pedido.getSerie() + " - " + pedido.getNumero() + " / " + cli.getNroDoc();

                Movimiento m = new Movimiento();
                m.setGlosa(glosa);
                m.setNick(X.getUser());
                m.setFecMov(pedido.getFecha());
                m.setIngreso(new BigDecimal(ent_efec));
                m.setFlag("C");
                m.setIdCuenta(frm_menu.caja.getIdCaja());
                m.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
                em.persist(m);

                try {

                    String ins_let_efec = "insert into letras_pedido values(null, '" + ent_efec + "', '" + pedido.getFecha() + "', '" + pedido.getIdPedido() + "' )";
                    System.out.println(ins_let_efec + "\n");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error en letras_pedido: " + e);
                }
            }
            //pago con tarjeta
            if (Double.parseDouble(txt_tarj.getText()) > 0) {
                String glosa = "ADELANTO DE SEPARACION CON TARJETA/ " + tido.getDescripcion() + " / " + pedido.getSerie() + " - " + pedido.getNumero() + " / " + cli.getNroDoc();
                Movimiento m = new Movimiento();
                m.setGlosa(glosa);
                m.setFecMov(pedido.getFecha());
                m.setIngreso(new BigDecimal(ent_efec));
                m.setNick(X.getUser());
                m.setFlag("B");
                m.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
                m.setIdCuenta(frm_menu.cue.getIdCuenta());
                JPA.getInstance().getEntityManager().persist(m);
                LetraPedido l = new LetraPedido();
                l.setMonto(new BigDecimal(ent_efec));
                l.setFecha(pedido.getFecha());
                l.setIdPedido(pedido.getIdPedido());
                JPA.getInstance().getEntityManager().persist(l);
            }
            //actualizar documentos
            try {
                tds.act_doc(pedido.getSerie(), pedido.getNumero() + 1, frm_menu.almacen.getIdAlmacen(), tido.getIdTipoDoc());
            } catch (Exception e) {
                System.out.println(e);
            }
            Double total = ent_efec + ent_tarj;
            // TICKET DE SEPARACION
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("idped", pedido.getIdPedido());
            parametros.put("Adelanto", total);
            parametros.put("Acumulado", total);
            ven.imp_reporte("rpt_ticket_separacion", parametros);
        }
        //cerrar y volver abrir
        this.close();
        frm_reg_venta venta = null;
        venta.btn_clo.doClick();
        venta = new frm_reg_venta();
        ven.open(venta);*/
    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_add_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_notaActionPerformed
//        frm_reg_nota nota = new frm_reg_nota();
//        nota.txt_nota.setText(frm_reg_venta.txt_pla.getText() + " - ");
//        nota.txt_nota.requestFocus();
//        ven.open(nota);

    }//GEN-LAST:event_btn_add_notaActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
//        if (frm_reg_venta.tipo_venta.equals("VENTA")) {
//            cbx_tipopago.setEnabled(true);
//            txt_fec_pago.setText(ven.fechaformateada(ven.getFechaActual()));
//            cbx_tipopago.requestFocus();
//        } else if (frm_reg_venta.tipo_venta.equals("SEPARACION")) {
//            cbx_tipopago.setEnabled(false);
//            txt_fec_pago.setText(ven.fechaformateada(ven.getFechaActual()));
//            txt_fec_pago.setForeground(Color.RED);
//            txt_entrega.setEditable(true);
//            txt_entrega.requestFocus();
//        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened

    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            btn_reg.doClick();
//        }
    }//GEN-LAST:event_btn_regKeyPressed

    private void chk_incluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_incluirActionPerformed
        m_tarj = Double.parseDouble(txt_tarj.getText());
        comision = 0;
        if (chk_incluir.isSelected()) {
            comision = m_tarj * 0.05;
            txt_com.setText(formato.format(comision));
        } else {
            comision = 0;
            txt_com.setText("0.00");
            lbl_tot.setText("S/. " + formato.format(pedido.getTotal()));
        }
        txt_tarj.requestFocus();
    }//GEN-LAST:event_chk_incluirActionPerformed

    private void txt_efecKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efecKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_tarj.setEnabled(true);
            txt_tarj.requestFocus();
            chk_incluir.setEnabled(true);
            m_tarj_com = 0;
        }
    }//GEN-LAST:event_txt_efecKeyPressed

    private void txt_tarjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarjKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //verificar suma y activar aceptar
            m_efect = Double.parseDouble(txt_efec.getText());
            m_tarj = Double.parseDouble(txt_tarj.getText());
            double suma_tot = m_efect + m_tarj;
            if (accion.equals("venta")) {
                if (pedido.getTotal() - suma_tot <= 0.0005) {
                    btn_reg.setEnabled(true);
                    btn_reg.requestFocus();
                }
            } else {
                btn_reg.setEnabled(true);
                btn_reg.requestFocus();
            }
            txt_subt.setText(formato.format(suma_tot));
        }

    }//GEN-LAST:event_txt_tarjKeyPressed

    private void btn_contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_contActionPerformed
        cbx_plazo.setEnabled(false);
        txt_efec.setEnabled(true);
        txt_efec.setText("0");
        txt_efec.requestFocus();
        txt_tarj.setEnabled(true);
        txt_tarj.setText("0");
        txt_subt.setText("0");
    }//GEN-LAST:event_btn_contActionPerformed

    private void btn_credActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_credActionPerformed
        cbx_plazo.setEnabled(true);
        txt_efec.setEnabled(false);
        txt_efec.setText("0");
        txt_efec.requestFocus();
        txt_tarj.setEnabled(false);
        txt_tarj.setText("0");
        txt_subt.setText("0");
    }//GEN-LAST:event_btn_credActionPerformed

    private void txt_efecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efecKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_efecKeyTyped

    private void txt_tarjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tarjKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_txt_tarjKeyTyped

    private void cbx_plazoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_plazoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_reg.setEnabled(true);
            btn_reg.requestFocus();
        }
    }//GEN-LAST:event_cbx_plazoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_nota;
    private javax.swing.JButton btn_cerrar;
    public static javax.swing.JRadioButton btn_cont;
    public static javax.swing.JRadioButton btn_cred;
    private javax.swing.JButton btn_reg;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JComboBox cbx_plazo;
    public static javax.swing.JCheckBox chk_incluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lbl_doc;
    public static javax.swing.JLabel lbl_tot;
    private javax.swing.JTextField txt_com;
    public static javax.swing.JTextField txt_efec;
    public static javax.swing.JTextField txt_subt;
    public static javax.swing.JTextField txt_tarj;
    // End of variables declaration//GEN-END:variables
}
