package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.AlmacenDocumento;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.AlmacenDocumentoFacade;

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
import org.jsuns.commerce.ejb.AlmacenDocumentoFacadeLocal;

@Named
@SessionScoped
public class AlmacenDocumentoController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.AlmacenDocumentoFacadeLocal ejbFacade;
    private List<AlmacenDocumento> items = null;
    private AlmacenDocumento selected;

    public AlmacenDocumentoController() {
    }

    public AlmacenDocumento getSelected() {
        return selected;
    }

    public void setSelected(AlmacenDocumento selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getAlmacenDocumentoPK().setIdTipoDoc(selected.getTipoDoc().getIdTipoDoc());
    }

    protected void initializeEmbeddableKey() {
        selected.setAlmacenDocumentoPK(new org.jsuns.commerce.jpa.AlmacenDocumentoPK());
    }

    private AlmacenDocumentoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public AlmacenDocumento prepareCreate() {
        selected = new AlmacenDocumento();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AlmacenDocumentoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AlmacenDocumentoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AlmacenDocumentoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AlmacenDocumento> getItems() {
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

    public AlmacenDocumento getAlmacenDocumento(org.jsuns.commerce.jpa.AlmacenDocumentoPK id) {
        return getFacade().find(id);
    }

    public List<AlmacenDocumento> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AlmacenDocumento> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AlmacenDocumento.class)
    public static class AlmacenDocumentoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlmacenDocumentoController controller = (AlmacenDocumentoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "almacenDocumentoController");
            return controller.getAlmacenDocumento(getKey(value));
        }

        org.jsuns.commerce.jpa.AlmacenDocumentoPK getKey(String value) {
            org.jsuns.commerce.jpa.AlmacenDocumentoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.AlmacenDocumentoPK();
            key.setIdAlmacen(Integer.parseInt(values[0]));
            key.setIdTipoDoc(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.AlmacenDocumentoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdAlmacen());
            sb.append(SEPARATOR);
            sb.append(value.getIdTipoDoc());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AlmacenDocumento) {
                AlmacenDocumento o = (AlmacenDocumento) object;
                return getStringKey(o.getAlmacenDocumentoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AlmacenDocumento.class.getName()});
                return null;
            }
        }

    }

}
