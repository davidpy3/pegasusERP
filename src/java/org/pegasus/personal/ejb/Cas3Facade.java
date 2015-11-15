package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Cas3;

@Stateless
public class Cas3Facade extends AbstractFacade<Cas3> implements Cas3FacadeLocal {

}
