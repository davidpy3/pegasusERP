package edu.uns.oceda.plan_curricular;

import org.jsuns.data.Q;

public class qPlanCurricularSimple extends Q{

    public qPlanCurricularSimple(){
        setQuery("SELECT id_plancur,denominacion,id_anio,id_especialidad "
                + "from cur_plan_curricular WHERE cur_plan_curricular.id_especialidad=:id_especialidad order by id_anio desc");
        setParams(new Object[][]{
            {"id_especialidad",Integer.class}
        });
    }

}