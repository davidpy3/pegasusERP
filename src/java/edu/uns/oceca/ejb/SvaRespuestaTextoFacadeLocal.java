/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaRespuestaTexto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaRespuestaTextoFacadeLocal {

    void create(SvaRespuestaTexto svaRespuestaTexto);

    void edit(SvaRespuestaTexto svaRespuestaTexto);

    void remove(SvaRespuestaTexto svaRespuestaTexto);

    SvaRespuestaTexto find(Object id);

    List<SvaRespuestaTexto> findAll();

    List<SvaRespuestaTexto> findRange(int[] range);

    int count();
    
}
