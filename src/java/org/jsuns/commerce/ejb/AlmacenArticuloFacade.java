/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.commerce.jpa.AlmacenArticulo;
import org.jsuns.util.AbstractFacade;

/**
 *
 * @author Jorik
 */
@Stateless
public class AlmacenArticuloFacade extends AbstractFacade<AlmacenArticulo> implements AlmacenArticuloFacadeLocal {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlmacenArticuloFacade() {
        super(AlmacenArticulo.class);
    }
    
}
