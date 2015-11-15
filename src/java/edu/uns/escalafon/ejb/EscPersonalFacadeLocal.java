/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscPersonal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscPersonalFacadeLocal {

    void create(EscPersonal escPersonal);

    void edit(EscPersonal escPersonal);

    void remove(EscPersonal escPersonal);

    EscPersonal find(Object id);

    List<EscPersonal> findAll();

    List<EscPersonal> findRange(int[] range);

    int count();
    
}
