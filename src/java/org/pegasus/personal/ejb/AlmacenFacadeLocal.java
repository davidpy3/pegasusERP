/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Almacen;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface AlmacenFacadeLocal {

    void create(Almacen almacen);

    void edit(Almacen almacen);

    void remove(Almacen almacen);

    Almacen find(Object id);

    List<Almacen> findAll();

    List<Almacen> findRange(int[] range);

    int count();
    
}
