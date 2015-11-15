package org.jsuns.commerce.jsf;

import org.jsuns.commerce.jpa.Banco;
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
import org.jsuns.commerce.ejb.BancoFacadeLocal;
import org.jsuns.util.AbstractController;

@Named("bancoController")
@SessionScoped
public class BancoController extends AbstractController<Banco> implements Serializable {

    @EJB
    private org.jsuns.commerce.ejb.BancoFacadeLocal ejbFacade;

    private BancoFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Banco> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    protected void persist(PersistAction persistAction, String successMessage) {
        Banco selected=this.getSelected();
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

    public Banco getBanco(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Banco> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Banco> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Banco.class)
    public static class BancoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BancoController controller = (BancoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bancoController");
            return controller.getBanco(getKey(value));
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
            if (object instanceof Banco) {
                Banco o = (Banco) object;
                return getStringKey(o.getIdBanco());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Banco.class.getName()});
                return null;
            }
        }

    }

}
