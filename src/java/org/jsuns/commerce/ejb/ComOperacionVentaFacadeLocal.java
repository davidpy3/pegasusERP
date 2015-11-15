/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOperacionVenta;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOperacionVentaFacadeLocal {

    void create(ComOperacionVenta comOperacionVenta);

    void edit(ComOperacionVenta comOperacionVenta);

    void remove(ComOperacionVenta comOperacionVenta);

    ComOperacionVenta find(Object id);

    List<ComOperacionVenta> findAll();

    List<ComOperacionVenta> findRange(int[] range);

    int count();
    
}
