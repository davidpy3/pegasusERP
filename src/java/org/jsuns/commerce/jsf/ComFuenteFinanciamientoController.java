package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComFuenteFinanciamiento;
import org.jsuns.commerce.ejb.ComFuenteFinanciamientoFacade;

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
import org.jsuns.commerce.ejb.ComFuenteFinanciamientoFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named("comFuenteFinanciamientoController")
@SessionScoped
public class ComFuenteFinanciamientoController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComFuenteFinanciamientoFacadeLocal ejbFacade;
    private List<ComFuenteFinanciamiento> items = null;
    private ComFuenteFinanciamiento selected;

    public ComFuenteFinanciamientoController() {
    }

    public ComFuenteFinanciamiento getSelected() {
        return selected;
    }

    public void setSelected(ComFuenteFinanciamiento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComFuenteFinanciamientoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComFuenteFinanciamiento prepareCreate() {
        selected = new ComFuenteFinanciamiento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComFuenteFinanciamientoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComFuenteFinanciamientoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComFuenteFinanciamientoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComFuenteFinanciamiento> getItems() {
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

    public ComFuenteFinanciamiento getComFuenteFinanciamiento(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ComFuenteFinanciamiento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComFuenteFinanciamiento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComFuenteFinanciamiento.class)
    public static class ComFuenteFinanciamientoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComFuenteFinanciamientoController controller = (ComFuenteFinanciamientoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comFuenteFinanciamientoController");
            return controller.getComFuenteFinanciamiento(getKey(value));
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
            if (object instanceof ComFuenteFinanciamiento) {
                ComFuenteFinanciamiento o = (ComFuenteFinanciamiento) object;
                return getStringKey(o.getIdFuenteFinanciamiento());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComFuenteFinanciamiento.class.getName()});
                return null;
            }
        }

    }

}
