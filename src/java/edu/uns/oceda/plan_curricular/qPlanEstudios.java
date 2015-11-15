package edu.uns.oceda.plan_curricular;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.data.Filter;
import org.jsuns.data.Q;
import org.jsuns.util.XUtil;

public class qPlanEstudios extends Q{
    
    @Override
    public void beforeRetrieve(HttpServletRequest request, Map map){
        Object id_especialidad=map.remove("id_especialidad");
        int numero=XUtil.intValue(map.remove("numero"));
        int id_promocion=XUtil.intValue(map.remove("id_promocion"));
        if(numero>0)numero= id_promocion - numero;
        if(id_especialidad!=null){
            map.put("id_plancur",new String[]{"a.id_plancur IN (SELECT TOP 1 id_plancur FROM cur_plan_curricular "
                    + "where id_especialidad "+
                     (id_especialidad instanceof List?" IN ("+
                        XUtil.implode((List)id_especialidad,",")+")":
                        ("="+XUtil.intValue(id_especialidad)))
                    +" ORDER BY id_anio)"});
        }
        
        setQuery("SELECT "
                + "a.id_asignatura,"
                + "a.id_plancur,"
                + "a.id_ciclo,"
                + "cur_ciclo.num_romano,"
                + "a.codasig,a.nombre,a.ht,a.hp,(isnull(a.ht,0)+isnull(a.hp,0)) th,"
                + "a.creditaje ,"
                + "list(a2.codasig,', ') requisitos from cur_asignatura a "
                + "left outer join cur_ciclo on  cur_ciclo.id_ciclo=a.id_ciclo "
                + "left outer join cur_plan_asignatura pa on pa.id_asignatura_base=a.id_asignatura "
                + "left outer join cur_asignatura a2 on a2.id_asignatura=pa.id_asignatura_req "
                + ":filter"
                + "GROUP BY a.id_asignatura,a.id_plancur,a.id_ciclo,cur_ciclo.num_romano,"
                + "a.codasig,a.nombre,a.ht,a.hp,th,a.creditaje "
                + "ORDER BY 2,3,1");
        setFilter(new Object[]{"filter",Filter.class,"WHERE"});
    }

    public qPlanEstudios(){
        setQuery("SELECT id_asignatura,cur_asignatura.id_plancur,"
                + "cur_asignatura.id_ciclo,"
                + "cur_ciclo.num_romano,"
                + "codasig,nombre,ht,hp,"
                + "(cur_asignatura.ht + cur_asignatura.hp) TH,"
                + "creditaje "
                + "from cur_asignatura "
                + "left outer join cur_ciclo on  cur_ciclo.id_ciclo=cur_asignatura.id_ciclo ");
    }

}


