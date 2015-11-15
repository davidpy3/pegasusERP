/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Cuentac;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface CuentacFacadeLocal {

    void create(Cuentac entidad);

    void edit(Cuentac entidad);

    void remove(Cuentac entidad);

    Cuentac find(Object id);

    List<Cuentac> findAll();

    List<Cuentac> findRange(int first,int max);

    int count();
    
}
