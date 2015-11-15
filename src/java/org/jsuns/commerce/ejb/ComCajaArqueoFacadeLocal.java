/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComCajaArqueo;

/**
 *
 * @author Jorik
 */
@Local
public interface ComCajaArqueoFacadeLocal {

    void create(ComCajaArqueo comCajaArqueo);

    void edit(ComCajaArqueo comCajaArqueo);

    void remove(ComCajaArqueo comCajaArqueo);

    ComCajaArqueo find(Object id);

    List<ComCajaArqueo> findAll();

    List<ComCajaArqueo> findRange(int[] range);

    int count();
    
}
