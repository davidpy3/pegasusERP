package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscDejuPeriodo;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscDejuPeriodoFacade;
import edu.uns.escalafon.ejb.EscDejuPeriodoFacadeLocal;

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

@Named("escDejuPeriodoController")
@SessionScoped
public class EscDejuPeriodoController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscDejuPeriodoFacadeLocal ejbFacade;
    private List<EscDejuPeriodo> items = null;
    private EscDejuPeriodo selected;

    public EscDejuPeriodoController() {
    }

    public EscDejuPeriodo getSelected() {
        return selected;
    }

    public void setSelected(EscDejuPeriodo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscDejuPeriodoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscDejuPeriodo prepareCreate() {
        selected = new EscDejuPeriodo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscDejuPeriodoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscDejuPeriodoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscDejuPeriodoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscDejuPeriodo> getItems() {
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

    public EscDejuPeriodo getEscDejuPeriodo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EscDejuPeriodo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscDejuPeriodo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscDejuPeriodo.class)
    public static class EscDejuPeriodoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscDejuPeriodoController controller = (EscDejuPeriodoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escDejuPeriodoController");
            return controller.getEscDejuPeriodo(getKey(value));
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
            if (object instanceof EscDejuPeriodo) {
                EscDejuPeriodo o = (EscDejuPeriodo) object;
                return getStringKey(o.getIdPeriodo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscDejuPeriodo.class.getName()});
                return null;
            }
        }

    }

}
