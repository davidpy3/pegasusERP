/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.RequerimientoDet;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface RequerimientoDetFacadeLocal {

    void create(RequerimientoDet requerimientoDet);

    void edit(RequerimientoDet requerimientoDet);

    void remove(RequerimientoDet requerimientoDet);

    RequerimientoDet find(Object id);

    List<RequerimientoDet> findAll();

    List<RequerimientoDet> findRange(int[] range);

    int count();
    
}
