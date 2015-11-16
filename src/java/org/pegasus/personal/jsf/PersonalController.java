package org.pegasus.personal.jsf;

import java.io.ByteArrayInputStream;
import org.pegasus.personal.jpa.Personal;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.jsuns.util.XMap;
import org.pegasus.personal.ejb.PersonalFacadeLocal;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named("personalController")
@SessionScoped
public class PersonalController extends AbstractController<Personal> implements Serializable {

    private String mes;

    public Integer getEdad(Date birthDate) {
        if(birthDate!=null){
            Calendar birth = new GregorianCalendar();
            Calendar today = new GregorianCalendar();
            int age = 0;
            int factor = 0;
            Date currentDate = new Date(); //current date
            birth.setTime(birthDate);
            today.setTime(currentDate);
            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        factor = -1; //Aun no celebra su cumpleaÃ±os
                    }
                } else {
                    factor = -1; //Aun no celebra su cumpleaÃ±os
                }
            }
            age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
            return age;
        }else return null;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @EJB
    private org.pegasus.personal.ejb.PersonalFacadeLocal ejbFacade;

    private PersonalFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Personal> complete(String q) {
        if (q.length() > 3) {
            return (List<Personal>) getFacade().load(0, -1, null,new XMap("q",q));
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    public List<Personal> getItems() {
        if (items == null) {
            items = getFacade().load(0,-1,null,getParams());
        }
        return items;
    }

    public boolean isRetencion(){
        return "1".equals(""+this.getSelected().getRetencion());
    }
    
    public void setRetencion(boolean b){
        getSelected().setRetencion(b?'1':'0');
    }
    
    @Override
    protected void persist(org.jsuns.util.JsfUtil.PersistAction persistAction, String successMessage) {
        Personal selected = getSelected();
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

    public Personal getPersonal(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Personal> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Personal> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(value="personalControllerConverter",forClass = Personal.class)
    public static class PersonalControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonalController controller = (PersonalController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personalController");
            return controller.getPersonal(getKey(value));
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
            if (object instanceof Personal) {
                Personal o = (Personal) object;
                return getStringKey(o.getDni());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Personal.class.getName()});
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
                                    "/org/munisoft/personal/jr/dw_onomastico.jasper", 0), new XMap(DataSource.class, getFacade().load(0, 0, null, null)), "pdf")
                    .toByteArray()
            ), "application/pdf");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
