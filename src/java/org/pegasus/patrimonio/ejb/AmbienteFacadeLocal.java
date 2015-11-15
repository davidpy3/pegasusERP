/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Ambiente;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface AmbienteFacadeLocal {

    void create(Ambiente area);

    void edit(Ambiente area);

    void remove(Ambiente area);

    Ambiente find(Object id);

    List<Ambiente> findAll();

    List<Ambiente> findRange(int[] range);

    int count();
    
}
