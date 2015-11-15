package org.pegasus.patrimonio.ejb;

import javax.ejb.Stateless;
import org.pegasus.patrimonio.jpa.ELocal;

@Stateless
public class LocalFacade extends org.jsuns.util.AbstractFacade<ELocal> implements LocalFacadeLocal{

}
