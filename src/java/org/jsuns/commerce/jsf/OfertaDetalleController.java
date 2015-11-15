package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.OfertaDetalle;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.OfertaDetalleFacade;

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
import org.jsuns.commerce.ejb.OfertaDetalleFacadeLocal;

@Named("ofertaDetalleController")
@SessionScoped
public class OfertaDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.OfertaDetalleFacadeLocal ejbFacade;
    private List<OfertaDetalle> items = null;
    private OfertaDetalle selected;

    public OfertaDetalleController() {
    }

    public OfertaDetalle getSelected() {
        return selected;
    }

    public void setSelected(OfertaDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getOfertaDetallePK().setIdOferta(selected.getOferta().getIdOferta());
        selected.getOfertaDetallePK().setIdArticulo(selected.getArticulo().getIdArticulo());
    }

    protected void initializeEmbeddableKey() {
        selected.setOfertaDetallePK(new org.jsuns.commerce.jpa.OfertaDetallePK());
    }

    private OfertaDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public OfertaDetalle prepareCreate() {
        selected = new OfertaDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OfertaDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OfertaDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OfertaDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OfertaDetalle> getItems() {
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

    public OfertaDetalle getOfertaDetalle(org.jsuns.commerce.jpa.OfertaDetallePK id) {
        return getFacade().find(id);
    }

    public List<OfertaDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OfertaDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OfertaDetalle.class)
    public static class OfertaDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OfertaDetalleController controller = (OfertaDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ofertaDetalleController");
            return controller.getOfertaDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.OfertaDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.OfertaDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.OfertaDetallePK();
            key.setIdOferta(Integer.parseInt(values[0]));
            key.setIdArticulo(Integer.parseInt(values[1]));
            key.setCantidad(Double.parseDouble(values[2]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.OfertaDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdOferta());
            sb.append(SEPARATOR);
            sb.append(value.getIdArticulo());
            sb.append(SEPARATOR);
            sb.append(value.getCantidad());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OfertaDetalle) {
                OfertaDetalle o = (OfertaDetalle) object;
                return getStringKey(o.getOfertaDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OfertaDetalle.class.getName()});
                return null;
            }
        }

    }

}
