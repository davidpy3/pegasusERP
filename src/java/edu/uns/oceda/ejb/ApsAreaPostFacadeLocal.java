/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsAreaPost;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsAreaPostFacadeLocal {

    void create(ApsAreaPost apsAreaPost);

    void edit(ApsAreaPost apsAreaPost);

    void remove(ApsAreaPost apsAreaPost);

    ApsAreaPost find(Object id);

    List<ApsAreaPost> findAll();

    List<ApsAreaPost> findRange(int[] range);

    int count();
    
}
