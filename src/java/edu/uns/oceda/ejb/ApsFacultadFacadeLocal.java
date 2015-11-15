/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsFacultad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsFacultadFacadeLocal {

    void create(ApsFacultad apsFacultad);

    void edit(ApsFacultad apsFacultad);

    void remove(ApsFacultad apsFacultad);

    ApsFacultad find(Object id);

    List<ApsFacultad> findAll();

    List<ApsFacultad> findRange(int[] range);

    int count();
    
}
