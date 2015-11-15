package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscEstadoTrabajador;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscEstadoTrabajadorFacade;
import edu.uns.escalafon.ejb.EscEstadoTrabajadorFacadeLocal;

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

@Named("escEstadoTrabajadorController")
@SessionScoped
public class EscEstadoTrabajadorController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscEstadoTrabajadorFacadeLocal ejbFacade;
    private List<EscEstadoTrabajador> items = null;
    private EscEstadoTrabajador selected;

    public EscEstadoTrabajadorController() {
    }

    public EscEstadoTrabajador getSelected() {
        return selected;
    }

    public void setSelected(EscEstadoTrabajador selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscEstadoTrabajadorFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscEstadoTrabajador prepareCreate() {
        selected = new EscEstadoTrabajador();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscEstadoTrabajadorCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscEstadoTrabajadorUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscEstadoTrabajadorDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscEstadoTrabajador> getItems() {
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

    public EscEstadoTrabajador getEscEstadoTrabajador(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<EscEstadoTrabajador> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscEstadoTrabajador> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscEstadoTrabajador.class)
    public static class EscEstadoTrabajadorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscEstadoTrabajadorController controller = (EscEstadoTrabajadorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escEstadoTrabajadorController");
            return controller.getEscEstadoTrabajador(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscEstadoTrabajador) {
                EscEstadoTrabajador o = (EscEstadoTrabajador) object;
                return getStringKey(o.getIdEstado());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscEstadoTrabajador.class.getName()});
                return null;
            }
        }

    }

}
