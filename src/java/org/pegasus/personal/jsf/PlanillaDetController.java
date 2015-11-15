package org.pegasus.personal.jsf;

import org.pegasus.personal.jpa.PlanillaDet;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.PlanillaDetFacade;

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

@Named("planillaDetController")
@SessionScoped
public class PlanillaDetController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.PlanillaDetFacade ejbFacade;
    private List<PlanillaDet> items = null;
    private PlanillaDet selected;

    public PlanillaDetController() {
    }

    public PlanillaDet getSelected() {
        return selected;
    }

    public void setSelected(PlanillaDet selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setPlanillaDetPK(new org.pegasus.personal.jpa.PlanillaDetPK());
    }

    private PlanillaDetFacade getFacade() {
        return ejbFacade;
    }

    public PlanillaDet prepareCreate() {
        selected = new PlanillaDet();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PlanillaDetCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PlanillaDetUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PlanillaDetDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PlanillaDet> getItems() {
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

    public PlanillaDet getPlanillaDet(org.pegasus.personal.jpa.PlanillaDetPK id) {
        return getFacade().find(id);
    }

    public List<PlanillaDet> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PlanillaDet> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PlanillaDet.class)
    public static class PlanillaDetControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlanillaDetController controller = (PlanillaDetController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "planillaDetController");
            return controller.getPlanillaDet(getKey(value));
        }

        org.pegasus.personal.jpa.PlanillaDetPK getKey(String value) {
            org.pegasus.personal.jpa.PlanillaDetPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.PlanillaDetPK();
            key.setNExpediente(values[0]);
            key.setAnoEje(values[1]);
            key.setDni(values[2]);
            key.setCodigo(values[3]);
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.PlanillaDetPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNExpediente());
            sb.append(SEPARATOR);
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getDni());
            sb.append(SEPARATOR);
            sb.append(value.getCodigo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PlanillaDet) {
                PlanillaDet o = (PlanillaDet) object;
                return getStringKey(o.getPlanillaDetPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PlanillaDet.class.getName()});
                return null;
            }
        }

    }

}
