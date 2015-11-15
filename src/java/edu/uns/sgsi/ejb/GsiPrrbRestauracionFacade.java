/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.sgsi.ejb;

import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.uns.sgsi.jpa.GsiPrrbRestauracion;

/**
 *
 * @author Administrador
 */
@Stateless
public class GsiPrrbRestauracionFacade extends AbstractFacade<GsiPrrbRestauracion> implements GsiPrrbRestauracionFacadeLocal {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GsiPrrbRestauracionFacade() {
        super(GsiPrrbRestauracion.class);
    }
    
}