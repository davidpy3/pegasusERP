package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscNombramientosDoc;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscNombramientosDocFacade;
import edu.uns.escalafon.ejb.EscNombramientosDocFacadeLocal;

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

@Named("escNombramientosDocController")
@SessionScoped
public class EscNombramientosDocController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscNombramientosDocFacadeLocal ejbFacade;
    private List<EscNombramientosDoc> items = null;
    private EscNombramientosDoc selected;

    public EscNombramientosDocController() {
    }

    public EscNombramientosDoc getSelected() {
        return selected;
    }

    public void setSelected(EscNombramientosDoc selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscNombramientosDocFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscNombramientosDoc prepareCreate() {
        selected = new EscNombramientosDoc();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscNombramientosDocCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscNombramientosDocUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscNombramientosDocDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscNombramientosDoc> getItems() {
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

    public EscNombramientosDoc getEscNombramientosDoc(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EscNombramientosDoc> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscNombramientosDoc> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscNombramientosDoc.class)
    public static class EscNombramientosDocControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscNombramientosDocController controller = (EscNombramientosDocController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escNombramientosDocController");
            return controller.getEscNombramientosDoc(getKey(value));
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
            if (object instanceof EscNombramientosDoc) {
                EscNombramientosDoc o = (EscNombramientosDoc) object;
                return getStringKey(o.getIdNomd());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscNombramientosDoc.class.getName()});
                return null;
            }
        }

    }

}
