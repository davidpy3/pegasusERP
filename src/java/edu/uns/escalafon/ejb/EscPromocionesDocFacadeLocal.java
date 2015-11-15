/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscPromocionesDoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscPromocionesDocFacadeLocal {

    void create(EscPromocionesDoc escPromocionesDoc);

    void edit(EscPromocionesDoc escPromocionesDoc);

    void remove(EscPromocionesDoc escPromocionesDoc);

    EscPromocionesDoc find(Object id);

    List<EscPromocionesDoc> findAll();

    List<EscPromocionesDoc> findRange(int[] range);

    int count();
    
}
