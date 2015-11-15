/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.ProgramaNombre;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface ProgramaNombreFacadeLocal {

    void create(ProgramaNombre programaNombre);

    void edit(ProgramaNombre programaNombre);

    void remove(ProgramaNombre programaNombre);

    ProgramaNombre find(Object id);

    List<ProgramaNombre> findAll();

    List<ProgramaNombre> findRange(int[] range);

    int count();
    
}
