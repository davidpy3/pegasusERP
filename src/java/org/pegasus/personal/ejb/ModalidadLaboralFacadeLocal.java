/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.ModalidadLaboral;

/**
 *
 * @author Jorik
 */
@Local
public interface ModalidadLaboralFacadeLocal {

    void create(ModalidadLaboral modalidadLaboral);

    void edit(ModalidadLaboral modalidadLaboral);

    void remove(ModalidadLaboral modalidadLaboral);

    ModalidadLaboral find(Object id);

    List<ModalidadLaboral> findAll();

    List<ModalidadLaboral> findRange(int[] range);

    int count();
    
}
