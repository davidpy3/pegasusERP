package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.QuizRespuesta;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaRespuestaFacade;
import edu.uns.oceca.ejb.SvaRespuestaFacadeLocal;

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

@Named("svaRespuestaController")
@SessionScoped
public class SvaRespuestaController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaRespuestaFacadeLocal ejbFacade;
    private List<QuizRespuesta> items = null;
    private QuizRespuesta selected;

    public SvaRespuestaController() {
    }

    public QuizRespuesta getSelected() {
        return selected;
    }

    public void setSelected(QuizRespuesta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSvaRespuestaPK(new edu.uns.oceca.jpa.SvaRespuestaPK());
    }

    private SvaRespuestaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public QuizRespuesta prepareCreate() {
        selected = new QuizRespuesta();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<QuizRespuesta> getItems() {
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

    public QuizRespuesta getSvaRespuesta(edu.uns.oceca.jpa.SvaRespuestaPK id) {
        return getFacade().find(id);
    }

    public List<QuizRespuesta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<QuizRespuesta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = QuizRespuesta.class)
    public static class SvaRespuestaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaRespuestaController controller = (SvaRespuestaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaRespuestaController");
            return controller.getSvaRespuesta(getKey(value));
        }

        edu.uns.oceca.jpa.SvaRespuestaPK getKey(String value) {
            edu.uns.oceca.jpa.SvaRespuestaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SvaRespuestaPK();
            key.setIdParticipacion(Integer.parseInt(values[0]));
            key.setIdPregunta(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SvaRespuestaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdParticipacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdPregunta());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof QuizRespuesta) {
                QuizRespuesta o = (QuizRespuesta) object;
                return getStringKey(o.getSvaRespuestaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), QuizRespuesta.class.getName()});
                return null;
            }
        }

    }

}
