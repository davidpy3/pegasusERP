/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.TurnosVigilantes;

@Stateless
public class TurnosVigilantesFacade extends AbstractFacade<TurnosVigilantes> implements TurnosVigilantesFacadeLocal {

}
