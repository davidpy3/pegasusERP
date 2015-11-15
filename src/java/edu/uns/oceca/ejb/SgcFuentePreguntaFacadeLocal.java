/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFuentePregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuentePreguntaFacadeLocal {

    void create(SgcFuentePregunta sgcFuentePregunta);

    void edit(SgcFuentePregunta sgcFuentePregunta);

    void remove(SgcFuentePregunta sgcFuentePregunta);

    SgcFuentePregunta find(Object id);

    List<SgcFuentePregunta> findAll();

    List<SgcFuentePregunta> findRange(int[] range);

    int count();
    
}
