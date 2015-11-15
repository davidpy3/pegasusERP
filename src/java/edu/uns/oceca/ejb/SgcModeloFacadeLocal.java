/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcModelo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcModeloFacadeLocal {

    void create(SgcModelo sgcModelo);

    void edit(SgcModelo sgcModelo);

    void remove(SgcModelo sgcModelo);

    SgcModelo find(Object id);

    List<SgcModelo> findAll();

    List<SgcModelo> findRange(int[] range);

    int count();
    
}
