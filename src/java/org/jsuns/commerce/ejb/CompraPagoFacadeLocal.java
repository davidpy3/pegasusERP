/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.CompraPago;

/**
 *
 * @author Jorik
 */
@Local
public interface CompraPagoFacadeLocal {

    void create(CompraPago compraPago);

    void edit(CompraPago compraPago);

    void remove(CompraPago compraPago);

    CompraPago find(Object id);

    List<CompraPago> findAll();

    List<CompraPago> findRange(int[] range);

    int count();
    
}
