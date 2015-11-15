package edu.uns.oceda.jpa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;


@ManagedBean
@ApplicationScoped
public class SGCService{
    
    public SGCService(){
        
    }
    
    public static Object getMenu(){
        return new Object[][]{
            {"Autoevaluacion","admin/oceca/carga-lectiva"},
            {"Documentos","admin/oceca/documento"},
            {"Auditorias","admin/oceca/estudiantes"},
            {"Encuestas","admin/oceca/calificacion"}
        };
    }
    
}
