package org.pegasus.personal.jsf;

import org.pegasus.personal.jpa.PersonalDscto;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.HashMap;
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
import org.pegasus.personal.ejb.PersonalDsctoFacadeLocal;

@Named("personalDsctoController")
@SessionScoped
public class PersonalDsctoController extends AbstractController<PersonalDscto> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.PersonalDsctoFacadeLocal ejbFacade;
    private HashMap params=new HashMap();
    
    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setPersonalDsctoPK(new org.pegasus.personal.jpa.PersonalDsctoPK());
    }

    private PersonalDsctoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public HashMap getParams() {
        return params;
    }

    public void setParams(HashMap params) {
        this.params = params;
    }

    public List<PersonalDscto> getItems() {
        if (items == null) {
            items = getFacade().load(0, -1, null,params);
        }
        return items;
    }

    public void ajaxListener(){
        items=null;
    }
    
    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        PersonalDscto selected=getSelected();
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

    public PersonalDscto getPersonalDscto(org.pegasus.personal.jpa.PersonalDsctoPK id) {
        return getFacade().find(id);
    }

    public List<PersonalDscto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PersonalDscto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PersonalDscto.class)
    public static class PersonalDsctoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonalDsctoController controller = (PersonalDsctoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personalDsctoController");
            return controller.getPersonalDscto(getKey(value));
        }

        org.pegasus.personal.jpa.PersonalDsctoPK getKey(String value) {
            org.pegasus.personal.jpa.PersonalDsctoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.PersonalDsctoPK();
            key.setDni(values[0]);
            key.setCodigo(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.PersonalDsctoPK value) {
            StringBuilder sb = new StringBuilder();
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
            if (object instanceof PersonalDscto) {
                PersonalDscto o = (PersonalDscto) object;
                return getStringKey(o.getPersonalDsctoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PersonalDscto.class.getName()});
                return null;
            }
        }

    }

}
