/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCapFacadeLocal {

    void create(EscCap escCap);

    void edit(EscCap escCap);

    void remove(EscCap escCap);

    EscCap find(Object id);

    List<EscCap> findAll();

    List<EscCap> findRange(int[] range);

    int count();
    
}
