package edu.uns.oceda.carga_lectiva.jpa;

import org.jsuns.data.Q;

public class qNuevoDocente extends Q{
    public qNuevoDocente(){
        setQuery("SELECT esc_categoria.abrev_ded,"
                + "esc_categoria.id_cat id_categoria,"
                + "esc_contratos.id_esc,"
                + "esc_contratos.horas,"
                + "esc_contratos.tipo,"
                + "(0+anr_dedicacion_docente.dedo_codigo) id_dedicacion "
                + "from"
                + "(select isnull(esc_promociones_doc.id_cap,tt.id_cap) id_cap,"
                + "tt.id_esc ,tt.horas,isnull(esc_promociones_doc.id_dep,tt.id_dep) id_dep,"
                + "tt.tipo from("
                + "select id_cap,id_esc,horas,id_dep,'c' tipo from esc_contratos_doc WHERE estado=1 "
                + "union "
                + "select id_cap,id_esc,horas,id_dep,'n' from esc_nombramientos_doc WHERE esc_nombramientos_doc.estado=1 "
                + ") tt left outer join esc_promociones_doc on esc_promociones_doc.id_esc=tt.id_esc and esc_promociones_doc.estado=1"
                + ") esc_contratos left outer join esc_cap_docente on esc_cap_docente.id_cap=esc_contratos.id_cap and esc_cap_docente.id_dep=esc_contratos.id_dep "
                + "left outer join esc_categoria on esc_categoria.id_categoria=esc_cap_docente.id_categoria left outer join anr_dedicacion_docente on anr_dedicacion_docente.abrev_ded=esc_categoria.abrev_ded");
    }
}