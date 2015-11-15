package org.jsuns.commerce.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.util.XDate;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;
import org.jsuns.swing.finder.FindSelectionListener;

public class frm_movimientos extends XPanel implements FindSelectionListener {

    /*Cl_Varios ven = new Cl_Varios();
    Movimiento mov = new Movimiento();*/
    DefaultTableModel mostrar;
    double suma_ingc;
    double suma_salc;
    double suma_ingb;
    double suma_salb;
    public static String ventana = "movimientos";
    Date fecha;
    DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
    DecimalFormat formato = null;

    /**
     * Creates new form frm_movimientos
     */
    public frm_movimientos() {
        //initComponents();
        simbolo.setDecimalSeparator('.');
        formato = new DecimalFormat("####0.00", simbolo);

        mostrar = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        mostrar.addColumn("Ori / Dest");
        mostrar.addColumn("Descripcion");
        mostrar.addColumn("Fecha");
        mostrar.addColumn("Ingreso");
        mostrar.addColumn("Salida");

        /*fecha = ven.getFechaActual();
        Object[] caja = new Object[5];
        caja[0] = "CAJA";
        caja[1] = "SALDO ANTERIOR DE CAJA";
        caja[2] = ven.getFechaActual();
        caja[3] = formato.format(sal_ant());
        caja[4] = "0.00";
        mostrar.addRow(caja);*/

        retrieve();

        sumar_ing_caja();
        sumar_sal_caja();
        /*Double totalc;
        Double totalb;
        totalc = suma_ingc - suma_salc;
        totalb = suma_ingb - suma_salb;
        txt_tot.setText(formato.format(totalc));
        txt_totb.setText(formato.format(totalb));

        t_movimientos.getColumnModel().getColumn(0).setPreferredWidth(80);
        t_movimientos.getColumnModel().getColumn(1).setPreferredWidth(500);
        t_movimientos.getColumnModel().getColumn(2).setPreferredWidth(80);
        t_movimientos.getColumnModel().getColumn(3).setPreferredWidth(70);
        t_movimientos.getColumnModel().getColumn(4).setPreferredWidth(70);
       *//* ven.centrar_celda(t_movimientos, 2);
        ven.derecha_celda(t_movimientos, 3);
        ven.derecha_celda(t_movimientos, 4);
        mostrar.fireTableDataChanged();
        t_movimientos.updateUI();*/

    }

    private double sal_ant() {
        double sal = 0;
       /*try {

            String ver_sal = "select monto from caja where idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "'";

//            if (rs.next()) {
//                sal = rs.getDouble("monto");
//            }
        } catch (Exception e) {
            System.out.println(e);
        }*/
        return sal;
    }

    private void retrieve() {
        /*String query = "select * from movimiento where fec_mov = '" + fecha + "' and"
                + " idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "' order by idMovimiento asc";

        query = "select * from movimiento where fec_mov = '" + XDate.getSQLDate(fecha) + "' and"
                + " idAlmacen = '" + frm_menu.almacen.getIdAlmacen() + "' order by idMovimiento asc";
*/
            //Creando las filas para el JTable
//            while (rs.next()) {
//                Object[] fila = new Object[5];
//                if (rs.getString("destino").equals("C")) {
//                    fila[0] = "CAJA";
//                } else {
//                    fila[0] = "BANCO";
//                }
//                fila[1] = rs.getObject("glosa");
//                fila[2] =rs.getDate("fec_mov");
//                fila[3] = rs.getObject("entrada");
//                fila[4] = rs.getObject("salida");
//                mostrar.addRow(fila);
//            }
       // t_movimientos.setModel(mostrar);

    }

    private void sumar_ing_caja() {
        /*int tot_filas_caja = t_movimientos.getRowCount();
        suma_ingc = 0.00;
        suma_ingb = 0.00;
        for (int x = 0; x < tot_filas_caja; x++) {
            if (t_movimientos.getValueAt(x, 0).equals("CAJA")) {
                suma_ingc += Double.parseDouble(t_movimientos.getValueAt(x, 3).toString());
            } else {
                suma_ingb += Double.parseDouble(t_movimientos.getValueAt(x, 3).toString());
            }
        }
        txt_ing.setText(formato.format(suma_ingc));
        txt_ingb.setText(formato.format(suma_ingb));*/
    }

