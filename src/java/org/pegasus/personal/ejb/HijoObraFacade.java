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
import org.pegasus.personal.jpa.HijosObra;

/**
 *
 * @author TOSHIBA
 */
@Stateless
public class HijoObraFacade extends AbstractFacade<HijosObra> implements HijoObraFacadeLocal{
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HijoObraFacade() {
        super(HijosObra.class);
    }

    @Override
    public List<HijosObra> findRange(int first, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
