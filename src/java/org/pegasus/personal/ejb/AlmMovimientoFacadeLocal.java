/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.AlmMovimiento;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface AlmMovimientoFacadeLocal {

    void create(AlmMovimiento almMovimiento);

    void edit(AlmMovimiento almMovimiento);

    void remove(AlmMovimiento almMovimiento);

    AlmMovimiento find(Object id);

    List<AlmMovimiento> findAll();

    List<AlmMovimiento> findRange(int[] range);

    int count();
    
}
