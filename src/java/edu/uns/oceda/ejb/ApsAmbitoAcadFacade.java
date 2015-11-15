/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsAmbitoAcad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.util.AbstractFacade;

/**
 *
 * @author Jorik
 */
@Stateless
public class ApsAmbitoAcadFacade extends AbstractFacade<ApsAmbitoAcad> implements ApsAmbitoAcadFacadeLocal {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApsAmbitoAcadFacade() {
        super(ApsAmbitoAcad.class);
    }
    
}
