/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComStock;

/**
 *
 * @author Jorik
 */
@Local
public interface ComStockFacadeLocal {

    void create(ComStock comStock);

    void edit(ComStock comStock);

    void remove(ComStock comStock);

    ComStock find(Object id);

    List<ComStock> findAll();

    List<ComStock> findRange(int[] range);

    int count();
    
}
