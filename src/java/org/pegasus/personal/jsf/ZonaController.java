package org.pegasus.personal.jsf;

import org.jsuns.util.AbstractController;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import org.jsuns.util.JsfUtil;
import org.pegasus.patrimonio.ejb.ZonaFacadeLocal;
import org.pegasus.patrimonio.jpa.Zona;
import org.pegasus.personal.jpa.RegimenPensionario;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@ManagedBean
@ViewScoped
public class ZonaController extends AbstractController<Zona> implements Serializable {

    @EJB
    private org.pegasus.patrimonio.ejb.ZonaFacadeLocal ejbFacade;

    private ZonaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Zona> getItems() {
//        X.log(this.params);
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        return new LazyDataModel<Zona>() {
            @Override
            public Zona getRowData(String rowKey) {
                return ejbFacade.find(rowKey);
            }

            @Override
            public Object getRowKey(Zona car) {
                return car.getId();
            }

            @Override
            public List<Zona> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                List data = ejbFacade.findRange(first, pageSize);
                if (getRowCount() <= 0) {
                    setRowCount(ejbFacade.count());
                }
                return data;
            }

        };
    }

    public Zona getZona(String id) {
        return getFacade().find(id);
    }

    @Override
    protected void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = Zona.class)
    public static class ZonaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {

            if (value == null || value.length() == 0) {
                return null;
            }
            return ((ZonaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "zonaController")).getZona(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return object != null ? ((Zona) object).getId() : null;
        }

    }
}
