/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.PatriMovimientoDet;

/**
 *
 * @author Jorik
 */
@Stateless
public class PatriMovimientoDetFacade extends AbstractFacade<PatriMovimientoDet> {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PatriMovimientoDetFacade() {
        super(PatriMovimientoDet.class);
    }
    
}
