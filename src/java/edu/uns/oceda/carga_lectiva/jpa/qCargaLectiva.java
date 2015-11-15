package edu.uns.oceda.carga_lectiva.jpa;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.data.Q;

public class qCargaLectiva extends Q{

    @Override
    public void beforeRetrieve(HttpServletRequest request, Map map) {
        Object cod_anio=map.remove("cod_anio");
        Object cod_sec=map.remove("cod_sec");
        String sql="";
        if(cod_anio!=null)sql+=" AND apc_periodo_academico.cod_anio="+cod_anio;
        if(cod_sec!=null)sql+=" AND apc_periodo_academico.cod_sec="+cod_sec;
        setQuery("SELECT crl_carga_lectiva.id_carglect,"
            + "crl_carga_lectiva.id_acper,"
            + "apc_periodo_academico.cod_acper,"
            + "crl_carga_lectiva.id_departamento,"
            + "aps_departamento.departamento,"
            + "crl_carga_lectiva.nro_docentes,"
            + "crl_carga_lectiva.fecha,"
            + "crl_carga_lectiva.estado,"
            + "crl_carga_lectiva.consolidado "
            + "FROM crl_carga_lectiva "
            + "LEFT outer join aps_departamento on aps_departamento.id_departamento=crl_carga_lectiva.id_departamento "
            + (sql.length()>0?"INNER join apc_periodo_academico "
            + "ON apc_periodo_academico.id_acper=crl_carga_lectiva.id_acper "
            + sql:" LEFT outer join apc_periodo_academico "
            + "ON apc_periodo_academico.id_acper=crl_carga_lectiva.id_acper ")
            );
        super.beforeRetrieve(request, map);
        request.getSession().setAttribute(":id_departamento",map.get("id_departamento"));
    }

    public qCargaLectiva(){
        setQuery("SELECT "
            + "crl_carga_lectiva.id_carglect,"
            + "crl_carga_lectiva.id_acper,"
            + "apc_periodo_academico.cod_acper,"
            + "crl_carga_lectiva.id_departamento,"
            + "aps_departamento.departamento,"
            + "crl_carga_lectiva.nro_docentes,"
            + "crl_carga_lectiva.fecha,"
            + "crl_carga_lectiva.estado,"
            + "crl_carga_lectiva.consolidado "
            + "FROM crl_carga_lectiva "
            + "LEFT outer join aps_departamento on aps_departamento.id_departamento=crl_carga_lectiva.id_departamento "
            + "LEFT outer join apc_periodo_academico "
            + "ON apc_periodo_academico.id_acper=crl_carga_lectiva.id_acper");
    }

}