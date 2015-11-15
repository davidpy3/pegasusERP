/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComPlan;

/**
 *
 * @author Jorik
 */
@Local
public interface ComPlanFacadeLocal {

    void create(ComPlan comPlan);

    void edit(ComPlan comPlan);

    void remove(ComPlan comPlan);

    ComPlan find(Object id);

    List<ComPlan> findAll();

    List<ComPlan> findRange(int[] range);

    int count();
    
}
