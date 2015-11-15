package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Expediente;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.ExpedienteFacadeLocal;

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
public class ExpedienteController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.ExpedienteFacadeLocal ejbFacade;
    private List<Expediente> items = null;
    private Expediente selected;

    public ExpedienteController() {
    }

    public Expediente getSelected() {
        return selected;
    }

    public void setSelected(Expediente selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setExpedientePK(new org.pegasus.patrimonio.jpa.ExpedientePK());
    }

    private ExpedienteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Expediente prepareCreate() {
        selected = new Expediente();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ExpedienteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ExpedienteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ExpedienteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Expediente> getItems() {
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

    public Expediente getExpediente(org.pegasus.patrimonio.jpa.ExpedientePK id) {
        return getFacade().find(id);
    }

    public List<Expediente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Expediente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Expediente.class)
    public static class ExpedienteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ExpedienteController controller = (ExpedienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "expedienteController");
            return controller.getExpediente(getKey(value));
        }

        org.pegasus.patrimonio.jpa.ExpedientePK getKey(String value) {
            org.pegasus.patrimonio.jpa.ExpedientePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.ExpedientePK();
            key.setAnoEje(values[0]);
            key.setNExpediente(Long.parseLong(values[1]));
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.ExpedientePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getNExpediente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Expediente) {
                Expediente o = (Expediente) object;
                return getStringKey(o.getExpedientePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Expediente.class.getName()});
                return null;
            }
        }

    }

}
