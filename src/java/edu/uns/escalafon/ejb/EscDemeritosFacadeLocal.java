/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscDemeritos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscDemeritosFacadeLocal {

    void create(EscDemeritos escDemeritos);

    void edit(EscDemeritos escDemeritos);

    void remove(EscDemeritos escDemeritos);

    EscDemeritos find(Object id);

    List<EscDemeritos> findAll();

    List<EscDemeritos> findRange(int[] range);

    int count();
    
}
