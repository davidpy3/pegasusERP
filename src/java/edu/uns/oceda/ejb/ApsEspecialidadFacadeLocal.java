/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsEspecialidadFacadeLocal {

    void create(ApsEspecialidad apsEspecialidad);

    void edit(ApsEspecialidad apsEspecialidad);

    void remove(ApsEspecialidad apsEspecialidad);

    ApsEspecialidad find(Object id);

    List<ApsEspecialidad> findAll();

    List<ApsEspecialidad> findRange(int[] range);

    int count();
    
}
