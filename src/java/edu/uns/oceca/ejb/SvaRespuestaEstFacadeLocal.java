/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaRespuestaEst;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaRespuestaEstFacadeLocal {

    void create(SvaRespuestaEst svaRespuestaEst);

    void edit(SvaRespuestaEst svaRespuestaEst);

    void remove(SvaRespuestaEst svaRespuestaEst);

    SvaRespuestaEst find(Object id);

    List<SvaRespuestaEst> findAll();

    List<SvaRespuestaEst> findRange(int[] range);

    int count();
    
}
