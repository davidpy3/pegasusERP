package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.CompraPago;
import org.jsuns.util.AbstractFacade;

@Stateless
public class CompraPagoFacade extends AbstractFacade<CompraPago> implements CompraPagoFacadeLocal {

}
