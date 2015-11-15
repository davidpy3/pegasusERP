/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComFuenteFinanciamiento;

/**
 *
 * @author Jorik
 */
@Local
public interface ComFuenteFinanciamientoFacadeLocal {

    void create(ComFuenteFinanciamiento comFuenteFinanciamiento);

    void edit(ComFuenteFinanciamiento comFuenteFinanciamiento);

    void remove(ComFuenteFinanciamiento comFuenteFinanciamiento);

    ComFuenteFinanciamiento find(Object id);

    List<ComFuenteFinanciamiento> findAll();

    List<ComFuenteFinanciamiento> findRange(int[] range);

    int count();
    
}
