/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscNivelEstudios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscNivelEstudiosFacadeLocal {

    void create(EscNivelEstudios escNivelEstudios);

    void edit(EscNivelEstudios escNivelEstudios);

    void remove(EscNivelEstudios escNivelEstudios);

    EscNivelEstudios find(Object id);

    List<EscNivelEstudios> findAll();

    List<EscNivelEstudios> findRange(int[] range);

    int count();
    
}
