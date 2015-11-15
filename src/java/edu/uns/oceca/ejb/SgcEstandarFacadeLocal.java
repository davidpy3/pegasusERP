/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcEstandar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcEstandarFacadeLocal {

    void create(SgcEstandar sgcEstandar);

    void edit(SgcEstandar sgcEstandar);

    void remove(SgcEstandar sgcEstandar);

    SgcEstandar find(Object id);

    List<SgcEstandar> findAll();

    List<SgcEstandar> findRange(int[] range);

    int count();
    
}
