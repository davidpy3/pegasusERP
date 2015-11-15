/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOrdenServicioDetalle;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOrdenServicioDetalleFacadeLocal {

    void create(ComOrdenServicioDetalle comOrdenServicioDetalle);

    void edit(ComOrdenServicioDetalle comOrdenServicioDetalle);

    void remove(ComOrdenServicioDetalle comOrdenServicioDetalle);

    ComOrdenServicioDetalle find(Object id);

    List<ComOrdenServicioDetalle> findAll();

    List<ComOrdenServicioDetalle> findRange(int[] range);

    int count();
    
}
