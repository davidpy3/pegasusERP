/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizRespuesta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaRespuestaFacadeLocal {

    void create(QuizRespuesta svaRespuesta);

    void edit(QuizRespuesta svaRespuesta);

    void remove(QuizRespuesta svaRespuesta);

    QuizRespuesta find(Object id);

    List<QuizRespuesta> findAll();

    List<QuizRespuesta> findRange(int[] range);

    int count();
    
}
