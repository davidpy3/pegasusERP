/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.CompraDetalle;

/**
 *
 * @author Jorik
 */
@Local
public interface CompraDetalleFacadeLocal {

    void create(CompraDetalle compraDetalle);

    void edit(CompraDetalle compraDetalle);

    void remove(CompraDetalle compraDetalle);

    CompraDetalle find(Object id);

    List<CompraDetalle> findAll();

    List<CompraDetalle> findRange(int[] range);

    int count();
    
}
