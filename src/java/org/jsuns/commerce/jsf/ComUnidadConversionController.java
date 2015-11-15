package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComUnidadConversion;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.ComUnidadConversionFacade;

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
import org.jsuns.commerce.ejb.ComUnidadConversionFacadeLocal;

@Named("comUnidadConversionController")
@SessionScoped
public class ComUnidadConversionController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComUnidadConversionFacadeLocal ejbFacade;
    private List<ComUnidadConversion> items = null;
    private ComUnidadConversion selected;

    public ComUnidadConversionController() {
    }

    public ComUnidadConversion getSelected() {
        return selected;
    }

    public void setSelected(ComUnidadConversion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setComUnidadConversionPK(new org.jsuns.commerce.jpa.ComUnidadConversionPK());
    }

    private ComUnidadConversionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComUnidadConversion prepareCreate() {
        selected = new ComUnidadConversion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComUnidadConversionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComUnidadConversionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComUnidadConversionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComUnidadConversion> getItems() {
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

    public ComUnidadConversion getComUnidadConversion(org.jsuns.commerce.jpa.ComUnidadConversionPK id) {
        return getFacade().find(id);
    }

    public List<ComUnidadConversion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComUnidadConversion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComUnidadConversion.class)
    public static class ComUnidadConversionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComUnidadConversionController controller = (ComUnidadConversionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comUnidadConversionController");
            return controller.getComUnidadConversion(getKey(value));
        }

        org.jsuns.commerce.jpa.ComUnidadConversionPK getKey(String value) {
            org.jsuns.commerce.jpa.ComUnidadConversionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.ComUnidadConversionPK();
            key.setIdUnidadA(Integer.parseInt(values[0]));
            key.setIdUnidadB(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.ComUnidadConversionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdUnidadA());
            sb.append(SEPARATOR);
            sb.append(value.getIdUnidadB());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ComUnidadConversion) {
                ComUnidadConversion o = (ComUnidadConversion) object;
                return getStringKey(o.getComUnidadConversionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComUnidadConversion.class.getName()});
                return null;
            }
        }

    }

}
