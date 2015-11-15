/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.registro_civil.ejb;

import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pegasus.registro_civil.LotJugada;

/**
 *
 * @author TOSHIBA
 */
@Stateless
public class LotJugadaFacade extends AbstractFacade<LotJugada> implements LotJugadaFacadeLocal{
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LotJugadaFacade() {
        super(LotJugada.class);
    }
    
}
