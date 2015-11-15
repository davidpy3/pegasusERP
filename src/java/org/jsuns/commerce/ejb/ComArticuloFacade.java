package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.ComArticulo;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComArticuloFacade extends AbstractFacade<ComArticulo> implements ComArticuloFacadeLocal {

}
