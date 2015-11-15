package edu.uns.oceda.plan_curricular;

import org.jsuns.data.Q;

public class qListadoPlanCurricular extends Q{

    public qListadoPlanCurricular(){
        setQuery("SELECT cur_plan_curricular.id_plancur,cur_plan_curricular.codplancur,"
                + "cur_plan_curricular.id_especialidad,"
                + "aps_especialidad.especialidad,cur_plan_curricular.id_anio,"
                + "cur_plan_curricular.denominacion,cur_plan_curricular.id_plancondi ,"
                + "cur_plan_condicion.nombre condicion,cur_plan_curricular.id_planmoda ,"
                + "cur_plan_modalidad.nombre modalidad,cur_plan_curricular.id_planejec,cur_plan_ejecucion.nombre ejecucion,"
                + "cur_plan_curricular.rgl_cred_total from cur_plan_curricular "
                + "left outer join aps_especialidad on aps_especialidad.id_especialidad=cur_plan_curricular.id_especialidad "
                + "left outer join cur_plan_condicion on cur_plan_condicion.id_plancondi=cur_plan_curricular.id_plancondi "
                + "left outer join cur_plan_modalidad on cur_plan_modalidad.id_planmoda=cur_plan_curricular.id_planmoda "
                + "left outer join cur_plan_ejecucion on cur_plan_ejecucion.id_planejec=cur_plan_curricular.id_planejec");
    }

}