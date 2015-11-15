/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTransporte;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTransporteFacadeLocal {

    void create(ComTransporte comTransporte);

    void edit(ComTransporte comTransporte);

    void remove(ComTransporte comTransporte);

    ComTransporte find(Object id);

    List<ComTransporte> findAll();

    List<ComTransporte> findRange(int[] range);

    int count();
    
}
