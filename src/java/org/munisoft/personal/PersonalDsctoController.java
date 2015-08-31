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
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean
@ViewScoped
public class PersonalDsctoController {
    class LazyListModel extends LazyDataModel<PersonalDscto> {

        public LazyListModel() {
        }

        @Override
        public PersonalDscto getRowData(String rowKey) {
            //dni=rowKey;
            PersonalDscto p=JPA.getInstance().get(PersonalDscto.class,rowKey);
            JPA.getInstance().close();
            return p;
        }

        @Override
        public Object getRowKey(PersonalDscto car) {
            return car.getPersonalDsctoPK();
        }

        @Override
        public List<PersonalDscto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
            EntityManager em = JPA.getInstance().getEntityManager();
            List data = em.createQuery("SELECT p FROM PersonalDscto p ORDER BY p.fechaIni")
                    .setFirstResult(first).setMaxResults(pageSize).getResultList();
            if (getRowCount() <= 0) {
                setRowCount(XUtil.intValue(em.createQuery("SELECT COUNT(p) FROM PersonalDscto p").getSingleResult()));
            }
            JPA.getInstance().close();
            return data;
        }

    }

    public PersonalDsctoController() {
        
    }
    private PersonalDscto personal;

    private String dni;

    private String nombre_completo;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public PersonalDscto getPersonal() {
        return personal;
    }

    public void delete() {
        EntityManager em = JPA.getInstance().getEntityManager(true);
        em.remove(em.find(PersonalDscto.class,dni));
        JPA.getInstance().close();
    }

    public void setPersonal(PersonalDscto personal) {
        this.personal = personal;
    }

    public PersonalDscto getSelected() {
        return personal;
    }

    public void setSelected(PersonalDscto personal) {
        this.personal = personal;
    }

    
    private LazyDataModel data = null;

    public LazyDataModel<PersonalDscto> getDataList() {
        if (data == null) {
            data = new LazyListModel();
        }
        System.out.println("palayers=" + data);
        return data;
    }
}
