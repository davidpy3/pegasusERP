package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComOperacionDetalle;
import org.jsuns.commerce.ejb.ComOperacionDetalleFacade;

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
import org.jsuns.commerce.ejb.ComOperacionDetalleFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named
@SessionScoped
public class ComOperacionDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComOperacionDetalleFacadeLocal ejbFacade;
    private List<ComOperacionDetalle> items = null;
    private ComOperacionDetalle selected;

    public ComOperacionDetalleController() {
    }

    public ComOperacionDetalle getSelected() {
        return selected;
    }

    public void setSelected(ComOperacionDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setComOperacionDetallePK(new org.jsuns.commerce.jpa.ComOperacionDetallePK());
    }

    private ComOperacionDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComOperacionDetalle prepareCreate() {
        selected = new ComOperacionDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComOperacionDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComOperacionDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComOperacionDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComOperacionDetalle> getItems() {
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

    public ComOperacionDetalle getComOperacionDetalle(org.jsuns.commerce.jpa.ComOperacionDetallePK id) {
        return getFacade().find(id);
    }

    public List<ComOperacionDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComOperacionDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComOperacionDetalle.class)
    public static class ComOperacionDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComOperacionDetalleController controller = (ComOperacionDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comOperacionDetalleController");
            return controller.getComOperacionDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.ComOperacionDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.ComOperacionDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.ComOperacionDetallePK();
            key.setIdItem(Integer.parseInt(values[0]));
            key.setIdOperacion(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.ComOperacionDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdItem());
            sb.append(SEPARATOR);
            sb.append(value.getIdOperacion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ComOperacionDetalle) {
                ComOperacionDetalle o = (ComOperacionDetalle) object;
                return getStringKey(o.getComOperacionDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComOperacionDetalle.class.getName()});
                return null;
            }
        }

    }

}
