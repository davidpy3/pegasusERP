/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComModoPago;

/**
 *
 * @author Jorik
 */
@Local
public interface ComModoPagoFacadeLocal {

    void create(ComModoPago comModoPago);

    void edit(ComModoPago comModoPago);

    void remove(ComModoPago comModoPago);

    ComModoPago find(Object id);

    List<ComModoPago> findAll();

    List<ComModoPago> findRange(int[] range);

    int count();
    
}
