package org.jsuns.commerce;

import org.jsuns.data.JPA;

public class OfertaService{
    
    public Double precio_oferta (Integer idalm, Integer idpro) {
        Double precio = 0.0;
        try{
            String ver_pre = "select do.precio "
                    + "from detalle_oferta as do "
                    + "inner join oferta as o on do.idOferta = o.idOferta "
                    + "where do.idProductos = '"+idpro+"' and o.idAlmacen = '"+
                    idalm+"' and (curdate() between o.fecha_ofer and o.fecha_venc)";
            precio=(Double)JPA.getInstance().getEntityManager().createQuery(ver_pre).getSingleResult();
            JPA.getInstance().close();
        }catch(Exception e){
            System.out.println(e);
        }
        return precio;
    }  
}
