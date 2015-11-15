package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.ApsSituacionEstudiante;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.ApsSituacionEstudianteFacade;
import edu.uns.oceda.ejb.ApsSituacionEstudianteFacadeLocal;

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

@Named("apsSituacionEstudianteController")
@SessionScoped
public class ApsSituacionEstudianteController implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.ApsSituacionEstudianteFacadeLocal ejbFacade;
    private List<ApsSituacionEstudiante> items = null;
    private ApsSituacionEstudiante selected;

    public ApsSituacionEstudianteController() {
    }

    public ApsSituacionEstudiante getSelected() {
        return selected;
    }

    public void setSelected(ApsSituacionEstudiante selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ApsSituacionEstudianteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ApsSituacionEstudiante prepareCreate() {
        selected = new ApsSituacionEstudiante();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ApsSituacionEstudianteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ApsSituacionEstudianteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ApsSituacionEstudianteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ApsSituacionEstudiante> getItems() {
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

    public ApsSituacionEstudiante getApsSituacionEstudiante(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<ApsSituacionEstudiante> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ApsSituacionEstudiante> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ApsSituacionEstudiante.class)
    public static class ApsSituacionEstudianteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ApsSituacionEstudianteController controller = (ApsSituacionEstudianteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "apsSituacionEstudianteController");
            return controller.getApsSituacionEstudiante(getKey(value));
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
            if (object instanceof ApsSituacionEstudiante) {
                ApsSituacionEstudiante o = (ApsSituacionEstudiante) object;
                return getStringKey(o.getCodAcsit());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ApsSituacionEstudiante.class.getName()});
                return null;
            }
        }

    }

}
