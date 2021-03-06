package org.jsuns.commerce.view;

import org.jsuns.commerce.jpa.Clasificacion;
import javax.swing.table.DefaultTableModel;
import org.jsuns.swing.XPanel;

public class frm_ver_clasificacion extends XPanel{

    private Clasificacion cla = new Clasificacion();
    private DefaultTableModel mostrar;
    private Integer i;

    public frm_ver_clasificacion() {
        initComponents();
        String query = "select * from clasificacion order by desc_clas asc";
        ver_clasificacion(query);
    }

    private void ver_clasificacion(String query) {
   
            mostrar = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int fila, int columna) {
                    return false;
                }
            };
            //Establecer como cabezeras el nombre de las colimnas
            mostrar.addColumn("Id");
            mostrar.addColumn("Descripcion");

            //Creando las filas para el JTable
//            while (rs.next()) {
//                Object[] fila = new Object[2];
//                fila[0] = rs.getObject("id_clas");
//                fila[1] = rs.getObject("desc_clas");
//                mostrar.addRow(fila);
//            }
            t_clasificacion.setModel(mostrar);
            t_clasificacion.getColumnModel().getColumn(0).setPreferredWidth(20);
            t_clasificacion.getColumnModel().getColumn(1).setPreferredWidth(180);
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

        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_clasificacion = new javax.swing.JTable();
        btn_reg = new javax.swing.JButton();
        btn_mod = new javax.swing.JButton();
        btn_cer = new javax.swing.JButton();
        btn_gra = new javax.swing.JButton();

        setTitle("Ver Clasificacion");

        jLabel1.setForeground(new java.awt.Color(212, 2, 2));
        jLabel1.setText("Id:");

        txt_id.setEditable(false);

        jLabel2.setForeground(new java.awt.Color(212, 2, 2));
        jLabel2.setText("Descripcion:");

        txt_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_descKeyPressed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));

        t_clasificacion.setModel(new javax.swing.table.DefaultTableModel(
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
        t_clasificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_clasificacionMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(t_clasificacion);

        btn_reg.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        btn_mod.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_mod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/application_edit.png"))); // NOI18N
        btn_mod.setText("Modificar");
        btn_mod.setEnabled(false);
        btn_mod.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_mod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modActionPerformed(evt);
            }
        });

        btn_cer.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_cer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cancel.png"))); // NOI18N
        btn_cer.setText("Cerrar");
        btn_cer.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_cer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerActionPerformed(evt);
            }
        });

        btn_gra.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btn_gra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/disk.png"))); // NOI18N
        btn_gra.setText("Grabar");
        btn_gra.setEnabled(false);
        btn_gra.setMargin(new java.awt.Insets(3, 3, 3, 3));
        btn_gra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_graActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_reg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_mod, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btn_cer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_gra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desc, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(btn_gra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btn_cer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerActionPerformed
        this.close();
    }//GEN-LAST:event_btn_cerActionPerformed

    private void llenar() {
        cla.setDescripcion(txt_desc.getText());
    }

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        llenar();
        String ins_clas = "insert into clasificacion Values (null, '" + cla.getDescripcion() + "')";
        cla.setDescripcion("");
        txt_desc.setText("");
        txt_desc.requestFocus();
        String query = "select * from clasificacion order by desc_clas asc";
        ver_clasificacion(query);

    }//GEN-LAST:event_btn_regActionPerformed

    private void t_clasificacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_clasificacionMousePressed
        i = t_clasificacion.getSelectedRow();
        btn_mod.setEnabled(true);

    }//GEN-LAST:event_t_clasificacionMousePressed

    private void btn_modActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modActionPerformed
        cla.setIdClas(Integer.parseInt(t_clasificacion.getValueAt(i, 0).toString()));
        cla.setDescripcion(t_clasificacion.getValueAt(i, 1).toString());
        btn_reg.setEnabled(false);
        btn_mod.setEnabled(false);
        btn_gra.setEnabled(true);
        txt_id.setText(""+cla.getIdClas());
        txt_desc.setText(cla.getDescripcion());
        txt_desc.requestFocus();
    }//GEN-LAST:event_btn_modActionPerformed

    private void btn_graActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_graActionPerformed
        llenar();
        try {
     
            String upd_cla = "update clasificacion set desc_clas = '" + cla.getDescripcion() + "' where id_clas = '" + cla.getIdClas() + "'";
  
        } catch (Exception ex) {
            System.out.print(ex);
        }
        btn_gra.setEnabled(false);
        btn_mod.setEnabled(false);
        btn_reg.setEnabled(true);
        String query = "select * from clasificacion order by desc_clas asc";
        ver_clasificacion(query);
        txt_desc.setText("");
        txt_desc.requestFocus();
    }//GEN-LAST:event_btn_graActionPerformed

    private void txt_descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descKeyPressed
        if (!txt_desc.getText().isEmpty()) {
            if (Character.isLetter(evt.getKeyChar())) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txt_descKeyPressed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        txt_desc.requestFocus();
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cer;
    private javax.swing.JButton btn_gra;
    private javax.swing.JButton btn_mod;
    private javax.swing.JButton btn_reg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_clasificacion;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
