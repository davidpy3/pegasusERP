package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscNivelRemunerativoUns;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscNivelRemunerativoUnsFacade;
import edu.uns.escalafon.ejb.EscNivelRemunerativoUnsFacadeLocal;

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

@Named("escNivelRemunerativoUnsController")
@SessionScoped
public class EscNivelRemunerativoUnsController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscNivelRemunerativoUnsFacadeLocal ejbFacade;
    private List<EscNivelRemunerativoUns> items = null;
    private EscNivelRemunerativoUns selected;

    public EscNivelRemunerativoUnsController() {
    }

    public EscNivelRemunerativoUns getSelected() {
        return selected;
    }

    public void setSelected(EscNivelRemunerativoUns selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEscNivelRemunerativoUnsPK(new edu.uns.escalafon.jpa.EscNivelRemunerativoUnsPK());
    }

    private EscNivelRemunerativoUnsFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscNivelRemunerativoUns prepareCreate() {
        selected = new EscNivelRemunerativoUns();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscNivelRemunerativoUnsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscNivelRemunerativoUnsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscNivelRemunerativoUnsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscNivelRemunerativoUns> getItems() {
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

    public EscNivelRemunerativoUns getEscNivelRemunerativoUns(edu.uns.escalafon.jpa.EscNivelRemunerativoUnsPK id) {
        return getFacade().find(id);
    }

    public List<EscNivelRemunerativoUns> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscNivelRemunerativoUns> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscNivelRemunerativoUns.class)
    public static class EscNivelRemunerativoUnsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscNivelRemunerativoUnsController controller = (EscNivelRemunerativoUnsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escNivelRemunerativoUnsController");
            return controller.getEscNivelRemunerativoUns(getKey(value));
        }

        edu.uns.escalafon.jpa.EscNivelRemunerativoUnsPK getKey(String value) {
            edu.uns.escalafon.jpa.EscNivelRemunerativoUnsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.escalafon.jpa.EscNivelRemunerativoUnsPK();
            key.setIdNivel(Short.parseShort(values[0]));
            key.setTipo(Boolean.parseBoolean(values[1]));
            return key;
        }

        String getStringKey(edu.uns.escalafon.jpa.EscNivelRemunerativoUnsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdNivel());
            sb.append(SEPARATOR);
            sb.append(value.getTipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscNivelRemunerativoUns) {
                EscNivelRemunerativoUns o = (EscNivelRemunerativoUns) object;
                return getStringKey(o.getEscNivelRemunerativoUnsPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscNivelRemunerativoUns.class.getName()});
                return null;
            }
        }

    }

}
