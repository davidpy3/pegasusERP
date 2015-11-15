package org.jsuns.commerce;

import org.jsuns.data.JPA;
import org.jsuns.commerce.jpa.Empleado;
import org.pegasus.personal.jpa.Cargo;

public class EmpleadoService{

    public Cargo getCargo(String dni){
        Empleado empleado=JPA.getInstance().getEntityManager().find(Empleado.class,dni);
        if(empleado!=null){
            return empleado.getCargo();
        }
        return null;
    }
    
    public String getNomPersonal(String dni) {
        String nom = null;
        Empleado empleado=JPA.getInstance().getEntityManager().find(Empleado.class,dni);
        if (empleado!=null) {
            nom =empleado.getNombreCompleto();
        }
        return nom;
    }
}
