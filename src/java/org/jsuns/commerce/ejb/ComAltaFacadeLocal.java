/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComAlta;

/**
 *
 * @author Jorik
 */
@Local
public interface ComAltaFacadeLocal {

    void create(ComAlta comAlta);

    void edit(ComAlta comAlta);

    void remove(ComAlta comAlta);

    ComAlta find(Object id);

    List<ComAlta> findAll();

    List<ComAlta> findRange(int[] range);

    int count();
    
}
