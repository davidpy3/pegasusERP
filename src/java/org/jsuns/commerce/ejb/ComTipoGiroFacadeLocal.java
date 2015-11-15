/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTipoGiro;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTipoGiroFacadeLocal {

    void create(ComTipoGiro comTipoGiro);

    void edit(ComTipoGiro comTipoGiro);

    void remove(ComTipoGiro comTipoGiro);

    ComTipoGiro find(Object id);

    List<ComTipoGiro> findAll();

    List<ComTipoGiro> findRange(int[] range);

    int count();
    
}
