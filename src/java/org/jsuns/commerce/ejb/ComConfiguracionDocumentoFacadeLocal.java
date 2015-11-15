/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComConfiguracionDocumento;

/**
 *
 * @author Jorik
 */
@Local
public interface ComConfiguracionDocumentoFacadeLocal {

    void create(ComConfiguracionDocumento comConfiguracionDocumento);

    void edit(ComConfiguracionDocumento comConfiguracionDocumento);

    void remove(ComConfiguracionDocumento comConfiguracionDocumento);

    ComConfiguracionDocumento find(Object id);

    List<ComConfiguracionDocumento> findAll();

    List<ComConfiguracionDocumento> findRange(int[] range);

    int count();
    
}
