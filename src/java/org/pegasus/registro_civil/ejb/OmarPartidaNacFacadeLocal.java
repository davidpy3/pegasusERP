/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.registro_civil.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.registro_civil.OmarPartidaNac;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface OmarPartidaNacFacadeLocal {

    void create(OmarPartidaNac tipoVia);

    void edit(OmarPartidaNac tipoVia);

    void remove(OmarPartidaNac tipoVia);

    OmarPartidaNac find(Object id);

    List<OmarPartidaNac> findAll();

    List<OmarPartidaNac> findRange(int[] range);

    int count();
    
}
