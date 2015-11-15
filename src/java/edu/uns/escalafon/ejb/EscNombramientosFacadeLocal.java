/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscNombramientos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscNombramientosFacadeLocal {

    void create(EscNombramientos escNombramientos);

    void edit(EscNombramientos escNombramientos);

    void remove(EscNombramientos escNombramientos);

    EscNombramientos find(Object id);

    List<EscNombramientos> findAll();

    List<EscNombramientos> findRange(int[] range);

    int count();
    
}
