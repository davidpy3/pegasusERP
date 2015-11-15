package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.InventarioDetalle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.jsuns.X;
import org.pegasus.patrimonio.ejb.InventarioDetalleFacadeLocal;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.primefaces.model.LazyDataModel;

@Named
@ViewScoped
public class InventarioDetalleController extends AbstractController<InventarioDetalle> implements Serializable {
    
    @EJB
    private org.pegasus.patrimonio.ejb.InventarioDetalleFacadeLocal ejbFacade;

    private InventarioDetalleFacadeLocal getFacade() {
        return ejbFacade;
    }

    public void inventariar(){
        ejbFacade.inventariar(getSelected());
    }

    public List<InventarioDetalle> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
   
    protected void persist(PersistAction persistAction, String successMessage) {
        InventarioDetalle selected=getSelected();
        if (selected != null) {
            X.log(selected);
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

    public InventarioDetalle getInventario(org.pegasus.patrimonio.jpa.InventarioDetallePK id) {
        return getFacade().find(id);
    }

    public List<InventarioDetalle> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<InventarioDetalle> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = InventarioDetalle.class)
    public static class InventarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InventarioDetalleController controller = (InventarioDetalleController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inventarioController");
            return controller.getInventario(getKey(value));
        }

        org.pegasus.patrimonio.jpa.InventarioDetallePK getKey(String value) {
            org.pegasus.patrimonio.jpa.InventarioDetallePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.InventarioDetallePK();
            key.setAnoEje(values[0]);
            key.setNumInv(values[1]);
            key.setCodbien(values[2]);
            key.setCorrela(values[3]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.InventarioDetallePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getNumInv());
            sb.append(SEPARATOR);
            sb.append(value.getCodbien());
            sb.append(SEPARATOR);
            sb.append(value.getCorrela());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof InventarioDetalle) {
                InventarioDetalle o = (InventarioDetalle) object;
                return getStringKey(o.getInventarioDetallePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), InventarioDetalle.class.getName()});
                return null;
            }
        }

    }

}
