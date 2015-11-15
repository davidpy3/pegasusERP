/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoMeritos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoMeritosFacadeLocal {

    void create(EscTipoMeritos escTipoMeritos);

    void edit(EscTipoMeritos escTipoMeritos);

    void remove(EscTipoMeritos escTipoMeritos);

    EscTipoMeritos find(Object id);

    List<EscTipoMeritos> findAll();

    List<EscTipoMeritos> findRange(int[] range);

    int count();
    
}
