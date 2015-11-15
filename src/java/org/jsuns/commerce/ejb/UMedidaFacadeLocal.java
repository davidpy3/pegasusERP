/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.UMedida;

/**
 *
 * @author Jorik
 */
@Local
public interface UMedidaFacadeLocal {

    void create(UMedida uMedida);

    void edit(UMedida uMedida);

    void remove(UMedida uMedida);

    UMedida find(Object id);

    List<UMedida> findAll();

    List<UMedida> findRange(int[] range);

    int count();
    
}
