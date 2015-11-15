package org.pegasus.registro_civil.jsf;

import org.pegasus.registro_civil.OmarPartidaDef;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.registro_civil.ejb.OmarPartidaDefFacadeLocal;

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

@Named
@SessionScoped
public class OmarPartidaDefController implements Serializable {

    @EJB
    private org.pegasus.registro_civil.ejb.OmarPartidaDefFacadeLocal ejbFacade;
    private List<OmarPartidaDef> items = null;
    private OmarPartidaDef selected;

    public OmarPartidaDefController() {
    }

    public OmarPartidaDef getSelected() {
        return selected;
    }

    public void setSelected(OmarPartidaDef selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OmarPartidaDefFacadeLocal getFacade() {
        return ejbFacade;
    }

    public OmarPartidaDef prepareCreate() {
        selected = new OmarPartidaDef();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OmarPartidaDefCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OmarPartidaDefUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OmarPartidaDefDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<OmarPartidaDef> getItems() {
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

    public OmarPartidaDef getOmarPartidaDef(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<OmarPartidaDef> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OmarPartidaDef> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = OmarPartidaDef.class)
    public static class OmarPartidaDefControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OmarPartidaDefController controller = (OmarPartidaDefController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "omarPartidaDefController");
            return controller.getOmarPartidaDef(getKey(value));
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
            if (object instanceof OmarPartidaDef) {
                OmarPartidaDef o = (OmarPartidaDef) object;
                return getStringKey(o.getIdPartidadef());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OmarPartidaDef.class.getName()});
                return null;
            }
        }

    }

}
