package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Afectaciones;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.AfectacionesFacade;

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
import org.pegasus.personal.ejb.AfectacionesFacadeLocal;

@Named("afectacionesController")
@SessionScoped
public class AfectacionesController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.AfectacionesFacadeLocal ejbFacade;
    private List<Afectaciones> items = null;
    private Afectaciones selected;

    public AfectacionesController() {
    }

    public Afectaciones getSelected() {
        return selected;
    }

    public void setSelected(Afectaciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setAfectacionesPK(new org.pegasus.patrimonio.jpa.AfectacionesPK());
    }

    private AfectacionesFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Afectaciones prepareCreate() {
        selected = new Afectaciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AfectacionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AfectacionesUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AfectacionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Afectaciones> getItems() {
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

    public Afectaciones getAfectaciones(org.pegasus.patrimonio.jpa.AfectacionesPK id) {
        return getFacade().find(id);
    }

    public List<Afectaciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Afectaciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Afectaciones.class)
    public static class AfectacionesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AfectacionesController controller = (AfectacionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "afectacionesController");
            return controller.getAfectaciones(getKey(value));
        }

        org.pegasus.patrimonio.jpa.AfectacionesPK getKey(String value) {
            org.pegasus.patrimonio.jpa.AfectacionesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.AfectacionesPK();
            key.setTipoTrab(values[0]);
            key.setCodigo(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.AfectacionesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoTrab());
            sb.append(SEPARATOR);
            sb.append(value.getCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Afectaciones) {
                Afectaciones o = (Afectaciones) object;
                return getStringKey(o.getAfectacionesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Afectaciones.class.getName()});
                return null;
            }
        }

    }

}
