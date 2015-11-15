package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless ;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Ambiente;

@Stateless
public class AmbienteFacade extends AbstractFacade<Ambiente> implements AmbienteFacadeLocal{

}
