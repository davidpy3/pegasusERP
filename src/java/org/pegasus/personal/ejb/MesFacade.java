package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Mes;

@Stateless
public class MesFacade extends AbstractFacade<Mes> implements MesFacadeLocal {

}
