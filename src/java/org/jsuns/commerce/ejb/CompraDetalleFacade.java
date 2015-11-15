package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.commerce.jpa.CompraDetalle;
import org.jsuns.util.AbstractFacade;

@Stateless
public class CompraDetalleFacade extends AbstractFacade<CompraDetalle> implements CompraDetalleFacadeLocal {
    
}
