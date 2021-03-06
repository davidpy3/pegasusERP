package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Funcion;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.FuncionFacadeLocal;

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

@Named("funcionController")
@SessionScoped
public class FuncionController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.FuncionFacadeLocal ejbFacade;
    private List<Funcion> items = null;
    private Funcion selected;

    public FuncionController() {
    }

    public Funcion getSelected() {
        return selected;
    }

    public void setSelected(Funcion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setFuncionPK(new org.pegasus.patrimonio.jpa.FuncionPK());
    }

    private FuncionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Funcion prepareCreate() {
        selected = new Funcion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FuncionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FuncionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FuncionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Funcion> getItems() {
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

    public Funcion getFuncion(org.pegasus.patrimonio.jpa.FuncionPK id) {
        return getFacade().find(id);
    }

    public List<Funcion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Funcion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Funcion.class)
    public static class FuncionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FuncionController controller = (FuncionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "funcionController");
            return controller.getFuncion(getKey(value));
        }

        org.pegasus.patrimonio.jpa.FuncionPK getKey(String value) {
            org.pegasus.patrimonio.jpa.FuncionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.FuncionPK();
            key.setAnoEje(values[0]);
            key.setFuncion(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.FuncionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getFuncion());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Funcion) {
                Funcion o = (Funcion) object;
                return getStringKey(o.getFuncionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Funcion.class.getName()});
                return null;
            }
        }

    }

}
