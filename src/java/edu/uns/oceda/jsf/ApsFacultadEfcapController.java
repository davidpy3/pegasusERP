package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.ApsFacultadEfcap;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.ApsFacultadEfcapFacade;
import edu.uns.oceda.ejb.ApsFacultadEfcapFacadeLocal;

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

@Named("apsFacultadEfcapController")
@SessionScoped
public class ApsFacultadEfcapController implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.ApsFacultadEfcapFacadeLocal ejbFacade;
    private List<ApsFacultadEfcap> items = null;
    private ApsFacultadEfcap selected;

    public ApsFacultadEfcapController() {
    }

    public ApsFacultadEfcap getSelected() {
        return selected;
    }

    public void setSelected(ApsFacultadEfcap selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ApsFacultadEfcapFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ApsFacultadEfcap prepareCreate() {
        selected = new ApsFacultadEfcap();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ApsFacultadEfcapCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ApsFacultadEfcapUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ApsFacultadEfcapDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ApsFacultadEfcap> getItems() {
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

    public ApsFacultadEfcap getApsFacultadEfcap(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ApsFacultadEfcap> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ApsFacultadEfcap> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ApsFacultadEfcap.class)
    public static class ApsFacultadEfcapControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ApsFacultadEfcapController controller = (ApsFacultadEfcapController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "apsFacultadEfcapController");
            return controller.getApsFacultadEfcap(getKey(value));
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
            if (object instanceof ApsFacultadEfcap) {
                ApsFacultadEfcap o = (ApsFacultadEfcap) object;
                return getStringKey(o.getIdFacultad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ApsFacultadEfcap.class.getName()});
                return null;
            }
        }

    }

}
