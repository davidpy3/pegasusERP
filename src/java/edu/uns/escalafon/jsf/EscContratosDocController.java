package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscContratosDoc;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscContratosDocFacade;
import edu.uns.escalafon.ejb.EscContratosDocFacadeLocal;

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

@Named("escContratosDocController")
@SessionScoped
public class EscContratosDocController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscContratosDocFacadeLocal ejbFacade;
    private List<EscContratosDoc> items = null;
    private EscContratosDoc selected;

    public EscContratosDocController() {
    }

    public EscContratosDoc getSelected() {
        return selected;
    }

    public void setSelected(EscContratosDoc selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscContratosDocFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscContratosDoc prepareCreate() {
        selected = new EscContratosDoc();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscContratosDocCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscContratosDocUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscContratosDocDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscContratosDoc> getItems() {
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

    public EscContratosDoc getEscContratosDoc(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EscContratosDoc> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscContratosDoc> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscContratosDoc.class)
    public static class EscContratosDocControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscContratosDocController controller = (EscContratosDocController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escContratosDocController");
            return controller.getEscContratosDoc(getKey(value));
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
            if (object instanceof EscContratosDoc) {
                EscContratosDoc o = (EscContratosDoc) object;
                return getStringKey(o.getIdCnd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscContratosDoc.class.getName()});
                return null;
            }
        }

    }

}
