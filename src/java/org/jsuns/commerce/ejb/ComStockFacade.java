package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.ComStock;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComStockFacade extends AbstractFacade<ComStock> implements ComStockFacadeLocal {

}
