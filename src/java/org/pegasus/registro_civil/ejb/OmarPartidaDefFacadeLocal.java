/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.registro_civil.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.registro_civil.OmarPartidaDef;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface OmarPartidaDefFacadeLocal {

    void create(OmarPartidaDef tipoVia);

    void edit(OmarPartidaDef tipoVia);

    void remove(OmarPartidaDef tipoVia);

    OmarPartidaDef find(Object id);

    List<OmarPartidaDef> findAll();

    List<OmarPartidaDef> findRange(int[] range);

    int count();
    
}
