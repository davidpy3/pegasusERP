/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.ComCajaArqueoDetalle;

/**
 *
 * @author Jorik
 */
@Local
public interface ComCajaArqueoDetalleFacadeLocal {

    void create(ComCajaArqueoDetalle comCajaArqueoDetalle);

    void edit(ComCajaArqueoDetalle comCajaArqueoDetalle);

    void remove(ComCajaArqueoDetalle comCajaArqueoDetalle);

    ComCajaArqueoDetalle find(Object id);

    List<ComCajaArqueoDetalle> findAll();

    List<ComCajaArqueoDetalle> findRange(int[] range);

    int count();
    
}
