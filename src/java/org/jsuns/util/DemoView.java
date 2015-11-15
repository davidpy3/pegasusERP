package org.jsuns.util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.*;
import javax.persistence.EntityManager;
import edu.uns.oceda.jpa.FxaEgreso;
import edu.uns.oceda.jpa.FxaEstudiante;
import edu.uns.oceda.jpa.GytModoTitulacion;
import org.jsuns.ocid.DrtPersonaNatural;

@ManagedBean
@RequestScoped
public class DemoView implements Serializable {

    private int uid;
    
    public int getUid(){
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    public Date getDate(){
        return RandomUtil.getDate();
    }
    
    private FxaEgreso egreso;

    public FxaEgreso getEgreso() {
        return egreso;
    }

    public void setEgreso(FxaEgreso egreso) {
        this.egreso = egreso;
    }
    
    public FxaEstudiante getEstudiante(){
        EntityManager em=JPA.getInstance().getEntityManager();
        FxaEstudiante e=em.find(FxaEstudiante.class,uid);
        if(e==null){
            e=new FxaEstudiante();
            e.setPersonaNatural(new DrtPersonaNatural());
            return e;
        }else
            e.getPersonaNatural();
        egreso=null;
        if(e.getIdAcexp()!=null)egreso=em.find(FxaEgreso.class,e.getIdAcexp());
        if(egreso==null)egreso=new FxaEgreso();
        return e;
    }
    
    public String getEspecialidad(){
        return "INGENIERIA DE SISTEMAS E INFORMATICA";
    }
    
    public String getCodigoEstudiante(){
        return "0199914050";
    }
    
    public List getModoTitulacion(){
        return JPA.getInstance().getEntityManager().createQuery("from "+GytModoTitulacion.class.getSimpleName()).getResultList();
    }
    
    public String getString2(int wordLength){
        return RandomUtil.getW(wordLength,true);
    }
    
    public String getString(){
        return getString2(20);
    }
    
    public int getInt(){
        return (int)(Math.random()*100);
    }
    
    public void persist(Object object){
        JPA.getInstance().getEntityManager(true).persist(object);
    }
    
}
