/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscEstudio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscEstudioFacadeLocal {

    void create(EscEstudio escEstudio);

    void edit(EscEstudio escEstudio);

    void remove(EscEstudio escEstudio);

    EscEstudio find(Object id);

    List<EscEstudio> findAll();

    List<EscEstudio> findRange(int[] range);

    int count();
    
}
