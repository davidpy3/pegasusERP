/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComArticulo;

/**
 *
 * @author Jorik
 */
@Local
public interface ComArticuloFacadeLocal {

    void create(ComArticulo comArticulo);

    void edit(ComArticulo comArticulo);

    void remove(ComArticulo comArticulo);

    ComArticulo find(Object id);

    List<ComArticulo> findAll();

    List<ComArticulo> findRange(int[] range);

    int count();
    
}
