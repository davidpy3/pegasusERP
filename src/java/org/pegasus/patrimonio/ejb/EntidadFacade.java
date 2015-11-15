package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Entidad;

@Stateless
public class EntidadFacade extends AbstractFacade<Entidad> implements EntidadFacadeLocal{

}
