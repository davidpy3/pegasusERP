/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.PecosaDetalle;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface PecosaDetalleFacadeLocal {

    void create(PecosaDetalle pecosaDetalle);

    void edit(PecosaDetalle pecosaDetalle);

    void remove(PecosaDetalle pecosaDetalle);

    PecosaDetalle find(Object id);

    List<PecosaDetalle> findAll();

    List<PecosaDetalle> findRange(int[] range);

    int count();
    
}
