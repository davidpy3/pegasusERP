/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Inventario;
import org.pegasus.patrimonio.jpa.InventarioPK;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface InventarioFacadeLocal {

    void create(Inventario local);

    void edit(Inventario local);

    void remove(Inventario local);

    Inventario find(Object id);

    List<Inventario> findAll();

    List<Inventario> findRange(int first,int max);

    int count();

    public void prepare(Inventario selected);
    
}
