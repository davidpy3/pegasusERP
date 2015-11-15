/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComTipoTransporte;

/**
 *
 * @author Jorik
 */
@Local
public interface ComTipoTransporteFacadeLocal {

    void create(ComTipoTransporte comTipoTransporte);

    void edit(ComTipoTransporte comTipoTransporte);

    void remove(ComTipoTransporte comTipoTransporte);

    ComTipoTransporte find(Object id);

    List<ComTipoTransporte> findAll();

    List<ComTipoTransporte> findRange(int[] range);

    int count();
    
}
