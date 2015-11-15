package org.pegasus.personal.jsf;

import org.pegasus.personal.jpa.NivelRemunerativo;
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
import org.jsuns.util.AbstractController;
import org.pegasus.personal.ejb.NivelRemunerativoFacadeLocal;

@Named("nivelRemunerativoController")
@SessionScoped
public class NivelRemunerativoController extends AbstractController<NivelRemunerativo> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.NivelRemunerativoFacadeLocal ejbFacade;
    
    private NivelRemunerativoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<NivelRemunerativo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        NivelRemunerativo selected=getSelected();
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

    public NivelRemunerativo getNivelRemunerativo(org.pegasus.personal.jpa.NivelRemunerativoPK id) {
        return getFacade().find(id);
    }

    public List<NivelRemunerativo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<NivelRemunerativo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = NivelRemunerativo.class)
    public static class NivelRemunerativoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            NivelRemunerativoController controller = (NivelRemunerativoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "nivelRemunerativoController");
            return controller.getNivelRemunerativo(getKey(value));
        }

        org.pegasus.personal.jpa.NivelRemunerativoPK getKey(String value) {
            org.pegasus.personal.jpa.NivelRemunerativoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.NivelRemunerativoPK();
            key.setTipoTrab(values[0]);
            key.setNivelRem(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.NivelRemunerativoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoTrab());
            sb.append(SEPARATOR);
            sb.append(value.getNivelRem());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof NivelRemunerativo) {
                NivelRemunerativo o = (NivelRemunerativo) object;
                return getStringKey(o.getNivelRemunerativoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), NivelRemunerativo.class.getName()});
                return null;
            }
        }

    }

}
