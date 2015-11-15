package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.TrasladoArticulo;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.TrasladoArticuloFacade;

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
import org.jsuns.commerce.ejb.TrasladoArticuloFacadeLocal;

@Named("trasladoArticuloController")
@SessionScoped
public class TrasladoArticuloController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.TrasladoArticuloFacadeLocal ejbFacade;
    private List<TrasladoArticulo> items = null;
    private TrasladoArticulo selected;

    public TrasladoArticuloController() {
    }

    public TrasladoArticulo getSelected() {
        return selected;
    }

    public void setSelected(TrasladoArticulo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getTrasladoArticuloPK().setIdArticulo(selected.getArticulo().getIdArticulo());
        selected.getTrasladoArticuloPK().setIdTraslado(selected.getTraslado().getIdTraslado());
    }

    protected void initializeEmbeddableKey() {
        selected.setTrasladoArticuloPK(new org.jsuns.commerce.jpa.TrasladoArticuloPK());
    }

    private TrasladoArticuloFacadeLocal getFacade() {
        return ejbFacade;
    }

    public TrasladoArticulo prepareCreate() {
        selected = new TrasladoArticulo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TrasladoArticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TrasladoArticuloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TrasladoArticuloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<TrasladoArticulo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
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

    public TrasladoArticulo getTrasladoArticulo(org.jsuns.commerce.jpa.TrasladoArticuloPK id) {
        return getFacade().find(id);
    }

    public List<TrasladoArticulo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TrasladoArticulo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TrasladoArticulo.class)
    public static class TrasladoArticuloControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TrasladoArticuloController controller = (TrasladoArticuloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "trasladoArticuloController");
            return controller.getTrasladoArticulo(getKey(value));
        }

        org.jsuns.commerce.jpa.TrasladoArticuloPK getKey(String value) {
            org.jsuns.commerce.jpa.TrasladoArticuloPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.jsuns.commerce.jpa.TrasladoArticuloPK();
            key.setIdTraslado(Integer.parseInt(values[0]));
            key.setIdArticulo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.jsuns.commerce.jpa.TrasladoArticuloPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdTraslado());
            sb.append(SEPARATOR);
            sb.append(value.getIdArticulo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TrasladoArticulo) {
                TrasladoArticulo o = (TrasladoArticulo) object;
                return getStringKey(o.getTrasladoArticuloPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TrasladoArticulo.class.getName()});
                return null;
            }
        }

    }

}
