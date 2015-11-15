/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComVendedor;

/**
 *
 * @author Jorik
 */
@Local
public interface ComVendedorFacadeLocal {

    void create(ComVendedor comVendedor);

    void edit(ComVendedor comVendedor);

    void remove(ComVendedor comVendedor);

    ComVendedor find(Object id);

    List<ComVendedor> findAll();

    List<ComVendedor> findRange(int[] range);

    int count();
    
}
