/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.TrasladoArticulo;

/**
 *
 * @author Jorik
 */
@Local
public interface TrasladoArticuloFacadeLocal {

    void create(TrasladoArticulo trasladoArticulo);

    void edit(TrasladoArticulo trasladoArticulo);

    void remove(TrasladoArticulo trasladoArticulo);

    TrasladoArticulo find(Object id);

    List<TrasladoArticulo> findAll();

    List<TrasladoArticulo> findRange(int[] range);

    int count();
    
}
