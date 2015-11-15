/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOperacion;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOperacionFacadeLocal {

    void create(ComOperacion comOperacion);

    void edit(ComOperacion comOperacion);

    void remove(ComOperacion comOperacion);

    ComOperacion find(Object id);

    List<ComOperacion> findAll();

    List<ComOperacion> findRange(int[] range);

    int count();
    
}
