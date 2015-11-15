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
import org.pegasus.personal.ejb.RegimenPensionarioFacadeLocal;
import org.pegasus.personal.jpa.RegimenPensionario;
import org.pegasus.personal.jpa.TipoTrabajador;

@ManagedBean
@ViewScoped
public class RegimenPensionarioController extends AbstractController<RegimenPensionario> implements Serializable {
    
    @EJB
    private RegimenPensionarioFacadeLocal ejbFacade;
    private RegimenPensionarioFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<RegimenPensionario> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    public RegimenPensionario getRegimenPensionario(String id) {
        return getFacade().find(id);
    }

    @Override
    protected void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        @FacesConverter(forClass = RegimenPensionario.class)
    public static class RegimenPensionarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            
            if (value == null || value.length() == 0) {
                return null;
            }
            return ((RegimenPensionarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "regimenPensionarioController")).getRegimenPensionario(value);
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            return object!=null?((RegimenPensionario) object).getId():null;
        }

    }
}
