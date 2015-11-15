package org.jsuns.commerce.ejb;

import javax.ejb.Stateless;
import org.jsuns.commerce.jpa.Clasificacion;
import org.jsuns.util.AbstractFacade;

@Stateless
public class ClasificacionFacade extends AbstractFacade<Clasificacion> implements ClasificacionFacadeLocal {

}
