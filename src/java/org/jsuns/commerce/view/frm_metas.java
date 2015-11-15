package org.jsuns.commerce.view;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import org.jsuns.data.JPA;
import org.jsuns.data.Store;
import org.jsuns.swing.XPanel;
import org.jsuns.util.Request;
import org.jsuns.util.XUtil;
import org.pegasus.patrimonio.jpa.Meta;
import org.pegasus.personal.jpa.Cargo;

public class frm_metas extends XPanel {

    //Cl_Varios ven = new Cl_Varios();
    Meta met = new Meta();
    Cargo car = new Cargo();
    public static DefaultTableModel modelo;
    int i;

    public frm_metas() {
//        initComponents();
        Store s = new Store() {
            @Override
            public void update() throws Exception {
                Request r = createRequest(new Request());
                List l = (List) r.getAttribute("#data");
                for (Object[] row : (List<Object[]>) l) {
                    switch (XUtil.intValue(row[0])) {
                        case Store.INSERTED: {
                            EntityManager em = JPA.getInstance().getEntityManager(true);
                            Cargo c = new Cargo();
                            Object[][] changes = (Object[][]) row[2];
                            for (Object o[] : changes) {
                                if (o[1].equals(1)) {
                                    //c.setTipoCargo(o[0].toString());
                                }
                            }
                            em.persist(c);
                            JPA.getInstance().close();
                        }
                        break;
                        case Store.MODIFIED: {
                            EntityManager em = JPA.getInstance().getEntityManager(true);
                            Cargo c = em.find(Cargo.class, ((Object[]) ((Object[]) row[3])[0])[0]);
                            Object[][] changes = (Object[][]) row[2];
                            for (Object o[] : changes) {
                                if (o[1].equals(1)) {
                                    //c.setTipoCargo(o[0].toString());
                                }
                            }
                            em.merge(c);
                            JPA.getInstance().close();
                        }
                        break;
                        case -1: {
                            EntityManager em = JPA.getInstance().getEntityManager(true);
                            List<Object[][]> changes = (List) row[1];
                            for (Object o[][] : changes) {
                                em.remove(em.find(Cargo.class, o[0][0]));
                            }
                            JPA.getInstance().close();
                        }
                        break;
                    }
                }
                retrieve();
            }

            @Override
            public void retrieve(Object... args) throws Exception {
                ArrayList data = new ArrayList();
                for (Meta m : JPA.getInstance().getEntityManager().createQuery("SELECT m FROM Meta m ORDER BY m.idMeta", Meta.class).getResultList()) {
                    Object dato[] = new Object[6];
                    /*dato[0] = m.getIdMeta();
                    dato[1] = m.getMonto();
                    dato[2] = m.getFechaIni();
                    dato[3] = m.getFechaFin();
                    dato[4] = m.getIdCargo();*/
                    if (m.getEstado() != null && m.getEstado() == '1') {
                        dato[5] = "Activo";
                    } else {
                        dato[5] = " - ";
                    }
                    data.add(dato);
                }
                JPA.getInstance().close();
                setRecords(data);
            }
        };
        s.setTemplate(Meta.class);
        s.addColumn("id", true, Store._PK, true, Store._CLASS, Integer.class);
        s.addColumn("monto", true, Store._SIZE, 20, Store._CLASS, Double.class);
        s.addColumn("fecha_ini");
        s.addColumn("fecha_fin");
        s.addColumn("tipo_crgo");
        s.addColumn("estado");
        s.setAutoincrement(0);
        /*setStore(s);
        txt_fec_ini.setDate(ven.getFechaActual());
        txt_fec_fin.setDate(ven.getFechaActual());
        txt_monto.setDocument(new NumberDocument(2));*/
//        cbx_tienda.setStore(Cargo.class);
//        cbx_tienda.load();
    }

    private Meta llenar(Meta met) {
        /*met.setMonto(new BigDecimal("" + XUtil.doubleValue(txt_monto.getText())));
        met.setFechaIni(txt_fec_ini.getDate());
        met.setFechaFin(txt_fec_fin.getDate());
        try {
            car.setIdCargo(XUtil.intValue(cbx_tienda.getSelectedObject()));
        } catch (Exception e) {
            car.setIdCargo(1);
        }*/
        return met;
    }
/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_fec_ini = new org.jsuns.swing.XDateField();
        jLabel2 = new javax.swing.JLabel();
        txt_fec_fin = new org.jsuns.swing.XDateField();
        jLabel3 = new javax.swing.JLabel();
        cbx_tienda = new org.jsuns.swing.XComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_monto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btn_reg = new javax.swing.JButton();

        jLabel2.setText("Monto:");

        jLabel3.setText("Fecha de Inicio:");

        cbx_tienda.setEditable(true);

        jLabel4.setText("Fecha de Fin:");

        jLabel5.setText("Cargo:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_reg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_reg.setText("Registrar");
        btn_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regActionPerformed(evt);
            }
        });

        setTitle("Programacion de Metas");
    }// </editor-fold>//GEN-END:initComponents
*/
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
       // txt_monto.requestFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void btn_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regActionPerformed
        met = llenar(new Meta());
        JPA.getInstance().getEntityManager(true).persist(met);
        JPA.getInstance().close();
        //retrieve();
//        limpiar();
    }//GEN-LAST:event_btn_regActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int confirmar = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el Codigo " + t_metas.getValueAt(i, 0));
//        if (JOptionPane.OK_OPTION == confirmar) {
//            EntityManager em = JPA.getInstance().getEntityManager(true);
//            em.remove(em.find(Meta.class, t_metas.getValueAt(i, 0)));
//            JPA.getInstance().close();
//            retrieve();
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

/*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_reg;
    private org.jsuns.swing.XComboBox cbx_tienda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private org.jsuns.swing.XDateField txt_fec_fin;
    private org.jsuns.swing.XDateField txt_fec_ini;
    private javax.swing.JTextField txt_monto;
    // End of variables declaration//GEN-END:variables
*/}
