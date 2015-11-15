package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Compra;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.commerce.jpa.AlmacenArticuloPK;
import org.jsuns.commerce.jpa.CompraDetalle;
import org.jsuns.commerce.jpa.Kardex;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.commerce.jpa.TipoDocumento;
import org.jsuns.commerce.jpa.TipoMovimiento;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;
import org.jsuns.util.XUtil;

public class frm_reg_compra_prod extends XPanel{
/*
    private Cl_Varios ven = new Cl_Varios();
    private Proveedor pro = new Proveedor();
//    private Articulo art=new Articulo();
    private Compra compra=new Compra();
    private Almacen alm = new Almacen();
    private Empresa emp = new Empresa();
    private TipoDocumento tido = new TipoDocumento();
    private DefaultTableModel detalle;
    private DecimalFormat formato = new DecimalFormat("####0.00");
    private Integer i;

    public frm_reg_compra_prod(){
        initComponents();
        cbx_alm.setStore(Almacen.class);
        txt_fec_com.setValue(ven.getFechaActual());
        txt_fec_pag.setValue(ven.getFechaActual());
        cbx_tido.setStore(TipoDocumento.class);
        cbx_tido.load();
        //dar formato a tabla
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
        t_detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(1).setPreferredWidth(450);
        t_detalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        t_detalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        detalle.fireTableDataChanged();

        //leer almacen y seleccionar por defecto en cbx_alm
        try {
            File Ffichero = new File("almacen.txt");
            String txt_alm = null;
           
            if (Ffichero.exists()) {
              
                BufferedReader Flee = new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                //Lee el fichero linea a linea hasta llegar a la ultima
                while ((Slinea = Flee.readLine()) != null) {
                  
                    txt_alm = Slinea;
                }
              
                Flee.close();
                cbx_alm.setSelectedItem(txt_alm);
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        txt_idp = new javax.swing.JTextField();
        txt_desp = new javax.swing.JTextField();
        btn_busm = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_sub = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        txt_tot = new javax.swing.JTextField();
        btn_ca = new javax.swing.JButton();
        btn_va = new javax.swing.JButton();
        btn_el = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_dir = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_ruc_dest = new javax.swing.JTextField();
        txt_ser = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_nro = new javax.swing.JTextField();
        cbx_tipa = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        btn_bus_emp = new javax.swing.JButton();
        txt_fec_pag = new org.jsuns.swing.XDateField();
        txt_fec_com = new org.jsuns.swing.XDateField();
        cbx_alm = new org.jsuns.swing.XComboBox();
        cbx_tido = new org.jsuns.swing.XComboBox();
        jLabel1 = new javax.swing.JLabel();
        txt_ruc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_raz = new javax.swing.JTextField();
        btn_busp = new javax.swing.JButton();

        setTitle("Registrar Compra");

        jLabel10.setText("Producto:");
        jLabel10.setFocusable(false);

        txt_idp.setEditable(false);
        txt_idp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_idp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idpKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idpKeyTyped(evt);
            }
        });

        txt_desp.setEditable(false);
        txt_desp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_desp.setFocusable(false);

        btn_busm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_busm.setEnabled(false);
        btn_busm.setFocusable(false);
        btn_busm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_busmActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setFocusable(false);

        t_detalle.setModel(new javax.swing.table.DefaultTableModel(
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
        t_detalle.setFocusable(false);
        t_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_detalleMouseClicked(evt);
            }
        });
        t_detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t_detalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_detalle);

        jLabel11.setText("Sub Total:");
        jLabel11.setFocusable(false);

        jLabel12.setText("IGV");
        jLabel12.setFocusable(false);

        jLabel13.setText("Total:");
        jLabel13.setFocusable(false);

        txt_sub.setEditable(false);
        txt_sub.setFocusable(false);

        txt_igv.setEditable(false);
        txt_igv.setFocusable(false);

        txt_tot.setEditable(false);
        txt_tot.setFocusable(false);

        btn_ca.setText("+/-");
        btn_ca.setEnabled(false);
        btn_ca.setFocusable(false);
        btn_ca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caActionPerformed(evt);
            }
        });

        btn_va.setText("S/.");
        btn_va.setEnabled(false);
        btn_va.setFocusable(false);
        btn_va.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vaActionPerformed(evt);
            }
        });

        btn_el.setText("X");
        btn_el.setEnabled(false);
        btn_el.setFocusable(false);
        btn_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/accept.png"))); // NOI18N
        btn_reg.setText("Aceptar");
        btn_reg.setEnabled(false);
        btn_reg.setFocusable(false);
        btn_reg.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setFocusable(false);
        btn_cer.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        jLabel3.setText("Almacen Destino:");
        jLabel3.setFocusable(false);

        jLabel4.setText("Fecha de Compra:");
        jLabel4.setFocusable(false);

        jLabel5.setText("Fecha de Pago:");
        jLabel5.setFocusable(false);

        jLabel6.setText("Direccion:");
        jLabel6.setFocusable(false);

        txt_dir.setEditable(false);
        txt_dir.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        txt_dir.setFocusable(false);

        jLabel14.setText("Tipo de Documento:");
        jLabel14.setFocusable(false);

        jLabel7.setText("Emp. Dest.");
        jLabel7.setFocusable(false);

        jLabel15.setText("Serie:");
        jLabel15.setFocusable(false);

        txt_ruc_dest.setEditable(false);
        txt_ruc_dest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc_dest.setFocusable(false);

        txt_ser.setEditable(false);
        txt_ser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_serKeyTyped(evt);
            }
        });

        jLabel16.setText("Nro. Doc:");
        jLabel16.setFocusable(false);

        txt_nro.setEditable(false);
        txt_nro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nroKeyTyped(evt);
            }
        });

        cbx_tipa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CONTADO", "CREDITO" }));
        cbx_tipa.setSelectedIndex(1);
        cbx_tipa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_tipaKeyPressed(evt);
            }
        });

        jLabel17.setText("Tipo de Pago:");

        btn_bus_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_bus_emp.setEnabled(false);
        btn_bus_emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bus_empActionPerformed(evt);
            }
        });

        jLabel1.setText("RUC:");
        jLabel1.setFocusable(false);

        txt_ruc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rucKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rucKeyTyped(evt);
            }
        });

        jLabel2.setText("Razon Social:");
        jLabel2.setFocusable(false);

        txt_raz.setEditable(false);
        txt_raz.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_raz.setFocusable(false);

        btn_busp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_busp.setFocusable(false);
        btn_busp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_raz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_busp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_tipa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_tido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nro))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ruc_dest, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_bus_emp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx_alm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(2, 2, 2)
                        .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fec_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_raz, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_busp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_dir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc_dest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_bus_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_fec_com, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_fec_pag, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbx_tipa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_tido, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_idp, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desp, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_busm))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_va)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_el))
                            .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_cer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btn_busm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_desp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                        .addGap(14, 14, 14)
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_ca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_va, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_rucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_busp.doClick();
        }else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_ruc.getText().length() == 11){
                pro=JPA.getInstance().getEntityManager().find(Proveedor.class,txt_ruc.getText());
                if(pro!=null){
                    txt_raz.setText(pro.getRazonSocial());
                    txt_dir.setText(pro.getDireccion());
                    btn_bus_emp.setEnabled(true);
                    btn_bus_emp.requestFocus();
                }else{
                    txt_ruc.setText("");
                    txt_ruc.requestFocus();
                    JOptionPane.showMessageDialog(null, "El Proveedor no existe \nPor favor ingrese otro nro de RUC");
                }
            }
        }
    }//GEN-LAST:event_txt_rucKeyPressed

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        frm_ver_compras_articulo compra = new frm_ver_compras_articulo();
        ven.open(compra);
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void txt_serKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_ser.getText().isEmpty()) {
                txt_nro.setEditable(true);
                txt_nro.requestFocus();
            }
        }
    }//GEN-LAST:event_txt_serKeyPressed

    private void txt_nroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txt_nro.getText().isEmpty()) {
                txt_idp.setEditable(true);
                txt_idp.requestFocus();
                btn_busm.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txt_nroKeyPressed

    private void txt_idpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idpKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F3) {
            btn_reg.doClick();
        }

        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            btn_busm.doClick();
        }
    }//GEN-LAST:event_txt_idpKeyPressed

    private void btn_buspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buspActionPerformed
        frm_ver_proveedores proveedor = new frm_ver_proveedores();
        proveedor.funcion = "compra_prod";
        ven.open(proveedor);
    }//GEN-LAST:event_btn_buspActionPerformed

    private void btn_busmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_busmActionPerformed
        frm_ver_productos prod=new frm_ver_productos();
        prod.setFindSeleccionListener(this);
        prod.retrieve();
        ven.open(prod);
    }//GEN-LAST:event_btn_busmActionPerformed

     @Override
    public void valueChanged(FindSelectionEvent evt) {
        JTable t_productos=(JTable)evt.getSource();
        int tabla = t_detalle.getRowCount(); 
        int a=evt.getSelectedRows()[0];
        String id = t_productos.getValueAt(a, 0).toString();         //id del formulario ver_productos
        String id_prod = "";
        int contar_repetidos = 0;
        Object[] fila_compra = new Object[6];
        fila_compra[0] = t_productos.getValueAt(a, 0);         //idproducto
        fila_compra[1] = t_productos.getValueAt(a, 1);         //descripcion
        fila_compra[2] = t_productos.getValueAt(a, 2);         //marca
        fila_compra[3] = "1";                                  //cantidad
        fila_compra[4] = t_productos.getValueAt(a, 7);         //und. med
        Articulo articulo=JPA.getInstance().getEntityManager().find(Articulo.class,id);
        fila_compra[5]=articulo.getCostoCompra();
        JPA.getInstance().close();
        if (tabla > 0){            //verifica si existen registros
            for (int j = 0; j < tabla; j++){           //recorremos la tabla reg_compra
                id_prod = t_detalle.getValueAt(j, 0).toString();// captura el id reg_compra
                if (id_prod.equals(id)) {
                    contar_repetidos++;
                }
            }
            if(contar_repetidos==0){
                detalle.addRow(fila_compra);
                txt_sub.setText(formato.format(subtotal()));
                txt_igv.setText(formato.format(igv()));
                txt_tot.setText(formato.format(total()));
                btn_reg.setEnabled(true);
                txt_idp.requestFocus();
            }
        } else {
            detalle.addRow(fila_compra);
            t_detalle.setModel(detalle);
            txt_sub.setText(formato.format(subtotal()));
            txt_igv.setText(formato.format(igv()));
            txt_tot.setText(formato.format(total()));
            btn_reg.setEnabled(true);
////        }
    }
    
    private void btn_caActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caActionPerformed
        Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Cantidad"));
        t_detalle.setValueAt(cantidad, i, 3);
        txt_sub.setText(formato.format(subtotal()));
        txt_igv.setText(formato.format(igv()));
        txt_tot.setText(formato.format(total()));

    }//GEN-LAST:event_btn_caActionPerformed

    private void btn_vaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vaActionPerformed
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Precio"));
        t_detalle.setValueAt(precio, i, 5);
        txt_sub.setText(formato.format(subtotal()));
        txt_igv.setText(formato.format(igv()));
        txt_tot.setText(formato.format(total()));
    }//GEN-LAST:event_btn_vaActionPerformed

    private void btn_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elActionPerformed
        detalle.removeRow(i);
        txt_sub.setText(formato.format(subtotal()));
        txt_igv.setText(formato.format(igv()));
        txt_tot.setText(formato.format(total()));
    }//GEN-LAST:event_btn_elActionPerformed

    private void t_detalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_detalleMouseClicked
        i = t_detalle.getSelectedRow();
        btn_ca.setEnabled(true);
        btn_va.setEnabled(true);
        btn_el.setEnabled(true);
        t_detalle.setFocusable(true);
    }//GEN-LAST:event_t_detalleMouseClicked

    private void t_detalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_detalleKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_PLUS) {
            btn_ca.doClick();
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_sub.setText(formato.format(subtotal()));
            txt_igv.setText(formato.format(igv()));
            txt_tot.setText(formato.format(total()));
            txt_idp.requestFocus();
        }

        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            i = t_detalle.getSelectedRow();
            detalle.removeRow(i);
            txt_sub.setText(formato.format(subtotal()));
            txt_igv.setText(formato.format(igv()));
            txt_tot.setText(formato.format(total()));
        }
    }//GEN-LAST:event_t_detalleKeyPressed

    private void llenar() {
        compra.setFechaDoc(txt_fec_com.getDate());
        compra.setFechaPago(txt_fec_pag.getDate());
        tido.setIdTipoDoc(cbx_tido.getSelectedIndex() + 1);
        compra.setSerie(Integer.parseInt(txt_ser.getText()));
        compra.setNroDoc(Integer.parseInt(txt_nro.getText()));
        pro.setRuc(txt_ruc.getText());
        pro.setRazonSocial(txt_raz.getText());
        compra.setEstado("" + (cbx_tipa.getSelectedIndex() + 1));
        alm.setIdAlmacen(cbx_alm.getSelectedIndex() + 1);
        emp.setRuc(txt_ruc_dest.getText());
        compra.setTotal(new BigDecimal(total()));
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        compra.setRucPro(pro.getRuc());
        compra.setIdTipoDoc(tido);
        compra.setNick(frm_menu.lbl_user.getText());
        compra.setIdAlmacen(alm.getIdAlmacen());
        compra.setRuc(emp.getRuc());
        compra.setTipoCompra('P');
        EntityManager em=JPA.getInstance().getEntityManager(true);
        em.persist(compra);
        //Contar filas de tabla
        int filas=t_detalle.getRowCount();
        //Recorrer filas de tabla
        for(int j=0;j<=(filas-1);j++){
            CompraDetalle compraDetalle=new CompraDetalle(compra.getIdCompra(),XUtil.intValue(t_detalle.getValueAt(j, 0)));
            compraDetalle.setCantCompra(new BigDecimal(t_detalle.getValueAt(j, 3).toString()));
            compraDetalle.setPrecioCompra(new BigDecimal(t_detalle.getValueAt(j, 3).toString()));
            em.persist(compraDetalle);
            //Registrar Movimiento en kardex
            /*art=em.find(Articulo.class,compraDetalle.getCompraDetallePK().getIdArticulo());
            Kardex kardex=new Kardex();
            kardex.setArticulo(art);
            kardex.setIdAlmacen(alm);
            kardex.setCantIng(compraDetalle.getCantCompra());
            kardex.setPreUniIng(compraDetalle.getPrecioCompra());
            kardex.setIdTipoDoc(tido);
            kardex.setRucPro(pro.getRuc());
            kardex.setNombre(pro.getRazonSocial());
            kardex.setIdTipoMov(em.find(TipoMovimiento.class,2));
            em.persist(kardex);
            //Ver Cantidad actual de Material
            //Actualizando cantidad actual de material
            art.setCantActual(art.getCantActual().add(compraDetalle.getCantCompra()));
            em.merge(art);
            //Verificar producto en almacen
            AlmacenArticulo almacenArticulo=em.find(AlmacenArticulo.class,new AlmacenArticuloPK(art.getIdArticulo(),alm.getIdAlmacen()));
            if(almacenArticulo==null){
                almacenArticulo=new AlmacenArticulo();
                almacenArticulo.setCantidad(compraDetalle.getCantCompra());
            }else{
                almacenArticulo.setCantidad(almacenArticulo.getCantidad().add(compraDetalle.getCantCompra()));
            }
            almacenArticulo.setPrecio(compraDetalle.getPrecioCompra());
            if(almacenArticulo.getAlmacenArticuloPK()==null){
                almacenArticulo.setAlmacenArticuloPK(new AlmacenArticuloPK(art.getIdArticulo(),alm.getIdAlmacen()));
                em.persist(almacenArticulo);
            }else
                em.merge(almacenArticulo);
        }
        //registrar en movimientos. 
        if (cbx_tipa.getSelectedItem().equals("CONTADO")) {
            String glosa = "COMPRA ARTICULOS - " + cbx_tido.getSelectedItem().toString() + " / " + compra.getSerie() + " - " + compra.getNumero() + " - " + pro.getRuc();
            Movimiento movimiento=new Movimiento();
            movimiento.setGlosa(glosa);
            movimiento.setFecMov(compra.getFechaDoc());
            movimiento.setEgreso(compra.getTotal());
            movimiento.setNick(X.getUser());
            movimiento.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
            movimiento.setFlag("C");
//            m.setidCAja();
            em.persist(movimiento);
        }
        JPA.getInstance().close();
        ven.open(new frm_ver_compras_articulo());
        this.close();
    }//GEN-LAST:event_btn_regActionPerformed

    private void txt_rucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyTyped
        if (txt_ruc.getText().length() == 11) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_rucKeyTyped

    private void txt_serKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_serKeyTyped

    private void txt_nroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nroKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nroKeyTyped

    private void txt_idpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idpKeyTyped
//        char car = evt.getKeyChar();
//        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txt_idpKeyTyped

    private void cbx_tipaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_tipaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cbx_tido.setEnabled(true);
            cbx_tido.requestFocus();
        }
    }//GEN-LAST:event_cbx_tipaKeyPressed

    private void btn_bus_empActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bus_empActionPerformed
        ven.open(new frm_reg_empresa());
    }//GEN-LAST:event_btn_bus_empActionPerformed

    public static Double subtotal() {
        int totalRow = t_detalle.getRowCount();
        double suma_sub = 0.00;
        for (int i = 0; i < totalRow; i++) {
            suma_sub += Double.parseDouble(String.valueOf(t_detalle.getValueAt(i, 5))) * Double.parseDouble(String.valueOf(t_detalle.getValueAt(i, 3))) / 1.18;

        }
        return suma_sub;
    }

    public static Double igv() {
        Double igv = 0.00;
        igv = subtotal() * 0.18;
        return igv;
    }

    public static Double total() {
        double total = 0.00;
        total = subtotal() + igv();
        return total;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_bus_emp;
    private javax.swing.JButton btn_busm;
    private javax.swing.JButton btn_busp;
    private javax.swing.JButton btn_ca;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_el;
    public static javax.swing.JButton btn_reg;
    private javax.swing.JButton btn_va;
    private org.jsuns.swing.XComboBox cbx_alm;
    private org.jsuns.swing.XComboBox cbx_tido;
    private javax.swing.JComboBox cbx_tipa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_detalle;
    private javax.swing.JTextField txt_desp;
    private javax.swing.JTextField txt_dir;
    private org.jsuns.swing.XDateField txt_fec_com;
    private org.jsuns.swing.XDateField txt_fec_pag;
    private javax.swing.JTextField txt_idp;
    public static javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_nro;
    private javax.swing.JTextField txt_raz;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_ruc_dest;
    private javax.swing.JTextField txt_ser;
    public static javax.swing.JTextField txt_sub;
    public static javax.swing.JTextField txt_tot;
    // End of variables declaration//GEN-END:variables
*/
   
}
