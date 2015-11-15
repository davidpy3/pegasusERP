package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.OrdenDet;

@Stateless
public class OrdenDetFacade extends AbstractFacade<OrdenDet> implements OrdenDetFacadeLocal{

}
