/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscContratosDoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscContratosDocFacadeLocal {

    void create(EscContratosDoc escContratosDoc);

    void edit(EscContratosDoc escContratosDoc);

    void remove(EscContratosDoc escContratosDoc);

    EscContratosDoc find(Object id);

    List<EscContratosDoc> findAll();

    List<EscContratosDoc> findRange(int[] range);

    int count();
    
}
