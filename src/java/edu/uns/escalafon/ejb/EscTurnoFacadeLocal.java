/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTurno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTurnoFacadeLocal {

    void create(EscTurno escTurno);

    void edit(EscTurno escTurno);

    void remove(EscTurno escTurno);

    EscTurno find(Object id);

    List<EscTurno> findAll();

    List<EscTurno> findRange(int[] range);

    int count();
    
}
