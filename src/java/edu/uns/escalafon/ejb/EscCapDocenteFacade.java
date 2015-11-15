/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCapDocente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.util.AbstractFacade;

/**
 *
 * @author Jorik
 */
@Stateless
public class EscCapDocenteFacade extends AbstractFacade<EscCapDocente> implements EscCapDocenteFacadeLocal {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EscCapDocenteFacade() {
        super(EscCapDocente.class);
    }
    
}
