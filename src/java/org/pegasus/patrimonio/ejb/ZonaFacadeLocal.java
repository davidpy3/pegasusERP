/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Zona;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ZonaFacadeLocal {

    void create(Zona zona);

    void edit(Zona zona);

    void remove(Zona zona);

    Zona find(Object id);

    List<Zona> findAll();

    List<Zona> findRange(int first,int max);

    int count();
    
}
