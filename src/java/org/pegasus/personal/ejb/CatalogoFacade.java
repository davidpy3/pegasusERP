/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pegasus.patrimonio.jpa.Catalogo;
import org.pegasus.personal.jpa.Concepto;

/**
 *
 * @author TOSHIBA
 */
@Stateless
public class CatalogoFacade extends AbstractFacade<Catalogo> implements CatalogoFacadeLocal{
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatalogoFacade() {
        super(Catalogo.class);
    }

   

    
}
