package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.FxaSituacionAcad;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.FxaSituacionAcadFacade;
import edu.uns.oceda.ejb.FxaSituacionAcadFacadeLocal;

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

@Named("fxaSituacionAcadController")
@SessionScoped
public class FxaSituacionAcadController implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.FxaSituacionAcadFacadeLocal ejbFacade;
    private List<FxaSituacionAcad> items = null;
    private FxaSituacionAcad selected;

    public FxaSituacionAcadController() {
    }

    public FxaSituacionAcad getSelected() {
        return selected;
    }

    public void setSelected(FxaSituacionAcad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FxaSituacionAcadFacadeLocal getFacade() {
        return ejbFacade;
    }

    public FxaSituacionAcad prepareCreate() {
        selected = new FxaSituacionAcad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FxaSituacionAcadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FxaSituacionAcadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FxaSituacionAcadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FxaSituacionAcad> getItems() {
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

    public FxaSituacionAcad getFxaSituacionAcad(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<FxaSituacionAcad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FxaSituacionAcad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FxaSituacionAcad.class)
    public static class FxaSituacionAcadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FxaSituacionAcadController controller = (FxaSituacionAcadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fxaSituacionAcadController");
            return controller.getFxaSituacionAcad(getKey(value));
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
            if (object instanceof FxaSituacionAcad) {
                FxaSituacionAcad o = (FxaSituacionAcad) object;
                return getStringKey(o.getCodSitAcad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FxaSituacionAcad.class.getName()});
                return null;
            }
        }

    }

}
