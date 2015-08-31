/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.personal;

import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import org.jsuns.data.JPA;
import org.jsuns.util.XUtil;
import org.munisoft.model.Concepto;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean
@ViewScoped
public class ConceptoController {
    class LazyListModel extends LazyDataModel<Concepto> {

        public LazyListModel() {
        }

        @Override
        public Concepto getRowData(String rowKey) {
            //dni=rowKey;
            Concepto p=JPA.getInstance().get(Concepto.class,rowKey);
            JPA.getInstance().close();
            return p;
        }

        @Override
        public Object getRowKey(Concepto car) {
            return car.getCodigo();
        }

        @Override
        public List<Concepto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            EntityManager em = JPA.getInstance().getEntityManager();
            List data = em.createQuery("SELECT p FROM Concepto p ORDER BY p.concepto")
                    .setFirstResult(first).setMaxResults(pageSize).getResultList();
            if (getRowCount() <= 0) {
                setRowCount(XUtil.intValue(em.createQuery("SELECT COUNT(p) FROM Concepto p").getSingleResult()));
            }
            JPA.getInstance().close();
            return data;
        }

    }

    public ConceptoController() {
        
    }
    private Concepto personal;

    private String dni;


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public Concepto getPersonal() {
        return personal;
    }

    public void delete() {
        EntityManager em = JPA.getInstance().getEntityManager(true);
        em.remove(em.find(Concepto.class,dni));
        JPA.getInstance().close();
    }

    public void setPersonal(Concepto personal) {
        this.personal = personal;
    }

    public Concepto getSelected() {
        return personal;
    }

    public void setSelected(Concepto personal) {
        this.personal = personal;
    }

    
    private LazyDataModel data = null;

    public LazyDataModel<Concepto> getDataList() {
        if (data == null) {
            data = new LazyListModel();
        }
        System.out.println("palayers=" + data);
        return data;
    }
}
