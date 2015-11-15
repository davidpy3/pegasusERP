/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAutoevaluacionEsp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcAutoevaluacionEspFacadeLocal {

    void create(SgcAutoevaluacionEsp sgcAutoevaluacionEsp);

    void edit(SgcAutoevaluacionEsp sgcAutoevaluacionEsp);

    void remove(SgcAutoevaluacionEsp sgcAutoevaluacionEsp);

    SgcAutoevaluacionEsp find(Object id);

    List<SgcAutoevaluacionEsp> findAll();

    List<SgcAutoevaluacionEsp> findRange(int[] range);

    int count();
    
}
