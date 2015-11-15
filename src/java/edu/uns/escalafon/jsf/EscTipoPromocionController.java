package edu.uns.escalafon.jsf;

import edu.uns.escalafon.ejb.EscTipoPromocionFacadeLocal;
import edu.uns.escalafon.jpa.EscTipoPromocion;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

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

@Named("escTipoPromocionController")
@SessionScoped
public class EscTipoPromocionController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscTipoPromocionFacadeLocal ejbFacade;
    private List<EscTipoPromocion> items = null;
    private EscTipoPromocion selected;

    public EscTipoPromocionController() {
    }

    public EscTipoPromocion getSelected() {
        return selected;
    }

    public void setSelected(EscTipoPromocion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscTipoPromocionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscTipoPromocion prepareCreate() {
        selected = new EscTipoPromocion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscTipoPromocionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscTipoPromocionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscTipoPromocionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscTipoPromocion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    protected void persist(PersistAction persistAction, String successMessage) {
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

    public EscTipoPromocion getEscTipoPromocion(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<EscTipoPromocion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscTipoPromocion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscTipoPromocion.class)
    public static class EscTipoPromocionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscTipoPromocionController controller = (EscTipoPromocionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escTipoPromocionController");
            return controller.getEscTipoPromocion(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscTipoPromocion) {
                EscTipoPromocion o = (EscTipoPromocion) object;
                return getStringKey(o.getIdTp());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscTipoPromocion.class.getName()});
                return null;
            }
        }

    }

}
