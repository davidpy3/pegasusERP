/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsAmbitoAcad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsAmbitoAcadFacadeLocal {

    void create(ApsAmbitoAcad apsAmbitoAcad);

    void edit(ApsAmbitoAcad apsAmbitoAcad);

    void remove(ApsAmbitoAcad apsAmbitoAcad);

    ApsAmbitoAcad find(Object id);

    List<ApsAmbitoAcad> findAll();

    List<ApsAmbitoAcad> findRange(int[] range);

    int count();
    
}
