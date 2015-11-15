package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Cliente;
import org.jsuns.commerce.jpa.Pedido;
//import org.jsuns.commerce.jpa.Articulo;
import org.jsuns.commerce.jpa.TipoPago;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.app.User;
import org.jsuns.data.JPA;
import org.jsuns.commerce.TipoDocumentoService;
import org.jsuns.commerce.jpa.Oferta;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.TipoDocumento;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_reg_venta extends XPanel {
/*
    Cl_Varios ven = new Cl_Varios();
    Oferta ofe = new Oferta();
    User usu = new User();
    Cliente cli = new Cliente();
    Pedido ped = new Pedido();
//    public static Articulo pro = new Articulo();
    TipoPago tipa = new TipoPago();
    TipoDocumento tido = new TipoDocumento();
    public static DefaultTableModel detalle;
    public static DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    public static DecimalFormat formato = null;
    public static String tipo_venta = "";
    Integer i;

    public frm_reg_venta() {
        initComponents();
        //establecer fecha actual
        txt_fec.setDate(ven.getFechaActual());
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);
        //mostrar nombres de columnas
        detalle = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna == 3 || columna == 5) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        detalle.addColumn("Id");
        detalle.addColumn("Descripcion");
        detalle.addColumn("Marca");
        detalle.addColumn("Cant.");
        detalle.addColumn("Und. Med");
        detalle.addColumn("Precio");
        t_detalle.setModel(detalle);
        t_detalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        t_detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        t_detalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        t_detalle.getColumnModel().getColumn(4).setPreferredWidth(70);
        t_detalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        detalle.fireTableDataChanged();
        //cargar tipo documento
        cbx_tipd.setStore(TipoDocumento.class);
        cbx_tipd.load();
        //mostrar vendedores activos
        ver_vendedores("" + frm_menu.almacen.getIdAlmacen());
        cbx_vendedor.requestFocus();
    }
    
    private void ver_vendedores(String id_alm){
        //mostrar vendedores segun cargo x prioridad
        for(Object item:JPA.getInstance().getEntityManager().createQuery("select dni from Empleado where idAlmacen = '" + id_alm + "' "
                + "and est_per = '1' order by idCargo asc ").getResultList()){
            cbx_vendedor.addItem(item);
        }
        cbx_vendedor.setSelectedItem(X.getUser());
    }

    public static double subtotal() {
        double sub_t;
        int totalRow = t_detalle.getRowCount();
        double suma_sub = 0.00;
        for (int i = 0; i < totalRow; i++) {
            double pre = Double.parseDouble(String.valueOf(t_detalle.getValueAt(i, 5)));
            double cant = Double.parseDouble(String.valueOf(t_detalle.getValueAt(i, 3)));
            suma_sub += pre * cant;
        }
        sub_t = suma_sub / 1.18;
        return sub_t;
    }

    public double total() {
        double igv;
        double tot;
        igv = subtotal() * 0.18;
        txt_igv.setText(formato.format(igv));
        tot = subtotal() + igv;
        return tot;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_subt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_igv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_tot = new javax.swing.JLabel();
        btn_reg = new javax.swing.JButton();
        btn_clo = new javax.swing.JButton();
        btn_cam_can = new javax.swing.JButton();
        btn_eli = new javax.swing.JButton();
        btn_add_pro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblcod_alm1 = new javax.swing.JLabel();
        cbx_alm = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbx_tip_venta = new javax.swing.JComboBox();
        txt_nro_doc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        txt_fec = new org.jsuns.swing.XDateField();
        cbx_tipd = new org.jsuns.swing.XComboBox();
        btn_cpre = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        txt_desc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_vend = new javax.swing.JTextField();
        cbx_vendedor = new org.jsuns.swing.XComboBox();

        setTitle("Registro de Venta");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setFocusable(false);

        t_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        t_detalle.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        t_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_detalleMousePressed(evt);
            }
        });
        t_detalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_detalleFocusLost(evt);
            }
        });
        t_detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_detalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_detalle);
        if (t_detalle.getColumnModel().getColumnCount() > 0) {
            t_detalle.getColumnModel().getColumn(0).setPreferredWidth(10);
            t_detalle.getColumnModel().getColumn(1).setPreferredWidth(350);
            t_detalle.getColumnModel().getColumn(2).setPreferredWidth(30);
            t_detalle.getColumnModel().getColumn(3).setPreferredWidth(20);
            t_detalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Sub Total:");
        jLabel2.setFocusable(false);

        txt_subt.setEditable(false);
        txt_subt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_subt.setFocusable(false);
        txt_subt.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("IGV:");
        jLabel7.setFocusable(false);

        txt_igv.setEditable(false);
        txt_igv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_igv.setFocusable(false);
        txt_igv.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("Total:");
        jLabel8.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("Detalle de Venta:");
        jLabel9.setFocusable(false);

        lbl_tot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_tot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tot.setText("S/. 0.00");
        lbl_tot.setFocusable(false);
        lbl_tot.setPreferredSize(new java.awt.Dimension(120, 52));

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.setFocusable(false);
        btn_reg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_reg.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_reg.setPreferredSize(new java.awt.Dimension(85, 25));
        btn_reg.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_clo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btn_clo.setText("Cancelar");
        btn_clo.setFocusable(false);
        btn_clo.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_clo.setPreferredSize(new java.awt.Dimension(85, 25));
        btn_clo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cloActionPerformed(evt);
            }
        });

        btn_cam_can.setText("Cambiar Cantidad");
        btn_cam_can.setEnabled(false);
        btn_cam_can.setFocusable(false);
        btn_cam_can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cam_canActionPerformed(evt);
            }
        });

        btn_eli.setText("Eliminar Producto");
        btn_eli.setEnabled(false);
        btn_eli.setFocusable(false);
        btn_eli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliActionPerformed(evt);
            }
        });

        btn_add_pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_add_pro.setText("Agregar Producto (F2)");
        btn_add_pro.setFocusable(false);
        btn_add_pro.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btn_add_pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_add_proActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFocusable(false);

        jLabel5.setText("Tipo de Doc:");
        jLabel5.setFocusable(false);

        jLabel4.setText("Fecha de Venta:");
        jLabel4.setFocusable(false);

        lblcod_alm1.setText("000");

        cbx_alm.setText("-");

        jLabel1.setText("Tipo Venta:");

        cbx_tip_venta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "VENTA", "SEPARACION" }));
        cbx_tip_venta.setEnabled(false);
        cbx_tip_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tip_ventaKeyPressed(evt);
            }
        });

        txt_nro_doc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nro_doc.setEnabled(false);
        txt_nro_doc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nro_docKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nro_docKeyTyped(evt);
            }
        });

        jLabel10.setText("D.N.I / R.U.C");

        jLabel12.setText("Nombre:");

        txt_nom.setEditable(false);
        txt_nom.setFocusable(false);
        txt_nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nro_doc, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                    .addComponent(cbx_tipd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbx_tip_venta, 0, 36, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_nom))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_tip_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_fec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbx_tipd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nro_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_cpre.setText("Cambiar Precio");
        btn_cpre.setEnabled(false);
        btn_cpre.setFocusable(false);
        btn_cpre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cpreActionPerformed(evt);
            }
        });

        txt_id.setEnabled(false);
        txt_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idKeyPressed(evt);
            }
        });

        txt_desc.setEnabled(false);
        txt_desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_descFocusGained(evt);
            }
        });
        txt_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_descKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descKeyReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("Vendedor:");

        txt_vend.setEditable(false);
        txt_vend.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cam_can)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cpre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_eli))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_tot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_subt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addComponent(cbx_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_vend)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_desc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_add_pro)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_vend, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_add_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cam_can, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cpre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_eli, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_subt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cloActionPerformed
        this.close();
    }//GEN-LAST:event_btn_cloActionPerformed

    private void btn_add_proActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_add_proActionPerformed
        frm_ver_prod_alm prod_alm = new frm_ver_prod_alm();
        prod_alm.setAlmacen(frm_menu.almacen);
        prod_alm.setFindSelectionListener(this);
        ven.open(prod_alm);

    }//GEN-LAST:event_btn_add_proActionPerformed

    
    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        frm_fin_venta venta = new frm_fin_venta();
        venta.lbl_tot.setText("S/. " + formato.format(total()));
        venta.pedido.setTotal(total());
        System.out.println(total());
        if (cbx_tip_venta.getSelectedItem().equals("VENTA")) {
            venta.btn_cont.setSelected(true);
            venta.cbx_plazo.setEnabled(false);
            venta.txt_efec.setEnabled(true);
            venta.txt_efec.setText("0");
            venta.txt_efec.requestFocus();
            venta.txt_tarj.setEnabled(true);
            venta.txt_tarj.setText("0");
            venta.txt_subt.setText("0");
        } else {
            venta.btn_cont.setSelected(true);
            venta.btn_cred.setEnabled(false);
            venta.cbx_plazo.setEnabled(false);
            venta.txt_efec.setEnabled(true);
            venta.txt_efec.setText("0");
            venta.txt_efec.requestFocus();
            venta.txt_tarj.setEnabled(true);
            venta.txt_tarj.setText("0");
            venta.txt_subt.setText("0");
        }
        tido.setIdTipoDoc(cbx_tipd.getSelectedIndex() + 1);
        tido.setDescripcion(cbx_tipd.getSelectedItem().toString());
        TipoDocumentoService tds=new TipoDocumentoService();
        
//        tido.setSerie(tds.ver_ser(tido.getTipoDoc(), frm_menu.almacen.getIdAlmacen()));
//        tido.setNumero(tds.ver_num(tido.getTipoDoc(), frm_menu.almacen.getIdAlmacen()));
//        venta.lbl_doc.setText(tido.getDescripcion() + " / " + tido.getSerie() + " - " + tido.getNro());
        if (cbx_tip_venta.getSelectedItem().equals("VENTA")){
            venta.accion = "venta";
        } else {
            venta.accion = "separacion";
        }
        ven.open(venta);

    }//GEN-LAST:event_btn_regActionPerformed

    private void btn_cam_canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cam_canActionPerformed
        Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Cantidad"));
        t_detalle.setValueAt(cantidad, i, 3);
        txt_subt.setText(formato.format(subtotal()));
        lbl_tot.setText("S/. " + formato.format(total()));
        txt_id.requestFocus();
    }//GEN-LAST:event_btn_cam_canActionPerformed

    private void t_detalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_detalleMousePressed
        i = t_detalle.getSelectedRow();
        btn_cam_can.setEnabled(true);
        btn_eli.setEnabled(true);
        btn_cpre.setEnabled(true);
    }//GEN-LAST:event_t_detalleMousePressed

    private void btn_cpreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cpreActionPerformed
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Precio"));
//        String pre_com = "select costo_compra from productos where idProductos='" + t_detalle.getValueAt(i, 0) + "'";
//        if (precio > rs.getDouble("costo_compra")) {
//            t_detalle.setValueAt(precio, i, 5);
//            txt_subt.setText(formato.format(subtotal()));
//            lbl_tot.setText("S/. " + formato.format(total()));
//            txt_id.requestFocus();
//        } else {
//            JOptionPane.showMessageDialog(null, "No se puede establecer ese precio");
//            txt_id.requestFocus();
//        }
            
    }//GEN-LAST:event_btn_cpreActionPerformed

    private void btn_eliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliActionPerformed
        detalle.removeRow(i);
        txt_subt.setText(formato.format(subtotal()));
        lbl_tot.setText("S/. " + formato.format(total()));
        txt_id.requestFocus();
    }//GEN-LAST:event_btn_eliActionPerformed

    private void txt_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_add_pro.doClick();
        }

        if (Character.isLetter(evt.getKeyChar())) {
            txt_desc.setEnabled(true);
            txt_id.setText("");
            txt_desc.requestFocus();

            try {
               
                String sql = "select pa.idProductos,p.desc_pro, p.marca, p.modelo, p.serie, pa.cant, pa.precio"
                        + " from producto_almacen as pa inner join productos as p"
                        + " on pa.idProductos=p.idProductos where pa.idAlmacen ='" + frm_menu.almacen.getIdAlmacen() + "' "
                        + "order by p.desc_pro asc, p.modelo asc";
       
//                while (rs.next()) {
//                    autocopletar.addItem(rs.getString("pa.idProductos") + " - " + rs.getString("p.desc_pro") + " - " + rs.getString("p.marca") + " - " + rs.getString("p.modelo"));
//                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
                System.out.println(e.getLocalizedMessage());
            }
        }

        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            String idpro = txt_id.getText();
            Integer idalm = frm_menu.almacen.getIdAlmacen();
          
                String query = "select p.desc_pro, p.grado, p.marca, p.modelo, p.serie "
                        + "from productos as p "
                        + "inner join producto_almacen"
                        + " as a on a.idProductos=p.idProductos where a.idProductos = '" + idpro + "' and idAlmacen = '" + idalm + "'";
            
//                if (rs1.next()) {
//                    txt_desc.setText(rs1.getString("desc_pro") + " - " + rs1.getString("modelo") + " - " + rs1.getString("serie") + " - " + rs1.getString("marca"));
//                    txt_id.requestFocus();
//                } else {
//                    txt_desc.setText("EL PRODUCTO NO EXISTE");
//                    txt_id.setText("");
//                    txt_id.requestFocus();
//                }
    
          
        }
        ///agregado de  productos
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_id.getText().length() != 0) {
                Integer idpro = Integer.parseInt(txt_id.getText());
                Integer idalm = frm_menu.almacen.getIdAlmacen();

                    String query = "select a.idProductos, p.desc_pro, p.grado, p.marca, p.modelo, p.serie, p.cant_actual, p.cant_min, a.cant, a.precio, p.estado, u.desc_und "
                            + "from producto_almacen as a inner join productos as p on a.idProductos=p.idProductos "
                            + "inner join und_medida as u on p.idUnd_medida=u.idUnd_medida where p.idProductos = '" + idpro + "' and a.idAlmacen = '" + idalm + "' order by p.desc_pro asc";
                
//                    if (rs1.next()) {
//                        Object fila[] = new Object[6];
//                        fila[0] = rs1.getInt("idProductos");  //COD PRO
//                        fila[1] = rs1.getString("desc_pro") + " - " + rs1.getString("modelo") + " - " + rs1.getString("serie"); // DESCRIPCION
//                        fila[2] = rs1.getString("marca");           //MARCA
//                        fila[3] = "1.00";                        // CANTIDAD
//                        fila[4] = rs1.getString("u.desc_und"); // UND MED
//                        Double cant_dis = rs1.getDouble("cant");
//                        Integer filas_tabla;
//
//                        //ENVIAR DATOS A FORMULARIO VENTA
//                        filas_tabla = t_detalle.getRowCount();
//                        if (cant_dis > 0) {
//                            Integer copiado = 0;
//                            double oferta_prod=new OfertaService().precio_oferta(frm_menu.almacen.getIdAlmacen(), rs1.getInt("idProductos"));
//                            if (filas_tabla > 0) {
//                                for (int x = 0; x < filas_tabla; x++) {
//                                    Integer id_pro_tabla;
//                                    id_pro_tabla = (Integer) t_detalle.getValueAt(x, 0);
//                                    if (id_pro_tabla == idpro) {
//                                        copiado++;
//                                    }
//                                }
//
//                                if (copiado == 0) {
//                                    if (oferta_prod == 0.00) {
//                                        fila[5] = rs1.getDouble("precio");
//                                    } else {
//                                        fila[5] = oferta_prod;
//                                    }
//                                    detalle.addRow(fila);
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
//                                }
//
//                            } else {
//                                if (oferta_prod == 0.00) {
//                                    fila[5] = rs1.getDouble("precio");
//                                } else {
//                                    fila[5] = oferta_prod;
//                                }
//                                detalle.addRow(fila);
//                            }
//                            txt_subt.setText(formato.format(subtotal()));
//                            lbl_tot.setText("S/. " + formato.format(total()));
//                        } else {
//                            JOptionPane.showMessageDialog(null, "No existe suficiente producto para la operacion");
//                        }
//
//                    } else {
//                        txt_desc.setText("EL PRODUCTO NO EXISTE");
//                    }

                txt_id.setText("");
                txt_id.requestFocus();
            }

        }

        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            cbx_tip_venta.setEnabled(true);
            cbx_tip_venta.requestFocus();
        }

    }//GEN-LAST:event_txt_idKeyPressed

    private void t_detalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_detalleFocusLost
        btn_cam_can.setEnabled(false);
        btn_cpre.setEnabled(false);
        btn_eli.setEnabled(false);
    }//GEN-LAST:event_t_detalleFocusLost

    private void btn_loadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_loadKeyPressed

    }//GEN-LAST:event_btn_loadKeyPressed

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed

    }//GEN-LAST:event_btn_loadActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    }//GEN-LAST:event_formInternalFrameActivated


    private void txt_nro_docKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_docKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_nro_doc.getText().length() == 8 || txt_nro_doc.getText().length() == 11) {
                if (!txt_nro_doc.getText().isEmpty()) {
                    cli.setNroDoc(txt_nro_doc.getText());
                  
                        String ver_pro = "select * from cliente where nro_doc = '" + cli.getNroDoc() + "'";
                      
//                        if (rs.next()) {
//                            txt_nro_doc.setText(rs.getString("nro_doc"));
//                            txt_nom.setText(rs.getString("nom_per"));
//                            txt_fec.setEnabled(true);
//                            txt_fec.setEditable(true);
//                            txt_fec.requestFocus();
//                            txt_nro_doc.setBackground(Color.white);
//                            txt_nro_doc.setForeground(Color.black);
//                            txt_fec.setBackground(Color.red);
//                            txt_fec.setForeground(Color.white);
//                        } else {
//                            txt_nro_doc.requestFocus();
//                            JOptionPane.showMessageDialog(null, "Cliente no registrado");
//                            frm_reg_cliente cliente = new frm_reg_cliente();
//                            cli.setNroDoc(txt_nro_doc.getText());
//                            ven.open(cliente);
//                            frm_reg_cliente.ventana = "reg_venta";
//                            if (txt_nro_doc.getText().length() == 8) {
//                                frm_reg_cliente.cbx_cli.setSelectedItem("DNI");
//                                frm_reg_cliente.txt_ndoc.setText(cli.getNroDoc());
//                                frm_reg_cliente.txt_ndoc.setEditable(false);
//                                frm_reg_cliente.txt_nom.setEditable(true);
//                                frm_reg_cliente.txt_nom.requestFocus();
//                            } else if (txt_nro_doc.getText().length() == 11) {
//                                frm_reg_cliente.cbx_cli.setSelectedItem("RUC");
//                                frm_reg_cliente.txt_ndoc.setText(cli.getNroDoc());
//                                frm_reg_cliente.txt_ndoc.setEditable(false);
//                                frm_reg_cliente.txt_nom.setEditable(true);
//                                frm_reg_cliente.txt_nom.requestFocus();
//                            }
//                        }
                
                } else {
                    JOptionPane.showMessageDialog(null, "Se ingresará DNI de Clientes Generales");
                    txt_nro_doc.setText("00000000");
                    txt_nro_doc.requestFocus();
                }

            } else {
//                JOptionPane.showMessageDialog(null, "Nro. de Documento no valido");
//                txt_nro_doc.setText("");
//                txt_nro_doc.requestFocus();
//            }
            if (cbx_tipd.getSelectedItem().equals("BOLETA") && total() >= 750) {
                if (txt_nro_doc.getText().equals("00000000")) {
                    JOptionPane.showMessageDialog(null, "Nro de Documento no valido");
                    txt_fec.setEnabled(false);
                    txt_fec.setBackground(Color.white);
                    txt_fec.setForeground(Color.black);
                    txt_nro_doc.setText("");
                    txt_nro_doc.requestFocus();
                }
            } else {
                if (txt_nro_doc.getText().equals("-")) {
                    txt_nom.setEditable(true);
                    txt_nom.setFocusable(true);
                    txt_nom.requestFocus();
                    txt_nro_doc.setText("00000000");
                }
            }
            }
        }
    }//GEN-LAST:event_txt_nro_docKeyPressed

    private void txt_nomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_fec.setBackground(Color.red);
            txt_fec.setForeground(Color.white);
            txt_nro_doc.setBackground(Color.white);
            txt_nro_doc.setForeground(Color.black);
            txt_fec.setEnabled(true);
            txt_fec.setEditable(true);
            txt_fec.setDate(ven.getFechaActual());
            txt_fec.requestFocus();
        }
    }//GEN-LAST:event_txt_nomKeyPressed

    private void cbx_tip_ventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tip_ventaKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (cbx_tip_venta.getSelectedIndex() == 1) {
                cbx_tipd.setSelectedIndex(0);
                cbx_tipd.setEnabled(false);
                txt_nro_doc.setEditable(true);
                txt_nro_doc.setEnabled(true);
                txt_nro_doc.setText("");
                txt_nom.setText("");
                txt_nro_doc.requestFocus();
            } else {
                cbx_tipd.setEnabled(true);
                cbx_tipd.requestFocus();
                txt_nro_doc.setText("");
                txt_nom.setText("");
            }
        }

    }//GEN-LAST:event_cbx_tip_ventaKeyPressed

    private void txt_nro_docKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nro_docKeyTyped
        if (cbx_tipd.getSelectedItem().equals("NOTA DE VENTA")) {
            if (txt_nro_doc.getText().length() == 8) {
                evt.consume();
            }
        }

        if (cbx_tipd.getSelectedItem().equals("BOLETA")) {
            if (txt_nro_doc.getText().length() == 8) {
                evt.consume();
            }
        }

        if (cbx_tipd.getSelectedItem().equals("FACTURA")) {
            if (txt_nro_doc.getText().length() == 11) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_nro_docKeyTyped

    private void t_detalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_detalleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Double precio = Double.parseDouble(t_detalle.getValueAt(i, 5).toString());
            try {
                String pre_com = "select costo_compra from productos where idProductos='" + t_detalle.getValueAt(i, 0) + "'";
              
                double precio_b = 0;
//                if (rs.next()) {
//                    precio_b = rs.getDouble("costo_compra");
//                }
                if (precio > precio_b) {
                    t_detalle.setValueAt(precio, i, 5);
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede establecer ese precio");
                    t_detalle.setValueAt(precio_b + 2, i, 5);
                }
                txt_subt.setText(formato.format(subtotal()));
                lbl_tot.setText("S/. " + formato.format(total()));
                txt_id.setText("");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getLocalizedMessage());
            }
            cbx_tip_venta.setEnabled(true);
            cbx_tip_venta.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            detalle.removeRow(i);
            txt_subt.setText(formato.format(subtotal()));
            lbl_tot.setText("S/. " + formato.format(total()));
            txt_id.requestFocus();
            txt_id.setText("");
        }
    }//GEN-LAST:event_t_detalleKeyPressed


    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void txt_descKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descKeyReleased

    }//GEN-LAST:event_txt_descKeyReleased

    private void txt_descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descKeyPressed

        String cap = txt_desc.getText();
        boolean estado = false;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            for (int j = 0; j < cap.length(); j++) {
                if (cap.charAt(j) == '-') {
                    estado = true;
                }
            }
            if (estado) {
                String[] cod = cap.split("-");
                String temp = cod[0];
                txt_id.setText("");
                txt_id.setText(temp.trim());
                txt_desc.setText("");
                txt_id.requestFocus();
            }
        }


    }//GEN-LAST:event_txt_descKeyPressed

    private void txt_descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_descFocusGained
        txt_id.setText("");
    }//GEN-LAST:event_txt_descFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add_pro;
    private javax.swing.JButton btn_cam_can;
    public static javax.swing.JButton btn_clo;
    private javax.swing.JButton btn_cpre;
    private javax.swing.JButton btn_eli;
    protected javax.swing.JButton btn_reg;
    private javax.swing.JLabel cbx_alm;
    private javax.swing.JComboBox cbx_tip_venta;
    private org.jsuns.swing.XComboBox cbx_tipd;
    private org.jsuns.swing.XComboBox cbx_vendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbl_tot;
    private javax.swing.JLabel lblcod_alm1;
    public static javax.swing.JTable t_detalle;
    private javax.swing.JTextField txt_desc;
    private org.jsuns.swing.XDateField txt_fec;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_nro_doc;
    private javax.swing.JTextField txt_subt;
    private javax.swing.JTextField txt_vend;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(FindSelectionEvent evt) {
        JTable t_productos =(JTable)evt.getSource();
        int i=evt.getSelectedRows()[0];
        Object fila[] = new Object[6];
        fila[0] = t_productos.getValueAt(i, 0);                                         //COD PRO
        fila[1] = t_productos.getValueAt(i, 1);                                         // DESCRIPCION
        fila[2] = t_productos.getValueAt(i, 2);                                         // MARCA
        fila[3] = "1.00";                                                               // CANTIDAD
        fila[4] = t_productos.getValueAt(i, 4);                                         // UND MED
        fila[5] = t_productos.getValueAt(i, 5);
        int prod = (int) t_productos.getValueAt(i, 0);
        Integer filas_tabla =t_detalle.getRowCount();
        Integer copiado = 0;
        if (filas_tabla > 0) {
            for (int x = 0; x < filas_tabla; x++) {
                Integer id_pro_tabla;
                id_pro_tabla = Integer.parseInt(t_detalle.getValueAt(x, 0).toString());
                if (id_pro_tabla == prod) {
                    copiado++;
                }
            }
            if (copiado == 0) {
                detalle.addRow(fila);
                t_detalle.setModel(frm_reg_venta.detalle);
                txt_id.requestFocus();
                subtotal();
                total();
                this.close();
            } else {
                JOptionPane.showMessageDialog(null, "Se esta escogiendo un producto ya existente");
            }
        } else {
            detalle.addRow(fila);
            t_detalle.setModel(frm_reg_venta.detalle);
            txt_id.requestFocus();
            subtotal();
            total();
            this.close();
        }
    }*/
}
