package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.Kardex;
import org.jsuns.util.AbstractFacade;

@Stateless
public class KardexFacade extends AbstractFacade<Kardex> implements KardexFacadeLocal {

}
