package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SvaEvaluacionDocenteParticipacion;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaEvaluacionDocenteParticipacionFacade;
import edu.uns.oceca.ejb.SvaEvaluacionDocenteParticipacionFacadeLocal;

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

@Named("svaEvaluacionDocenteParticipacionController")
@SessionScoped
public class SvaEvaluacionDocenteParticipacionController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaEvaluacionDocenteParticipacionFacadeLocal ejbFacade;
    private List<SvaEvaluacionDocenteParticipacion> items = null;
    private SvaEvaluacionDocenteParticipacion selected;

    public SvaEvaluacionDocenteParticipacionController() {
    }

    public SvaEvaluacionDocenteParticipacion getSelected() {
        return selected;
    }

    public void setSelected(SvaEvaluacionDocenteParticipacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SvaEvaluacionDocenteParticipacionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SvaEvaluacionDocenteParticipacion prepareCreate() {
        selected = new SvaEvaluacionDocenteParticipacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SvaEvaluacionDocenteParticipacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SvaEvaluacionDocenteParticipacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SvaEvaluacionDocenteParticipacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SvaEvaluacionDocenteParticipacion> getItems() {
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

    public SvaEvaluacionDocenteParticipacion getSvaEvaluacionDocenteParticipacion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SvaEvaluacionDocenteParticipacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SvaEvaluacionDocenteParticipacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SvaEvaluacionDocenteParticipacion.class)
    public static class SvaEvaluacionDocenteParticipacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaEvaluacionDocenteParticipacionController controller = (SvaEvaluacionDocenteParticipacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaEvaluacionDocenteParticipacionController");
            return controller.getSvaEvaluacionDocenteParticipacion(getKey(value));
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
            if (object instanceof SvaEvaluacionDocenteParticipacion) {
                SvaEvaluacionDocenteParticipacion o = (SvaEvaluacionDocenteParticipacion) object;
                return getStringKey(o.getIdParticipacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SvaEvaluacionDocenteParticipacion.class.getName()});
                return null;
            }
        }

    }

}
