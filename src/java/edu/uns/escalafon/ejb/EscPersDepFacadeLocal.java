/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscPersDep;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscPersDepFacadeLocal {

    void create(EscPersDep escPersDep);

    void edit(EscPersDep escPersDep);

    void remove(EscPersDep escPersDep);

    EscPersDep find(Object id);

    List<EscPersDep> findAll();

    List<EscPersDep> findRange(int[] range);

    int count();
    
}
