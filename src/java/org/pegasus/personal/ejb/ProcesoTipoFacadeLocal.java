/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.ProcesoTipo;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ProcesoTipoFacadeLocal {

    void create(ProcesoTipo pais);

    void edit(ProcesoTipo pais);

    void remove(ProcesoTipo pais);

    ProcesoTipo find(Object id);

    List<ProcesoTipo> findAll();

    List<ProcesoTipo> findRange(int[] range);
    
    List<ProcesoTipo> findRange(int first,int max);
    
    int count();
    
}
