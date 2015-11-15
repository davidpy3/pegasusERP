/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscPersHorario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscPersHorarioFacadeLocal {

    void create(EscPersHorario escPersHorario);

    void edit(EscPersHorario escPersHorario);

    void remove(EscPersHorario escPersHorario);

    EscPersHorario find(Object id);

    List<EscPersHorario> findAll();

    List<EscPersHorario> findRange(int[] range);

    int count();
    
}
