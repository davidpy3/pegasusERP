package org.jsuns.commerce;

import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.SonAlmacen;

public class AlmacenService{
    public String nom_alm (String dir){
        SonAlmacen almacen=(SonAlmacen) JPA.getInstance().getEntityManager()
                .createQuery("select a from "
                + "Almacen a where direccion='"+dir+"'")
                .getSingleResult();
        return almacen.getNombre();
    }
            
    public int id_alm_dir (String dir) {
        int idalm = 0;
        SonAlmacen almacen=(SonAlmacen) JPA.getInstance().getEntityManager()
                .createQuery("select a from "
                + "Almacen a where direccion='"+dir+"'")
                .getSingleResult();
        return almacen.getIdAlmacen();
    }
    
}
