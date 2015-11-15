package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.FxaEstudiante;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.FxaEstudianteFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.jsuns.util.AbstractController;
import org.jsuns.util.XMap;
import org.jsuns.util.XUtil;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Named
@SessionScoped
public class FxaEstudianteController extends AbstractController<FxaEstudiante> implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.FxaEstudianteFacadeLocal ejbFacade;

    private FxaEstudianteFacadeLocal getFacade() {
        return ejbFacade;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        FxaEstudiante selected = getSelected();
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public FxaEstudiante getFxaEstudiante(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<FxaEstudiante> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FxaEstudiante> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        return new LazyDataModel<FxaEstudiante>() {

            @Override
            public FxaEstudiante getRowData(String rowKey) {
                return ejbFacade.find(XUtil.intValue(rowKey));
            }

            @Override
            public Object getRowKey(FxaEstudiante car) {
                return car.getIdAcexp();
            }

            @Override
            public List<FxaEstudiante> load(int first, int pageSize,
                    String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                if(filters!=null){
                    filters.put("nombreCompleto","%ALA%");
                }else
                    filters=new XMap("nombreCompleto","%ALA%");
                List<FxaEstudiante> l= ejbFacade.load(first, pageSize, sortField, filters);
                setRowCount(((Number) filters.get("size")).intValue());
                return l;
            }

        };

    }

    @FacesConverter(forClass = FxaEstudiante.class)
    public static class FxaEstudianteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FxaEstudianteController controller = (FxaEstudianteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fxaEstudianteController");
            return controller.getFxaEstudiante(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FxaEstudiante) {
                FxaEstudiante o = (FxaEstudiante) object;
                return getStringKey(o.getIdAcexp());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FxaEstudiante.class.getName()});
                return null;
            }
        }

    }

}
