/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscMateria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscMateriaFacadeLocal {

    void create(EscMateria escMateria);

    void edit(EscMateria escMateria);

    void remove(EscMateria escMateria);

    EscMateria find(Object id);

    List<EscMateria> findAll();

    List<EscMateria> findRange(int[] range);

    int count();
    
}
