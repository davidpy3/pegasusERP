package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.commerce.jpa.ComVendedor;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComVendedorFacade extends AbstractFacade<ComVendedor> implements ComVendedorFacadeLocal {

}
