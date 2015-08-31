/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.personal;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import org.jsuns.data.JPA;
import org.jsuns.util.XUtil;
import org.munisoft.model.Personal;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean
@ViewScoped
public class PersonalController {

    class LazyListModel extends LazyDataModel<Personal> {

        private List<Personal> datasource;

        public LazyListModel() {
        }

        @Override
        public Personal getRowData(String rowKey) {
            dni=rowKey;
            Personal p=JPA.getInstance().get(Personal.class,rowKey);
            JPA.getInstance().close();
            return p;
        }

        @Override
        public Object getRowKey(Personal car) {
            return car.getDni();
        }

        @Override
        public List<Personal> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            EntityManager em = JPA.getInstance().getEntityManager();
            List data = em.createQuery("SELECT p FROM Personal p ORDER BY p.nombComp")
                    .setFirstResult(first).setMaxResults(pageSize).getResultList();
            if (getRowCount() <= 0) {
                setRowCount(XUtil.intValue(em.createQuery("SELECT COUNT(p) FROM Personal p").getSingleResult()));
            }
            datasource = data;
            JPA.getInstance().close();
            return data;
        }

    }

    private Personal personal;

    private String dni;

    private String nombre_completo;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public int getEdad(Date d) {
        return 20;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void delete() {
        EntityManager em = JPA.getInstance().getEntityManager(true);
        em.remove(em.find(Personal.class,dni));
        JPA.getInstance().close();
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Personal getSelected() {
        return personal;
    }

    public void setSelected(Personal personal) {
        this.personal = personal;
    }

    public PersonalController() {
    }

    private LazyDataModel players = null;

    public LazyDataModel<Personal> getPersonalList() {
        if (players == null) {
            players = new LazyListModel();
        }
        System.out.println("palayers=" + players);
        return players;
    }
    
}
