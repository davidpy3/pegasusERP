/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.AlmacenDocumento;

/**
 *
 * @author Jorik
 */
@Local
public interface AlmacenDocumentoFacadeLocal {

    void create(AlmacenDocumento almacenDocumento);

    void edit(AlmacenDocumento almacenDocumento);

    void remove(AlmacenDocumento almacenDocumento);

    AlmacenDocumento find(Object id);

    List<AlmacenDocumento> findAll();

    List<AlmacenDocumento> findRange(int[] range);

    int count();
    
}
