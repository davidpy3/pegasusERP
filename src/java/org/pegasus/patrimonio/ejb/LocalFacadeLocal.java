/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import org.pegasus.patrimonio.jpa.ELocal;

@javax.ejb.Local
public interface LocalFacadeLocal {

    void create(ELocal area);

    void edit(ELocal area);

    void remove(ELocal area);

    ELocal find(Object id);

    List<ELocal> findAll();

    List<ELocal> findRange(int[] range);

    int count();
    
}
