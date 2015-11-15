/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCondicionCap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCondicionCapFacadeLocal {

    void create(EscCondicionCap escCondicionCap);

    void edit(EscCondicionCap escCondicionCap);

    void remove(EscCondicionCap escCondicionCap);

    EscCondicionCap find(Object id);

    List<EscCondicionCap> findAll();

    List<EscCondicionCap> findRange(int[] range);

    int count();
    
}
