package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComCajaArqueoDetalle;
import org.jsuns.commerce.ejb.ComCajaArqueoDetalleFacade;

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
import org.jsuns.commerce.ejb.ComCajaArqueoDetalleFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named("comCajaArqueoDetalleController")
@SessionScoped
public class ComCajaArqueoDetalleController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComCajaArqueoDetalleFacadeLocal ejbFacade;
    private List<ComCajaArqueoDetalle> items = null;
    private ComCajaArqueoDetalle selected;

    public ComCajaArqueoDetalleController() {
    }

    public ComCajaArqueoDetalle getSelected() {
        return selected;
    }

    public void setSelected(ComCajaArqueoDetalle selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setComCajaArqueoDetallePK(new org.jsuns.commerce.jpa.ComCajaArqueoDetallePK());
    }

    private ComCajaArqueoDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComCajaArqueoDetalle prepareCreate() {
        selected = new ComCajaArqueoDetalle();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComCajaArqueoDetalleCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComCajaArqueoDetalleUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComCajaArqueoDetalleDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComCajaArqueoDetalle> getItems() {
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

    public ComCajaArqueoDetalle getComCajaArqueoDetalle(org.jsuns.commerce.jpa.ComCajaArqueoDetallePK id) {
        return getFacade().find(id);
    }

    public List<ComCajaArqueoDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComCajaArqueoDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComCajaArqueoDetalle.class)
    public static class ComCajaArqueoDetalleControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComCajaArqueoDetalleController controller = (ComCajaArqueoDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comCajaArqueoDetalleController");
            return controller.getComCajaArqueoDetalle(getKey(value));
        }

        org.jsuns.commerce.jpa.ComCajaArqueoDetallePK getKey(String value) {
            org.jsuns.commerce.jpa.ComCajaArqueoDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.ComCajaArqueoDetallePK();
            key.setIdArqueo(Integer.parseInt(values[0]));
            key.setIdMedio(new Character(values[1].charAt(0)));
            key.setIdMoneda(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.ComCajaArqueoDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdArqueo());
            sb.append(SEPARATOR);
            sb.append(value.getIdMedio());
            sb.append(SEPARATOR);
            sb.append(value.getIdMoneda());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ComCajaArqueoDetalle) {
                ComCajaArqueoDetalle o = (ComCajaArqueoDetalle) object;
                return getStringKey(o.getComCajaArqueoDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComCajaArqueoDetalle.class.getName()});
                return null;
            }
        }

    }

}
