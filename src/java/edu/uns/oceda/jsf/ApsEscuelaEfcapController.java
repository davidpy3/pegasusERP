package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.ApsEscuelaEfcap;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.ApsEscuelaEfcapFacade;
import edu.uns.oceda.ejb.ApsEscuelaEfcapFacadeLocal;

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

@Named("apsEscuelaEfcapController")
@SessionScoped
public class ApsEscuelaEfcapController implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.ApsEscuelaEfcapFacadeLocal ejbFacade;
    private List<ApsEscuelaEfcap> items = null;
    private ApsEscuelaEfcap selected;

    public ApsEscuelaEfcapController() {
    }

    public ApsEscuelaEfcap getSelected() {
        return selected;
    }

    public void setSelected(ApsEscuelaEfcap selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ApsEscuelaEfcapFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ApsEscuelaEfcap prepareCreate() {
        selected = new ApsEscuelaEfcap();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ApsEscuelaEfcapCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ApsEscuelaEfcapUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ApsEscuelaEfcapDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ApsEscuelaEfcap> getItems() {
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

    public ApsEscuelaEfcap getApsEscuelaEfcap(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ApsEscuelaEfcap> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ApsEscuelaEfcap> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ApsEscuelaEfcap.class)
    public static class ApsEscuelaEfcapControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ApsEscuelaEfcapController controller = (ApsEscuelaEfcapController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "apsEscuelaEfcapController");
            return controller.getApsEscuelaEfcap(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ApsEscuelaEfcap) {
                ApsEscuelaEfcap o = (ApsEscuelaEfcap) object;
                return getStringKey(o.getIdEscuela());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ApsEscuelaEfcap.class.getName()});
                return null;
            }
        }

    }

}
