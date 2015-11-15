package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Hcc;

@Stateless
public class HccFacade extends AbstractFacade<Hcc> implements HccFacadeLocal {

}
