package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.SgcAutoevaluacionPlan;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import edu.uns.oceca.ejb.SgcAutoevaluacionPlanFacade;
import edu.uns.oceca.ejb.SgcAutoevaluacionPlanFacadeLocal;

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

@Named("sgcAutoevaluacionPlanController")
@SessionScoped
public class SgcAutoevaluacionPlanController implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.SgcAutoevaluacionPlanFacadeLocal ejbFacade;
    private List<SgcAutoevaluacionPlan> items = null;
    private SgcAutoevaluacionPlan selected;

    public SgcAutoevaluacionPlanController() {
    }

    public SgcAutoevaluacionPlan getSelected() {
        return selected;
    }

    public void setSelected(SgcAutoevaluacionPlan selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setSgcAutoevaluacionPlanPK(new edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK());
    }

    private SgcAutoevaluacionPlanFacadeLocal getFacade() {
        return ejbFacade;
    }

    public SgcAutoevaluacionPlan prepareCreate() {
        selected = new SgcAutoevaluacionPlan();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("SgcAutoevaluacionPlanCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("SgcAutoevaluacionPlanUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("SgcAutoevaluacionPlanDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<SgcAutoevaluacionPlan> getItems() {
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

    public SgcAutoevaluacionPlan getSgcAutoevaluacionPlan(edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK id) {
        return getFacade().find(id);
    }

    public List<SgcAutoevaluacionPlan> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<SgcAutoevaluacionPlan> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = SgcAutoevaluacionPlan.class)
    public static class SgcAutoevaluacionPlanControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SgcAutoevaluacionPlanController controller = (SgcAutoevaluacionPlanController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcAutoevaluacionPlanController");
            return controller.getSgcAutoevaluacionPlan(getKey(value));
        }

        edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK getKey(String value) {
            edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK();
            key.setIdAutoevaluacion(Integer.parseInt(values[0]));
            key.setIdEstandar(Integer.parseInt(values[1]));
            key.setIdPlacti(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(edu.uns.oceca.jpa.SgcAutoevaluacionPlanPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdAutoevaluacion());
            sb.append(SEPARATOR);
            sb.append(value.getIdEstandar());
            sb.append(SEPARATOR);
            sb.append(value.getIdPlacti());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof SgcAutoevaluacionPlan) {
                SgcAutoevaluacionPlan o = (SgcAutoevaluacionPlan) object;
                return getStringKey(o.getSgcAutoevaluacionPlanPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), SgcAutoevaluacionPlan.class.getName()});
                return null;
            }
        }

    }

}
