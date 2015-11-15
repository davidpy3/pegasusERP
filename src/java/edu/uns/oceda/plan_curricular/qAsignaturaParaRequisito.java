package edu.uns.oceda.plan_curricular;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.data.Q;

public class qAsignaturaParaRequisito extends Q{
        @Override
    public void beforeRetrieve(HttpServletRequest request, Map map) {
        //if(request.getSession().getAttribute(":all")!=null)
            request.setAttribute(":all",1);
    }

    public qAsignaturaParaRequisito(){
        setQuery("SELECT * from (SELECT "
                
                + "cur_asignatura.id_asignatura id_asignatura_req,"
                + "cur_asignatura.codasig,"
                + "cur_asignatura.nombre,"
                + "id_ciclo,"
                + "id_ambito,"
                + "id_plancur "

                + " from cur_asignatura "
                + "WHERE id_ambito=11 and id_ciclo<:id_ciclo ) cur_asignatura");
        setParams(new Object[][]{
            {"id_ciclo",Integer.class}
        });
    }


}