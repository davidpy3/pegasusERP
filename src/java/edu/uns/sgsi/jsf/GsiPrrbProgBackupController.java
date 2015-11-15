package edu.uns.sgsi.jsf;

import edu.uns.sgsi.ejb.GsiPrrbProgBackupFacadeLocal;
import edu.uns.sgsi.jpa.GsiPrrbProgBackup;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@ManagedBean(name = "gsiPrrbProgBackupController")
@SessionScoped
public class GsiPrrbProgBackupController implements Serializable {

    @EJB
    private edu.uns.sgsi.ejb.GsiPrrbProgBackupFacadeLocal ejbFacade;
    private List<GsiPrrbProgBackup> items = null;
    private GsiPrrbProgBackup selected;

    public GsiPrrbProgBackupController() {
    }

    public GsiPrrbProgBackup getSelected() {
        return selected;
    }

    public void setSelected(GsiPrrbProgBackup selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private GsiPrrbProgBackupFacadeLocal getFacade() {
        return ejbFacade;
    }

    public GsiPrrbProgBackup prepareCreate() {
        selected = new GsiPrrbProgBackup();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GsiPrrbProgBackupCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GsiPrrbProgBackupUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GsiPrrbProgBackupDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<GsiPrrbProgBackup> getItems() {
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

    public List<GsiPrrbProgBackup> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<GsiPrrbProgBackup> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = GsiPrrbProgBackup.class)
    public static class GsiPrrbProgBackupControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GsiPrrbProgBackupController controller = (GsiPrrbProgBackupController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "gsiPrrbProgBackupController");
            return controller.getFacade().find(getKey(value));
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
            if (object instanceof GsiPrrbProgBackup) {
                GsiPrrbProgBackup o = (GsiPrrbProgBackup) object;
                return getStringKey(o.getIdProg());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), GsiPrrbProgBackup.class.getName()});
                return null;
            }
        }

    }

}
