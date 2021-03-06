/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTipoOperacion;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTipoOperacionFacadeLocal {

    void create(ComTipoOperacion comTipoOperacion);

    void edit(ComTipoOperacion comTipoOperacion);

    void remove(ComTipoOperacion comTipoOperacion);

    ComTipoOperacion find(Object id);

    List<ComTipoOperacion> findAll();

    List<ComTipoOperacion> findRange(int[] range);

    int count();
    
}
