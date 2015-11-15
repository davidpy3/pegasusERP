/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Valorizacion;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ValorizacionFacadeLocal {

    void create(Valorizacion zona);

    void edit(Valorizacion zona);

    void remove(Valorizacion zona);

    Valorizacion find(Object id);

    List<Valorizacion> findAll();

    List<Valorizacion> findRange(int first,int max);

    int count();
    
}
