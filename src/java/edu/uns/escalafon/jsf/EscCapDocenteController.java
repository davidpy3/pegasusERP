package edu.uns.escalafon.jsf;

import edu.uns.escalafon.ejb.EscCapDocenteFacadeLocal;
import edu.uns.escalafon.jpa.EscCapDocente;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

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

@Named("escCapDocenteController")
@SessionScoped
public class EscCapDocenteController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscCapDocenteFacadeLocal ejbFacade;
    private List<EscCapDocente> items = null;
    private EscCapDocente selected;

    public EscCapDocenteController() {
    }

    public EscCapDocente getSelected() {
        return selected;
    }

    public void setSelected(EscCapDocente selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEscCapDocentePK(new edu.uns.escalafon.jpa.EscCapDocentePK());
    }

    private EscCapDocenteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscCapDocente prepareCreate() {
        selected = new EscCapDocente();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscCapDocenteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscCapDocenteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscCapDocenteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscCapDocente> getItems() {
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

    public EscCapDocente getEscCapDocente(edu.uns.escalafon.jpa.EscCapDocentePK id) {
        return getFacade().find(id);
    }

    public List<EscCapDocente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscCapDocente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscCapDocente.class)
    public static class EscCapDocenteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscCapDocenteController controller = (EscCapDocenteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escCapDocenteController");
            return controller.getEscCapDocente(getKey(value));
        }

        edu.uns.escalafon.jpa.EscCapDocentePK getKey(String value) {
            edu.uns.escalafon.jpa.EscCapDocentePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.escalafon.jpa.EscCapDocentePK();
            key.setIdCap(Integer.parseInt(values[0]));
            key.setIdDep(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.escalafon.jpa.EscCapDocentePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCap());
            sb.append(SEPARATOR);
            sb.append(value.getIdDep());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscCapDocente) {
                EscCapDocente o = (EscCapDocente) object;
                return getStringKey(o.getEscCapDocentePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscCapDocente.class.getName()});
                return null;
            }
        }

    }

}
