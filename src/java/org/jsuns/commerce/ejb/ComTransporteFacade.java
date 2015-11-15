package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.commerce.jpa.ComTransporte;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComTransporteFacade extends AbstractFacade<ComTransporte> implements ComTransporteFacadeLocal {
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComTransporteFacade() {
        super(ComTransporte.class);
    }
    
}
