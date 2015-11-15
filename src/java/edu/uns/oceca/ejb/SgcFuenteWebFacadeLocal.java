/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFuenteWeb;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuenteWebFacadeLocal {

    void create(SgcFuenteWeb sgcFuenteWeb);

    void edit(SgcFuenteWeb sgcFuenteWeb);

    void remove(SgcFuenteWeb sgcFuenteWeb);

    SgcFuenteWeb find(Object id);

    List<SgcFuenteWeb> findAll();

    List<SgcFuenteWeb> findRange(int[] range);

    int count();
    
}
