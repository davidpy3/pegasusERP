/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaRespuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaRespuestaFacadeLocal {

    void create(SvaRespuesta svaRespuesta);

    void edit(SvaRespuesta svaRespuesta);

    void remove(SvaRespuesta svaRespuesta);

    SvaRespuesta find(Object id);

    List<SvaRespuesta> findAll();

    List<SvaRespuesta> findRange(int[] range);

    int count();
    
}
