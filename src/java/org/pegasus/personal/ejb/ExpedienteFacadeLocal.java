/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Expediente;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ExpedienteFacadeLocal {

    void create(Expediente entidad);

    void edit(Expediente entidad);

    void remove(Expediente entidad);

    Expediente find(Object id);

    List<Expediente> findAll();

    List<Expediente> findRange(int first,int max);

    int count();
    
}
