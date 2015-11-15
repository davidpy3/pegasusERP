package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SvaRespuestaDocenteEst;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaRespuestaDocenteEstFacade;
import edu.uns.oceca.ejb.SvaRespuestaDocenteEstFacadeLocal;

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

@Named("svaRespuestaDocenteEstController")
@SessionScoped
public class SvaRespuestaDocenteEstController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaRespuestaDocenteEstFacadeLocal ejbFacade;
    private List<SvaRespuestaDocenteEst> items = null;
    private SvaRespuestaDocenteEst selected;

    public SvaRespuestaDocenteEstController() {
    }

    public SvaRespuestaDocenteEst getSelected() {
        return selected;
    }

    public void setSelected(SvaRespuestaDocenteEst selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSvaRespuestaDocenteEstPK(new edu.uns.oceca.jpa.SvaRespuestaDocenteEstPK());
    }

    private SvaRespuestaDocenteEstFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SvaRespuestaDocenteEst prepareCreate() {
        selected = new SvaRespuestaDocenteEst();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaDocenteEstCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaDocenteEstUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SvaRespuestaDocenteEstDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SvaRespuestaDocenteEst> getItems() {
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

    public SvaRespuestaDocenteEst getSvaRespuestaDocenteEst(edu.uns.oceca.jpa.SvaRespuestaDocenteEstPK id) {
        return getFacade().find(id);
    }

    public List<SvaRespuestaDocenteEst> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SvaRespuestaDocenteEst> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SvaRespuestaDocenteEst.class)
    public static class SvaRespuestaDocenteEstControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaRespuestaDocenteEstController controller = (SvaRespuestaDocenteEstController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaRespuestaDocenteEstController");
            return controller.getSvaRespuestaDocenteEst(getKey(value));
        }

        edu.uns.oceca.jpa.SvaRespuestaDocenteEstPK getKey(String value) {
            edu.uns.oceca.jpa.SvaRespuestaDocenteEstPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SvaRespuestaDocenteEstPK();
            key.setIdParticipacion(Integer.parseInt(values[0]));
            key.setIdPregunta(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SvaRespuestaDocenteEstPK value) {
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
            if (object instanceof SvaRespuestaDocenteEst) {
                SvaRespuestaDocenteEst o = (SvaRespuestaDocenteEst) object;
                return getStringKey(o.getSvaRespuestaDocenteEstPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SvaRespuestaDocenteEst.class.getName()});
                return null;
            }
        }

    }

}
