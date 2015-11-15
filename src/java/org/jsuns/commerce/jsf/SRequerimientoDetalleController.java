package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.SRequerimientoDetalle;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.SRequerimientoDetalleFacade;

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
import org.jsuns.commerce.ejb.SRequerimientoDetalleFacadeLocal;

@Named("sRequerimientoDetalleController")
@SessionScoped
public class SRequerimientoDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.SRequerimientoDetalleFacadeLocal ejbFacade;
    private List<SRequerimientoDetalle> items = null;
    private SRequerimientoDetalle selected;

    public SRequerimientoDetalleController() {
    }

    public SRequerimientoDetalle getSelected() {
        return selected;
    }

    public void setSelected(SRequerimientoDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getSolicitudDetallePK().setIdArticulo(selected.getArticulo().getIdArticulo());
    }

    protected void initializeEmbeddableKey() {
        selected.setSolicitudDetallePK(new org.jsuns.commerce.jpa.SolicitudDetallePK());
    }

    private SRequerimientoDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SRequerimientoDetalle prepareCreate() {
        selected = new SRequerimientoDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SRequerimientoDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SRequerimientoDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SRequerimientoDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SRequerimientoDetalle> getItems() {
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

    public SRequerimientoDetalle getSRequerimientoDetalle(org.jsuns.commerce.jpa.SolicitudDetallePK id) {
        return getFacade().find(id);
    }

    public List<SRequerimientoDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SRequerimientoDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SRequerimientoDetalle.class)
    public static class SRequerimientoDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SRequerimientoDetalleController controller = (SRequerimientoDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sRequerimientoDetalleController");
            return controller.getSRequerimientoDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.SolicitudDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.SolicitudDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.SolicitudDetallePK();
            key.setIdSolicitud(Integer.parseInt(values[0]));
            key.setIdArticulo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.SolicitudDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdSolicitud());
            sb.append(SEPARATOR);
            sb.append(value.getIdArticulo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SRequerimientoDetalle) {
                SRequerimientoDetalle o = (SRequerimientoDetalle) object;
                return getStringKey(o.getSolicitudDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SRequerimientoDetalle.class.getName()});
                return null;
            }
        }

    }

}
