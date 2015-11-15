/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCategoriaFacadeLocal {

    void create(EscCategoria escCategoria);

    void edit(EscCategoria escCategoria);

    void remove(EscCategoria escCategoria);

    EscCategoria find(Object id);

    List<EscCategoria> findAll();

    List<EscCategoria> findRange(int[] range);

    int count();
    
}
