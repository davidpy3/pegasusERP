package org.jsuns.commerce;

import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Caja;

public class CajaService{
    
    public int id_caja(int idalm){
        int id_caja=0;
        try{
            Caja caja=JPA.getInstance().getEntityManager()
                .createQuery("select c from Caja c "
                + "where c.almacen.idAlmacen="+idalm,Caja.class).getSingleResult();
            id_caja=caja.getIdCaja();
        }finally{
            JPA.getInstance();
        }
        return id_caja;
    }
      
}
