/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.TipoMovimiento;

/**
 *
 * @author Jorik
 */
@Local
public interface TipoMovimientoFacadeLocal {

    void create(TipoMovimiento tipoMovimiento);

    void edit(TipoMovimiento tipoMovimiento);

    void remove(TipoMovimiento tipoMovimiento);

    TipoMovimiento find(Object id);

    List<TipoMovimiento> findAll();

    List<TipoMovimiento> findRange(int[] range);

    int count();
    
}
