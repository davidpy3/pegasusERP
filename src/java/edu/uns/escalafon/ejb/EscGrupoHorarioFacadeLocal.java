/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscGrupoHorario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscGrupoHorarioFacadeLocal {

    void create(EscGrupoHorario escGrupoHorario);

    void edit(EscGrupoHorario escGrupoHorario);

    void remove(EscGrupoHorario escGrupoHorario);

    EscGrupoHorario find(Object id);

    List<EscGrupoHorario> findAll();

    List<EscGrupoHorario> findRange(int[] range);

    int count();
    
}
