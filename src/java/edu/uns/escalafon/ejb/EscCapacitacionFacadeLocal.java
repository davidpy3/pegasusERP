/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCapacitacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCapacitacionFacadeLocal {

    void create(EscCapacitacion escCapacitacion);

    void edit(EscCapacitacion escCapacitacion);

    void remove(EscCapacitacion escCapacitacion);

    EscCapacitacion find(Object id);

    List<EscCapacitacion> findAll();

    List<EscCapacitacion> findRange(int[] range);

    int count();
    
}
