/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComMovimiento;

/**
 *
 * @author Jorik
 */
@Local
public interface ComMovimientoFacadeLocal {

    void create(ComMovimiento comMovimiento);

    void edit(ComMovimiento comMovimiento);

    void remove(ComMovimiento comMovimiento);

    ComMovimiento find(Object id);

    List<ComMovimiento> findAll();

    List<ComMovimiento> findRange(int[] range);

    int count();
    
}
