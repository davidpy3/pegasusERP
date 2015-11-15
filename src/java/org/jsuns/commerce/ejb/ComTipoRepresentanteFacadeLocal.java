/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTipoRepresentante;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTipoRepresentanteFacadeLocal {

    void create(ComTipoRepresentante comTipoRepresentante);

    void edit(ComTipoRepresentante comTipoRepresentante);

    void remove(ComTipoRepresentante comTipoRepresentante);

    ComTipoRepresentante find(Object id);

    List<ComTipoRepresentante> findAll();

    List<ComTipoRepresentante> findRange(int[] range);

    int count();
    
}
