package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SgcAutoevaluacionEsp;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SgcAutoevaluacionEspFacade;
import edu.uns.oceca.ejb.SgcAutoevaluacionEspFacadeLocal;

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

@Named("sgcAutoevaluacionEspController")
@SessionScoped
public class SgcAutoevaluacionEspController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SgcAutoevaluacionEspFacadeLocal ejbFacade;
    private List<SgcAutoevaluacionEsp> items = null;
    private SgcAutoevaluacionEsp selected;

    public SgcAutoevaluacionEspController() {
    }

    public SgcAutoevaluacionEsp getSelected() {
        return selected;
    }

    public void setSelected(SgcAutoevaluacionEsp selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSgcAutoevaluacionEspPK(new edu.uns.oceca.jpa.SgcAutoevaluacionEspPK());
    }

    private SgcAutoevaluacionEspFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SgcAutoevaluacionEsp prepareCreate() {
        selected = new SgcAutoevaluacionEsp();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgcAutoevaluacionEspCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgcAutoevaluacionEspUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgcAutoevaluacionEspDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgcAutoevaluacionEsp> getItems() {
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

    public SgcAutoevaluacionEsp getSgcAutoevaluacionEsp(edu.uns.oceca.jpa.SgcAutoevaluacionEspPK id) {
        return getFacade().find(id);
    }

    public List<SgcAutoevaluacionEsp> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgcAutoevaluacionEsp> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgcAutoevaluacionEsp.class)
    public static class SgcAutoevaluacionEspControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgcAutoevaluacionEspController controller = (SgcAutoevaluacionEspController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcAutoevaluacionEspController");
            return controller.getSgcAutoevaluacionEsp(getKey(value));
        }

        edu.uns.oceca.jpa.SgcAutoevaluacionEspPK getKey(String value) {
            edu.uns.oceca.jpa.SgcAutoevaluacionEspPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SgcAutoevaluacionEspPK();
            key.setIdAutoevaluacion(Integer.parseInt(values[0]));
            key.setIdEspecialidad(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SgcAutoevaluacionEspPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdAutoevaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdEspecialidad());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgcAutoevaluacionEsp) {
                SgcAutoevaluacionEsp o = (SgcAutoevaluacionEsp) object;
                return getStringKey(o.getSgcAutoevaluacionEspPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgcAutoevaluacionEsp.class.getName()});
                return null;
            }
        }

    }

}
