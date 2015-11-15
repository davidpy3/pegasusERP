/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcEstado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcEstadoFacadeLocal {

    void create(SgcEstado sgcEstado);

    void edit(SgcEstado sgcEstado);

    void remove(SgcEstado sgcEstado);

    SgcEstado find(Object id);

    List<SgcEstado> findAll();

    List<SgcEstado> findRange(int[] range);

    int count();
    
}
