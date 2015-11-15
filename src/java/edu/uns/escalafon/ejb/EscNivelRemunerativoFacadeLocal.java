/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscNivelRemunerativo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscNivelRemunerativoFacadeLocal {

    void create(EscNivelRemunerativo escNivelRemunerativo);

    void edit(EscNivelRemunerativo escNivelRemunerativo);

    void remove(EscNivelRemunerativo escNivelRemunerativo);

    EscNivelRemunerativo find(Object id);

    List<EscNivelRemunerativo> findAll();

    List<EscNivelRemunerativo> findRange(int[] range);

    int count();
    
}
