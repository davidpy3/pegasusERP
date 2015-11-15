package edu.uns.oceda.carga_lectiva.jsf;

import edu.uns.oceda.carga_lectiva.ejb.CargaLectivaDocenteFacadeLocal;
import edu.uns.oceda.carga_lectiva.jpa.CargaLectivaDocente;

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
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;

@Named("cargaLectivaDocenteController")
@SessionScoped
public class CargaLectivaDocenteController implements Serializable {

    @EJB
    private edu.uns.oceda.carga_lectiva.ejb.CargaLectivaDocenteFacadeLocal ejbFacade;
    private List<CargaLectivaDocente> items = null;
    private CargaLectivaDocente selected;

    public CargaLectivaDocenteController() {
    }

    public CargaLectivaDocente getSelected() {
        return selected;
    }

    public void setSelected(CargaLectivaDocente selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CargaLectivaDocenteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CargaLectivaDocente prepareCreate() {
        selected = new CargaLectivaDocente();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CargaLectivaDocenteCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CargaLectivaDocenteUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CargaLectivaDocenteDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CargaLectivaDocente> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
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

    public CargaLectivaDocente getCargaLectivaDocente(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CargaLectivaDocente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CargaLectivaDocente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CargaLectivaDocente.class)
    public static class CargaLectivaDocenteControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CargaLectivaDocenteController controller = (CargaLectivaDocenteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cargaLectivaDocenteController");
            return controller.getCargaLectivaDocente(getKey(value));
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
            if (object instanceof CargaLectivaDocente) {
                CargaLectivaDocente o = (CargaLectivaDocente) object;
                return getStringKey(o.getIdClcab());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CargaLectivaDocente.class.getName()});
                return null;
            }
        }

    }

}
