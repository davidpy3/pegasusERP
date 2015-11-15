package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscHistoriaCap;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscHistoriaCapFacade;
import edu.uns.escalafon.ejb.EscHistoriaCapFacadeLocal;

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

@Named("escHistoriaCapController")
@SessionScoped
public class EscHistoriaCapController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscHistoriaCapFacadeLocal ejbFacade;
    private List<EscHistoriaCap> items = null;
    private EscHistoriaCap selected;

    public EscHistoriaCapController() {
    }

    public EscHistoriaCap getSelected() {
        return selected;
    }

    public void setSelected(EscHistoriaCap selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private EscHistoriaCapFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscHistoriaCap prepareCreate() {
        selected = new EscHistoriaCap();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscHistoriaCapCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscHistoriaCapUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscHistoriaCapDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscHistoriaCap> getItems() {
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

    public EscHistoriaCap getEscHistoriaCap(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<EscHistoriaCap> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscHistoriaCap> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscHistoriaCap.class)
    public static class EscHistoriaCapControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscHistoriaCapController controller = (EscHistoriaCapController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escHistoriaCapController");
            return controller.getEscHistoriaCap(getKey(value));
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
            if (object instanceof EscHistoriaCap) {
                EscHistoriaCap o = (EscHistoriaCap) object;
                return getStringKey(o.getIdHistCap());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscHistoriaCap.class.getName()});
                return null;
            }
        }

    }

}
