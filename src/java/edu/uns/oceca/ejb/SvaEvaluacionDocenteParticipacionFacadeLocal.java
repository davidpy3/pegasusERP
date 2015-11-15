/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaEvaluacionDocenteParticipacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaEvaluacionDocenteParticipacionFacadeLocal {

    void create(SvaEvaluacionDocenteParticipacion svaEvaluacionDocenteParticipacion);

    void edit(SvaEvaluacionDocenteParticipacion svaEvaluacionDocenteParticipacion);

    void remove(SvaEvaluacionDocenteParticipacion svaEvaluacionDocenteParticipacion);

    SvaEvaluacionDocenteParticipacion find(Object id);

    List<SvaEvaluacionDocenteParticipacion> findAll();

    List<SvaEvaluacionDocenteParticipacion> findRange(int[] range);

    int count();
    
}
