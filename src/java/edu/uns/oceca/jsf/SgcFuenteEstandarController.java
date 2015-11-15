package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SgcFuenteEstandar;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SgcFuenteEstandarFacade;
import edu.uns.oceca.ejb.SgcFuenteEstandarFacadeLocal;

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

@Named("sgcFuenteEstandarController")
@SessionScoped
public class SgcFuenteEstandarController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SgcFuenteEstandarFacadeLocal ejbFacade;
    private List<SgcFuenteEstandar> items = null;
    private SgcFuenteEstandar selected;

    public SgcFuenteEstandarController() {
    }

    public SgcFuenteEstandar getSelected() {
        return selected;
    }

    public void setSelected(SgcFuenteEstandar selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSgcFuenteEstandarPK(new edu.uns.oceca.jpa.SgcFuenteEstandarPK());
    }

    private SgcFuenteEstandarFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SgcFuenteEstandar prepareCreate() {
        selected = new SgcFuenteEstandar();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgcFuenteEstandarCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgcFuenteEstandarUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgcFuenteEstandarDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgcFuenteEstandar> getItems() {
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

    public SgcFuenteEstandar getSgcFuenteEstandar(edu.uns.oceca.jpa.SgcFuenteEstandarPK id) {
        return getFacade().find(id);
    }

    public List<SgcFuenteEstandar> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgcFuenteEstandar> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgcFuenteEstandar.class)
    public static class SgcFuenteEstandarControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgcFuenteEstandarController controller = (SgcFuenteEstandarController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcFuenteEstandarController");
            return controller.getSgcFuenteEstandar(getKey(value));
        }

        edu.uns.oceca.jpa.SgcFuenteEstandarPK getKey(String value) {
            edu.uns.oceca.jpa.SgcFuenteEstandarPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SgcFuenteEstandarPK();
            key.setIdFuente(Integer.parseInt(values[0]));
            key.setIdEstandar(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SgcFuenteEstandarPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdFuente());
            sb.append(SEPARATOR);
            sb.append(value.getIdEstandar());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgcFuenteEstandar) {
                SgcFuenteEstandar o = (SgcFuenteEstandar) object;
                return getStringKey(o.getSgcFuenteEstandarPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgcFuenteEstandar.class.getName()});
                return null;
            }
        }

    }

}
