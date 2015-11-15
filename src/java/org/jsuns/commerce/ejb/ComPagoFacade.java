package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.ComPago;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComPagoFacade extends AbstractFacade<ComPago> implements ComPagoFacadeLocal {

}
