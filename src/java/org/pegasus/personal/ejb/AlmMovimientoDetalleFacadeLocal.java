/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.AlmMovimientoDetalle;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface AlmMovimientoDetalleFacadeLocal {

    void create(AlmMovimientoDetalle almMovimientoDetalle);

    void edit(AlmMovimientoDetalle almMovimientoDetalle);

    void remove(AlmMovimientoDetalle almMovimientoDetalle);

    AlmMovimientoDetalle find(Object id);

    List<AlmMovimientoDetalle> findAll();

    List<AlmMovimientoDetalle> findRange(int[] range);

    int count();
    
}
