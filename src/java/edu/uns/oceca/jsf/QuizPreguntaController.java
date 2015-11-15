package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.QuizPregunta;
import edu.uns.oceca.ejb.QuizPreguntaFacadeLocal;
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
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named("quizPreguntaController")
@SessionScoped
public class QuizPreguntaController extends AbstractController<QuizPregunta> implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.QuizPreguntaFacadeLocal ejbFacade;

    private QuizPreguntaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<QuizPregunta> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        QuizPregunta selected=getSelected();
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

    public QuizPregunta getQuizPregunta(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<QuizPregunta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<QuizPregunta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = QuizPregunta.class)
    public static class QuizPreguntaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            QuizPreguntaController controller = (QuizPreguntaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "quizPreguntaController");
            return controller.getQuizPregunta(getKey(value));
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
            if (object instanceof QuizPregunta) {
                QuizPregunta o = (QuizPregunta) object;
                return getStringKey(o.getIdPregunta());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), QuizPregunta.class.getName()});
                return null;
            }
        }

    }

}
