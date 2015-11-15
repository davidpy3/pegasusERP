/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComPago;

/**
 *
 * @author Jorik
 */
@Local
public interface ComPagoFacadeLocal {

    void create(ComPago comPago);

    void edit(ComPago comPago);

    void remove(ComPago comPago);

    ComPago find(Object id);

    List<ComPago> findAll();

    List<ComPago> findRange(int[] range);

    int count();
    
}
