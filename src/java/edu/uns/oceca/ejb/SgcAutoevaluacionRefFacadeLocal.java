/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAutoevaluacionRef;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcAutoevaluacionRefFacadeLocal {

    void create(SgcAutoevaluacionRef sgcAutoevaluacionRef);

    void edit(SgcAutoevaluacionRef sgcAutoevaluacionRef);

    void remove(SgcAutoevaluacionRef sgcAutoevaluacionRef);

    SgcAutoevaluacionRef find(Object id);

    List<SgcAutoevaluacionRef> findAll();

    List<SgcAutoevaluacionRef> findRange(int[] range);

    int count();
    
}
