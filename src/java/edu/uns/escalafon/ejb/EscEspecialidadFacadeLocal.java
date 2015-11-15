/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscEspecialidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscEspecialidadFacadeLocal {

    void create(EscEspecialidad escEspecialidad);

    void edit(EscEspecialidad escEspecialidad);

    void remove(EscEspecialidad escEspecialidad);

    EscEspecialidad find(Object id);

    List<EscEspecialidad> findAll();

    List<EscEspecialidad> findRange(int[] range);

    int count();
    
}
