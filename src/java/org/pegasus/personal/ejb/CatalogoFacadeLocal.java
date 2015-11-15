/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import org.pegasus.patrimonio.jpa.Catalogo;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface CatalogoFacadeLocal {

    void create(Catalogo concepto);

    void edit(Catalogo concepto);

    void remove(Catalogo concepto);

    Catalogo find(Object id);

    List<Catalogo> findAll();

    List<Catalogo> findRange(int[] range);

    int count();
    
}
