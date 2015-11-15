/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.Oferta;

/**
 *
 * @author Jorik
 */
@Local
public interface OfertaFacadeLocal {

    void create(Oferta oferta);

    void edit(Oferta oferta);

    void remove(Oferta oferta);

    Oferta find(Object id);

    List<Oferta> findAll();

    List<Oferta> findRange(int[] range);

    int count();
    
}
