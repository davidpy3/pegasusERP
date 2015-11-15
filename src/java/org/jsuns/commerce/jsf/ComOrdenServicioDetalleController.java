package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComOrdenServicioDetalle;

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
import org.jsuns.commerce.ejb.ComOrdenServicioDetalleFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named
@SessionScoped
public class ComOrdenServicioDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComOrdenServicioDetalleFacadeLocal ejbFacade;
    private List<ComOrdenServicioDetalle> items = null;
    private ComOrdenServicioDetalle selected;

    public ComOrdenServicioDetalleController() {
    }

    public ComOrdenServicioDetalle getSelected() {
        return selected;
    }

    public void setSelected(ComOrdenServicioDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setComOrdenServicioDetallePK(new org.jsuns.commerce.jpa.ComOrdenServicioDetallePK());
    }

    private ComOrdenServicioDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComOrdenServicioDetalle prepareCreate() {
        selected = new ComOrdenServicioDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComOrdenServicioDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComOrdenServicioDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComOrdenServicioDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComOrdenServicioDetalle> getItems() {
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

    public ComOrdenServicioDetalle getComOrdenServicioDetalle(org.jsuns.commerce.jpa.ComOrdenServicioDetallePK id) {
        return getFacade().find(id);
    }

    public List<ComOrdenServicioDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComOrdenServicioDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComOrdenServicioDetalle.class)
    public static class ComOrdenServicioDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComOrdenServicioDetalleController controller = (ComOrdenServicioDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comOrdenServicioDetalleController");
            return controller.getComOrdenServicioDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.ComOrdenServicioDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.ComOrdenServicioDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.ComOrdenServicioDetallePK();
            key.setIdItem(Integer.parseInt(values[0]));
            key.setIdOperacion(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.ComOrdenServicioDetallePK value) {
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
            if (object instanceof ComOrdenServicioDetalle) {
                ComOrdenServicioDetalle o = (ComOrdenServicioDetalle) object;
                return getStringKey(o.getComOrdenServicioDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComOrdenServicioDetalle.class.getName()});
                return null;
            }
        }

    }

}
