package edu.uns.oceca.jsf;

import edu.uns.oceca.jpa.QuizEncuestaParticipacion;
import edu.uns.oceca.ejb.QuizEncuestaParticipacionFacadeLocal;
import edu.uns.oceca.jpa.QuizCategoria;
import edu.uns.oceca.jpa.QuizPregunta;
import edu.uns.oceca.jpa.QuizRespuesta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
import org.jsuns.util.AbstractController;
import org.jsuns.util.JsfUtil;
import org.jsuns.util.JsfUtil.PersistAction;
import org.jsuns.util.Pegasus;

@Named
@SessionScoped
public class QuizEncuestaParticipacionController extends AbstractController<QuizEncuestaParticipacion> implements Serializable {

    @EJB
    private edu.uns.oceca.ejb.QuizEncuestaParticipacionFacadeLocal ejbFacade;

    private List<QuizRespuesta> quizRespuestaList;

    private List<QuizCategoria> quizCategoriaList;

    private int count1 = 0, count2 = 0;

    public List<QuizRespuesta> getQuizRespuestaList() {
        return quizRespuestaList;
    }

    public int getCounter(int n) {
        if (n == 0) {
            return ++count1;
        } else {
            return (++count2) / 2;
        }
    }

    private double progress = 0;

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
    
    private O[] o3=new O[]{new O("1"),new O("3"),new O("4"),new O("2")};

    public O[] getO3() {
        return o3;
    }

    public void setO3(O[] o3) {
        this.o3 = o3;
    }
    
    public class O{
        Object n;
        public O(Object n){
            this.n=n;
        }

        public Object getN() {
            return n;
        }

        public void setN(Object n) {
            this.n = n;
        }

        @Override
        public String toString() {
            return "O{" + "n=" + n + '}';
        }
    }

    public String toString(Object i) {
        return "XX" + i;
    }

    public void grabar(boolean close) {
        for(Object v:this.o3)
        System.out.println("oo="+v);
        Map m = getParams();
        for(Object[] c:getTmpList()){
            for(Object[] p:(List<Object[]>)c[1]){
                System.out.println(p[0]+">>>"+p[1]);
            }
        }
        for (QuizRespuesta r : quizRespuestaList) {
            m.put("R" + r.getSvaRespuestaPK().getIdPregunta(), r);
        }
        int si = 0;
        int t = 0;
        for (QuizCategoria c : this.quizCategoriaList) {
            List<Object[]> l=(List<Object[]>) m.get("C"+c.getIdCategoria());
            for(Object[] row:l){
                System.out.println(row[0]+"->"+row[1]);
            }
//            for (QuizPregunta p : c.getPreguntaCollection()) {
//                ++t;
//                Object o = m.get(p.getIdPregunta());
//                if (o != null) {
//                    ++si;
//                }
//            }
        }
        progress = 100.0 * si / (double) (t);
        System.out.println(si + " de " + t);
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Progress="+progress,  null);
//        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void setQuizRespuestaList(List<QuizRespuesta> quizRespuestaList) {
        this.quizRespuestaList = quizRespuestaList;
        for (QuizRespuesta r : quizRespuestaList) {
            getParams().put(r.getSvaRespuestaPK().getIdPregunta(), r.getIdOpcion());
        }
    }

    public List<QuizCategoria> getQuizCategoriaList() {
        return quizCategoriaList;
    }

    public void setQuizCategoriaList(List<QuizCategoria> quizCategoria) {
        this.quizCategoriaList = quizCategoria;
    }

    public void ajax() {
        items = null;
    }

    private QuizEncuestaParticipacionFacadeLocal getFacade() {
        return ejbFacade;
    }

    public void setPreguntaList(QuizCategoria c,List<Object[]> l){
        getParams().put("C"+c.getIdCategoria(),l);
    }
    
    public List<Object[]> getPreguntaList(QuizCategoria c){
        return (List<Object[]>) getParams().get("C"+c.getIdCategoria());
    }

    public List<Object[]> getTmpList() {
        return tmpList;
    }

    public void setTmpList(List<Object[]> tmpList) {
        this.tmpList = tmpList;
    }
    
    private List<Object[]> tmpList;
    
    
    
    public String responder(QuizEncuestaParticipacion r) {
        if (r != null) {
            this.setSelected(r);
        }
        Map m = this.getFacade().responder(getSelected());
        setQuizCategoriaList((List<QuizCategoria>) m.get(QuizCategoria.class.getName()));
        setQuizRespuestaList((List<QuizRespuesta>) m.get(QuizRespuesta.class.getName()));
        ArrayList<Object[]> tl=new ArrayList();
        this.setTmpList(tl);
        m = getParams();
        int si = 0;
        int t = 0;
        for (QuizCategoria c : this.quizCategoriaList) {
            ArrayList l=new ArrayList();
            m.put("C"+c.getIdCategoria(),l);
            for (QuizPregunta p : c.getPreguntaCollection()){
                l.add(new Object[]{p,new O(null)});
//                m.put("R"+p.getIdPregunta(),0);
            }
            tl.add(new Object[]{c,l});
        }
        progress = 100.0 * si / (double) (t);
        System.out.println(si + " de " + t);
        this.count1 = 0;
        this.count2 = 0;
        return "/oceca/encuestaParticipacion/Responder?faces-redirect=true";
    }

    public boolean filter(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public List<QuizEncuestaParticipacion> getItems() {
        if (items == null) {
            getParams().put("personaNatural", Pegasus.getSession().getAttribute("personaNatural"));
            items = getFacade().load(0, -1, null, getParams());
        }
        return items;
    }

    @Override
    protected void persist(PersistAction persistAction, String successMessage) {
        QuizEncuestaParticipacion selected = getSelected();
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
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle0").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle0").getString("PersistenceErrorOccured"));
            }
        }
    }

    public QuizEncuestaParticipacion getSgcEncuestaParticipante(Integer id) {
        return getFacade().find(id);
    }

    public List<QuizEncuestaParticipacion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<QuizEncuestaParticipacion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = QuizEncuestaParticipacion.class)
    public static class SgcEncuestaParticipanteControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            QuizEncuestaParticipacionController controller = (QuizEncuestaParticipacionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sgcEncuestaParticipanteController");
            return controller.getSgcEncuestaParticipante(getKey(value));
        }

        Integer getKey(String value) {
            return Integer.parseInt(value);
        }

        String getStringKey(Integer value) {
            return value.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof QuizEncuestaParticipacion) {
                QuizEncuestaParticipacion o = (QuizEncuestaParticipacion) object;
                return getStringKey(o.getIdParticipacion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), QuizEncuestaParticipacion.class.getName()});
                return null;
            }
        }

    }

}
