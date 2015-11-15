/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcFuenteTexto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcFuenteTextoFacadeLocal {

    void create(SgcFuenteTexto sgcFuenteTexto);

    void edit(SgcFuenteTexto sgcFuenteTexto);

    void remove(SgcFuenteTexto sgcFuenteTexto);

    SgcFuenteTexto find(Object id);

    List<SgcFuenteTexto> findAll();

    List<SgcFuenteTexto> findRange(int[] range);

    int count();
    
}
