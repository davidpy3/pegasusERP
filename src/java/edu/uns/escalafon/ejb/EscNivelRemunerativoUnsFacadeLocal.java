/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscNivelRemunerativoUns;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscNivelRemunerativoUnsFacadeLocal {

    void create(EscNivelRemunerativoUns escNivelRemunerativoUns);

    void edit(EscNivelRemunerativoUns escNivelRemunerativoUns);

    void remove(EscNivelRemunerativoUns escNivelRemunerativoUns);

    EscNivelRemunerativoUns find(Object id);

    List<EscNivelRemunerativoUns> findAll();

    List<EscNivelRemunerativoUns> findRange(int[] range);

    int count();
    
}
