package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.ComConfiguracionDocumento;

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
import org.jsuns.commerce.ejb.ComConfiguracionDocumentoFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named
@SessionScoped
public class ComConfiguracionDocumentoController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.ComConfiguracionDocumentoFacadeLocal ejbFacade;
    private List<ComConfiguracionDocumento> items = null;
    private ComConfiguracionDocumento selected;

    public ComConfiguracionDocumentoController() {
    }

    public ComConfiguracionDocumento getSelected() {
        return selected;
    }

    public void setSelected(ComConfiguracionDocumento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setComConfiguracionDocumentoPK(new org.jsuns.commerce.jpa.ComConfiguracionDocumentoPK());
    }

    private ComConfiguracionDocumentoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ComConfiguracionDocumento prepareCreate() {
        selected = new ComConfiguracionDocumento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ComConfiguracionDocumentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ComConfiguracionDocumentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ComConfiguracionDocumentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ComConfiguracionDocumento> getItems() {
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

    public ComConfiguracionDocumento getComConfiguracionDocumento(org.jsuns.commerce.jpa.ComConfiguracionDocumentoPK id) {
        return getFacade().find(id);
    }

    public List<ComConfiguracionDocumento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ComConfiguracionDocumento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ComConfiguracionDocumento.class)
    public static class ComConfiguracionDocumentoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ComConfiguracionDocumentoController controller = (ComConfiguracionDocumentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "comConfiguracionDocumentoController");
            return controller.getComConfiguracionDocumento(getKey(value));
        }

        org.jsuns.commerce.jpa.ComConfiguracionDocumentoPK getKey(String value) {
            org.jsuns.commerce.jpa.ComConfiguracionDocumentoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.ComConfiguracionDocumentoPK();
            key.setIdSucursal(Integer.parseInt(values[0]));
            key.setIdTipoDocumento(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.ComConfiguracionDocumentoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdSucursal());
            sb.append(SEPARATOR);
            sb.append(value.getIdTipoDocumento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ComConfiguracionDocumento) {
                ComConfiguracionDocumento o = (ComConfiguracionDocumento) object;
                return getStringKey(o.getComConfiguracionDocumentoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ComConfiguracionDocumento.class.getName()});
                return null;
            }
        }

    }

}
