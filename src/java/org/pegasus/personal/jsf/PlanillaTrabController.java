package org.pegasus.personal.jsf;

import java.io.ByteArrayInputStream;
import org.pegasus.personal.jpa.PlanillaTrab;
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
import javax.faces.event.ComponentSystemEvent;
import javax.sql.DataSource;
import org.jsuns.jreport.JReportAction;
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.XMap;
import org.jsuns.util.XUtil;
import org.pegasus.personal.ejb.PlanillaTrabFacadeLocal;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named("planillaTrabController")
@SessionScoped
public class PlanillaTrabController extends AbstractController<PlanillaTrab> implements Serializable {

    @EJB
    private PlanillaTrabFacadeLocal ejbFacade;

    private PlanillaTrabFacadeLocal getFacade() {
        return ejbFacade;
    }

    public int getDiasTotal(PlanillaTrab pt){
        int nd=XUtil.intValue(pt.getDiasNor())+XUtil.intValue(pt.getDiasFer())+XUtil.intValue(pt.getDiasFtrab());
        pt.setDiasTot(nd+XUtil.intValue(pt.getDiasDom()));
        return nd;
    }
    
    public List<PlanillaTrab> getItems() {
        if (items == null) {
            items = getFacade().load(0, -1, null, getParams());
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        PlanillaTrab selected = getSelected();
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundlex").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundlex").getString("PersistenceErrorOccured"));
            }
        }
    }

    public PlanillaTrab getPlanillaTrab(org.pegasus.personal.jpa.PlanillaTrabPK id) {
        return getFacade().find(id);
    }

    public List<PlanillaTrab> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<PlanillaTrab> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = PlanillaTrab.class)
    public static class PlanillaTrabControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlanillaTrabController controller = (PlanillaTrabController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "planillaTrabController");
            return controller.getPlanillaTrab(getKey(value));
        }

        org.pegasus.personal.jpa.PlanillaTrabPK getKey(String value) {
            org.pegasus.personal.jpa.PlanillaTrabPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.PlanillaTrabPK();
            key.setNExpediente(values[0]);
            key.setAnoEje(values[1]);
            key.setDni(values[2]);
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.PlanillaTrabPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNExpediente());
            sb.append(SEPARATOR);
            sb.append(value.getAnoEje());
            sb.append(SEPARATOR);
            sb.append(value.getDni());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PlanillaTrab) {
                PlanillaTrab o = (PlanillaTrab) object;
                return getStringKey(o.getPlanillaTrabPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), PlanillaTrab.class.getName()});
                return null;
            }
        }

    }

    public void ajaxListener() {
        items = null;
    }

    StreamedContent content;
    
    public StreamedContent getContent() {
        return content;
    }

    public void setContent(StreamedContent content) {
        this.content = content;
    }

    public void onPrerender(ComponentSystemEvent event) {
        try{
            content = new DefaultStreamedContent(new ByteArrayInputStream(
                    JReportAction.export(
                            JReportAction.getJasperReport(Object.class,
                                    "/org/munisoft/personal/jr/dw_pers_certificado_trab.jasper", 0), 
                            new XMap("YEAR_NAME","Año de la pera",DataSource.class, getFacade().load(0, 0, null,getParams())), "pdf")
                    .toByteArray()
            ), "application/pdf");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
