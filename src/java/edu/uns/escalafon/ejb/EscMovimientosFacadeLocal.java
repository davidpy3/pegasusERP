/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscMovimientos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscMovimientosFacadeLocal {

    void create(EscMovimientos escMovimientos);

    void edit(EscMovimientos escMovimientos);

    void remove(EscMovimientos escMovimientos);

    EscMovimientos find(Object id);

    List<EscMovimientos> findAll();

    List<EscMovimientos> findRange(int[] range);

    int count();
    
}
