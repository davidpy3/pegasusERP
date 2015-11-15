package org.pegasus.personal.jsf;

import org.pegasus.personal.jpa.Horario;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.AbstractController;

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
import org.pegasus.personal.ejb.HorarioFacadeLocal;

@Named("horarioController")
@SessionScoped
public class HorarioController extends AbstractController<Horario> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.HorarioFacadeLocal ejbFacade;

    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setHorarioPK(new org.pegasus.personal.jpa.HorarioPK());
    }

    private HorarioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Horario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Horario selected = this.getSelected();
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

    public Horario getHorario(org.pegasus.personal.jpa.HorarioPK id) {
        return getFacade().find(id);
    }

    public List<Horario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Horario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Horario.class)
    public static class HorarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            HorarioController controller = (HorarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "horarioController");
            return controller.getHorario(getKey(value));
        }

        org.pegasus.personal.jpa.HorarioPK getKey(String value) {
            org.pegasus.personal.jpa.HorarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.HorarioPK();
            key.setTipoHor(new Character(values[0].charAt(0)));
            key.setTurno(new Character(values[1].charAt(0)));
            key.setRegistro(new Character(values[2].charAt(0)));
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.HorarioPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoHor());
            sb.append(SEPARATOR);
            sb.append(value.getTurno());
            sb.append(SEPARATOR);
            sb.append(value.getRegistro());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Horario) {
                Horario o = (Horario) object;
                return getStringKey(o.getHorarioPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Horario.class.getName()});
                return null;
            }
        }

    }

}
