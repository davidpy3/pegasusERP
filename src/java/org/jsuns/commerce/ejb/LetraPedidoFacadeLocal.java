/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.LetraPedido;

/**
 *
 * @author Jorik
 */
@Local
public interface LetraPedidoFacadeLocal {

    void create(LetraPedido letraPedido);

    void edit(LetraPedido letraPedido);

    void remove(LetraPedido letraPedido);

    LetraPedido find(Object id);

    List<LetraPedido> findAll();

    List<LetraPedido> findRange(int[] range);

    int count();
    
}
