/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCapUns;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCapUnsFacadeLocal {

    void create(EscCapUns escCapUns);

    void edit(EscCapUns escCapUns);

    void remove(EscCapUns escCapUns);

    EscCapUns find(Object id);

    List<EscCapUns> findAll();

    List<EscCapUns> findRange(int[] range);

    int count();
    
}
