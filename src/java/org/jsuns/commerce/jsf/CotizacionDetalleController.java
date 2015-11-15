package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.CotizacionDetalle;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.CotizacionDetalleFacade;

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
import org.jsuns.commerce.ejb.CotizacionDetalleFacadeLocal;

@Named("cotizacionDetalleController")
@SessionScoped
public class CotizacionDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.CotizacionDetalleFacadeLocal ejbFacade;
    private List<CotizacionDetalle> items = null;
    private CotizacionDetalle selected;

    public CotizacionDetalleController() {
    }

    public CotizacionDetalle getSelected() {
        return selected;
    }

    public void setSelected(CotizacionDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCotizacionDetallePK().setIdArticulo(selected.getArticulo().getIdArticulo());
    }

    protected void initializeEmbeddableKey() {
        selected.setCotizacionDetallePK(new org.jsuns.commerce.jpa.CotizacionDetallePK());
    }

    private CotizacionDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CotizacionDetalle prepareCreate() {
        selected = new CotizacionDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CotizacionDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CotizacionDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CotizacionDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CotizacionDetalle> getItems() {
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

    public CotizacionDetalle getCotizacionDetalle(org.jsuns.commerce.jpa.CotizacionDetallePK id) {
        return getFacade().find(id);
    }

    public List<CotizacionDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CotizacionDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CotizacionDetalle.class)
    public static class CotizacionDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CotizacionDetalleController controller = (CotizacionDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cotizacionDetalleController");
            return controller.getCotizacionDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.CotizacionDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.CotizacionDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.CotizacionDetallePK();
            key.setIdCotizacion(Integer.parseInt(values[0]));
            key.setIdArticulo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.CotizacionDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCotizacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdArticulo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CotizacionDetalle) {
                CotizacionDetalle o = (CotizacionDetalle) object;
                return getStringKey(o.getCotizacionDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CotizacionDetalle.class.getName()});
                return null;
            }
        }

    }

}
