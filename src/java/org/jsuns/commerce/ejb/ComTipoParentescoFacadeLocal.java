/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTipoParentesco;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTipoParentescoFacadeLocal {

    void create(ComTipoParentesco comTipoParentesco);

    void edit(ComTipoParentesco comTipoParentesco);

    void remove(ComTipoParentesco comTipoParentesco);

    ComTipoParentesco find(Object id);

    List<ComTipoParentesco> findAll();

    List<ComTipoParentesco> findRange(int[] range);

    int count();
    
}
