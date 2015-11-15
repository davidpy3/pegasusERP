/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscReposiciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscReposicionesFacadeLocal {

    void create(EscReposiciones escReposiciones);

    void edit(EscReposiciones escReposiciones);

    void remove(EscReposiciones escReposiciones);

    EscReposiciones find(Object id);

    List<EscReposiciones> findAll();

    List<EscReposiciones> findRange(int[] range);

    int count();
    
}
