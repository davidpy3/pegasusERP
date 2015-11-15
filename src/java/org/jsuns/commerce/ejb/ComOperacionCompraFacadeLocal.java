/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComOperacionCompra;

/**
 *
 * @author Jorik
 */
@Local
public interface ComOperacionCompraFacadeLocal {

    void create(ComOperacionCompra comOperacionCompra);

    void edit(ComOperacionCompra comOperacionCompra);

    void remove(ComOperacionCompra comOperacionCompra);

    ComOperacionCompra find(Object id);

    List<ComOperacionCompra> findAll();

    List<ComOperacionCompra> findRange(int[] range);

    int count();
    
}
