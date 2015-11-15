package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Orden;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
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
import org.jsuns.util.AbstractController;
import org.pegasus.patrimonio.ejb.OrdenFacadeLocal;
import org.primefaces.model.LazyDataModel;

@Named
@SessionScoped
public class OrdenController extends AbstractController<Orden> implements Serializable {

    @EJB
    private OrdenFacadeLocal ejbFacade;

    private OrdenFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Orden> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Orden selected = this.getSelected();
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

    public Orden getOrden(org.pegasus.patrimonio.jpa.OrdenPK id) {
        return getFacade().find(id);
    }

    public List<Orden> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Orden> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = Orden.class)
    public static class OrdenControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdenController controller = (OrdenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenController");
            return controller.getOrden(getKey(value));
        }

        org.pegasus.patrimonio.jpa.OrdenPK getKey(String value) {
            org.pegasus.patrimonio.jpa.OrdenPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.OrdenPK();
            key.setAnoEje(values[0]);
            key.setNOrden(Integer.parseInt(values[1]));
            key.setTipo(new Character(values[2].charAt(0)));
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.OrdenPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getNOrden());
            sb.append(SEPARATOR);
            sb.append(value.getTipo());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Orden) {
                Orden o = (Orden) object;
                return getStringKey(o.getOrdenPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Orden.class.getName()});
                return null;
            }
        }

    }

}
