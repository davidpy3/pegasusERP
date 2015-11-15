package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.Pago;
import org.jsuns.util.AbstractFacade;

@Stateless
public class PagoFacade extends AbstractFacade<Pago> implements PagoFacadeLocal {

}
