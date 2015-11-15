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
import org.pegasus.personal.ejb.TipoContratoFacadeLocal;
import org.pegasus.personal.jpa.TipoContrato;

@ManagedBean
@ViewScoped
public class TipoContratoController extends AbstractController<TipoContrato> implements Serializable {
    
    @EJB
    private TipoContratoFacadeLocal ejbFacade;

    
    private TipoContratoFacadeLocal getFacade() {
        return ejbFacade;
    }
    
    public List<TipoContrato> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public TipoContrato getTipoContrato(String id) {
        return getFacade().find(id);
    }
    
    @Override
    protected void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FacesConverter(forClass = TipoContrato.class)
    public static class TipoContratoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            return ((TipoContratoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tipoContratoController")).getTipoContrato(value);
            
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return object!=null?((TipoContrato) object).getTipoContrato():null;
        }

    }

}
