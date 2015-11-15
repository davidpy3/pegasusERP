/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTipoDocumento;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTipoDocumentoFacadeLocal {

    void create(ComTipoDocumento comTipoDocumento);

    void edit(ComTipoDocumento comTipoDocumento);

    void remove(ComTipoDocumento comTipoDocumento);

    ComTipoDocumento find(Object id);

    List<ComTipoDocumento> findAll();

    List<ComTipoDocumento> findRange(int[] range);

    int count();
    
}
