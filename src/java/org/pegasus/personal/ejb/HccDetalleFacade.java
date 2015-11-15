package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.HccDetalle;

@Stateless
public class HccDetalleFacade extends AbstractFacade<HccDetalle> implements HccDetalleFacadeLocal {

}
