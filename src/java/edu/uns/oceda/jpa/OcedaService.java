package edu.uns.oceda.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.jsuns.util.JPA;
import org.jsuns.util.RandomUtil;
import org.jsuns.ocid.DrtPersonaNatural;
import org.primefaces.context.RequestContext;


@ManagedBean
@ApplicationScoped
public class OcedaService{

     public void open() {
        System.out.println("selectCar");
        RequestContext.getCurrentInstance().openDialog("selectCar");
    }
    public OcedaService(){
        
    }
    
    public static Object getMenu(){
        return new Object[][]{
            {"Carga Lectiva","admin/oceda/carga-lectiva"},
            {"Estudiantes","admin/oceda/estudiantes"},
            {"Calificacion","admin/oceda/calificacion"},
            {"Matricula","admin/oceda/matricula"}
        };
    }
    
    public ArrayList getEstudianteList2(int n){
        ArrayList data=new ArrayList();
        for(int i=0;i<n;i++)
            data.add(new Object[]{
                RandomUtil.getCode(8).toUpperCase(),
                RandomUtil.getW(30,true).toUpperCase(),
                RandomUtil.getW(3,false).toUpperCase(),
                RandomUtil.getW(10,false).toUpperCase(),
                RandomUtil.getDate(),
                RandomUtil.getNumber(18,50,0)
            });
        return data;
    }
    
    public ArrayList getEstudianteList(){
        ArrayList data=new ArrayList();
        for(int i=0;i<50;i++)
            data.add(new Object[]{
                ((int)RandomUtil.getNumber(99,0,0))+i*100,
                RandomUtil.getW(30,true).toUpperCase(),
                RandomUtil.getW(3,false).toUpperCase(),
                RandomUtil.getW(1,false).toUpperCase(),
                RandomUtil.getDate(),
                RandomUtil.getNumber(18,50,0)
            });
        return data;
    }
    
    public List<FxaEstudiante> getEstudianteList3(){
        return JPA.getInstance().getEntityManager()
                .createQuery("SELECT e from "+DrtPersonaNatural.class.getSimpleName()+
                        " p,"+FxaEstudiante.class.getSimpleName()+" e WHERE "
                        + "p.nombreCompleto like '%ERIK A%'"
                        + "AND e.personaNatural=p",FxaEstudiante.class)
                .getResultList();
    }
    
    public List<ApsAmbitoAcad> getAmbitoAcademicoList(){
        return JPA.getInstance().getEntityManager()
            .createQuery("from "+ApsAmbitoAcad.class.getSimpleName())
            .getResultList();
    }
    
    public List<ApsEspecialidad> getEspecialidadList(){
        return JPA.getInstance().getEntityManager()
            .createQuery("from "+ApsEspecialidad.class.getSimpleName())
            .getResultList();
    }
    
    public List<FxaNivelAcad> getNivelAcademicoList(){
        return JPA.getInstance().getEntityManager()
            .createQuery("from "+FxaNivelAcad.class.getSimpleName())
            .getResultList();
    }
    
    public List<FxaSituacionAcad> getSituacionAcademicaList(){
        return JPA.getInstance().getEntityManager()
            .createQuery("from "+FxaSituacionAcad.class.getSimpleName())
            .getResultList();
    }
    
    public void update(){
        
    }
    
    public void delete(){
        
    }
}
