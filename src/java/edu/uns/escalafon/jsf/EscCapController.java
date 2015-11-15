package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscCap;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscCapFacade;
import edu.uns.escalafon.ejb.EscCapFacadeLocal;

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

@Named("escCapController")
@SessionScoped
public class EscCapController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscCapFacadeLocal ejbFacade;
    private List<EscCap> items = null;
    private EscCap selected;

    public EscCapController() {
    }

    public EscCap getSelected() {
        return selected;
    }

    public void setSelected(EscCap selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setEscCapPK(new edu.uns.escalafon.jpa.EscCapPK());
    }

    private EscCapFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscCap prepareCreate() {
        selected = new EscCap();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscCapCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscCapUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscCapDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscCap> getItems() {
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

    public EscCap getEscCap(edu.uns.escalafon.jpa.EscCapPK id) {
        return getFacade().find(id);
    }

    public List<EscCap> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscCap> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscCap.class)
    public static class EscCapControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscCapController controller = (EscCapController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escCapController");
            return controller.getEscCap(getKey(value));
        }

        edu.uns.escalafon.jpa.EscCapPK getKey(String value) {
            edu.uns.escalafon.jpa.EscCapPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.escalafon.jpa.EscCapPK();
            key.setIdCap(Integer.parseInt(values[0]));
            key.setIdDep(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.escalafon.jpa.EscCapPK value) {
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
            if (object instanceof EscCap) {
                EscCap o = (EscCap) object;
                return getStringKey(o.getEscCapPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscCap.class.getName()});
                return null;
            }
        }

    }

}
