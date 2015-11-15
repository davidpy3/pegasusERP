/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsEscuela;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsEscuelaFacadeLocal {

    void create(ApsEscuela apsEscuela);

    void edit(ApsEscuela apsEscuela);

    void remove(ApsEscuela apsEscuela);

    ApsEscuela find(Object id);

    List<ApsEscuela> findAll();

    List<ApsEscuela> findRange(int[] range);

    int count();
    
}
