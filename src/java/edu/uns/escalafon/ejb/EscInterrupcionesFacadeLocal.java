/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscInterrupciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscInterrupcionesFacadeLocal {

    void create(EscInterrupciones escInterrupciones);

    void edit(EscInterrupciones escInterrupciones);

    void remove(EscInterrupciones escInterrupciones);

    EscInterrupciones find(Object id);

    List<EscInterrupciones> findAll();

    List<EscInterrupciones> findRange(int[] range);

    int count();
    
}
