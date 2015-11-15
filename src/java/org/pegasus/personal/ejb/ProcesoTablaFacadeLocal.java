/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.ProcesoTabla;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ProcesoTablaFacadeLocal {

    void create(ProcesoTabla entidad);

    void edit(ProcesoTabla entidad);

    void remove(ProcesoTabla entidad);

    ProcesoTabla find(Object id);

    List<ProcesoTabla> findAll();

    List<ProcesoTabla> findRange(int first,int max);

    int count();
    
}
