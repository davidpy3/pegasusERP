/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscNombramientosDoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscNombramientosDocFacadeLocal {

    void create(EscNombramientosDoc escNombramientosDoc);

    void edit(EscNombramientosDoc escNombramientosDoc);

    void remove(EscNombramientosDoc escNombramientosDoc);

    EscNombramientosDoc find(Object id);

    List<EscNombramientosDoc> findAll();

    List<EscNombramientosDoc> findRange(int[] range);

    int count();
    
}
