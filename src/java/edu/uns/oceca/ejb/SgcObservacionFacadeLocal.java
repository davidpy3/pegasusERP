/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcObservacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcObservacionFacadeLocal {

    void create(SgcObservacion sgcObservacion);

    void edit(SgcObservacion sgcObservacion);

    void remove(SgcObservacion sgcObservacion);

    SgcObservacion find(Object id);

    List<SgcObservacion> findAll();

    List<SgcObservacion> findRange(int[] range);

    int count();
    
}
