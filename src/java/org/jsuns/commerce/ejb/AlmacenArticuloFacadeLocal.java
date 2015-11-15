/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.AlmacenArticulo;

/**
 *
 * @author Jorik
 */
@Local
public interface AlmacenArticuloFacadeLocal {

    void create(AlmacenArticulo almacenArticulo);

    void edit(AlmacenArticulo almacenArticulo);

    void remove(AlmacenArticulo almacenArticulo);

    AlmacenArticulo find(Object id);

    List<AlmacenArticulo> findAll();

    List<AlmacenArticulo> findRange(int[] range);

    int count();
    
}
