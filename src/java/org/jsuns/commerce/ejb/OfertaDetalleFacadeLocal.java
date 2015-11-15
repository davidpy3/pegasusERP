/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.OfertaDetalle;

/**
 *
 * @author Jorik
 */
@Local
public interface OfertaDetalleFacadeLocal {

    void create(OfertaDetalle ofertaDetalle);

    void edit(OfertaDetalle ofertaDetalle);

    void remove(OfertaDetalle ofertaDetalle);

    OfertaDetalle find(Object id);

    List<OfertaDetalle> findAll();

    List<OfertaDetalle> findRange(int[] range);

    int count();
    
}
