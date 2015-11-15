/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOrdenServicio;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOrdenServicioFacadeLocal {

    void create(ComOrdenServicio comOrdenServicio);

    void edit(ComOrdenServicio comOrdenServicio);

    void remove(ComOrdenServicio comOrdenServicio);

    ComOrdenServicio find(Object id);

    List<ComOrdenServicio> findAll();

    List<ComOrdenServicio> findRange(int[] range);

    int count();
    
}
