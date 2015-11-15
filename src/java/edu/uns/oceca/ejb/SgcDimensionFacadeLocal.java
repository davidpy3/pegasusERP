/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcDimension;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcDimensionFacadeLocal {

    void create(SgcDimension sgcDimension);

    void edit(SgcDimension sgcDimension);

    void remove(SgcDimension sgcDimension);

    SgcDimension find(Object id);

    List<SgcDimension> findAll();

    List<SgcDimension> findRange(int[] range);

    int count();
    
}
