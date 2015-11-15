/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoPersonal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoPersonalFacadeLocal {

    void create(EscTipoPersonal escTipoPersonal);

    void edit(EscTipoPersonal escTipoPersonal);

    void remove(EscTipoPersonal escTipoPersonal);

    EscTipoPersonal find(Object id);

    List<EscTipoPersonal> findAll();

    List<EscTipoPersonal> findRange(int[] range);

    int count();
    
}
