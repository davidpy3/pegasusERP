/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.TipoVia;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface TipoViaFacadeLocal {

    void create(TipoVia tipoVia);

    void edit(TipoVia tipoVia);

    void remove(TipoVia tipoVia);

    TipoVia find(Object id);

    List<TipoVia> findAll();

    List<TipoVia> findRange(int[] range);

    int count();
    
}
