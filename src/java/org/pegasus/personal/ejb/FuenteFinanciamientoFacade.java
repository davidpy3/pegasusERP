/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pegasus.patrimonio.jpa.FuenteFinanc;

/**
 *
 * @author TOSHIBA
 */
@Stateless
public class FuenteFinanciamientoFacade extends AbstractFacade<FuenteFinanc> implements FuenteFinanciamientoFacadeLocal{
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuenteFinanciamientoFacade() {
        super(FuenteFinanc.class);
    }

    @Override
    public List<FuenteFinanc> findRange(int first, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
