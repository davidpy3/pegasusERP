package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.PatriMovimientoDet;
import org.pegasus.patrimonio.ejb.PatriMovimientoDetFacade;

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
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.patrimonio.ejb.PatriMovimientoDetFacadeLocal;

@Named
@SessionScoped
public class PatriMovimientoDetController implements Serializable {

    @EJB
    private org.pegasus.patrimonio.ejb.PatriMovimientoDetFacadeLocal ejbFacade;
    private List<PatriMovimientoDet> items = null;
    private PatriMovimientoDet selected;

    public PatriMovimientoDetController() {
    }

    public PatriMovimientoDet getSelected() {
        return selected;
    }

    public void setSelected(PatriMovimientoDet selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPatriMovimientoDetPK().setAnoEje(selected.getPatriMovimiento().getPatriMovimientoPK().getAnoEje());
        selected.getPatriMovimientoDetPK().setTipoMov(selected.getPatriMovimiento().getPatriMovimientoPK().getTipoMov());
        selected.getPatriMovimientoDetPK().setCorrela(selected.getBien().getBienPK().getCorrela());
        selected.getPatriMovimientoDetPK().setCodbien(selected.getBien().getBienPK().getCodbien());
        selected.getPatriMovimientoDetPK().setNumMov(selected.getPatriMovimiento().getPatriMovimientoPK().getNumMov());
    }

    protected void initializeEmbeddableKey() {
        selected.setPatriMovimientoDetPK(new org.pegasus.patrimonio.jpa.PatriMovimientoDetPK());
    }

    private PatriMovimientoDetFacadeLocal getFacade() {
        return ejbFacade;
    }

    public PatriMovimientoDet prepareCreate() {
        selected = new PatriMovimientoDet();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PatriMovimientoDetCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PatriMovimientoDetUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PatriMovimientoDetDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<PatriMovimientoDet> getItems() {
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

    public PatriMovimientoDet getPatriMovimientoDet(org.pegasus.patrimonio.jpa.PatriMovimientoDetPK id) {
        return getFacade().find(id);
    }

    public List<PatriMovimientoDet> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PatriMovimientoDet> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PatriMovimientoDet.class)
    public static class PatriMovimientoDetControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PatriMovimientoDetController controller = (PatriMovimientoDetController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "patriMovimientoDetController");
            return controller.getPatriMovimientoDet(getKey(value));
        }

        org.pegasus.patrimonio.jpa.PatriMovimientoDetPK getKey(String value) {
            org.pegasus.patrimonio.jpa.PatriMovimientoDetPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.PatriMovimientoDetPK();
            key.setAnoEje(values[0]);
            key.setTipoMov(new Character(values[1].charAt(0)));
            key.setNumMov(values[2]);
            key.setCodbien(values[3]);
            key.setCorrela(values[4]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.PatriMovimientoDetPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getTipoMov());
            sb.append(SEPARATOR);
            sb.append(value.getNumMov());
            sb.append(SEPARATOR);
            sb.append(value.getCodbien());
            sb.append(SEPARATOR);
            sb.append(value.getCorrela());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PatriMovimientoDet) {
                PatriMovimientoDet o = (PatriMovimientoDet) object;
                return getStringKey(o.getPatriMovimientoDetPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PatriMovimientoDet.class.getName()});
                return null;
            }
        }

    }

}
