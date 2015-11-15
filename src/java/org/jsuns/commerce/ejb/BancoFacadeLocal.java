/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.Banco;

/**
 *
 * @author Jorik
 */
@Local
public interface BancoFacadeLocal {

    void create(Banco banco);

    void edit(Banco banco);

    void remove(Banco banco);

    Banco find(Object id);

    List<Banco> findAll();

    List<Banco> findRange(int[] range);

    int count();
    
}
