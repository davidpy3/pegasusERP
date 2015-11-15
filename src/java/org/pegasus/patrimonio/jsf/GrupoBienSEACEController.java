package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.GrupoBienSEACE;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.GrupoBienSEACEFacadeLocal;

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

@Named("grupoBienSEACEController")
@SessionScoped
public class GrupoBienSEACEController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.GrupoBienSEACEFacadeLocal ejbFacade;
    private List<GrupoBienSEACE> items = null;
    private GrupoBienSEACE selected;

    public GrupoBienSEACEController() {
    }

    public GrupoBienSEACE getSelected() {
        return selected;
    }

    public void setSelected(GrupoBienSEACE selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setGrupoBienSEACEPK(new org.pegasus.patrimonio.jpa.GrupoBienSEACEPK());
    }

    private GrupoBienSEACEFacadeLocal getFacade() {
        return ejbFacade;
    }

    public GrupoBienSEACE prepareCreate() {
        selected = new GrupoBienSEACE();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("GrupoBienSEACECreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("GrupoBienSEACEUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("GrupoBienSEACEDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<GrupoBienSEACE> getItems() {
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

    public GrupoBienSEACE getGrupoBienSEACE(org.pegasus.patrimonio.jpa.GrupoBienSEACEPK id) {
        return getFacade().find(id);
    }

    public List<GrupoBienSEACE> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<GrupoBienSEACE> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = GrupoBienSEACE.class)
    public static class GrupoBienSEACEControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GrupoBienSEACEController controller = (GrupoBienSEACEController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "grupoBienSEACEController");
            return controller.getGrupoBienSEACE(getKey(value));
        }

        org.pegasus.patrimonio.jpa.GrupoBienSEACEPK getKey(String value) {
            org.pegasus.patrimonio.jpa.GrupoBienSEACEPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.GrupoBienSEACEPK();
            key.setTipoBien(new Character(values[0].charAt(0)));
            key.setGrupoBien(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.GrupoBienSEACEPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoBien());
            sb.append(SEPARATOR);
            sb.append(value.getGrupoBien());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof GrupoBienSEACE) {
                GrupoBienSEACE o = (GrupoBienSEACE) object;
                return getStringKey(o.getGrupoBienSEACEPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), GrupoBienSEACE.class.getName()});
                return null;
            }
        }

    }

}
