/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoPromocion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoPromocionFacadeLocal {

    void create(EscTipoPromocion escTipoPromocion);

    void edit(EscTipoPromocion escTipoPromocion);

    void remove(EscTipoPromocion escTipoPromocion);

    EscTipoPromocion find(Object id);

    List<EscTipoPromocion> findAll();

    List<EscTipoPromocion> findRange(int[] range);

    int count();
    
}
