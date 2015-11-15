/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Afectaciones;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface AfectacionesFacadeLocal {

    void create(Afectaciones almMovimiento);

    void edit(Afectaciones almMovimiento);

    void remove(Afectaciones almMovimiento);

    Afectaciones find(Object id);

    List<Afectaciones> findAll();

    List<Afectaciones> findRange(int[] range);

    int count();
    
}
