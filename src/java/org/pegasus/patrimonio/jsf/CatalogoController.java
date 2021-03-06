package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Catalogo;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import org.jsuns.util.AbstractController;
import org.pegasus.personal.ejb.CatalogoFacadeLocal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.primefaces.model.LazyDataModel;

@ManagedBean
@ViewScoped
public class CatalogoController extends AbstractController<Catalogo> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.CatalogoFacadeLocal ejbFacade;

    private CatalogoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Catalogo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    protected void persist(PersistAction persistAction, String successMessage) {
        Catalogo selected=getSelected();
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

    public Catalogo getCatalogo(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Catalogo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Catalogo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @FacesConverter(forClass = Catalogo.class)
    public static class CatalogoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CatalogoController controller = (CatalogoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "catalogoController");
            return controller.getCatalogo(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Catalogo) {
                Catalogo o = (Catalogo) object;
                return getStringKey(o.getCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Catalogo.class.getName()});
                return null;
            }
        }

    }

}
