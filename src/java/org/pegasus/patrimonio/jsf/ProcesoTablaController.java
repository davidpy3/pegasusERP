package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.ProcesoTabla;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.personal.ejb.ProcesoTablaFacadeLocal;

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

@Named("procesoTablaController")
@SessionScoped
public class ProcesoTablaController implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.ProcesoTablaFacadeLocal ejbFacade;
    private List<ProcesoTabla> items = null;
    private ProcesoTabla selected;

    public ProcesoTablaController() {
    }

    public ProcesoTabla getSelected() {
        return selected;
    }

    public void setSelected(ProcesoTabla selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getProcesoTablaPK().setTipoproceso(selected.getProcesoTipo().getTipoproceso());
    }

    protected void initializeEmbeddableKey() {
        selected.setProcesoTablaPK(new org.pegasus.patrimonio.jpa.ProcesoTablaPK());
    }

    private ProcesoTablaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public ProcesoTabla prepareCreate() {
        selected = new ProcesoTabla();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProcesoTablaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProcesoTablaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProcesoTablaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProcesoTabla> getItems() {
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

    public ProcesoTabla getProcesoTabla(org.pegasus.patrimonio.jpa.ProcesoTablaPK id) {
        return getFacade().find(id);
    }

    public List<ProcesoTabla> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProcesoTabla> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProcesoTabla.class)
    public static class ProcesoTablaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProcesoTablaController controller = (ProcesoTablaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "procesoTablaController");
            return controller.getProcesoTabla(getKey(value));
        }

        org.pegasus.patrimonio.jpa.ProcesoTablaPK getKey(String value) {
            org.pegasus.patrimonio.jpa.ProcesoTablaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.ProcesoTablaPK();
            key.setTipoproceso(values[0]);
            key.setClasifica(new Character(values[1].charAt(0)));
            key.setAnno(Integer.parseInt(values[2]));
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.ProcesoTablaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoproceso());
            sb.append(SEPARATOR);
            sb.append(value.getClasifica());
            sb.append(SEPARATOR);
            sb.append(value.getAnno());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProcesoTabla) {
                ProcesoTabla o = (ProcesoTabla) object;
                return getStringKey(o.getProcesoTablaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProcesoTabla.class.getName()});
                return null;
            }
        }

    }

}
