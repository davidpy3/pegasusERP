package edu.uns.oceda.carga_lectiva.jpa;

import org.jsuns.data.Q;

public class qCargaLectivaCab extends Q{

    public qCargaLectivaCab(){
        setQuery("SELECT "
                + "crl_carga_lectiva_cab.id_clcab,"
                + "crl_carga_lectiva_cab.id_dir,"
                + "drt_personanatural.nombre_completo,"
                + "crl_carga_lectiva_cab.tipo,"
                + "crl_carga_lectiva_cab.id_categoria,esc_categoria_doc.nombre,"
                + "crl_carga_lectiva_cab.id_dedicacion,anr_dedicacion_docente.dedo_descripcion,"
                + "crl_carga_lectiva_cab.id_carglect,"
                + "crl_carga_lectiva_cab.total_horas,crl_carga_lectiva_cab.estado from crl_carga_lectiva_cab "
                + "left outer join drt_personanatural on drt_personanatural.id_dir=crl_carga_lectiva_cab.id_dir "
                + "left outer join esc_categoria_doc on crl_carga_lectiva_cab.id_categoria=esc_categoria_doc.id_cat "
                + "left outer join anr_dedicacion_docente on (0+anr_dedicacion_docente.dedo_codigo)=crl_carga_lectiva_cab.id_dedicacion ");
    }
}