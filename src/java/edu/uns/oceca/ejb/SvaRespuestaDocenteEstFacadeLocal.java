/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaRespuestaDocenteEst;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaRespuestaDocenteEstFacadeLocal {

    void create(SvaRespuestaDocenteEst svaRespuestaDocenteEst);

    void edit(SvaRespuestaDocenteEst svaRespuestaDocenteEst);

    void remove(SvaRespuestaDocenteEst svaRespuestaDocenteEst);

    SvaRespuestaDocenteEst find(Object id);

    List<SvaRespuestaDocenteEst> findAll();

    List<SvaRespuestaDocenteEst> findRange(int[] range);

    int count();
    
}
