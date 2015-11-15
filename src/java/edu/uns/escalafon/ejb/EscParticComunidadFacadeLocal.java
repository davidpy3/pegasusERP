/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscParticComunidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscParticComunidadFacadeLocal {

    void create(EscParticComunidad escParticComunidad);

    void edit(EscParticComunidad escParticComunidad);

    void remove(EscParticComunidad escParticComunidad);

    EscParticComunidad find(Object id);

    List<EscParticComunidad> findAll();

    List<EscParticComunidad> findRange(int[] range);

    int count();
    
}
