package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SgcCriterio;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SgcCriterioFacade;
import edu.uns.oceca.ejb.SgcCriterioFacadeLocal;

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

@Named("sgcCriterioController")
@SessionScoped
public class SgcCriterioController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SgcCriterioFacadeLocal ejbFacade;
    private List<SgcCriterio> items = null;
    private SgcCriterio selected;

    public SgcCriterioController() {
    }

    public SgcCriterio getSelected() {
        return selected;
    }

    public void setSelected(SgcCriterio selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSgcCriterioPK(new edu.uns.oceca.jpa.SgcCriterioPK());
    }

    private SgcCriterioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SgcCriterio prepareCreate() {
        selected = new SgcCriterio();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgcCriterioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgcCriterioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgcCriterioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgcCriterio> getItems() {
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

    public SgcCriterio getSgcCriterio(edu.uns.oceca.jpa.SgcCriterioPK id) {
        return getFacade().find(id);
    }

    public List<SgcCriterio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgcCriterio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgcCriterio.class)
    public static class SgcCriterioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgcCriterioController controller = (SgcCriterioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcCriterioController");
            return controller.getSgcCriterio(getKey(value));
        }

        edu.uns.oceca.jpa.SgcCriterioPK getKey(String value) {
            edu.uns.oceca.jpa.SgcCriterioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SgcCriterioPK();
            key.setIdCriterio(Integer.parseInt(values[0]));
            key.setIdFactor(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SgcCriterioPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCriterio());
            sb.append(SEPARATOR);
            sb.append(value.getIdFactor());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgcCriterio) {
                SgcCriterio o = (SgcCriterio) object;
                return getStringKey(o.getSgcCriterioPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgcCriterio.class.getName()});
                return null;
            }
        }

    }

}
