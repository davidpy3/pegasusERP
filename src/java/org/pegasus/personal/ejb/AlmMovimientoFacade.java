/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pegasus.patrimonio.jpa.AlmMovimiento;

/**
 *
 * @author TOSHIBA
 */
@Stateless
public class AlmMovimientoFacade extends AbstractFacade<AlmMovimiento> implements AlmMovimientoFacadeLocal {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlmMovimientoFacade() {
        super(AlmMovimiento.class);
    }
    
}
