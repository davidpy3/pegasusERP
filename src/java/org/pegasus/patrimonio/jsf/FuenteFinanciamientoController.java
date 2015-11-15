package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.FuenteFinanc;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.FuenteFinanciamientoFacadeLocal;

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
public class FuenteFinanciamientoController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.FuenteFinanciamientoFacadeLocal ejbFacade;
    private List<FuenteFinanc> items = null;
    private FuenteFinanc selected;

    public FuenteFinanciamientoController() {
    }

    public FuenteFinanc getSelected() {
        return selected;
    }

    public void setSelected(FuenteFinanc selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setFuenteFinancPK(new org.pegasus.patrimonio.jpa.FuenteFinancPK());
    }

    private FuenteFinanciamientoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public FuenteFinanc prepareCreate() {
        selected = new FuenteFinanc();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FuenteFinancCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FuenteFinancUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("FuenteFinancDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<FuenteFinanc> getItems() {
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

    public FuenteFinanc getFuenteFinanc(org.pegasus.patrimonio.jpa.FuenteFinancPK id) {
        return getFacade().find(id);
    }

    public List<FuenteFinanc> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<FuenteFinanc> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = FuenteFinanc.class)
    public static class FuenteFinancControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FuenteFinanciamientoController controller = (FuenteFinanciamientoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fuenteFinancController");
            return controller.getFuenteFinanc(getKey(value));
        }

        org.pegasus.patrimonio.jpa.FuenteFinancPK getKey(String value) {
            org.pegasus.patrimonio.jpa.FuenteFinancPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.FuenteFinancPK();
            key.setAnoEje(values[0]);
            key.setFuenteFinanc(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.FuenteFinancPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getFuenteFinanc());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FuenteFinanc) {
                FuenteFinanc o = (FuenteFinanc) object;
                return getStringKey(o.getFuenteFinancPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FuenteFinanc.class.getName()});
                return null;
            }
        }

    }

}
