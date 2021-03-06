package org.pegasus.registro_civil.jsf;

import org.pegasus.registro_civil.LotJugada;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.registro_civil.ejb.LotJugadaFacadeLocal;

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
public class LotJugadaController implements Serializable {

    @EJB
    private org.pegasus.registro_civil.ejb.LotJugadaFacadeLocal ejbFacade;
    private List<LotJugada> items = null;
    private LotJugada selected;

    public LotJugadaController() {
    }

    public LotJugada getSelected() {
        return selected;
    }

    public void setSelected(LotJugada selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private LotJugadaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public LotJugada prepareCreate() {
        selected = new LotJugada();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("LotJugadaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("LotJugadaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("LotJugadaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<LotJugada> getItems() {
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

    public LotJugada getLotJugada(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<LotJugada> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<LotJugada> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = LotJugada.class)
    public static class LotJugadaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            LotJugadaController controller = (LotJugadaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "lotJugadaController");
            return controller.getLotJugada(getKey(value));
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
            if (object instanceof LotJugada) {
                LotJugada o = (LotJugada) object;
                return getStringKey(o.getSorteo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), LotJugada.class.getName()});
                return null;
            }
        }

    }

}
