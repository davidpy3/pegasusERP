package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComTipoGiro;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.ComTipoGiroFacade;

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
import org.jsuns.commerce.ejb.ComTipoGiroFacadeLocal;

@Named("comTipoGiroController")
@SessionScoped
public class ComTipoGiroController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComTipoGiroFacadeLocal ejbFacade;
    private List<ComTipoGiro> items = null;
    private ComTipoGiro selected;

    public ComTipoGiroController() {
    }

    public ComTipoGiro getSelected() {
        return selected;
    }

    public void setSelected(ComTipoGiro selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ComTipoGiroFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComTipoGiro prepareCreate() {
        selected = new ComTipoGiro();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComTipoGiroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComTipoGiroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComTipoGiroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComTipoGiro> getItems() {
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

    public ComTipoGiro getComTipoGiro(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ComTipoGiro> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComTipoGiro> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComTipoGiro.class)
    public static class ComTipoGiroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComTipoGiroController controller = (ComTipoGiroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comTipoGiroController");
            return controller.getComTipoGiro(getKey(value));
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
            if (object instanceof ComTipoGiro) {
                ComTipoGiro o = (ComTipoGiro) object;
                return getStringKey(o.getIdTipoGiro());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComTipoGiro.class.getName()});
                return null;
            }
        }

    }

}
