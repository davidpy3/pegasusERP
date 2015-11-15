/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoFalta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoFaltaFacadeLocal {

    void create(EscTipoFalta escTipoFalta);

    void edit(EscTipoFalta escTipoFalta);

    void remove(EscTipoFalta escTipoFalta);

    EscTipoFalta find(Object id);

    List<EscTipoFalta> findAll();

    List<EscTipoFalta> findRange(int[] range);

    int count();
    
}
