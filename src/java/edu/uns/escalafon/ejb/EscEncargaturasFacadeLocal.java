/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscEncargaturas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscEncargaturasFacadeLocal {

    void create(EscEncargaturas escEncargaturas);

    void edit(EscEncargaturas escEncargaturas);

    void remove(EscEncargaturas escEncargaturas);

    EscEncargaturas find(Object id);

    List<EscEncargaturas> findAll();

    List<EscEncargaturas> findRange(int[] range);

    int count();
    
}
