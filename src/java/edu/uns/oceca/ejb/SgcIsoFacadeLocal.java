/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcIso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcIsoFacadeLocal {

    void create(SgcIso sgcIso);

    void edit(SgcIso sgcIso);

    void remove(SgcIso sgcIso);

    SgcIso find(Object id);

    List<SgcIso> findAll();

    List<SgcIso> findRange(int[] range);

    int count();
    
}
