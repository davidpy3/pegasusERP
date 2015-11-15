/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcCriterio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcCriterioFacadeLocal {

    void create(SgcCriterio sgcCriterio);

    void edit(SgcCriterio sgcCriterio);

    void remove(SgcCriterio sgcCriterio);

    SgcCriterio find(Object id);

    List<SgcCriterio> findAll();

    List<SgcCriterio> findRange(int[] range);

    int count();
    
}
