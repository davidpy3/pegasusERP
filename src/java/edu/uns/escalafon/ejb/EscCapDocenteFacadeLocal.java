/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCapDocente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCapDocenteFacadeLocal {

    void create(EscCapDocente escCapDocente);

    void edit(EscCapDocente escCapDocente);

    void remove(EscCapDocente escCapDocente);

    EscCapDocente find(Object id);

    List<EscCapDocente> findAll();

    List<EscCapDocente> findRange(int[] range);

    int count();
    
}
