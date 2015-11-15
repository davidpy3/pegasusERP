/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComMoneda;

/**
 *
 * @author Jorik
 */
@Local
public interface ComMonedaFacadeLocal {

    void create(ComMoneda comMoneda);

    void edit(ComMoneda comMoneda);

    void remove(ComMoneda comMoneda);

    ComMoneda find(Object id);

    List<ComMoneda> findAll();

    List<ComMoneda> findRange(int[] range);

    int count();
    
}
