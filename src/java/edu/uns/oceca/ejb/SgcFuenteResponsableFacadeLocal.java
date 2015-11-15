/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFuenteResponsable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuenteResponsableFacadeLocal {

    void create(SgcFuenteResponsable sgcFuenteResponsable);

    void edit(SgcFuenteResponsable sgcFuenteResponsable);

    void remove(SgcFuenteResponsable sgcFuenteResponsable);

    SgcFuenteResponsable find(Object id);

    List<SgcFuenteResponsable> findAll();

    List<SgcFuenteResponsable> findRange(int[] range);

    int count();
    
}
