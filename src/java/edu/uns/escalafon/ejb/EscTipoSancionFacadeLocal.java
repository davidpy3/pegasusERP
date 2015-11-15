/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoSancion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoSancionFacadeLocal {

    void create(EscTipoSancion escTipoSancion);

    void edit(EscTipoSancion escTipoSancion);

    void remove(EscTipoSancion escTipoSancion);

    EscTipoSancion find(Object id);

    List<EscTipoSancion> findAll();

    List<EscTipoSancion> findRange(int[] range);

    int count();
    
}
