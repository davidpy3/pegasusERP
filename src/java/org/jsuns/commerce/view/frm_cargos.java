package org.jsuns.commerce.view;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.jsuns.data.JPA;
import org.jsuns.data.Store;
import org.jsuns.swing.XPanel;
import org.jsuns.util.Request;
import org.jsuns.util.XUtil;
import org.pegasus.personal.jpa.Cargo;

public class frm_cargos extends XPanel {

    public frm_cargos() {
        initComponents();
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
//                                    c.setTipoCargo(o[0].toString());
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
//                                    c.setTipoCargo(o[0].toString());
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
                String query = "select c from Cargo c";
                //Establecer como cabezeras el nombre de las colimnas
                ArrayList data = new ArrayList();
                for (Cargo cargo : JPA.getInstance().getEntityManager().createQuery(query, Cargo.class).getResultList()) {
                    data.add(new Object[]{
                        cargo.getIdCargo(),
//                        cargo.getTipoCargo()
                    });
                }
                JPA.getInstance().close();
                setRecords(data);
            }
        };
        s.setTemplate(Cargo.class);
        s.addColumn("id_cargo", true, Store._PK, true, Store._CLASS, Integer.class);
        s.addColumn("tipo_cargo", true, Store._SIZE, 20, Store._CLASS, String.class);
        s.setAutoincrement(0);
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
