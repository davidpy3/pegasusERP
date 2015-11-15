/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoFinCarreraLab;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoFinCarreraLabFacadeLocal {

    void create(EscTipoFinCarreraLab escTipoFinCarreraLab);

    void edit(EscTipoFinCarreraLab escTipoFinCarreraLab);

    void remove(EscTipoFinCarreraLab escTipoFinCarreraLab);

    EscTipoFinCarreraLab find(Object id);

    List<EscTipoFinCarreraLab> findAll();

    List<EscTipoFinCarreraLab> findRange(int[] range);

    int count();
    
}
