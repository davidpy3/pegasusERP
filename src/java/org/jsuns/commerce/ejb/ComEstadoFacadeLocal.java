/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComEstado;

/**
 *
 * @author Jorik
 */
@Local
public interface ComEstadoFacadeLocal {

    void create(ComEstado comEstado);

    void edit(ComEstado comEstado);

    void remove(ComEstado comEstado);

    ComEstado find(Object id);

    List<ComEstado> findAll();

    List<ComEstado> findRange(int[] range);

    int count();
    
}
