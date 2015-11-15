/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscFinCarreraLaboral;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscFinCarreraLaboralFacadeLocal {

    void create(EscFinCarreraLaboral escFinCarreraLaboral);

    void edit(EscFinCarreraLaboral escFinCarreraLaboral);

    void remove(EscFinCarreraLaboral escFinCarreraLaboral);

    EscFinCarreraLaboral find(Object id);

    List<EscFinCarreraLaboral> findAll();

    List<EscFinCarreraLaboral> findRange(int[] range);

    int count();
    
}
