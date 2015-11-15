package org.pegasus.personal.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.pegasus.personal.ejb.TipoTrabajadorFacadeLocal;
import org.pegasus.personal.jpa.TipoTrabajador;

@ManagedBean
@ViewScoped
public class TipoTrabajadorController extends AbstractController<TipoTrabajador> implements Serializable {
    
    @EJB
    private TipoTrabajadorFacadeLocal ejbFacade;

    @Override
    protected void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private TipoTrabajadorFacadeLocal getFacade() {
        return ejbFacade;
    }
    
    public List<TipoTrabajador> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public TipoTrabajador getTipoTrabajador(String id) {
        return getFacade().find(id);
    }
    
        @FacesConverter(forClass = TipoTrabajador.class)
    public static class TipoTrabajadorControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            return ((TipoTrabajadorController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoTrabajadorController")).getTipoTrabajador(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return object!=null?((TipoTrabajador) object).getId():null;
        }

    }

}
