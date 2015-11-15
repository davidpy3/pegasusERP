/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFuenteEstandar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuenteEstandarFacadeLocal {

    void create(SgcFuenteEstandar sgcFuenteEstandar);

    void edit(SgcFuenteEstandar sgcFuenteEstandar);

    void remove(SgcFuenteEstandar sgcFuenteEstandar);

    SgcFuenteEstandar find(Object id);

    List<SgcFuenteEstandar> findAll();

    List<SgcFuenteEstandar> findRange(int[] range);

    int count();
    
}
