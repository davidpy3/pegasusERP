package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscTipoFinCarreraLab;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscTipoFinCarreraLabFacade;
import edu.uns.escalafon.ejb.EscTipoFinCarreraLabFacadeLocal;

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

@Named("escTipoFinCarreraLabController")
@SessionScoped
public class EscTipoFinCarreraLabController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscTipoFinCarreraLabFacadeLocal ejbFacade;
    private List<EscTipoFinCarreraLab> items = null;
    private EscTipoFinCarreraLab selected;

    public EscTipoFinCarreraLabController() {
    }

    public EscTipoFinCarreraLab getSelected() {
        return selected;
    }

    public void setSelected(EscTipoFinCarreraLab selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscTipoFinCarreraLabFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscTipoFinCarreraLab prepareCreate() {
        selected = new EscTipoFinCarreraLab();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscTipoFinCarreraLabCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscTipoFinCarreraLabUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscTipoFinCarreraLabDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscTipoFinCarreraLab> getItems() {
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

    public EscTipoFinCarreraLab getEscTipoFinCarreraLab(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<EscTipoFinCarreraLab> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscTipoFinCarreraLab> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscTipoFinCarreraLab.class)
    public static class EscTipoFinCarreraLabControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscTipoFinCarreraLabController controller = (EscTipoFinCarreraLabController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escTipoFinCarreraLabController");
            return controller.getEscTipoFinCarreraLab(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscTipoFinCarreraLab) {
                EscTipoFinCarreraLab o = (EscTipoFinCarreraLab) object;
                return getStringKey(o.getIdTipo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscTipoFinCarreraLab.class.getName()});
                return null;
            }
        }

    }

}
