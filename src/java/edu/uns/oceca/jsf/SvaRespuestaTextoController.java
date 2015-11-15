package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SvaRespuestaTexto;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaRespuestaTextoFacade;
import edu.uns.oceca.ejb.SvaRespuestaTextoFacadeLocal;

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

@Named("svaRespuestaTextoController")
@SessionScoped
public class SvaRespuestaTextoController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaRespuestaTextoFacadeLocal ejbFacade;
    private List<SvaRespuestaTexto> items = null;
    private SvaRespuestaTexto selected;

    public SvaRespuestaTextoController() {
    }

    public SvaRespuestaTexto getSelected() {
        return selected;
    }

    public void setSelected(SvaRespuestaTexto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSvaRespuestaTextoPK(new edu.uns.oceca.jpa.SvaRespuestaTextoPK());
    }

    private SvaRespuestaTextoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SvaRespuestaTexto prepareCreate() {
        selected = new SvaRespuestaTexto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaTextoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaTextoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaTextoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SvaRespuestaTexto> getItems() {
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

    public SvaRespuestaTexto getSvaRespuestaTexto(edu.uns.oceca.jpa.SvaRespuestaTextoPK id) {
        return getFacade().find(id);
    }

    public List<SvaRespuestaTexto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SvaRespuestaTexto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SvaRespuestaTexto.class)
    public static class SvaRespuestaTextoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaRespuestaTextoController controller = (SvaRespuestaTextoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaRespuestaTextoController");
            return controller.getSvaRespuestaTexto(getKey(value));
        }

        edu.uns.oceca.jpa.SvaRespuestaTextoPK getKey(String value) {
            edu.uns.oceca.jpa.SvaRespuestaTextoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SvaRespuestaTextoPK();
            key.setIdParticipacion(Integer.parseInt(values[0]));
            key.setIdPregunta(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SvaRespuestaTextoPK value) {
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
            if (object instanceof SvaRespuestaTexto) {
                SvaRespuestaTexto o = (SvaRespuestaTexto) object;
                return getStringKey(o.getSvaRespuestaTextoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SvaRespuestaTexto.class.getName()});
                return null;
            }
        }

    }

}
