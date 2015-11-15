/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.Movimiento;

/**
 *
 * @author Jorik
 */
@Local
public interface MovimientoFacadeLocal {

    void create(Movimiento movimiento);

    void edit(Movimiento movimiento);

    void remove(Movimiento movimiento);

    Movimiento find(Object id);

    List<Movimiento> findAll();

    List<Movimiento> findRange(int[] range);

    int count();
    
}
