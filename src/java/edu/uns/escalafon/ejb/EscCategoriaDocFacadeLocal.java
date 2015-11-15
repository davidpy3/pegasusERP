/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCategoriaDoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCategoriaDocFacadeLocal {

    void create(EscCategoriaDoc escCategoriaDoc);

    void edit(EscCategoriaDoc escCategoriaDoc);

    void remove(EscCategoriaDoc escCategoriaDoc);

    EscCategoriaDoc find(Object id);

    List<EscCategoriaDoc> findAll();

    List<EscCategoriaDoc> findRange(int[] range);

    int count();
    
}
