package org.jsuns.commerce.jpa;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.jsuns.data.Q;

public final class CompraQ extends Q{

    //            while (rs.next()) {
//                Object fila[] = new Object[11];
//                fila[0] = rs.getString("idCompra");
//                fila[1] =rs.getString("fecha_doc");
//                if (rs.getString("estado").equals("1")) {
//                    fila[10] = "PAGADO";
//                } else {
//                    fila[10] = "PENDIENTE";
//                }
//                mostrar.addRow(fila);
//            }
    
    @Override
    public List afterRetrieve(HttpServletRequest request, List data){
        
        return data;
    }

    @Override
    public void beforeRetrieve(HttpServletRequest request, Map m) {
        setQuery("SELECT "
                
                + "c.id_compra, "
                + "c.fecha_doc,"
                + "ifnull(pc.fecha_venc,c.fecha_pago) fecha_pago,"
                + "c.total,"
                + "t.desc_tipd,"
                
                + "c.serie,"
                + "c.numero,"
                + "c.estado,"
                + "c.ruc_pro,"
                + "p.raz_soc_pro,"
                
                + "a.nom_alm "
                
                + "FROM compra c "
                + "inner join tipo_doc t on c.id_tipo_doc=t.id_tipo_doc "
                + "inner join proveedor as p on c.ruc_pro=p.ruc_pro "
                + "inner join almacen a on c.id_almacen=a.id_almacen "
                + "LEFT OUTER JOIN compra_pago pc ON pc.id_compra=c.id_compra AND pc.estado=0  "
                + "WHERE c.tipo_compra = 'P' and MONTH(c.fecha_doc) > '"+new Date().getMonth()+"'"
                + " and c.estado = '2' "
                + "ORDER BY c.fecha_doc desc,c.id_compra desc");
    }
    
    public CompraQ(){
        beforeRetrieve(null,Collections.EMPTY_MAP);
    }
    
}
