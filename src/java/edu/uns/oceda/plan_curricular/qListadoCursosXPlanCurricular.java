package edu.uns.oceda.plan_curricular;

import org.jsuns.data.Q;

public class qListadoCursosXPlanCurricular extends Q{

    public qListadoCursosXPlanCurricular(){
        setQuery("SELECT "
                
                + "id_asignatura,"
                + "cur_asignatura.id_plancur,"
                + "cur_asignatura.id_ciclo,"
                + "cur_ciclo.num_escrito,"
                + "codasig,"

                + "nombre,ht,hp,"
                + "creditaje,"
                + "'' requisitos "

                + "from cur_asignatura "
                + "left outer join cur_ciclo on  cur_ciclo.id_ciclo=cur_asignatura.id_ciclo "
                + "WHERE cur_asignatura.id_plancur=:id_plancur order by cur_asignatura.id_ciclo");
        setParams(new Object[][]{
            {"id_plancur",Integer.class}
        });
    }

}