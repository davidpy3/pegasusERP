package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pegasus.patrimonio.jpa.GrupoBienSEACE;

@Stateless
public class GrupoBienSEACEFacade extends AbstractFacade<GrupoBienSEACE> implements GrupoBienSEACEFacadeLocal{
    
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoBienSEACEFacade() {
        super(GrupoBienSEACE.class);
    }

    @Override
    public List<GrupoBienSEACE> findRange(int first, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
