/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.SonAlmacen;

/**
 *
 * @author Jorik
 */
@Local
public interface SonAlmacenFacadeLocal {

    void create(SonAlmacen sonAlmacen);

    void edit(SonAlmacen sonAlmacen);

    void remove(SonAlmacen sonAlmacen);

    SonAlmacen find(Object id);

    List<SonAlmacen> findAll();

    List<SonAlmacen> findRange(int[] range);

    int count();
    
}
