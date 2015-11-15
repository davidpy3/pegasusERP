/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOperacionDetalle;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOperacionDetalleFacadeLocal {

    void create(ComOperacionDetalle comOperacionDetalle);

    void edit(ComOperacionDetalle comOperacionDetalle);

    void remove(ComOperacionDetalle comOperacionDetalle);

    ComOperacionDetalle find(Object id);

    List<ComOperacionDetalle> findAll();

    List<ComOperacionDetalle> findRange(int[] range);

    int count();
    
}
