package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Programa;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.ProgramaFacadeLocal;

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

@Named("programaController")
@SessionScoped
public class ProgramaController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.ProgramaFacadeLocal ejbFacade;
    private List<Programa> items = null;
    private Programa selected;

    public ProgramaController() {
    }

    public Programa getSelected() {
        return selected;
    }

    public void setSelected(Programa selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getProgramaPK().setPrograma(selected.getProgramaNombre().getProgramaNombrePK().getPrograma());
        selected.getProgramaPK().setFuncion(selected.getFuncion1().getFuncionPK().getFuncion());
        selected.getProgramaPK().setAnoEje(selected.getProgramaNombre().getProgramaNombrePK().getAnoEje());
    }

    protected void initializeEmbeddableKey() {
        selected.setProgramaPK(new org.pegasus.patrimonio.jpa.ProgramaPK());
    }

    private ProgramaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Programa prepareCreate() {
        selected = new Programa();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProgramaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProgramaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProgramaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Programa> getItems() {
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

    public Programa getPrograma(org.pegasus.patrimonio.jpa.ProgramaPK id) {
        return getFacade().find(id);
    }

    public List<Programa> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Programa> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Programa.class)
    public static class ProgramaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProgramaController controller = (ProgramaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "programaController");
            return controller.getPrograma(getKey(value));
        }

        org.pegasus.patrimonio.jpa.ProgramaPK getKey(String value) {
            org.pegasus.patrimonio.jpa.ProgramaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.ProgramaPK();
            key.setAnoEje(values[0]);
            key.setFuncion(values[1]);
            key.setPrograma(values[2]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.ProgramaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getFuncion());
            sb.append(SEPARATOR);
            sb.append(value.getPrograma());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Programa) {
                Programa o = (Programa) object;
                return getStringKey(o.getProgramaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Programa.class.getName()});
                return null;
            }
        }

    }

}
