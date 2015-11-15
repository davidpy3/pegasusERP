package edu.uns.escalafon.jsf;

import edu.uns.escalafon.jpa.EscCapUns;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.escalafon.ejb.EscCapUnsFacade;
import edu.uns.escalafon.ejb.EscCapUnsFacadeLocal;

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

@Named("escCapUnsController")
@SessionScoped
public class EscCapUnsController implements Serializable {

    @EJB
    private edu.uns.escalafon.ejb.EscCapUnsFacadeLocal ejbFacade;
    private List<EscCapUns> items = null;
    private EscCapUns selected;

    public EscCapUnsController() {
    }

    public EscCapUns getSelected() {
        return selected;
    }

    public void setSelected(EscCapUns selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getEscCapUnsPK().setTipoCap(selected.getEscNivelRemunerativoUns().getEscNivelRemunerativoUnsPK().getTipo());
    }

    protected void initializeEmbeddableKey() {
        selected.setEscCapUnsPK(new edu.uns.escalafon.jpa.EscCapUnsPK());
    }

    private EscCapUnsFacadeLocal getFacade() {
        return ejbFacade;
    }

    public EscCapUns prepareCreate() {
        selected = new EscCapUns();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("EscCapUnsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("EscCapUnsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("EscCapUnsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<EscCapUns> getItems() {
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

    public EscCapUns getEscCapUns(edu.uns.escalafon.jpa.EscCapUnsPK id) {
        return getFacade().find(id);
    }

    public List<EscCapUns> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<EscCapUns> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = EscCapUns.class)
    public static class EscCapUnsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EscCapUnsController controller = (EscCapUnsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "escCapUnsController");
            return controller.getEscCapUns(getKey(value));
        }

        edu.uns.escalafon.jpa.EscCapUnsPK getKey(String value) {
            edu.uns.escalafon.jpa.EscCapUnsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.escalafon.jpa.EscCapUnsPK();
            key.setIdCap(Integer.parseInt(values[0]));
            key.setIdDep(Integer.parseInt(values[1]));
            key.setTipoCap(Boolean.parseBoolean(values[2]));
            return key;
        }

        String getStringKey(edu.uns.escalafon.jpa.EscCapUnsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdCap());
            sb.append(SEPARATOR);
            sb.append(value.getIdDep());
            sb.append(SEPARATOR);
            sb.append(value.getTipoCap());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof EscCapUns) {
                EscCapUns o = (EscCapUns) object;
                return getStringKey(o.getEscCapUnsPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), EscCapUns.class.getName()});
                return null;
            }
        }

    }

}
