package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.OrdenDet;
import org.pegasus.patrimonio.ejb.OrdenDetFacade;
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
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.pegasus.patrimonio.ejb.OrdenDetFacadeLocal;
import org.primefaces.model.LazyDataModel;

@Named
@SessionScoped
public class OrdenDetController extends AbstractController<OrdenDet> implements Serializable {

    @EJB
    private org.pegasus.patrimonio.ejb.OrdenDetFacadeLocal ejbFacade;

//    protected void setEmbeddableKeys() {
//        selected.getOrdenDetPK().setNOrden(selected.getOrden().getOrdenPK().getNOrden());
//        selected.getOrdenDetPK().setAnoEje(selected.getOrden().getOrdenPK().getAnoEje());
//        selected.getOrdenDetPK().setTipo(selected.getOrden().getOrdenPK().getTipo());
//    }
//
//    protected void initializeEmbeddableKey() {
//        selected.setOrdenDetPK(new org.munisoft.jpa.OrdenDetPK());
//    }

    private OrdenDetFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<OrdenDet> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    protected void persist(PersistAction persistAction, String successMessage) {
        OrdenDet selected=getSelected();
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

    public OrdenDet getOrdenDet(org.pegasus.patrimonio.jpa.OrdenDetPK id) {
        return getFacade().find(id);
    }

    public List<OrdenDet> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<OrdenDet> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = OrdenDet.class)
    public static class OrdenDetControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdenDetController controller = (OrdenDetController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordenDetController");
            return controller.getOrdenDet(getKey(value));
        }

        org.pegasus.patrimonio.jpa.OrdenDetPK getKey(String value) {
            org.pegasus.patrimonio.jpa.OrdenDetPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.OrdenDetPK();
            key.setAnoEje(values[0]);
            key.setNOrden(Integer.parseInt(values[1]));
            key.setTipo(new Character(values[2].charAt(0)));
            key.setItem(Integer.parseInt(values[3]));
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.OrdenDetPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getNOrden());
            sb.append(SEPARATOR);
            sb.append(value.getTipo());
            sb.append(SEPARATOR);
            sb.append(value.getItem());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof OrdenDet) {
                OrdenDet o = (OrdenDet) object;
                return getStringKey(o.getOrdenDetPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), OrdenDet.class.getName()});
                return null;
            }
        }

    }

}
