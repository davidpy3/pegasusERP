/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsAreaElear;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsAreaElearFacadeLocal {

    void create(ApsAreaElear apsAreaElear);

    void edit(ApsAreaElear apsAreaElear);

    void remove(ApsAreaElear apsAreaElear);

    ApsAreaElear find(Object id);

    List<ApsAreaElear> findAll();

    List<ApsAreaElear> findRange(int[] range);

    int count();
    
}
