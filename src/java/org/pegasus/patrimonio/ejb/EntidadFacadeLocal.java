/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Entidad;

@Local
public interface EntidadFacadeLocal {

    void create(Entidad area);

    void edit(Entidad area);

    void remove(Entidad area);

    Entidad find(Object id);

    List<Entidad> findAll();

    List<Entidad> findRange(int[] range);

    int count();
    
}
