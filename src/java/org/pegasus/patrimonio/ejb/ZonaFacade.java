package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Zona;

@Stateless
public class ZonaFacade extends AbstractFacade<Zona> implements ZonaFacadeLocal {

}
