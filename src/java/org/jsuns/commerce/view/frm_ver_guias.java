package org.jsuns.commerce.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import org.jsuns.commerce.jpa.Empleado;
//import org.jsuns.commerce.jpa.Articulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.jsuns.data.JPA;
import org.jsuns.data.Q;
import org.jsuns.data.Store;
import org.jsuns.commerce.AlmacenService;
import org.jsuns.commerce.frm_menu;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.commerce.jpa.AlmacenArticuloPK;
import org.jsuns.commerce.jpa.Kardex;
import org.jsuns.commerce.jpa.Traslado;
import org.jsuns.commerce.jpa.TrasladoArticulo;
import org.jsuns.swing.XPanel;
import org.jsuns.swing.finder.FindSelectionEvent;

public class frm_ver_guias extends XPanel {
/*
    private Traslado traslado = new Traslado();
    private Almacen alm = new Almacen();
    private Empleado emp = new Empleado();
    private String valor = "";
    private int i;

    @Override
    public void create() {
        frm_reg_traslado_almacen f = new frm_reg_traslado_almacen();
        f.setFindSelectionListener(this);
        f.open();
    }

    public frm_ver_guias() {
        initComponents();
        Store s = new Store(new Q() {
            public void configureView(ParamsModel m) {
                m.put("fecha", "y:0");
                m.put("id_estado", "y:0;w:*");
                XComboBox cb = new XComboBox();
                cb.setEditable(true);
                cb.setDisplayColumn(1);
                Store s = new Store();
                s.addColumn("id");
                s.addColumn("name");
                s.setRecords(new Object[][]{{1, "PENDIENTES"}, {2, "ANULADOS"}, {0, "TODOS"}});
                cb.setStore(s);
                m.getColumnExt("id_estado", cb);

            }
        }) {

            @Override
            public void retrieve(Object... args) throws Exception {
                //Establecer como cabezeras el nombre de las colimnas
                ArrayList data = new ArrayList();
                for (Traslado traslado : JPA.getInstance().getEntityManager().createQuery("SELECT t from "
                        + "Traslado t "
                        + "where "
                        //                        + (cbx_estado.getSelectedIndex() == 0 ? "t.estado='0' AND "
                        //                                : (cbx_estado.getSelectedIndex() == 1 ? "t.estado='2' AND "
                        //                                        : (cbx_estado.getSelectedIndex() == 2 ? "t.estado = '1' AND " : "")))
                        + " (t.origen = '" + frm_menu.almacen.getDireccion() + "' or t.destino = "
                        + "'" + frm_menu.almacen.getDireccion()
                        + "') "
                        + "ORDER BY t.fecha desc, t.idTraslado desc", Traslado.class).getResultList()) {
                    Object[] fila = new Object[9];
                    fila[0] = traslado.getMotivo();
                    fila[1] = traslado.getFecha();
                    fila[2] = traslado.getIdTraslado();
                    fila[3] = as.nom_alm(traslado.getOrigen());
                    fila[4] = traslado.getRazSocDest();
                    String destino = traslado.getDestino();
                    fila[5] = as.nom_alm(destino);
                    if (traslado.getSerie() == 0 && traslado.getNumero() == 0) {
                        fila[6] = "------";
                    } else {
                        fila[6] = traslado.getSerie() + " - " + traslado.getNumero();
                    }
                    fila[7] = traslado.getNick();
                    switch (traslado.getEstado()) {
                        case 0:
                            fila[8] = "PENDIENTE";
                            break;
                        case 1:
                            fila[8] = "APROBADO";
                            break;
                        case 2:
                            fila[8] = "ANULADO";
                            break;
                    }
                    data.add(fila);
                }
                JPA.getInstance().close();
                setRecords(data);
            }

        };
        s.addColumn("Motivo");
        s.addColumn("Fecha");
        s.addColumn("Id");
        s.addColumn("Origen");
        s.addColumn("Raz. Social");
        s.addColumn("Dir. Destino");
        s.addColumn("Guia");
        s.addColumn("Usuario");
        s.addColumn("Estado");
        s.setParams(new Object[][]{
            {"buscar", String.class},
            {"fecha", Date.class},
            {"id_estado", Integer.class}
        });
        setStore(s);
    }

    private AlmacenService as = new AlmacenService();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ver_guia = new javax.swing.JButton();
        btn_anular = new javax.swing.JButton();
        btn_verificar_envio = new javax.swing.JButton();

        btn_ver_guia.setText("Ver Guia");
        btn_ver_guia.setEnabled(false);
        btn_ver_guia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ver_guiaActionPerformed(evt);
            }
        });

        btn_anular.setText("Anular");
        btn_anular.setEnabled(false);
        btn_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anularActionPerformed(evt);
            }
        });

        btn_verificar_envio.setText("Verificar Envio");
        btn_verificar_envio.setEnabled(false);
        btn_verificar_envio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verificar_envioActionPerformed(evt);
            }
        });

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void btn_verificar_envioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verificar_envioActionPerformed
//        frm_reg_traslado_almacen traslado = new frm_reg_traslado_almacen();
//        traslado.setTraslado(Integer.parseInt(t_guias.getValueAt(i, 2).toString()));
//        Cl_Varios.open(traslado);
        this.close();
    }//GEN-LAST:event_btn_verificar_envioActionPerformed

    private void btn_ver_guiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ver_guiaActionPerformed
//        alb.setIdTraslado(Integer.parseInt(t_guias.getValueAt(i, 2).toString()));
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("idtraslado", alb.getIdTraslado());
//        Cl_Varios.ver_reporte("rpt_ver_guia", parametros);
    }//GEN-LAST:event_btn_ver_guiaActionPerformed

    private int ver_id_alm(String dir_alm) {
        int ida = 0;
        try {
            List l = JPA.getInstance().getEntityManager()
                    .createQuery("SELECT a "
                            + "FROM Almacen a "
                            + "where a.nombre like :nombre")
                    .setParameter("nombre", dir_alm + "%").getResultList();
            if (l.size() > 0) {
                ida = ((Almacen) l.get(0)).getIdAlmacen();
            }
            JPA.getInstance().close();
        } catch (Exception e) {
            alert(e);
        }
        return ida;
    }

    private String ruc_alm(String id_alm) {
        String ruc = null;
        try {
            Almacen l = JPA.getInstance().getEntityManager().find(Almacen.class, id_alm);
            if (l != null) {
                ruc = l.getRuc();
            }
            JPA.getInstance().close();
        } catch (Exception e) {
            alert(e);
        }
        return ruc;
    }

    private String raz_soc(String id_alm) {
        String raz = null;
        try {
            Almacen l = JPA.getInstance().getEntityManager().find(Almacen.class, id_alm);
            if (l != null) {
                raz = l.getRazonSocial();
            }
            JPA.getInstance().close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return raz;
    }

    private void btn_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anularActionPerformed
        int confirmado = JOptionPane.showConfirmDialog(null, "¿Confirma eliminar el traslado?");
        if (JOptionPane.OK_OPTION == confirmado) {
            //anular guia si es pendiente
            JTable t_guias = (JTable) this.vComp;
            traslado.setIdTraslado(Integer.parseInt(t_guias.getValueAt(i, 2).toString()));
            String est_guia = t_guias.getValueAt(i, 8).toString();
            if (est_guia.equals("PENDIENTE")) {
                EntityManager em = JPA.getInstance().getEntityManager(true);
                traslado = em.find(Traslado.class, traslado.getIdTraslado());
                String nom_alm_or = t_guias.getValueAt(i, 3).toString();
                //ver id almacen origen:
                int id_ao = ver_id_alm(nom_alm_or);
                System.out.println("almacen origen " + id_ao + "\n");
                String ruc = ruc_alm("" + id_ao);
                String raz = raz_soc("" + id_ao);
                for (TrasladoArticulo ta : traslado.getTrasladoArticuloCollection()) {
                    Articulo a=ta.getArticulo();
                    a.setCantActual(a.getCantActual().add(ta.getCant()));
                    em.remove(ta);
                    AlmacenArticulo aa=em.find(AlmacenArticulo.class,new AlmacenArticuloPK(id_ao,a.getIdArticulo()));
                    aa.setCantidad(a.getCantActual());
                    Kardex k=new Kardex();
                    k.setArticulo(a);
                    k.setFecha(traslado.getFecha());
                    k.setCantIng(ta.getCant());
                    k.setNumero(traslado.getNumero());
                    k.setSerie(traslado.getSerie());
                    k.setNombre(raz);
                    k.setDocNro(ruc);
                    k.setPreUniIng(BigDecimal.ZERO);
                    k.setCantSal(BigDecimal.ZERO);
                    k.setPreUniSal(BigDecimal.ZERO);
                }
                //seleccionar detalle envio
                Traslado t = em.find(Traslado.class, traslado.getIdTraslado());
                t.setEstado(2);
                em.merge(i);
                JPA.getInstance().close();
            }
        }
        retrieve();
    }//GEN-LAST:event_btn_anularActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anular;
    private javax.swing.JButton btn_ver_guia;
    private javax.swing.JButton btn_verificar_envio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void valueChanged(FindSelectionEvent evt) {
        retrieve();
    }
*/
}
