package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.NivelEducativo;

@Stateless
public class NivelEducativoFacade extends AbstractFacade<NivelEducativo> implements NivelEducativoFacadeLocal {

}
