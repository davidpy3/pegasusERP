/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOperacionTraslado;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOperacionTrasladoFacadeLocal {

    void create(ComOperacionTraslado comOperacionTraslado);

    void edit(ComOperacionTraslado comOperacionTraslado);

    void remove(ComOperacionTraslado comOperacionTraslado);

    ComOperacionTraslado find(Object id);

    List<ComOperacionTraslado> findAll();

    List<ComOperacionTraslado> findRange(int[] range);

    int count();
    
}
