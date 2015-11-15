package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Cargo;

@Stateless
public class CargoFacade extends AbstractFacade<Cargo> implements CargoFacadeLocal {

}
