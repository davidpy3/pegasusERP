/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizFuentePregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuentePreguntaFacadeLocal {

    void create(QuizFuentePregunta sgcFuentePregunta);

    void edit(QuizFuentePregunta sgcFuentePregunta);

    void remove(QuizFuentePregunta sgcFuentePregunta);

    QuizFuentePregunta find(Object id);

    List<QuizFuentePregunta> findAll();

    List<QuizFuentePregunta> findRange(int[] range);

    int count();
    
}
