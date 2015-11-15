/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.Adelanto;

/**
 *
 * @author Jorik
 */
@Local
public interface AdelantoFacadeLocal {

    void create(Adelanto adelanto);

    void edit(Adelanto adelanto);

    void remove(Adelanto adelanto);

    Adelanto find(Object id);

    List<Adelanto> findAll();

    List<Adelanto> findRange(int[] range);

    int count();
    
}
