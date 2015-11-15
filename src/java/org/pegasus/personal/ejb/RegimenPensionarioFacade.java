package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.RegimenPensionario;

@Stateless
public class RegimenPensionarioFacade extends AbstractFacade<RegimenPensionario> implements RegimenPensionarioFacadeLocal {

}
