package org.jsuns.commerce.jsf;

import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.commerce.ejb.AlmacenArticuloFacade;

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
import org.jsuns.commerce.ejb.AlmacenArticuloFacadeLocal;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.commerce.jpa.AlmacenArticuloPK;

@Named("almacenArticuloController")
@SessionScoped
public class AlmacenArticuloController implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.AlmacenArticuloFacadeLocal ejbFacade;
    private List<AlmacenArticulo> items = null;
    private AlmacenArticulo selected;

    public AlmacenArticuloController() {
    }

    public AlmacenArticulo getSelected() {
        return selected;
    }

    public void setSelected(AlmacenArticulo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getAlmacenArticuloPK().setIdArticulo(selected.getArticulo().getIdArticulo());
        selected.getAlmacenArticuloPK().setIdAlmacen(selected.getAlmacen().getIdAlmacen());
    }

    protected void initializeEmbeddableKey() {
        selected.setAlmacenArticuloPK(new AlmacenArticuloPK());
    }

    private AlmacenArticuloFacadeLocal getFacade() {
        return ejbFacade;
    }

    public AlmacenArticulo prepareCreate() {
        selected = new AlmacenArticulo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AlmacenArticuloCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AlmacenArticuloUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AlmacenArticuloDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AlmacenArticulo> getItems() {
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

    public AlmacenArticulo getAlmacenArticulo(AlmacenArticuloPK id) {
        return getFacade().find(id);
    }

    public List<AlmacenArticulo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AlmacenArticulo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AlmacenArticulo.class)
    public static class AlmacenArticuloControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AlmacenArticuloController controller = (AlmacenArticuloController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "almacenArticuloController");
            return controller.getAlmacenArticulo(getKey(value));
        }

        AlmacenArticuloPK getKey(String value) {
            AlmacenArticuloPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new AlmacenArticuloPK();
            key.setIdArticulo(Integer.parseInt(values[0]));
            key.setIdAlmacen(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(AlmacenArticuloPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdArticulo());
            sb.append(SEPARATOR);
            sb.append(value.getIdAlmacen());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AlmacenArticulo) {
                AlmacenArticulo o = (AlmacenArticulo) object;
                return getStringKey(o.getAlmacenArticuloPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AlmacenArticulo.class.getName()});
                return null;
            }
        }

    }

}
