/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Proyecto;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ProyectoFacadeLocal {

    void create(Proyecto oficina);

    void edit(Proyecto oficina);

    void remove(Proyecto oficina);

    Proyecto find(Object id);

    List<Proyecto> findAll();

    List<Proyecto> findRange(int first,int max);

    int count();
    
}
