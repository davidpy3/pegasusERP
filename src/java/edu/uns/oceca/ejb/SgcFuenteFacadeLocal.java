/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFuente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuenteFacadeLocal {

    void create(SgcFuente sgcFuente);

    void edit(SgcFuente sgcFuente);

    void remove(SgcFuente sgcFuente);

    SgcFuente find(Object id);

    List<SgcFuente> findAll();

    List<SgcFuente> findRange(int[] range);

    int count();
    
}
