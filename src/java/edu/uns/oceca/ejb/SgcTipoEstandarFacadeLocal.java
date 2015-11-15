/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcTipoEstandar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcTipoEstandarFacadeLocal {

    void create(SgcTipoEstandar sgcTipoEstandar);

    void edit(SgcTipoEstandar sgcTipoEstandar);

    void remove(SgcTipoEstandar sgcTipoEstandar);

    SgcTipoEstandar find(Object id);

    List<SgcTipoEstandar> findAll();

    List<SgcTipoEstandar> findRange(int[] range);

    int count();
    
}