    private void sumar_sal_caja() {
        /*int tot_filas_caja = t_movimientos.getRowCount();
        suma_salc = 0.00;
        suma_salb = 0.00;
        for (int x = 0; x < tot_filas_caja; x++) {
            if (t_movimientos.getValueAt(x, 0).equals("CAJA")) {
                suma_salc += Double.parseDouble(t_movimientos.getValueAt(x, 4).toString());
            } else {
                suma_salb += Double.parseDouble(t_movimientos.getValueAt(x, 4).toString());
            }
        }
        txt_sal.setText(formato.format(suma_salc));
        txt_salb.setText(formato.format(suma_salb));*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *//*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_movimientos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_dni = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        btn_reg = new javax.swing.JButton();
        btn_buse = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbt_sal = new javax.swing.JRadioButton();
        rbt_ing = new javax.swing.JRadioButton();
        rbt_ini = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        btn_rep_caja = new javax.swing.JButton();
        btn_rep_banco = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_mot = new javax.swing.JTextField();
        txt_ing = new javax.swing.JTextField();
        txt_sal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_tot = new javax.swing.JTextField();
        txt_salb = new javax.swing.JTextField();
        txt_ingb = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_totb = new javax.swing.JTextField();
        txt_fecha = new org.jsuns.swing.XDateField();

        setTitle("Movimientos");

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_movimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "LUIS OYANGUREN GIRON", "COMPRA DE FILTROS", "2014-11-09", "0.00", "135.00"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id.", "Usuario", "Descripcion", "Fecha", "Ingreso", "Salida"
            }
        ));
        jScrollPane1.setViewportView(t_movimientos);
        if (t_movimientos.getColumnModel().getColumnCount() > 0) {
            t_movimientos.getColumnModel().getColumn(0).setPreferredWidth(10);
            t_movimientos.getColumnModel().getColumn(1).setPreferredWidth(40);
            t_movimientos.getColumnModel().getColumn(2).setPreferredWidth(180);
            t_movimientos.getColumnModel().getColumn(3).setPreferredWidth(40);
            t_movimientos.getColumnModel().getColumn(4).setPreferredWidth(30);
            t_movimientos.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        jLabel1.setText("Seleccionar Empleado");

        txt_dni.setEditable(false);

        txt_nom.setEditable(false);

        jLabel2.setText("Seleccionar Operacion:");

        jLabel3.setForeground(new java.awt.Color(212, 2, 2));
        jLabel3.setText("Monto:");

        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_montoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_reg.setText("Aceptar");
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

        btn_buse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/find.png"))); // NOI18N
        btn_buse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buseActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        buttonGroup1.add(rbt_sal);
        rbt_sal.setText("Registrar Salida de Dinero");
        rbt_sal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_salActionPerformed(evt);
            }
        });
        jPanel1.add(rbt_sal);

        buttonGroup1.add(rbt_ing);
        rbt_ing.setText("Registrar Ingreso de Dinero");
        rbt_ing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_ingActionPerformed(evt);
            }
        });
        jPanel1.add(rbt_ing);

        buttonGroup1.add(rbt_ini);
        rbt_ini.setText("Iniciar Caja Chica");
        rbt_ini.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbt_iniActionPerformed(evt);
            }
        });
        jPanel1.add(rbt_ini);

        jLabel4.setForeground(new java.awt.Color(212, 2, 2));
        jLabel4.setText("Fecha");

        btn_rep_caja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard_text.png"))); // NOI18N
        btn_rep_caja.setText("Imprimir Reporte Caja");
        btn_rep_caja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rep_cajaActionPerformed(evt);
            }
        });

        btn_rep_banco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard_text.png"))); // NOI18N
        btn_rep_banco.setText("Imprimir Reporte Bancos");
        btn_rep_banco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rep_bancoActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(212, 2, 2));
        jLabel5.setText("Total Ingresos CAJA");

        jLabel6.setForeground(new java.awt.Color(212, 2, 2));
        jLabel6.setText("Total Salidas CAJA");

        jLabel7.setText("Motivo:");

        txt_mot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_motKeyPressed(evt);
            }
        });

        txt_ing.setEditable(false);
        txt_ing.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txt_sal.setEditable(false);
        txt_sal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel8.setForeground(new java.awt.Color(212, 2, 2));
        jLabel8.setText("Total CAJA");

        txt_tot.setEditable(false);
        txt_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txt_salb.setEditable(false);
        txt_salb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txt_ingb.setEditable(false);
        txt_ingb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel9.setForeground(new java.awt.Color(212, 2, 2));
        jLabel9.setText("Total BANCO");

        jLabel10.setForeground(new java.awt.Color(212, 2, 2));
        jLabel10.setText("Total Salidas BANCO");

        jLabel11.setForeground(new java.awt.Color(212, 2, 2));
        jLabel11.setText("Total Ingresos BANCO");

        txt_totb.setEditable(false);
        txt_totb.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_rep_caja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_rep_banco)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txt_mot))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_buse))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_monto)
                                    .addComponent(txt_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txt_ing, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_ingb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_salb, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_totb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_reg)
                        .addGap(12, 12, 12)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(112, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(433, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btn_buse, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_monto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_mot, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ing, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ingb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_salb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_rep_caja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rep_banco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(52, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(383, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
*/
    private void rbt_ingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_ingActionPerformed
       /* txt_monto.setEditable(false);
        txt_mot.setText("");
        txt_mot.setEditable(true);
        txt_mot.requestFocus();*/

    }//GEN-LAST:event_rbt_ingActionPerformed

