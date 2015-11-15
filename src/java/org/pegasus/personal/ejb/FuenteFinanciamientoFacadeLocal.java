/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.FuenteFinanc;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface FuenteFinanciamientoFacadeLocal {

    void create(FuenteFinanc entidad);

    void edit(FuenteFinanc entidad);

    void remove(FuenteFinanc entidad);

    FuenteFinanc find(Object id);

    List<FuenteFinanc> findAll();

    List<FuenteFinanc> findRange(int first,int max);

    int count();
    
}
