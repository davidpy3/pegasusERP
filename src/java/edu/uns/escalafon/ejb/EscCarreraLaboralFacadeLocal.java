/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCarreraLaboral;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCarreraLaboralFacadeLocal {

    void create(EscCarreraLaboral escCarreraLaboral);

    void edit(EscCarreraLaboral escCarreraLaboral);

    void remove(EscCarreraLaboral escCarreraLaboral);

    EscCarreraLaboral find(Object id);

    List<EscCarreraLaboral> findAll();

    List<EscCarreraLaboral> findRange(int[] range);

    int count();
    
}
