package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.ComOperacion;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComOperacionFacade extends AbstractFacade<ComOperacion> implements ComOperacionFacadeLocal {

}
