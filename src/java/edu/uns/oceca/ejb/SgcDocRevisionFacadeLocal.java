/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcDocRevision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcDocRevisionFacadeLocal {

    void create(SgcDocRevision sgcDocRevision);

    void edit(SgcDocRevision sgcDocRevision);

    void remove(SgcDocRevision sgcDocRevision);

    SgcDocRevision find(Object id);

    List<SgcDocRevision> findAll();

    List<SgcDocRevision> findRange(int[] range);

    int count();
    
}
