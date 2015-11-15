/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFactor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFactorFacadeLocal {

    void create(SgcFactor sgcFactor);

    void edit(SgcFactor sgcFactor);

    void remove(SgcFactor sgcFactor);

    SgcFactor find(Object id);

    List<SgcFactor> findAll();

    List<SgcFactor> findRange(int[] range);

    int count();
    
}
