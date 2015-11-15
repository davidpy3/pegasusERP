package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Inventario;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.pegasus.patrimonio.ejb.InventarioFacadeLocal;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.Tag;
import org.jsuns.util.XDate;
import org.primefaces.model.LazyDataModel;

@Named
@ViewScoped
public class InventarioController extends AbstractController<Inventario> implements Serializable {
    
    @EJB
    private org.pegasus.patrimonio.ejb.InventarioFacadeLocal ejbFacade;

    @Override
    protected void initializeEmbeddableKey() {
        
        getFacade().prepare(getSelected());
    }

    private InventarioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Inventario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<Tag> getTipoInventarioList(){
        ArrayList l=new ArrayList();
        l.add(new Tag('1',"Anual"));
        l.add(new Tag('2',"Semestral"));
        l.add(new Tag('3',"Trimestral"));
        l.add(new Tag('4',"Bimestral"));
        return l;
    }
    
    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Inventario selected=getSelected();
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

    public Inventario getInventario(org.pegasus.patrimonio.jpa.InventarioPK id) {
        return getFacade().find(id);
    }

    public List<Inventario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Inventario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = Inventario.class)
    public static class InventarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InventarioController controller = (InventarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inventarioController");
            return controller.getInventario(getKey(value));
        }

        org.pegasus.patrimonio.jpa.InventarioPK getKey(String value) {
            org.pegasus.patrimonio.jpa.InventarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.InventarioPK();
            key.setAnoEje(values[0]);
            key.setNumInv(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.InventarioPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getNumInv());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Inventario) {
                Inventario o = (Inventario) object;
                return getStringKey(o.getInventarioPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Inventario.class.getName()});
                return null;
            }
        }

    }

}
