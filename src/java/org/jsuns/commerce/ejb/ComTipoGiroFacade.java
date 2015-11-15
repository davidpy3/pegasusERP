package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.commerce.jpa.ComTipoGiro;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComTipoGiroFacade extends AbstractFacade<ComTipoGiro> implements ComTipoGiroFacadeLocal {

}
