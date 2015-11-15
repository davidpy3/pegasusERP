package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SgcAcreditacionDependencia;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SgcAcreditacionDependenciaFacade;
import edu.uns.oceca.ejb.SgcAcreditacionDependenciaFacadeLocal;

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

@Named("sgcAcreditacionDependenciaController")
@SessionScoped
public class SgcAcreditacionDependenciaController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SgcAcreditacionDependenciaFacadeLocal ejbFacade;
    private List<SgcAcreditacionDependencia> items = null;
    private SgcAcreditacionDependencia selected;

    public SgcAcreditacionDependenciaController() {
    }

    public SgcAcreditacionDependencia getSelected() {
        return selected;
    }

    public void setSelected(SgcAcreditacionDependencia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private SgcAcreditacionDependenciaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SgcAcreditacionDependencia prepareCreate() {
        selected = new SgcAcreditacionDependencia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgcAcreditacionDependenciaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgcAcreditacionDependenciaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgcAcreditacionDependenciaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgcAcreditacionDependencia> getItems() {
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

    public SgcAcreditacionDependencia getSgcAcreditacionDependencia(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<SgcAcreditacionDependencia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgcAcreditacionDependencia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgcAcreditacionDependencia.class)
    public static class SgcAcreditacionDependenciaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgcAcreditacionDependenciaController controller = (SgcAcreditacionDependenciaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcAcreditacionDependenciaController");
            return controller.getSgcAcreditacionDependencia(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgcAcreditacionDependencia) {
                SgcAcreditacionDependencia o = (SgcAcreditacionDependencia) object;
                return getStringKey(o.getIdAsignacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgcAcreditacionDependencia.class.getName()});
                return null;
            }
        }

    }

}
