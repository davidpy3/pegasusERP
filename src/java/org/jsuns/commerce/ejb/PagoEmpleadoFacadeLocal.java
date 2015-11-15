/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.PagoEmpleado;

/**
 *
 * @author Jorik
 */
@Local
public interface PagoEmpleadoFacadeLocal {

    void create(PagoEmpleado pagoEmpleado);

    void edit(PagoEmpleado pagoEmpleado);

    void remove(PagoEmpleado pagoEmpleado);

    PagoEmpleado find(Object id);

    List<PagoEmpleado> findAll();

    List<PagoEmpleado> findRange(int[] range);

    int count();
    
}
