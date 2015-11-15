/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Pecosa;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface PecosaFacadeLocal {

    void create(Pecosa pecosa);

    void edit(Pecosa pecosa);

    void remove(Pecosa pecosa);

    Pecosa find(Object id);

    List<Pecosa> findAll();

    List<Pecosa> findRange(int[] range);

    int count();
    
}
