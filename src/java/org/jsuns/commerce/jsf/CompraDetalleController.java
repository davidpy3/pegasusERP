package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.CompraDetalle;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.CompraDetalleFacade;

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
import org.jsuns.commerce.ejb.CompraDetalleFacadeLocal;

@Named("compraDetalleController")
@SessionScoped
public class CompraDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.CompraDetalleFacadeLocal ejbFacade;
    private List<CompraDetalle> items = null;
    private CompraDetalle selected;

    public CompraDetalleController() {
    }

    public CompraDetalle getSelected() {
        return selected;
    }

    public void setSelected(CompraDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCompraDetallePK().setIdArticulo(selected.getArticulo().getIdArticulo());
        selected.getCompraDetallePK().setIdCompra(selected.getCompra().getIdCompra());
    }

    protected void initializeEmbeddableKey() {
        selected.setCompraDetallePK(new org.jsuns.commerce.jpa.CompraDetallePK());
    }

    private CompraDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CompraDetalle prepareCreate() {
        selected = new CompraDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CompraDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CompraDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CompraDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CompraDetalle> getItems() {
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

    public CompraDetalle getCompraDetalle(org.jsuns.commerce.jpa.CompraDetallePK id) {
        return getFacade().find(id);
    }

    public List<CompraDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CompraDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CompraDetalle.class)
    public static class CompraDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CompraDetalleController controller = (CompraDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "compraDetalleController");
            return controller.getCompraDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.CompraDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.CompraDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.CompraDetallePK();
            key.setIdCompra(Integer.parseInt(values[0]));
            key.setIdArticulo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.CompraDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCompra());
            sb.append(SEPARATOR);
            sb.append(value.getIdArticulo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof CompraDetalle) {
                CompraDetalle o = (CompraDetalle) object;
                return getStringKey(o.getCompraDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CompraDetalle.class.getName()});
                return null;
            }
        }

    }

}
