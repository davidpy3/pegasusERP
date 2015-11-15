package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.ComOrdenServicio;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ComOrdenServicioFacade extends AbstractFacade<ComOrdenServicio> implements ComOrdenServicioFacadeLocal {

}
