/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAutoevaluacionPlan;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcAutoevaluacionPlanFacadeLocal {

    void create(SgcAutoevaluacionPlan sgcAutoevaluacionPlan);

    void edit(SgcAutoevaluacionPlan sgcAutoevaluacionPlan);

    void remove(SgcAutoevaluacionPlan sgcAutoevaluacionPlan);

    SgcAutoevaluacionPlan find(Object id);

    List<SgcAutoevaluacionPlan> findAll();

    List<SgcAutoevaluacionPlan> findRange(int[] range);

    int count();
    
}
