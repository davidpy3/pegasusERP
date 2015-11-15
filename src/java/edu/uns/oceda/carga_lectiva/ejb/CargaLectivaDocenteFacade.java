/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.carga_lectiva.ejb;

import edu.uns.oceda.carga_lectiva.jpa.CargaLectivaDocente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.util.AbstractFacade;

/**
 *
 * @author Jorik
 */
@Stateless
public class CargaLectivaDocenteFacade extends AbstractFacade<CargaLectivaDocente> implements CargaLectivaDocenteFacadeLocal{

}
