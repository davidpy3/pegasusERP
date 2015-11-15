/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.InventarioDetalle;
import org.pegasus.patrimonio.jpa.InventarioDetallePK;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface InventarioDetalleFacadeLocal {

    void create(InventarioDetalle local);

    void edit(InventarioDetalle local);

    void remove(InventarioDetalle local);

    InventarioDetalle find(Object id);

    List<InventarioDetalle> findAll();

    List<InventarioDetalle> findRange(int first,int max);

    int count();

    public void prepare(InventarioDetalle selected);

    public void inventariar(InventarioDetalle i);
    
}
