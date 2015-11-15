package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Valorizacion;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.patrimonio.ejb.ValorizacionFacadeLocal;

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

@Named("valorizacionController")
@SessionScoped
public class ValorizacionController implements Serializable {

    @EJB
    private org.pegasus.patrimonio.ejb.ValorizacionFacadeLocal ejbFacade;
    private List<Valorizacion> items = null;
    private Valorizacion selected;

    public ValorizacionController() {
    }

    public Valorizacion getSelected() {
        return selected;
    }

    public void setSelected(Valorizacion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setValorizacionPK(new org.pegasus.patrimonio.jpa.ValorizacionPK());
    }

    private ValorizacionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Valorizacion prepareCreate() {
        selected = new Valorizacion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ValorizacionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ValorizacionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ValorizacionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Valorizacion> getItems() {
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

    public Valorizacion getValorizacion(org.pegasus.patrimonio.jpa.ValorizacionPK id) {
        return getFacade().find(id);
    }

    public List<Valorizacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Valorizacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Valorizacion.class)
    public static class ValorizacionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ValorizacionController controller = (ValorizacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "valorizacionController");
            return controller.getValorizacion(getKey(value));
        }

        org.pegasus.patrimonio.jpa.ValorizacionPK getKey(String value) {
            org.pegasus.patrimonio.jpa.ValorizacionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.ValorizacionPK();
            key.setAnoEje(values[0]);
            key.setTipo(new Character(values[1].charAt(0)));
            key.setNOrden(Integer.parseInt(values[2]));
            key.setNValor(Integer.parseInt(values[3]));
            key.setTipoValor(new Character(values[4].charAt(0)));
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.ValorizacionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getTipo());
            sb.append(SEPARATOR);
            sb.append(value.getNOrden());
            sb.append(SEPARATOR);
            sb.append(value.getNValor());
            sb.append(SEPARATOR);
            sb.append(value.getTipoValor());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Valorizacion) {
                Valorizacion o = (Valorizacion) object;
                return getStringKey(o.getValorizacionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Valorizacion.class.getName()});
                return null;
            }
        }

    }

}
