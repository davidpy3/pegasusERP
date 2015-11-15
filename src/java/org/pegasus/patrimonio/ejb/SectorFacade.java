package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless ;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Sector;

@Stateless
public class SectorFacade extends AbstractFacade<Sector> implements SectorFacadeLocal{

}
