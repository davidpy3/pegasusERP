package edu.uns.oceda.plan_curricular;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.X;
import org.jsuns.data.JPA;
import org.jsuns.data.Q;
import org.jsuns.util.XUtil;

public class qAsignatura extends Q{

    @Override
    public void beforeRetrieve(HttpServletRequest request, Map map) {
        List l=JPA.getInstance().getEntityManager().createNativeQuery("select id_acper from apc_periodo_academico"
                        + " where id_ambito=:id_ambito AND cod_anio=:cod_anio and cod_sec=:cod_sec")
                        .setParameter("id_ambito",XUtil.intValue(map.remove("id_ambito")))
                        .setParameter("cod_anio",XUtil.intValue(map.remove("cod_anio")))
                        .setParameter("cod_sec",XUtil.intValue(map.remove("cod_sec"))).getResultList();
                l.add(0);
                setQuery("SELECT "
                + "cur_asignatura.id_plancur,"
                + "cur_ciclo.num_romano,"
                + "cur_plan_curricular.denominacion,"
                + "cur_asignatura.codasig,"
                + "cur_asignatura.id_asignatura,"
                + "cur_asignatura.nombre,"
                + "cur_asignatura.id_ciclo,"
                + "cur_asignatura.id_ambito,"
                + "cur_asignatura.id_especialidad,"
                + "ht,"
                + "hp,"
                + "cur_asignatura_periodo.estudiantes_matriculados estudiantes"
                + " from cur_asignatura "
                + "inner join cur_ciclo on cur_ciclo.id_ciclo=cur_asignatura.id_ciclo  "
                + " inner join cur_plan_curricular on cur_plan_curricular.id_plancur=cur_asignatura.id_plancur "
                + "left outer join cur_asignatura_periodo on cur_asignatura_periodo.id_asignatura=cur_asignatura.id_asignatura and "
                + "cur_asignatura_periodo.id_acper IN ("+XUtil.implode(l,",")+")");
        super.beforeRetrieve(request, map);
    }

    public qAsignatura(){
        setQuery("SELECT "
                + "cur_asignatura.id_plancur,"
                + "cur_ciclo.num_romano,"
                + "cur_plan_curricular.denominacion,"
                + "cur_asignatura.codasig,"
                + "cur_asignatura.id_asignatura,"
                + "cur_asignatura.nombre,"
                + "cur_asignatura.id_ciclo,"
                + "cur_asignatura.id_ambito,"
                + "cur_asignatura.id_especialidad,"
                + "ht,"
                + "hp,"
                + "cur_asignatura_periodo.estudiantes_matriculados estudiantes"
                + " from cur_asignatura "
                + "inner join cur_ciclo on cur_ciclo.id_ciclo=cur_asignatura.id_ciclo  "
                + " inner join cur_plan_curricular on cur_plan_curricular.id_plancur=cur_asignatura.id_plancur "
                + "left outer join cur_asignatura_periodo on cur_asignatura_periodo.id_asignatura=cur_asignatura.id_asignatura and "
                + "cur_asignatura_periodo.id_acper=0");
    }


}