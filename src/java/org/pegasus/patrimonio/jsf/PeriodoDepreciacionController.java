package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.PeriodoDepreciacion;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.pegasus.personal.ejb.PeriodoDepreciacionFacadeLocal;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.primefaces.model.LazyDataModel;

@Named
@SessionScoped
public class PeriodoDepreciacionController extends AbstractController<PeriodoDepreciacion> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.PeriodoDepreciacionFacadeLocal ejbFacade;
    

    private PeriodoDepreciacionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public void procesar() {
        ejbFacade.procesar(this.getSelected());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful","Registro procesado!") );
    }

    public void cerrar() {
        ejbFacade.cerrar(this.getSelected());
    }

    public List<PeriodoDepreciacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        PeriodoDepreciacion selected=getSelected();
        System.out.println("selected66="+selected);
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

    public PeriodoDepreciacion getPeriodoDepreciacion(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<PeriodoDepreciacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PeriodoDepreciacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setCodPeriodo(new Long(0));
    }

    @FacesConverter(forClass = PeriodoDepreciacion.class)
    public static class PeriodoDepreciacionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PeriodoDepreciacionController controller = (PeriodoDepreciacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "periodoDepreciacionController");
            return controller.getPeriodoDepreciacion(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PeriodoDepreciacion) {
                PeriodoDepreciacion o = (PeriodoDepreciacion) object;
                return getStringKey(o.getCodPeriodo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PeriodoDepreciacion.class.getName()});
                return null;
            }
        }

    }

}
