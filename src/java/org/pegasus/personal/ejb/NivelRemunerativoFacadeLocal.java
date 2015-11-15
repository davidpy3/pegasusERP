/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.NivelRemunerativo;

/**
 *
 * @author Jorik
 */
@Local
public interface NivelRemunerativoFacadeLocal {

    void create(NivelRemunerativo nivelRemunerativo);

    void edit(NivelRemunerativo nivelRemunerativo);

    void remove(NivelRemunerativo nivelRemunerativo);

    NivelRemunerativo find(Object id);

    List<NivelRemunerativo> findAll();

    List<NivelRemunerativo> findRange(int[] range);

    int count();
    
}
