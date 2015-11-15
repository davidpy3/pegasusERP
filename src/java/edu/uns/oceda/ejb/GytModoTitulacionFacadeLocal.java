/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.GytModoTitulacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface GytModoTitulacionFacadeLocal {

    void create(GytModoTitulacion gytModoTitulacion);

    void edit(GytModoTitulacion gytModoTitulacion);

    void remove(GytModoTitulacion gytModoTitulacion);

    GytModoTitulacion find(Object id);

    List<GytModoTitulacion> findAll();

    List<GytModoTitulacion> findRange(int[] range);

    int count();
    
}
