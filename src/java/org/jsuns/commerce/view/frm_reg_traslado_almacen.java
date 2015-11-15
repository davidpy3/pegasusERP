package org.jsuns.commerce.view;

//import org.jsuns.commerce.jpa.Articulo;
import org.jsuns.commerce.jpa.TipoDocumento;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.commerce.AlmacenService;
import org.jsuns.commerce.TipoDocumentoService;
import org.jsuns.swing.XPanel;
import org.jsuns.commerce.jpa.TipoMovimiento;
import org.jsuns.commerce.jpa.Traslado;
import org.jsuns.commerce.jpa.TrasladoArticulo;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;
import org.jsuns.util.XUtil;

public class frm_reg_traslado_almacen extends XPanel
 {
/*
    private Traslado traslado = new Traslado();
//    private Articulo pro = new Articulo();
    private TipoDocumento tido = new TipoDocumento();
    public static DefaultTableModel detalle;
    private int idRequerimiento = 0;
    private int idtras = 0;
    private String accion = "traslado";
    private Integer i;

    private FindSelectionListener findSelectionListener;

    public FindSelectionListener getFindSelectionListener() {
        return findSelectionListener;
    }

    public void setFindSelectionListener(FindSelectionListener findSelectionListener) {
        this.findSelectionListener = findSelectionListener;
    }

    public frm_reg_traslado_almacen() {
        initComponents();
        txt_fec.setDate(new Date());
//        ver_almacen(almacen);
        cbx_alm_or.setSelectedItem(frm_menu.almacen);
        detalle = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna < 5) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        detalle.addColumn("Id");
        detalle.addColumn("Descripcion");
        detalle.addColumn("Marca");
        detalle.addColumn("Cant.");
        detalle.addColumn("Und. Med");
        detalle.addColumn("Cant. Rec.");
        t_detalle.setModel(detalle);
        t_detalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        t_detalle.getColumnModel().getColumn(1).setPreferredWidth(350);
        t_detalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        t_detalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        t_detalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        t_detalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        detalle.fireTableDataChanged();
        cbx_alm_or.requestFocus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbx_alm_de = new javax.swing.JComboBox();
        btn_add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_detalle = new javax.swing.JTable();
        btn_cc = new javax.swing.JButton();
        btn_el = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_ser = new javax.swing.JTextField();
        txt_num = new javax.swing.JTextField();
        chk_emitir = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_brev = new javax.swing.JTextField();
        txt_cons = new javax.swing.JTextField();
        txt_chofer = new javax.swing.JTextField();
        txt_raz_alm = new javax.swing.JTextField();
        txt_ruc_alm = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_ruc_tra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_raz_tra = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        txt_fec = new org.jsuns.swing.XDateField();
        cbx_alm_or = new org.jsuns.swing.XComboBox();

        setMaximumSize(new java.awt.Dimension(800, 600));
        setTitle("Traslado entre Almacenes");

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Opciones:");

        jLabel2.setText("Almacen Origen");

        jLabel3.setText("Almacen Destino");

        jLabel4.setText("Fecha");

        cbx_alm_de.setEditable(true);
        cbx_alm_de.setEnabled(false);
        cbx_alm_de.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_alm_deActionPerformed(evt);
            }
        });
        cbx_alm_de.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbx_alm_deKeyPressed(evt);
            }
        });

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delivery.png"))); // NOI18N
        btn_add.setText("Agregar Productos");
        btn_add.setEnabled(false);
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

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
        t_detalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_detalleMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_detalle);

        btn_cc.setText("+/-");
        btn_cc.setEnabled(false);
        btn_cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ccActionPerformed(evt);
            }
        });

        btn_el.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bin_closed.png"))); // NOI18N
        btn_el.setText("Eliminar");
        btn_el.setEnabled(false);
        btn_el.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_elActionPerformed(evt);
            }
        });

        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/printer.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setEnabled(false);
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        jLabel8.setText("Serie:");

        jLabel9.setText("Numero:");

        txt_ser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_ser.setText("0");
        txt_ser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_serKeyPressed(evt);
            }
        });

        txt_num.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_num.setText("0");

        chk_emitir.setText("Emitir Guia de Remision");
        chk_emitir.setFocusable(false);
        chk_emitir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_emitirActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Datos de la Unidad de Transporte:");

        jLabel10.setText("Brevete");

        jLabel11.setText("Nro. Constancia Insc.");

        jLabel12.setText("Nombres y Apellidos:");

        txt_brev.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_brevKeyPressed(evt);
            }
        });

        txt_cons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_consKeyPressed(evt);
            }
        });

        txt_ruc_alm.setEditable(false);

        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Datos del Transportista:");

        txt_ruc_tra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ruc_traKeyPressed(evt);
            }
        });

        jLabel13.setText("RUC:");

        txt_raz_tra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_raz_traKeyPressed(evt);
            }
        });

        jLabel14.setText("Raz. Social:");

        jLabel15.setText("Marca:");

        txt_marca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_marcaKeyPressed(evt);
            }
        });

        jLabel16.setText("Nro. Placa:");

        txt_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_placaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chk_emitir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_cc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_el)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_reg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_cer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_add))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_brev, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_chofer))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbx_alm_or, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(24, 24, 24)
                                        .addComponent(cbx_alm_de, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_ruc_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_raz_alm)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ruc_tra, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_raz_tra)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_emitir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_ser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_alm_de, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbx_alm_or, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raz_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ruc_alm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fec, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ruc_tra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_raz_tra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_brev, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cons, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_chofer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_el, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        accion = "";
        this.close();

    }//GEN-LAST:event_btn_cerActionPerformed

    private void chk_emitirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_emitirActionPerformed
        if (chk_emitir.isSelected()) {
            int idalm = frm_menu.almacen.getIdAlmacen();
            int idtido = 4;
            txt_ser.setText("" + tds.ver_ser(idtido, idalm));
            txt_ser.setEditable(true);
            txt_num.setText("" + tds.ver_num(idtido, idalm));
            txt_num.setEditable(true);
            txt_ruc_tra.setEditable(true);
            txt_ruc_tra.requestFocus();
        } else {
            txt_ser.setEditable(false);
            txt_ser.setText("0");
            txt_num.setEditable(false);
            txt_num.setText("0");
        }
    }//GEN-LAST:event_chk_emitirActionPerformed

    private void cbx_alm_deActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_alm_deActionPerformed

    }//GEN-LAST:event_cbx_alm_deActionPerformed

    private void txt_serKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_serKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_num.setEditable(true);
            txt_num.requestFocus();
        }
    }//GEN-LAST:event_txt_serKeyPressed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        frm_ver_prod_alm prod_alm = new frm_ver_prod_alm();
        Object ida = cbx_alm_or.getSelectedIndex() + 1;
        prod_alm.setAlmacen(ida);
        prod_alm.setFindSelectionListener(this);
        prod_alm.retrieve();
        Cl_Varios.open(prod_alm);
    }//GEN-LAST:event_btn_addActionPerformed

    private void t_detalleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_detalleMousePressed
        i = t_detalle.getSelectedRow();
        if (accion.equals("traslado")) {
            btn_el.setEnabled(true);
            btn_cc.setEnabled(true);
        }
    }//GEN-LAST:event_t_detalleMousePressed

    private void btn_elActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_elActionPerformed
        detalle.removeRow(i);
    }//GEN-LAST:event_btn_elActionPerformed

    private void btn_ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ccActionPerformed
        Double cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese Cantidad"));
        t_detalle.setValueAt(cantidad, i, 3);
    }//GEN-LAST:event_btn_ccActionPerformed

    private void llenar() {
        traslado.setFecha(txt_fec.getDate());
        traslado.setMotivo("TRASLADO");

        Integer id = cbx_alm_or.getSelectedIndex() + 1;

        String ver_dir = "select dir_alm from almacen where idAlmacen='" + id + "'";

//            if (rs.next()) {
//                traslado.setOrigen(rs.getString("dir_alm"));
//            }
        id = cbx_alm_de.getSelectedIndex() + 1;

        ver_dir = "select dir_alm from almacen where idAlmacen='" + id + "'";

//            if (rs.next()) {
//                traslado.setDestino(rs.getString("dir_alm"));
//            }
//       
        traslado.setSerie(Integer.parseInt(txt_ser.getText()));
        traslado.setNumero(Integer.parseInt(txt_num.getText()));
        traslado.setBrevete(txt_brev.getText());
        traslado.setRucTrans(txt_ruc_tra.getText());
        traslado.setRazTrans(txt_raz_tra.getText());
        traslado.setChofer(txt_chofer.getText());
        traslado.setConstancia(txt_cons.getText());
        traslado.setMarcaVeh(txt_marca.getText());
        traslado.setPlacaVeh(txt_placa.getText());
    }

    private TipoDocumentoService tds = new TipoDocumentoService();

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        Integer alm_or = cbx_alm_or.getSelectedIndex() + 1;
        Integer alm_de = cbx_alm_de.getSelectedIndex() + 1;
        Double cant_act = 0.00;
        Double nueva_cant = 0.00;
        String dir = "";
        Almacen destino = null;
        if (accion.equals("traslado")) {
            EntityManager em = JPA.getInstance().getEntityManager(true);
            destino = (Almacen) cbx_alm_de.getSelectedItem();
            if (chk_emitir.isSelected()) {
                int ser, nro, alm, doc;
                ser = Integer.parseInt(txt_ser.getText());
                nro = Integer.parseInt(txt_num.getText());
                alm = frm_menu.almacen.getIdAlmacen();
                doc = 4;
                tds.act_doc(ser, nro + 1, alm, doc);
            }
            traslado.setNick(X.getUser());
            traslado.setRucDest(XUtil.intValue(destino.getRuc()));
            traslado.setRazSocDest(destino.getRazonSocial());
            em.persist(traslado);
            if (idRequerimiento != 0) {
                Requerimiento requerimiento = em.find(Requerimiento.class, idRequerimiento);
                requerimiento.setFecEnv(traslado.getFecha());
                requerimiento.setEstado('1');
                em.merge(requerimiento);
            }
            Integer filas = t_detalle.getRowCount();
            for (int x = 0; x <= (filas - 1); x++) {
                /*pro.setIdArticulo(Integer.parseInt(t_detalle.getValueAt(x, 0).toString()));
//                pro.setCan(Double.parseDouble(t_detalle.getValueAt(x, 3).toString()));
                String ver_pro_alm = "select costo_compra from productos where idProductos = '" + pro.getIdArticulo() + "'";
//                    if (rs.next()) {
////                        pro.setCos_pro(rs.getDouble("costo_compra"));
//                    }
                //registrar detalle de traslado
                TrasladoArticulo trasladoArticulo = new TrasladoArticulo(traslado.getIdTraslado(), pro.getIdArticulo());
                trasladoArticulo.setCantidad(pro.getCantActual());
                em.persist(trasladoArticulo);
                //registrar retiro de primer almacen (actualizar cantidades)

                ver_pro_alm = "select cant from producto_almacen "
                        + "where "
                        + "idAlmacen = '" + alm_or + "' "
                        + "and idProductos= '" + pro.getIdArticulo() + "'";

//                    if (rs.next()) {
//                        cant_act = rs.getDouble("cant");
//                    } else {
//                        cant_act = 0.0;
//                    }
//                nueva_cant = cant_act - pro.getCantActual();
                String act_pro_alm = "Update producto_almacen "
                        + "set cant = '" + nueva_cant + "' where "
                        + "idAlmacen = '" + alm_or
                        + "' and idProductos= '" + pro.getIdArticulo() + "'";

                Kardex kardex = new Kardex();
                kardex.setFecha(traslado.getFecha());
                kardex.setArticulo(pro);
                kardex.setCantSal(pro.getCantActual());
                kardex.setPreUniSal(pro.getCostoCompra());
                kardex.setSerie(traslado.getSerie());
                kardex.setNumero(traslado.getNumero());
                kardex.setIdTipoDoc(em.find(TipoDocumento.class, 4));
                kardex.setIdAlmacen(em.find(Almacen.class, alm_or));
                kardex.setRucPro(destino.getRuc());
                kardex.setNombre(destino.getRazonSocial());
                kardex.setIdTipoMov(em.find(TipoMovimiento.class, 11));
                em.persist(kardex);
            }
            JPA.getInstance().close();
            findSelectionListener.valueChanged(
                    new FindSelectionEvent(traslado, null, 0));
        } else if (accion.equals("compruebat")) {
            EntityManager em = JPA.getInstance().getEntityManager(true);
            int idalma = cbx_alm_de.getSelectedIndex() + 1;
            String ver_emp = "select * from almacen where idAlmacen = '" + idalma + "'";
//                if (rs.next()) {
//                    ruc = rs.getString("ruc");
//                    raz = rs.getString("raz_soc");
//                    dir = rs.getString("dir_alm");
//                }
            Integer filas = t_detalle.getRowCount();
            for (int x = 0; x <= (filas - 1); x++) {
                pro.setIdArticulo(Integer.parseInt(t_detalle.getValueAt(x, 0).toString()));
//              pro.setCan(Double.parseDouble(t_detalle.getValueAt(x, 5).toString()));
                System.out.println(pro.getCantActual() + " - id " + pro.getIdArticulo());
                try {
                    String ver_pre = "select precio_venta from Productos "
                            + "where idProductos  = '" + pro.getIdArticulo() + "'";
//                    if (rs1.next()) {
////                        pro.setCos_pro(rs1.getDouble("precio_venta"));
//                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                //registrar ingreso al segundo almacen (actualizar cantidades)
                String ver_pro_alm = "select cant from producto_almacen where idAlmacen = '" + alm_de + "' and idProductos= '" + pro.getIdArticulo() + "'";
//                    if (rs.next()) {
//                        cant_act = rs.getDouble("cant");
////                        nueva_cant = cant_act + pro.getCantActual();
//                            String act_pro_alm = "Update producto_almacen set cant = '" + nueva_cant + "' where idAlmacen = '" + alm_de + "' and idProductos= '" + pro.getIdArticulo() + "'";
//                    } else {
//                        cant_act = 0.0;
////                        nueva_cant = cant_act + pro.getCantActual();
//                        try {
//                           
//                            String ins_pro_alm = "insert into producto_almacen Values ('" + pro.getIdArticulo() + "', '" + alm_de + "', '" + nueva_cant + "', '" + pro.getCostoCompra() + "')";
//                    }
                Kardex kardex = new Kardex();
                kardex.setFecha(traslado.getFecha());
                kardex.setArticulo(pro);
                kardex.setCantIng(pro.getCantActual());
                kardex.setPreUniIng(pro.getCostoCompra());
                kardex.setSerie(traslado.getSerie());
                kardex.setNumero(traslado.getNumero());
                kardex.setIdTipoDoc(em.find(TipoDocumento.class, 4));
                kardex.setIdAlmacen(em.find(Almacen.class, alm_de));
                kardex.setRucPro(destino.getRuc());
                kardex.setNombre(destino.getRazonSocial());
                kardex.setIdTipoMov(em.find(TipoMovimiento.class, 11));
                em.persist(kardex);
            }
            Traslado traslado = em.find(Traslado.class, idtras);
            traslado.setEstado('1');
            em.merge(traslado);
            JPA.getInstance().close();
        }
        accion = "";
        this.close();
    }//GEN-LAST:event_btn_regActionPerformed

    private void cbx_alm_deKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbx_alm_deKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int idalm = cbx_alm_de.getSelectedIndex() + 1;

                String ver_alm = "select ruc, raz_soc from almacen where idAlmacen = '" + idalm + "'";

//                if (rs.next()) {
//                    txt_ruc_alm.setText(rs.getString("ruc"));
//                    txt_raz_alm.setText(rs.getString("raz_soc"));
//                    txt_fec.setEditable(true);
//                    txt_fec.requestFocus();
//                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_cbx_alm_deKeyPressed

    private void txt_ruc_traKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ruc_traKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_raz_tra.setEditable(true);
            txt_raz_tra.requestFocus();
        }
    }//GEN-LAST:event_txt_ruc_traKeyPressed

    private void txt_raz_traKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_raz_traKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_marca.setEditable(true);
            txt_marca.requestFocus();
        }
    }//GEN-LAST:event_txt_raz_traKeyPressed

    private void txt_marcaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_marcaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_placa.setEditable(true);
            txt_placa.requestFocus();
        }
    }//GEN-LAST:event_txt_marcaKeyPressed

    private void txt_placaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_brev.setEditable(true);
            txt_brev.requestFocus();
        }
    }//GEN-LAST:event_txt_placaKeyPressed

    private void txt_brevKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_brevKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_cons.setEditable(true);
            txt_cons.requestFocus();
        }
    }//GEN-LAST:event_txt_brevKeyPressed

    private void txt_consKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_consKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_chofer.setEditable(true);
            txt_chofer.requestFocus();
        }
    }//GEN-LAST:event_txt_consKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_cc;
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_el;
    public static javax.swing.JButton btn_reg;
    public static javax.swing.JComboBox cbx_alm_de;
    private org.jsuns.swing.XComboBox cbx_alm_or;
    public static javax.swing.JCheckBox chk_emitir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable t_detalle;
    public static javax.swing.JTextField txt_brev;
    public static javax.swing.JTextField txt_chofer;
    public static javax.swing.JTextField txt_cons;
    public org.jsuns.swing.XDateField txt_fec;
    private javax.swing.JTextField txt_marca;
    public static javax.swing.JTextField txt_num;
    public static javax.swing.JTextField txt_placa;
    public static javax.swing.JTextField txt_raz_alm;
    public static javax.swing.JTextField txt_raz_tra;
    public static javax.swing.JTextField txt_ruc_alm;
    public static javax.swing.JTextField txt_ruc_tra;
    public static javax.swing.JTextField txt_ser;
    // End of variables declaration//GEN-END:variables

    public void setRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
//        int idalm = Integer.parseInt(txt_id_ori.getText());
//        cbx_alm_or.setEnabled(false);
//        cbx_alm_or.setSelectedIndex(Integer.parseInt(txt_id_des.getText()) - 1);
//        cbx_alm_de.setEnabled(false);
//        cbx_alm_de.setSelectedIndex(Integer.parseInt(txt_id_ori.getText()) - 1);
//        System.out.println(idalm);
//        try {
//            
//            String ver_alm = "select ruc, raz_soc "
//                    + "from Almacen where idAlmacen = '" + idalm + "'";
//       
////            if (rs.next()) {
////                traslado.txt_ruc_alm.setText(rs.getString("ruc"));
////                traslado.txt_raz_alm.setText(rs.getString("raz_soc"));
////            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        idRequerimiento = idsol;
//        txt_fec.setEditable(true);
//        txt_fec.requestFocus();
//
//        int filas_tabla = t_solicitud.getRowCount();
//        for (int j = 0; j < filas_tabla; j++) {
//            if (Integer.parseInt(t_solicitud.getValueAt(j, 5).toString()) != 0) {
//                Object[] fila = new Object[5];
//                fila[0] = t_solicitud.getValueAt(j, 0);
//                fila[1] = t_solicitud.getValueAt(j, 1);
//                fila[2] = t_solicitud.getValueAt(j, 2);
//                fila[3] = t_solicitud.getValueAt(j, 5);
//                fila[4] = t_solicitud.getValueAt(j, 4);
//                detalle.addRow(fila);
//            }
//        }
//        t_detalle.setModel(traslado.detalle);
//        btn_reg.setEnabled(true);
    }

    @Override
    public void valueChanged(FindSelectionEvent evt) {

    }
    private AlmacenService as = new AlmacenService();

    public void setTraslado(Object traslado) {
        Traslado t = JPA.getInstance().getEntityManager().find(Traslado.class, XUtil.intValue(traslado));
        idtras = t.getIdTraslado();
        cbx_alm_or.setEnabled(false);
        chk_emitir.setEnabled(false);
        txt_fec.setEnabled(false);
        txt_fec.setDate(t.getFecha());
        cbx_alm_or.setSelectedIndex(
                as.id_alm_dir(t.getOrigen()) - 1);
        cbx_alm_de.setSelectedIndex(as.id_alm_dir(t.getDestino()) - 1);
        txt_ser.setText(t.getSerie().toString());
        txt_num.setText(t.getNumero().toString());
        txt_ruc_tra.setText(t.getRazTrans());
        txt_raz_tra.setText(t.getRazTrans());
        txt_marca.setText(t.getMarcaVeh());
        txt_placa.setText(t.getPlacaVeh());
        txt_brev.setText(t.getBrevete());
        txt_cons.setText(t.getConstancia());
        txt_chofer.setText(t.getChofer());
        txt_ruc_alm.setText(t.getRucDest().toString());
        txt_raz_alm.setText(t.getRazSocDest());
        llenar_tguias(t);
        JPA.getInstance().close();
        accion = "compruebat";
        btn_reg.setEnabled(true);
    }

    private void llenar_tguias(Object idtra) {
        while (detalle.getRowCount() > 0) {
            detalle.removeRow(0);
        }
        Traslado t = (Traslado) idtra;
        for (TrasladoArticulo ta : t.getTrasladoArticuloCollection()) {
            Object[] fila = new Object[5];
            /*Articulo a = ta.getArticulo();
            fila[0] = a.getIdArticulo();
            fila[1] = a.getDescripcion() + " " + a.getModelo() + " " + a.getSerie();
            fila[2] = a.getMarca();
            fila[3] = ta.getCant();
            fila[4] = a.getUmedida().getUnidad();
            detalle.addRow(fila);
        }
        detalle.fireTableDataChanged();
    }
    */
}
