package org.pegasus.personal.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.pegasus.personal.ejb.TipoPapeletaFacadeLocal;
import org.pegasus.personal.jpa.TipoPapeleta;

@ManagedBean
@ViewScoped
public class TipoPapeletaController extends AbstractController<TipoPapeleta> implements Serializable {

    @EJB
    private TipoPapeletaFacadeLocal ejbFacade;

    private TipoPapeletaFacadeLocal getFacade() {
        return ejbFacade;
    }

    @Override
    protected void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TipoPapeleta> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
}
