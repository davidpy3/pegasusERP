/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Oficina;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface OficinaFacadeLocal {

    void create(Oficina oficina);

    void edit(Oficina oficina);

    void remove(Oficina oficina);

    Oficina find(Object id);

    List<Oficina> findAll();

    List<Oficina> findRange(int first,int max);

    int count();
    
}
