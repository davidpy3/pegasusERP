package edu.uns.oceda.carga_lectiva.jsf;

import edu.uns.oceda.carga_lectiva.jpa.CargaLectivaAsignatura;
import edu.uns.oceda.carga_lectiva.ejb.CargaLectivaAsignaturaFacadeLocal;

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

@Named("cargaLectivaAsignaturaController")
@SessionScoped
public class CargaLectivaAsignaturaController implements Serializable {

    @EJB
    private edu.uns.oceda.carga_lectiva.ejb.CargaLectivaAsignaturaFacadeLocal ejbFacade;
    private List<CargaLectivaAsignatura> items = null;
    private CargaLectivaAsignatura selected;

    public CargaLectivaAsignatura getSelected() {
        return selected;
    }

    public void setSelected(CargaLectivaAsignatura selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CargaLectivaAsignaturaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public CargaLectivaAsignatura prepareCreate() {
        selected = new CargaLectivaAsignatura();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CargaLectivaAsignaturaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CargaLectivaAsignaturaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CargaLectivaAsignaturaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CargaLectivaAsignatura> getItems() {
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

    public CargaLectivaAsignatura getCargaLectivaAsignatura(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CargaLectivaAsignatura> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CargaLectivaAsignatura> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CargaLectivaAsignatura.class)
    public static class CargaLectivaAsignaturaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CargaLectivaAsignaturaController controller = (CargaLectivaAsignaturaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cargaLectivaAsignaturaController");
            return controller.getCargaLectivaAsignatura(getKey(value));
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
            if (object instanceof CargaLectivaAsignatura) {
                CargaLectivaAsignatura o = (CargaLectivaAsignatura) object;
                return getStringKey(o.getIdCldet());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CargaLectivaAsignatura.class.getName()});
                return null;
            }
        }

    }

}
