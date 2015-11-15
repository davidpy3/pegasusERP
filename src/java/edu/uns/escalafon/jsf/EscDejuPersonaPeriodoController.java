package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscDejuPersonaPeriodo;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscDejuPersonaPeriodoFacade;
import edu.uns.escalafon.ejb.EscDejuPersonaPeriodoFacadeLocal;

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

@Named("escDejuPersonaPeriodoController")
@SessionScoped
public class EscDejuPersonaPeriodoController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscDejuPersonaPeriodoFacadeLocal ejbFacade;
    private List<EscDejuPersonaPeriodo> items = null;
    private EscDejuPersonaPeriodo selected;

    public EscDejuPersonaPeriodoController() {
    }

    public EscDejuPersonaPeriodo getSelected() {
        return selected;
    }

    public void setSelected(EscDejuPersonaPeriodo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEscDejuPersonaPeriodoPK().setIdPeriodo(selected.getEscDejuPeriodo().getIdPeriodo());
    }

    protected void initializeEmbeddableKey() {
        selected.setEscDejuPersonaPeriodoPK(new edu.uns.escalafon.jpa.EscDejuPersonaPeriodoPK());
    }

    private EscDejuPersonaPeriodoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscDejuPersonaPeriodo prepareCreate() {
        selected = new EscDejuPersonaPeriodo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscDejuPersonaPeriodoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscDejuPersonaPeriodoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscDejuPersonaPeriodoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscDejuPersonaPeriodo> getItems() {
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

    public EscDejuPersonaPeriodo getEscDejuPersonaPeriodo(edu.uns.escalafon.jpa.EscDejuPersonaPeriodoPK id) {
        return getFacade().find(id);
    }

    public List<EscDejuPersonaPeriodo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscDejuPersonaPeriodo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscDejuPersonaPeriodo.class)
    public static class EscDejuPersonaPeriodoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscDejuPersonaPeriodoController controller = (EscDejuPersonaPeriodoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escDejuPersonaPeriodoController");
            return controller.getEscDejuPersonaPeriodo(getKey(value));
        }

        edu.uns.escalafon.jpa.EscDejuPersonaPeriodoPK getKey(String value) {
            edu.uns.escalafon.jpa.EscDejuPersonaPeriodoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.escalafon.jpa.EscDejuPersonaPeriodoPK();
            key.setIdEsc(Integer.parseInt(values[0]));
            key.setIdPeriodo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.escalafon.jpa.EscDejuPersonaPeriodoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdEsc());
            sb.append(SEPARATOR);
            sb.append(value.getIdPeriodo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscDejuPersonaPeriodo) {
                EscDejuPersonaPeriodo o = (EscDejuPersonaPeriodo) object;
                return getStringKey(o.getEscDejuPersonaPeriodoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscDejuPersonaPeriodo.class.getName()});
                return null;
            }
        }

    }

}