    private void rbt_iniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_iniActionPerformed
        /*txt_mot.setText("MONTO INICIAL DE CAJA CHICA");
        txt_mot.setEditable(false);
        txt_monto.setEditable(true);
        txt_monto.requestFocus();*/
    }//GEN-LAST:event_rbt_iniActionPerformed

    private void rbt_salActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbt_salActionPerformed
        /*txt_monto.setEditable(false);
        txt_mot.setText("");
        txt_mot.setEditable(true);
        txt_mot.requestFocus();*/
    }//GEN-LAST:event_rbt_salActionPerformed

    private void btn_buseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buseActionPerformed
        /*frm_ver_empleado frm_ver_empleado = new frm_ver_empleado();
        frm_ver_empleado.setFindSelectionListener(this);
        Cl_Varios.open(frm_ver_empleado);*/
    }//GEN-LAST:event_btn_buseActionPerformed

    private void txt_montoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txt_fecha.setEditable(true);
            txt_fecha.setValue(ven.getFechaActual());
            txt_fecha.requestFocus();
        }*/
    }//GEN-LAST:event_txt_montoKeyPressed

    private void btn_regKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_regKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btn_reg.doClick();
        }*/
    }//GEN-LAST:event_btn_regKeyPressed

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        /*if (txt_monto.getText().length() == 8) {
            evt.consume();
        }
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && car != '.') {
            evt.consume();
        }*/
    }//GEN-LAST:event_txt_montoKeyTyped

    private Object llenar() {
        Movimiento m = new Movimiento();/*
        m.setGlosa(txt_mot.getText() + " - " + txt_nom.getText());
        m.setIngreso(new BigDecimal(0));
        m.setEgreso(new BigDecimal(0));
        m.setFecMov(txt_fecha.getDate());
        m.setIdAlmacen(frm_menu.almacen.getIdAlmacen());
        m.setFlag("C");
//        m.setIdDestino(frm_menu.caja.getIdCaja());
        m.setIdDestino(0);
        m.setDestino("xx");
        m.setNick(X.getUser());
        if (rbt_ini.isSelected() || rbt_ing.isSelected()) {
            m.setIngreso(new BigDecimal(txt_monto.getText()));
        } else if (rbt_sal.isSelected()) {
            m.setEgreso(new BigDecimal(txt_monto.getText()));
        }*/
        return m;
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        /*JPA.getInstance().getEntityManager(true).persist(llenar());
        JPA.getInstance().close();
        retrieve();
        sumar_ing_caja();
        sumar_sal_caja();
        Double totalc;
        Double totalb;
        totalc = suma_ingc - suma_salc;
        totalb = suma_ingb - suma_salb;
        txt_tot.setText(formato.format(totalc));
        txt_totb.setText(formato.format(totalb));
        limpiar();*/
    }//GEN-LAST:event_btn_regActionPerformed

    private void txt_motKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_motKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txt_mot.getText().length() > 10) {
                txt_monto.setEditable(true);
                txt_monto.requestFocus();
            }
        }*/
    }//GEN-LAST:event_txt_motKeyPressed

    private void btn_rep_cajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rep_cajaActionPerformed
        /*Date fec = ven.getFechaActual();
        Map<String, Object> parametros = new HashMap();
        parametros.put("idalm", frm_menu.almacen.getIdAlmacen());
        parametros.put("fec_mov", fec);
        ven.ver_reporte("rpt_caja_movimiento_caja", parametros);*/
    }//GEN-LAST:event_btn_rep_cajaActionPerformed

    private void btn_rep_bancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rep_bancoActionPerformed
        /*Date fec = ven.getFechaActual();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idalm", frm_menu.almacen.getIdAlmacen());
        parametros.put("fec_mov", fec);
        ven.ver_reporte("rpt_caja_movimiento_banco", parametros);*/
    }//GEN-LAST:event_btn_rep_bancoActionPerformed
/*

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_buse;
    private javax.swing.JButton btn_reg;
    private javax.swing.JButton btn_rep_banco;
    private javax.swing.JButton btn_rep_caja;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbt_ing;
    private javax.swing.JRadioButton rbt_ini;
    private javax.swing.JRadioButton rbt_sal;
    private javax.swing.JTable t_movimientos;
    private javax.swing.JTextField txt_dni;
    private org.jsuns.swing.XDateField txt_fecha;
    private javax.swing.JTextField txt_ing;
    private javax.swing.JTextField txt_ingb;
    private javax.swing.JTextField txt_monto;
    public static javax.swing.JTextField txt_mot;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_sal;
    private javax.swing.JTextField txt_salb;
    private javax.swing.JTextField txt_tot;
    private javax.swing.JTextField txt_totb;
    // End of variables declaration//GEN-END:variables
*/
    @Override
    public void valueChanged(FindSelectionEvent evt) {
       /* Empleado empleado = (Empleado) evt.getSource();
        txt_dni.setText(empleado.getDni().toString());
        txt_nom.setText(empleado.getNombreCompleto());*/
    }
}
