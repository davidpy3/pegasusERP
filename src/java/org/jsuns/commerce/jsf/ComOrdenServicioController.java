package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComOrdenServicio;

import java.io.Serializable;
import java.util.List;
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
import org.jsuns.commerce.ejb.ComOrdenServicioFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named("comOrdenServicioController")
@SessionScoped
public class ComOrdenServicioController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComOrdenServicioFacadeLocal ejbFacade;
    private List<ComOrdenServicio> items = null;
    private ComOrdenServicio selected;

    public ComOrdenServicioController() {
    }

    public ComOrdenServicio getSelected() {
        return selected;
    }

    public void setSelected(ComOrdenServicio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComOrdenServicioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComOrdenServicio prepareCreate() {
        selected = new ComOrdenServicio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComOrdenServicioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComOrdenServicioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComOrdenServicioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComOrdenServicio> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
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

    public ComOrdenServicio getComOrdenServicio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ComOrdenServicio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComOrdenServicio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComOrdenServicio.class)
    public static class ComOrdenServicioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComOrdenServicioController controller = (ComOrdenServicioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comOrdenServicioController");
            return controller.getComOrdenServicio(getKey(value));
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
            if (object instanceof ComOrdenServicio) {
                ComOrdenServicio o = (ComOrdenServicio) object;
                return getStringKey(o.getIdOrdenServicio());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComOrdenServicio.class.getName()});
                return null;
            }
        }

    }

}
