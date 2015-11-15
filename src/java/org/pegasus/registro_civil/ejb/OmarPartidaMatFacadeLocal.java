/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.registro_civil.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.registro_civil.OmarPartidaMat;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface OmarPartidaMatFacadeLocal {

    void create(OmarPartidaMat tipoVia);

    void edit(OmarPartidaMat tipoVia);

    void remove(OmarPartidaMat tipoVia);

    OmarPartidaMat find(Object id);

    List<OmarPartidaMat> findAll();

    List<OmarPartidaMat> findRange(int[] range);

    int count();
    
}
