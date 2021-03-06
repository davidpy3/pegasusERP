/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscRotaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscRotacionesFacadeLocal {

    void create(EscRotaciones escRotaciones);

    void edit(EscRotaciones escRotaciones);

    void remove(EscRotaciones escRotaciones);

    EscRotaciones find(Object id);

    List<EscRotaciones> findAll();

    List<EscRotaciones> findRange(int[] range);

    int count();
    
}
