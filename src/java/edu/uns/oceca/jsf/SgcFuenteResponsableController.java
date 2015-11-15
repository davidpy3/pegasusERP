package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SgcFuenteResponsable;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SgcFuenteResponsableFacade;
import edu.uns.oceca.ejb.SgcFuenteResponsableFacadeLocal;

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

@Named("sgcFuenteResponsableController")
@SessionScoped
public class SgcFuenteResponsableController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SgcFuenteResponsableFacadeLocal ejbFacade;
    private List<SgcFuenteResponsable> items = null;
    private SgcFuenteResponsable selected;

    public SgcFuenteResponsableController() {
    }

    public SgcFuenteResponsable getSelected() {
        return selected;
    }

    public void setSelected(SgcFuenteResponsable selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSgcFuenteResponsablePK(new edu.uns.oceca.jpa.SgcFuenteResponsablePK());
    }

    private SgcFuenteResponsableFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SgcFuenteResponsable prepareCreate() {
        selected = new SgcFuenteResponsable();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgcFuenteResponsableCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgcFuenteResponsableUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgcFuenteResponsableDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgcFuenteResponsable> getItems() {
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

    public SgcFuenteResponsable getSgcFuenteResponsable(edu.uns.oceca.jpa.SgcFuenteResponsablePK id) {
        return getFacade().find(id);
    }

    public List<SgcFuenteResponsable> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgcFuenteResponsable> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgcFuenteResponsable.class)
    public static class SgcFuenteResponsableControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgcFuenteResponsableController controller = (SgcFuenteResponsableController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcFuenteResponsableController");
            return controller.getSgcFuenteResponsable(getKey(value));
        }

        edu.uns.oceca.jpa.SgcFuenteResponsablePK getKey(String value) {
            edu.uns.oceca.jpa.SgcFuenteResponsablePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SgcFuenteResponsablePK();
            key.setIdFuente(Integer.parseInt(values[0]));
            key.setIdDir(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SgcFuenteResponsablePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdFuente());
            sb.append(SEPARATOR);
            sb.append(value.getIdDir());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgcFuenteResponsable) {
                SgcFuenteResponsable o = (SgcFuenteResponsable) object;
                return getStringKey(o.getSgcFuenteResponsablePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgcFuenteResponsable.class.getName()});
                return null;
            }
        }

    }

}
