package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscNivelRemunerativo;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscNivelRemunerativoFacade;
import edu.uns.escalafon.ejb.EscNivelRemunerativoFacadeLocal;

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

@Named("escNivelRemunerativoController")
@SessionScoped
public class EscNivelRemunerativoController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscNivelRemunerativoFacadeLocal ejbFacade;
    private List<EscNivelRemunerativo> items = null;
    private EscNivelRemunerativo selected;

    public EscNivelRemunerativoController() {
    }

    public EscNivelRemunerativo getSelected() {
        return selected;
    }

    public void setSelected(EscNivelRemunerativo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscNivelRemunerativoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscNivelRemunerativo prepareCreate() {
        selected = new EscNivelRemunerativo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscNivelRemunerativoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscNivelRemunerativoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscNivelRemunerativoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscNivelRemunerativo> getItems() {
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

    public EscNivelRemunerativo getEscNivelRemunerativo(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<EscNivelRemunerativo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscNivelRemunerativo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscNivelRemunerativo.class)
    public static class EscNivelRemunerativoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscNivelRemunerativoController controller = (EscNivelRemunerativoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escNivelRemunerativoController");
            return controller.getEscNivelRemunerativo(getKey(value));
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
            if (object instanceof EscNivelRemunerativo) {
                EscNivelRemunerativo o = (EscNivelRemunerativo) object;
                return getStringKey(o.getIdNivel());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscNivelRemunerativo.class.getName()});
                return null;
            }
        }

    }

}
