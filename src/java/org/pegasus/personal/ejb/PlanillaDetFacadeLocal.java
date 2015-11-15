/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.PlanillaDet;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface PlanillaDetFacadeLocal {

    void create(PlanillaDet planillaDet);

    void edit(PlanillaDet planillaDet);

    void remove(PlanillaDet planillaDet);

    PlanillaDet find(Object id);

    List<PlanillaDet> findAll();

    List<PlanillaDet> findRange(int[] range);

    int count();
    
}
