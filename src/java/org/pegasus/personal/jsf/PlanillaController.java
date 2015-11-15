package org.pegasus.personal.jsf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.pegasus.personal.jpa.Planilla;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.jsuns.X;
import org.jsuns.app.export.TraslatorCVS;
import org.jsuns.util.AbstractController;
import org.jsuns.util.XMap;
import org.jsuns.util.XUtil;
import org.pegasus.personal.ejb.PlanillaFacadeLocal;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@ViewScoped
public class PlanillaController extends AbstractController<Planilla> implements Serializable {

    private String bandeja;
    private List<Planilla> selectedList;
    private HashMap params=new HashMap();

    public PlanillaController() {
        params.put("mes", "06");
        params.put("anoEje", "2015");
    }

    public HashMap getParams() {
        return params;
    }

    public void setParams(HashMap params) {
        this.params = params;
    }

    public void siaf() {
        X.log(this.getSelectedList());
    }

    public List<Planilla> getSelectedList(){
        return selectedList;
    }

    public void setSelectedList(List<Planilla> selectedList) {
        setSelected(selectedList!=null&&selectedList.size()>0?selectedList.get(0):null);
        this.selectedList = selectedList;
    }

    public String getEstado(Character c) {
        ArrayList<Object[]> estadoList = new ArrayList();
        estadoList.add(new Object[]{'0', "Borrador"});
        estadoList.add(new Object[]{'1', "Trámite"});
        estadoList.add(new Object[]{'2', "Elaboración"});
        estadoList.add(new Object[]{'3', "Procesado"});
        estadoList.add(new Object[]{'4', "Procesado"});
        estadoList.add(new Object[]{'5', "Comprometido"});
        estadoList.add(new Object[]{'6', "Girado"});
        estadoList.add(new Object[]{'9', "Anulado"});
        for (Object[] o : estadoList) {
            if (o[0].equals(c)) {
                return o[1].toString();
            }
        }
        return "";
    }

    public Object[] getMesList() {
        List<Object[]> mL = new ArrayList();
        String[] months = new DateFormatSymbols().getMonths();
        for (int i = 0; i < months.length; i++) {
            if (months[i].length() > 0) {
                mL.add(new Object[]{String.format("%20d", i + 1), months[i].toUpperCase()});
            }
        }
        return mL.toArray();
    }

    public StreamedContent download() throws IOException {
        Planilla p = getSelected();
        List l = this.getFacade().getResultList(0, 0,null, new XMap("planilla", p));
        File f = new TraslatorCVS()._export(l, File.createTempFile("pegasus", ""), ";");
        InputStream stream = new FileInputStream(f);
        Object[] head = (Object[]) l.get(0);
        return new DefaultStreamedContent(stream, "application/cvs",
                "PPL" + XUtil.implode(head, "", 6) + ".txt");
    }

    public String getBandeja() {
        return bandeja;
    }

    public void setBandeja(String bandeja) {
        this.bandeja = bandeja;
    }

    @EJB
    private org.pegasus.personal.ejb.PlanillaFacadeLocal ejbFacade;

    private PlanillaFacadeLocal getFacade() {
        return ejbFacade;
    }

    public List<Planilla> getItems() {
        if (items == null) {
            items = getFacade().load(0, 0, null,params);
        }
        return items;
    }

    public void ajax(){
        items=null;
    }

    @Override
    protected void initializeEmbeddableKey() {
        Planilla selected = getSelected();
        if(selected.getPlanillaPK()==null){
            this.getFacade().prepare(selected);
        }
    }
    
    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        Planilla selected = getSelected();
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

    public Planilla getPlanilla(org.pegasus.personal.jpa.PlanillaPK id) {
        return getFacade().find(id);
    }

    public List<Planilla> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Planilla> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(value="planillaControllerConverter",forClass = Planilla.class)
    public static class PlanillaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PlanillaController controller = (PlanillaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "planillaController");
            System.out.println("value="+value);
            return controller.getPlanilla(getKey(value));
        }

        org.pegasus.personal.jpa.PlanillaPK getKey(String value) {
            org.pegasus.personal.jpa.PlanillaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new org.pegasus.personal.jpa.PlanillaPK();
            key.setNExpediente(values[0]);
            key.setAnoEje(values[1]);
            return key;
        }

        String getStringKey(org.pegasus.personal.jpa.PlanillaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getNExpediente());
            sb.append(SEPARATOR);
            sb.append(value.getAnoEje());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Planilla) {
                Planilla o = (Planilla) object;
                return getStringKey(o.getPlanillaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Planilla.class.getName()});
                return null;
            }
        }

    }

}
