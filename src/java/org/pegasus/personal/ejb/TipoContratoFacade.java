package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.TipoContrato;

@Stateless
public class TipoContratoFacade extends AbstractFacade<TipoContrato> implements TipoContratoFacadeLocal {

}
