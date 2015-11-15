package org.pegasus.personal.jsf;

import java.io.ByteArrayInputStream;
import org.pegasus.personal.jpa.Marcacion;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.AbstractController;

import java.io.Serializable;
import java.util.HashMap;
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
import org.jsuns.util.XMap;
import org.pegasus.personal.ejb.MarcacionFacadeLocal;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named("marcacionController")
@SessionScoped
public class MarcacionController extends AbstractController<Marcacion> implements Serializable {

    @EJB
    private org.pegasus.personal.ejb.MarcacionFacadeLocal ejbFacade;
    private HashMap params=new HashMap();
    
    @Override
    protected void initializeEmbeddableKey() {
        getSelected().setMarcacionPK(new org.pegasus.personal.jpa.MarcacionPK());
    }

    private MarcacionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Marcacion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Marcacion selected = this.getSelected();
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

    public Marcacion getMarcacion(org.pegasus.personal.jpa.MarcacionPK id) {
        return getFacade().find(id);
    }

    public List<Marcacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Marcacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Marcacion.class)
    public static class MarcacionControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MarcacionController controller = (MarcacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "marcacionController");
            return controller.getMarcacion(getKey(value));
        }

        org.pegasus.personal.jpa.MarcacionPK getKey(String value) {
            org.pegasus.personal.jpa.MarcacionPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.MarcacionPK();
            key.setDni(values[0]);
            key.setFechaHora(java.sql.Date.valueOf(values[1]));
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.MarcacionPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDni());
            sb.append(SEPARATOR);
            sb.append(value.getFechaHora());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Marcacion) {
                Marcacion o = (Marcacion) object;
                return getStringKey(o.getMarcacionPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Marcacion.class.getName()});
                return null;
            }
        }

    }

    private StreamedContent content;

    public StreamedContent getContent() {
        return content;
    }

    public void setContent(StreamedContent content) {
        this.content = content;
    }

    public void onPrerender(ComponentSystemEvent event) {
        try {
            content = new DefaultStreamedContent(new ByteArrayInputStream(
                    JReportAction.export(
                            JReportAction.getJasperReport(Object.class,
                                    "/org/munisoft/personal/jr/dw_reporte_marcaciones.jasper", 0), new XMap(DataSource.class, getFacade().load(0, 0, null, params)), "pdf")
                    .toByteArray()
            ), "application/pdf");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
