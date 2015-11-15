/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcStandard;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcStandardFacadeLocal {

    void create(SgcStandard sgcStandard);

    void edit(SgcStandard sgcStandard);

    void remove(SgcStandard sgcStandard);

    SgcStandard find(Object id);

    List<SgcStandard> findAll();

    List<SgcStandard> findRange(int[] range);

    int count();
    
}
