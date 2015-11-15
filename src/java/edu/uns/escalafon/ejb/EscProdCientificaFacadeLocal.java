/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscProdCientifica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscProdCientificaFacadeLocal {

    void create(EscProdCientifica escProdCientifica);

    void edit(EscProdCientifica escProdCientifica);

    void remove(EscProdCientifica escProdCientifica);

    EscProdCientifica find(Object id);

    List<EscProdCientifica> findAll();

    List<EscProdCientifica> findRange(int[] range);

    int count();
    
}
