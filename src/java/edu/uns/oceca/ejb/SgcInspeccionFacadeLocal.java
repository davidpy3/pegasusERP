/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcInspeccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcInspeccionFacadeLocal {

    void create(SgcInspeccion sgcInspeccion);

    void edit(SgcInspeccion sgcInspeccion);

    void remove(SgcInspeccion sgcInspeccion);

    SgcInspeccion find(Object id);

    List<SgcInspeccion> findAll();

    List<SgcInspeccion> findRange(int[] range);

    int count();
    
}
