package org.pegasus.personal.jsf;

import org.pegasus.personal.jpa.ModalidadLaboral;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.ModalidadLaboralFacade;

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
import org.pegasus.personal.ejb.ModalidadLaboralFacadeLocal;

@Named("modalidadLaboralController")
@SessionScoped
public class ModalidadLaboralController extends AbstractController<ModalidadLaboral> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.ModalidadLaboralFacadeLocal ejbFacade;

    private ModalidadLaboralFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<ModalidadLaboral> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        ModalidadLaboral selected=getSelected();
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

    public ModalidadLaboral getModalidadLaboral(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<ModalidadLaboral> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ModalidadLaboral> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ModalidadLaboral.class)
    public static class ModalidadLaboralControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ModalidadLaboralController controller = (ModalidadLaboralController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "modalidadLaboralController");
            return controller.getModalidadLaboral(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ModalidadLaboral) {
                ModalidadLaboral o = (ModalidadLaboral) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ModalidadLaboral.class.getName()});
                return null;
            }
        }

    }

}
