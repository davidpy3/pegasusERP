package edu.uns.oceda.carga_lectiva.jpa;

import java.util.List;
import java.util.Map;
import org.jsuns.data.Q;

public class qCargaLectivaDetalle extends Q{

    @Override
    public void setMetadata(List metadata){
        Map field=(Map)((Object[])metadata.get(2))[1];
        field.put("type", "boolean");
        super.setMetadata(metadata);
    }

    public qCargaLectivaDetalle(){
        setQuery("SELECT "
                + "crl_carga_lectiva_det.id_cldet,"
                + "crl_carga_lectiva_det.id_clcab,"
                + "crl_carga_lectiva_det.uso,"
                + "crl_carga_lectiva_det.est_compartido,"
                + "crl_carga_lectiva_det.id_asignatura,"

                + "cur_asignatura.nombre asignatura,"
                + "cur_asignatura.id_ciclo,"
                + "cur_ciclo.num_romano,"
                + "cur_asignatura.creditaje,"
                + "crl_carga_lectiva_det.id_esp,"

                + "aps_especialidad.especialidad,"
                + "crl_carga_lectiva_det.nro_alum,"
                + "crl_carga_lectiva_det.grupt_teor,"
                + "crl_carga_lectiva_det.grupt_prac,"
                + "crl_carga_lectiva_det.ht,"

                + "crl_carga_lectiva_det.hp,"
                + "crl_carga_lectiva_det.grup_teor,"
                + "crl_carga_lectiva_det.grupo_t,"
                + "crl_carga_lectiva_det.grup_prac,"
                + "crl_carga_lectiva_det.grupo_p,"

                + "crl_carga_lectiva_det.hor_teor,"
                + "crl_carga_lectiva_det.hor_prac,"
                + "crl_carga_lectiva_det.subtotal,"
                + "crl_carga_lectiva_det.id_estado, "
                + "crl_carga_lectiva_cab.total_horas  "

                + "from crl_carga_lectiva_det "
                + "inner join crl_carga_lectiva_cab on crl_carga_lectiva_cab.id_clcab=crl_carga_lectiva_det.id_clcab "
                + "INNER JOIN cur_asignatura on cur_asignatura.id_asignatura=crl_carga_lectiva_det.id_asignatura "
                + "left outer join cur_ciclo on cur_ciclo.id_ciclo=cur_asignatura.id_ciclo "
                
                + "inner join aps_especialidad on aps_especialidad.id_especialidad=crl_carga_lectiva_det.id_esp "
                + "");
    }
}