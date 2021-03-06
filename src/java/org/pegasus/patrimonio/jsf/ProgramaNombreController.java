package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.ProgramaNombre;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.ProgramaNombreFacadeLocal;

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

@Named("programaNombreController")
@SessionScoped
public class ProgramaNombreController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.ProgramaNombreFacadeLocal ejbFacade;
    private List<ProgramaNombre> items = null;
    private ProgramaNombre selected;

    public ProgramaNombreController() {
    }

    public ProgramaNombre getSelected() {
        return selected;
    }

    public void setSelected(ProgramaNombre selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setProgramaNombrePK(new org.pegasus.patrimonio.jpa.ProgramaNombrePK());
    }

    private ProgramaNombreFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ProgramaNombre prepareCreate() {
        selected = new ProgramaNombre();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProgramaNombreCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProgramaNombreUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProgramaNombreDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProgramaNombre> getItems() {
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

    public ProgramaNombre getProgramaNombre(org.pegasus.patrimonio.jpa.ProgramaNombrePK id) {
        return getFacade().find(id);
    }

    public List<ProgramaNombre> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProgramaNombre> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProgramaNombre.class)
    public static class ProgramaNombreControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramaNombreController controller = (ProgramaNombreController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programaNombreController");
            return controller.getProgramaNombre(getKey(value));
        }

        org.pegasus.patrimonio.jpa.ProgramaNombrePK getKey(String value) {
            org.pegasus.patrimonio.jpa.ProgramaNombrePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.ProgramaNombrePK();
            key.setAnoEje(values[0]);
            key.setPrograma(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.ProgramaNombrePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getPrograma());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProgramaNombre) {
                ProgramaNombre o = (ProgramaNombre) object;
                return getStringKey(o.getProgramaNombrePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProgramaNombre.class.getName()});
                return null;
            }
        }

    }

}
