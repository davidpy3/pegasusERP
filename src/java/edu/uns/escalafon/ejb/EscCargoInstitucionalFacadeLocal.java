/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscCargoInstitucional;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscCargoInstitucionalFacadeLocal {

    void create(EscCargoInstitucional escCargoInstitucional);

    void edit(EscCargoInstitucional escCargoInstitucional);

    void remove(EscCargoInstitucional escCargoInstitucional);

    EscCargoInstitucional find(Object id);

    List<EscCargoInstitucional> findAll();

    List<EscCargoInstitucional> findRange(int[] range);

    int count();
    
}
