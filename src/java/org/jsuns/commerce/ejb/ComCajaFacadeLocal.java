/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComCaja;

/**
 *
 * @author Jorik
 */
@Local
public interface ComCajaFacadeLocal {

    void create(ComCaja comCaja);

    void edit(ComCaja comCaja);

    void remove(ComCaja comCaja);

    ComCaja find(Object id);

    List<ComCaja> findAll();

    List<ComCaja> findRange(int[] range);

    int count();
    
}
