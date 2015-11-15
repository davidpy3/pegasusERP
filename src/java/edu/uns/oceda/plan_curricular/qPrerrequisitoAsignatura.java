package edu.uns.oceda.plan_curricular;

import org.jsuns.data.Q;

public class qPrerrequisitoAsignatura extends Q{

    public qPrerrequisitoAsignatura(){
        setQuery("SELECT cur_plan_asignatura.id_asignatura_base,"
                + "cur_plan_asignatura.id_asignatura_req,"
                + "cur_asignatura.codasig,cur_asignatura.nombre "
                + "from cur_plan_asignatura "
                + "inner join cur_asignatura on cur_plan_asignatura.id_asignatura_req=cur_asignatura.id_asignatura");
    }
}