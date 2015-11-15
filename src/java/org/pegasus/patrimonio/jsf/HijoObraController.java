package org.pegasus.patrimonio.jsf;

import org.pegasus.personal.jpa.HijosObra;
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
import org.pegasus.personal.ejb.HijoObraFacadeLocal;

@Named
@SessionScoped
public class HijoObraController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.HijoObraFacadeLocal ejbFacade;
    private List<HijosObra> items = null;
    private HijosObra selected;

    public HijoObraController() {
    }

    public HijosObra getSelected() {
        return selected;
    }

    public void setSelected(HijosObra selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setHijosObraPK(new org.pegasus.personal.jpa.HijosObraPK());
    }

    private HijoObraFacadeLocal getFacade() {
        return ejbFacade;
    }

    public HijosObra prepareCreate() {
        selected = new HijosObra();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("HijosObraCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("HijosObraUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("HijosObraDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<HijosObra> getItems() {
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

    public HijosObra getHijosObra(org.pegasus.personal.jpa.HijosObraPK id) {
        return getFacade().find(id);
    }

    public List<HijosObra> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<HijosObra> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = HijosObra.class)
    public static class HijosObraControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HijoObraController controller = (HijoObraController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "hijosObraController");
            return controller.getHijosObra(getKey(value));
        }

        org.pegasus.personal.jpa.HijosObraPK getKey(String value) {
            org.pegasus.personal.jpa.HijosObraPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.HijosObraPK();
            key.setDocuiden(values[0]);
            key.setNhijo(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.HijosObraPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDocuiden());
            sb.append(SEPARATOR);
            sb.append(value.getNhijo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof HijosObra) {
                HijosObra o = (HijosObra) object;
                return getStringKey(o.getHijosObraPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), HijosObra.class.getName()});
                return null;
            }
        }

    }

}
