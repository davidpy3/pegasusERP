package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.ApsEspecialidad;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.ApsEspecialidadFacade;
import edu.uns.oceda.ejb.ApsEspecialidadFacadeLocal;

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

@Named("apsEspecialidadController")
@SessionScoped
public class ApsEspecialidadController implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.ApsEspecialidadFacadeLocal ejbFacade;
    private List<ApsEspecialidad> items = null;
    private ApsEspecialidad selected;

    public ApsEspecialidadController() {
    }

    public ApsEspecialidad getSelected() {
        return selected;
    }

    public void setSelected(ApsEspecialidad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ApsEspecialidadFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ApsEspecialidad prepareCreate() {
        selected = new ApsEspecialidad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ApsEspecialidadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ApsEspecialidadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ApsEspecialidadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ApsEspecialidad> getItems() {
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

    public ApsEspecialidad getApsEspecialidad(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ApsEspecialidad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ApsEspecialidad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ApsEspecialidad.class)
    public static class ApsEspecialidadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ApsEspecialidadController controller = (ApsEspecialidadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "apsEspecialidadController");
            return controller.getApsEspecialidad(getKey(value));
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
            if (object instanceof ApsEspecialidad) {
                ApsEspecialidad o = (ApsEspecialidad) object;
                return getStringKey(o.getIdEspecialidad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ApsEspecialidad.class.getName()});
                return null;
            }
        }

    }

}
