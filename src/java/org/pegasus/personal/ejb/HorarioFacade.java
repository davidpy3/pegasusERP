package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Horario;

@Stateless
public class HorarioFacade extends AbstractFacade<Horario> implements HorarioFacadeLocal {

}
