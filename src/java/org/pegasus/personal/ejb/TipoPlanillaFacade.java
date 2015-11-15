package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.TipoPlanilla;

@Stateless
public class TipoPlanillaFacade extends AbstractFacade<TipoPlanilla> implements TipoPlanillaFacadeLocal {

}
