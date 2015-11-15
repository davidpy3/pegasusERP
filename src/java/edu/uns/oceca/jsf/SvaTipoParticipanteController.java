package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SvaTipoParticipante;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SvaTipoParticipanteFacade;
import edu.uns.oceca.ejb.SvaTipoParticipanteFacadeLocal;

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

@Named("svaTipoParticipanteController")
@SessionScoped
public class SvaTipoParticipanteController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SvaTipoParticipanteFacadeLocal ejbFacade;
    private List<SvaTipoParticipante> items = null;
    private SvaTipoParticipante selected;

    public SvaTipoParticipanteController() {
    }

    public SvaTipoParticipante getSelected() {
        return selected;
    }

    public void setSelected(SvaTipoParticipante selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SvaTipoParticipanteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SvaTipoParticipante prepareCreate() {
        selected = new SvaTipoParticipante();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SvaTipoParticipanteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SvaTipoParticipanteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SvaTipoParticipanteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SvaTipoParticipante> getItems() {
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

    public SvaTipoParticipante getSvaTipoParticipante(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<SvaTipoParticipante> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SvaTipoParticipante> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SvaTipoParticipante.class)
    public static class SvaTipoParticipanteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SvaTipoParticipanteController controller = (SvaTipoParticipanteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "svaTipoParticipanteController");
            return controller.getSvaTipoParticipante(getKey(value));
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
            if (object instanceof SvaTipoParticipante) {
                SvaTipoParticipante o = (SvaTipoParticipante) object;
                return getStringKey(o.getIdTipo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SvaTipoParticipante.class.getName()});
                return null;
            }
        }

    }

}
