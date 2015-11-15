/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.SMeta;

/**
 *
 * @author Jorik
 */
@Local
public interface SMetaFacadeLocal {

    void create(SMeta sMeta);

    void edit(SMeta sMeta);

    void remove(SMeta sMeta);

    SMeta find(Object id);

    List<SMeta> findAll();

    List<SMeta> findRange(int[] range);

    int count();
    
}
