/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.sgsi.ejb;

import java.util.List;
import javax.ejb.Local;
import edu.uns.sgsi.jpa.GsiPrrbRestauracion;

/**
 *
 * @author Administrador
 */
@Local
public interface GsiPrrbRestauracionFacadeLocal {

    void create(GsiPrrbRestauracion gsiPrrbRestauracion);

    void edit(GsiPrrbRestauracion gsiPrrbRestauracion);

    void remove(GsiPrrbRestauracion gsiPrrbRestauracion);

    GsiPrrbRestauracion find(Object id);

    List<GsiPrrbRestauracion> findAll();

    List<GsiPrrbRestauracion> findRange(int[] range);

    int count();
    
}
