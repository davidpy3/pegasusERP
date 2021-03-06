/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.Kardex;

/**
 *
 * @author Jorik
 */
@Local
public interface KardexFacadeLocal {

    void create(Kardex kardex);

    void edit(Kardex kardex);

    void remove(Kardex kardex);

    Kardex find(Object id);

    List<Kardex> findAll();

    List<Kardex> findRange(int[] range);

    int count();
    
}
