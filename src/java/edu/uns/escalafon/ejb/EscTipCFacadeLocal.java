/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipC;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipCFacadeLocal {

    void create(EscTipC escTipC);

    void edit(EscTipC escTipC);

    void remove(EscTipC escTipC);

    EscTipC find(Object id);

    List<EscTipC> findAll();

    List<EscTipC> findRange(int[] range);

    int count();
    
}
