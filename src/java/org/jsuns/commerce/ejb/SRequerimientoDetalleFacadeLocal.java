/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.SRequerimientoDetalle;

/**
 *
 * @author Jorik
 */
@Local
public interface SRequerimientoDetalleFacadeLocal {

    void create(SRequerimientoDetalle sRequerimientoDetalle);

    void edit(SRequerimientoDetalle sRequerimientoDetalle);

    void remove(SRequerimientoDetalle sRequerimientoDetalle);

    SRequerimientoDetalle find(Object id);

    List<SRequerimientoDetalle> findAll();

    List<SRequerimientoDetalle> findRange(int[] range);

    int count();
    
}
