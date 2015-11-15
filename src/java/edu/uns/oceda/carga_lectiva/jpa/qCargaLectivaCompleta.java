package edu.uns.oceda.carga_lectiva.jpa;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.data.Filter;
import org.jsuns.data.Q;

public class qCargaLectivaCompleta extends Q{

    @Override
    public void beforeRetrieve(HttpServletRequest request, Map map) {
        map.remove("especialidad");
        map.remove("cod_acper");
        map.put("id_esp",map.remove("id_especialidad"));
    }

    public qCargaLectivaCompleta(){
        setQuery("SELECT " +
            "crl_carga_lectiva_cab.id_carglect," +
            "cod_acper," +
            "crl_carga_lectiva_cab.id_clcab,"+
            "crl_carga_lectiva_cab.id_dir," +
            "drt_personanatural.nombre_completo," +
            "crl_carga_lectiva_cab.tipo," +
            "crl_carga_lectiva_cab.id_categoria," +
            "esc_categoria_doc.nombre," +
            "crl_carga_lectiva_cab.id_dedicacion," +
            "anr_dedicacion_docente.abrev_ded," +
            
            "crl_carga_lectiva_cab.total_horas," +
            "crl_carga_lectiva_cab.estado," +
            "cur_asignatura.nombre asignatura,cur_ciclo.num_romano," +
            "cur_asignatura.creditaje," +
            "crl_carga_lectiva_det.id_esp," +
            "aps_especialidad.especialidad, " +
            "crl_carga_lectiva_det.nro_alum, " +
            "crl_carga_lectiva_det.grupt_teor, " +
            "crl_carga_lectiva_det.grupt_prac, " +
            "crl_carga_lectiva_det.ht," +
            "crl_carga_lectiva_det.hp, " +
            "crl_carga_lectiva_det.grup_teor, " +
            "crl_carga_lectiva_det.grupo_t, " +
            "crl_carga_lectiva_det.grup_prac," +
            "crl_carga_lectiva_det.grupo_p, " +
            "crl_carga_lectiva_det.hor_teor, " +
            "crl_carga_lectiva_det.hor_prac, " +
            "crl_carga_lectiva_det.subtotal," +
            "crl_carga_lectiva_det.id_estado," +
            "crl_carga_lectiva_cab.total_horas " +
            "FROM crl_carga_lectiva_cab " +
            "INNER JOIN crl_carga_lectiva ON crl_carga_lectiva.id_carglect=crl_carga_lectiva_cab.id_carglect "+
            "INNER JOIN apc_periodo_academico pa ON pa.id_acper=crl_carga_lectiva.id_acper " +
            "left outer join drt_personanatural ON drt_personanatural.id_dir=crl_carga_lectiva_cab.id_dir " +
            "left outer join esc_categoria_doc ON crl_carga_lectiva_cab.id_categoria=esc_categoria_doc.id_cat  " +
            "left outer join anr_dedicacion_docente ON (0+anr_dedicacion_docente.dedo_codigo)=crl_carga_lectiva_cab.id_dedicacion " +
            "inner join crl_carga_lectiva_det ON crl_carga_lectiva_det.id_clcab=crl_carga_lectiva_cab.id_clcab " +
            "INNER JOIN cur_asignatura on cur_asignatura.id_asignatura=crl_carga_lectiva_det.id_asignatura  " +
            "left outer join cur_ciclo on cur_ciclo.id_ciclo=cur_asignatura.id_ciclo  " +
            "INNER JOIN aps_especialidad on aps_especialidad.id_especialidad=crl_carga_lectiva_det.id_esp "
                + " :filter " +
            "ORDER BY  2,5 ");
        setFilter(new Object[]{"filter",Filter.class," WHERE "});
    }
}