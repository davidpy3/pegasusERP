package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.Movimiento;
import org.jsuns.util.AbstractFacade;

@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> implements MovimientoFacadeLocal {

}
