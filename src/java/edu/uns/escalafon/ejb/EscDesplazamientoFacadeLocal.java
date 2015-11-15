/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscDesplazamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscDesplazamientoFacadeLocal {

    void create(EscDesplazamiento escDesplazamiento);

    void edit(EscDesplazamiento escDesplazamiento);

    void remove(EscDesplazamiento escDesplazamiento);

    EscDesplazamiento find(Object id);

    List<EscDesplazamiento> findAll();

    List<EscDesplazamiento> findRange(int[] range);

    int count();
    
}
