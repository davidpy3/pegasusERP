package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;

import org.pegasus.patrimonio.jpa.Estante;

@Stateless
public class EstanteFacade extends AbstractFacade<Estante> implements EstanteFacadeLocal{

}
