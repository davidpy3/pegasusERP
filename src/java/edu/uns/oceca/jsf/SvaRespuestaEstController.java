package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SvaRespuestaEst;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaRespuestaEstFacade;
import edu.uns.oceca.ejb.SvaRespuestaEstFacadeLocal;

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

@Named("svaRespuestaEstController")
@SessionScoped
public class SvaRespuestaEstController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaRespuestaEstFacadeLocal ejbFacade;
    private List<SvaRespuestaEst> items = null;
    private SvaRespuestaEst selected;

    public SvaRespuestaEstController() {
    }

    public SvaRespuestaEst getSelected() {
        return selected;
    }

    public void setSelected(SvaRespuestaEst selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSvaRespuestaEstPK(new edu.uns.oceca.jpa.SvaRespuestaEstPK());
    }

    private SvaRespuestaEstFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SvaRespuestaEst prepareCreate() {
        selected = new SvaRespuestaEst();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaEstCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaEstUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaEstDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SvaRespuestaEst> getItems() {
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

    public SvaRespuestaEst getSvaRespuestaEst(edu.uns.oceca.jpa.SvaRespuestaEstPK id) {
        return getFacade().find(id);
    }

    public List<SvaRespuestaEst> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SvaRespuestaEst> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SvaRespuestaEst.class)
    public static class SvaRespuestaEstControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaRespuestaEstController controller = (SvaRespuestaEstController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaRespuestaEstController");
            return controller.getSvaRespuestaEst(getKey(value));
        }

        edu.uns.oceca.jpa.SvaRespuestaEstPK getKey(String value) {
            edu.uns.oceca.jpa.SvaRespuestaEstPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SvaRespuestaEstPK();
            key.setIdParticipacion(Integer.parseInt(values[0]));
            key.setIdPregunta(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SvaRespuestaEstPK value) {
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
            if (object instanceof SvaRespuestaEst) {
                SvaRespuestaEst o = (SvaRespuestaEst) object;
                return getStringKey(o.getSvaRespuestaEstPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SvaRespuestaEst.class.getName()});
                return null;
            }
        }

    }

}
