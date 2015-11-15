/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComPrecio;

/**
 *
 * @author Jorik
 */
@Local
public interface ComPrecioFacadeLocal {

    void create(ComPrecio comPrecio);

    void edit(ComPrecio comPrecio);

    void remove(ComPrecio comPrecio);

    ComPrecio find(Object id);

    List<ComPrecio> findAll();

    List<ComPrecio> findRange(int[] range);

    int count();
    
}
