package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Oficina;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;


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
import org.pegasus.patrimonio.ejb.OficinaFacadeLocal;

@Named("oficinaController")
@SessionScoped
public class OficinaController implements Serializable {

    @EJB
    private OficinaFacadeLocal ejbFacade;
    private List<Oficina> items = null;
    private Oficina selected;

    public OficinaController() {
    }

    public Oficina getSelected() {
        return selected;
    }

    public void setSelected(Oficina selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getOficinaPK().setCodarea(selected.getArea().getCodarea());
    }

    protected void initializeEmbeddableKey() {
        selected.setOficinaPK(new org.pegasus.patrimonio.jpa.OficinaPK());
    }

    private OficinaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Oficina prepareCreate() {
        selected = new Oficina();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("OficinaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("OficinaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("OficinaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Oficina> getItems() {
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

    public Oficina getOficina(org.pegasus.patrimonio.jpa.OficinaPK id) {
        return getFacade().find(id);
    }

    public List<Oficina> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Oficina> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Oficina.class)
    public static class OficinaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OficinaController controller = (OficinaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "oficinaController");
            return controller.getOficina(getKey(value));
        }

        org.pegasus.patrimonio.jpa.OficinaPK getKey(String value) {
            org.pegasus.patrimonio.jpa.OficinaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.OficinaPK();
            key.setCodarea(values[0]);
            key.setCodoficina(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.OficinaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodarea());
            sb.append(SEPARATOR);
            sb.append(value.getCodoficina());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Oficina) {
                Oficina o = (Oficina) object;
                return getStringKey(o.getOficinaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Oficina.class.getName()});
                return null;
            }
        }

    }

}
