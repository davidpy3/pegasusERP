package edu.uns.oceda.jsf;

import edu.uns.oceda.jpa.ApsAmbitoAcad;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceda.ejb.ApsAmbitoAcadFacadeLocal;

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
import org.primefaces.model.LazyDataModel;

@Named
@SessionScoped
public class ApsAmbitoAcadController extends AbstractController<ApsAmbitoAcad> implements Serializable {

    @EJB
    private edu.uns.oceda.ejb.ApsAmbitoAcadFacadeLocal ejbFacade;

    private ApsAmbitoAcadFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<ApsAmbitoAcad> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        ApsAmbitoAcad selected=getSelected();
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

    public ApsAmbitoAcad getApsAmbitoAcad(java.lang.Short id) {
        return getFacade().find(id);
    }

    public List<ApsAmbitoAcad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ApsAmbitoAcad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = ApsAmbitoAcad.class)
    public static class ApsAmbitoAcadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ApsAmbitoAcadController controller = (ApsAmbitoAcadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "apsAmbitoAcadController");
            return controller.getApsAmbitoAcad(getKey(value));
        }

        java.lang.Short getKey(String value) {
            java.lang.Short key;
            key = Short.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Short value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ApsAmbitoAcad) {
                ApsAmbitoAcad o = (ApsAmbitoAcad) object;
                return getStringKey(o.getIdAmbito());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ApsAmbitoAcad.class.getName()});
                return null;
            }
        }

    }

}
