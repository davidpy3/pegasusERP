/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscPromociones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscPromocionesFacadeLocal {

    void create(EscPromociones escPromociones);

    void edit(EscPromociones escPromociones);

    void remove(EscPromociones escPromociones);

    EscPromociones find(Object id);

    List<EscPromociones> findAll();

    List<EscPromociones> findRange(int[] range);

    int count();
    
}
