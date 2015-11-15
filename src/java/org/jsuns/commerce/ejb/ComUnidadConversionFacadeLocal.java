/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComUnidadConversion;

/**
 *
 * @author Jorik
 */
@Local
public interface ComUnidadConversionFacadeLocal {

    void create(ComUnidadConversion comUnidadConversion);

    void edit(ComUnidadConversion comUnidadConversion);

    void remove(ComUnidadConversion comUnidadConversion);

    ComUnidadConversion find(Object id);

    List<ComUnidadConversion> findAll();

    List<ComUnidadConversion> findRange(int[] range);

    int count();
    
}
