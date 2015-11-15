package org.pegasus.patrimonio.jsf;

import org.pegasus.patrimonio.jpa.Ambiente;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import org.pegasus.patrimonio.ejb.AmbienteFacadeLocal;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.primefaces.model.LazyDataModel;

@Named
@ViewScoped
public class AmbienteController extends AbstractController<Ambiente> implements Serializable {

    @EJB
    private org.pegasus.patrimonio.ejb.AmbienteFacadeLocal ejbFacade;
  
    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setAmbientePK(new org.pegasus.patrimonio.jpa.AmbientePK());
    }

    private AmbienteFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Ambiente> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    protected void persist(PersistAction persistAction, String successMessage) {
        Ambiente selected=getSelected();
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

    public Ambiente getAmbiente(org.pegasus.patrimonio.jpa.AmbientePK id) {
        return getFacade().find(id);
    }

    public List<Ambiente> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ambiente> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @Override
    protected LazyDataModel createLazyListModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = Ambiente.class)
    public static class AmbienteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AmbienteController controller = (AmbienteController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ambienteController");
            return controller.getAmbiente(getKey(value));
        }

        org.pegasus.patrimonio.jpa.AmbientePK getKey(String value) {
            org.pegasus.patrimonio.jpa.AmbientePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.patrimonio.jpa.AmbientePK();
            key.setCodlocal(values[0]);
            key.setCodambiente(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.patrimonio.jpa.AmbientePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCodlocal());
            sb.append(SEPARATOR);
            sb.append(value.getCodambiente());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ambiente) {
                Ambiente o = (Ambiente) object;
                return getStringKey(o.getAmbientePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ambiente.class.getName()});
                return null;
            }
        }

    }

}
