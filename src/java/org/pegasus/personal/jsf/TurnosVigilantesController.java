package org.pegasus.personal.jsf;

import org.pegasus.personal.jpa.TurnosVigilantes;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.AbstractController;
import org.pegasus.personal.ejb.TurnosVigilantesFacade;

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
import org.pegasus.personal.ejb.TurnosVigilantesFacadeLocal;

@Named("turnosVigilantesController")
@SessionScoped
public class TurnosVigilantesController extends AbstractController<TurnosVigilantes> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.TurnosVigilantesFacadeLocal ejbFacade;

    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setTurnosVigilantesPK(new org.pegasus.personal.jpa.TurnosVigilantesPK());
    }

    private TurnosVigilantesFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<TurnosVigilantes> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        TurnosVigilantes selected = this.getSelected();
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

    public TurnosVigilantes getTurnosVigilantes(org.pegasus.personal.jpa.TurnosVigilantesPK id) {
        return getFacade().find(id);
    }

    public List<TurnosVigilantes> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<TurnosVigilantes> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = TurnosVigilantes.class)
    public static class TurnosVigilantesControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TurnosVigilantesController controller = (TurnosVigilantesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "turnosVigilantesController");
            return controller.getTurnosVigilantes(getKey(value));
        }

        org.pegasus.personal.jpa.TurnosVigilantesPK getKey(String value) {
            org.pegasus.personal.jpa.TurnosVigilantesPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.TurnosVigilantesPK();
            key.setDni(values[0]);
            key.setTipoHor(new Character(values[1].charAt(0)));
            key.setFechaIni(java.sql.Date.valueOf(values[2]));
            key.setFechaFin(java.sql.Date.valueOf(values[3]));
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.TurnosVigilantesPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDni());
            sb.append(SEPARATOR);
            sb.append(value.getTipoHor());
            sb.append(SEPARATOR);
            sb.append(value.getFechaIni());
            sb.append(SEPARATOR);
            sb.append(value.getFechaFin());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TurnosVigilantes) {
                TurnosVigilantes o = (TurnosVigilantes) object;
                return getStringKey(o.getTurnosVigilantesPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), TurnosVigilantes.class.getName()});
                return null;
            }
        }

    }

}
