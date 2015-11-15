package edu.uns.oceda.carga_lectiva.jpa;

import org.jsuns.data.Q;

public class qAsignaturaCompartidaDetalle extends Q{
    public qAsignaturaCompartidaDetalle(){
        setQuery("SELECT "
            + "cl.id_carglect,d.id_clcab,list(d.id_cldet) id_cldet,"
            + "ca.id_dir,"
            + "p.nombre_completo,"
            + "d.id_asignatura,"
            + "ca.id_categoria,ca.id_dedicacion from crl_carga_lectiva cl "
            + "inner join crl_carga_lectiva_cab ca on cl.id_carglect=ca.id_carglect "
            + "inner join drt_personanatural p on p.id_dir=ca.id_dir "
            + "inner join crl_carga_lectiva_det d  on ca.id_clcab=d.id_clcab "
            + "WHERE d.id_asignatura=:id_asignatura and  d.estado=1 "
            + "and cl.id_acper=:id_acper "
            + "GROUP BY cl.id_carglect,d.id_clcab,"
            + "ca.id_dir,"
            + "p.nombre_completo,"
            + "d.id_asignatura,"
            + "ca.id_categoria,ca.id_dedicacion");
        setParams(new Object[][]{
            {"id_asignatura",Integer.class},
            {"id_acper",Integer.class}
        });
    }
}