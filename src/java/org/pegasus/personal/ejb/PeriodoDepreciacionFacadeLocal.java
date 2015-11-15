/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.PeriodoDepreciacion;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface PeriodoDepreciacionFacadeLocal {

    void create(PeriodoDepreciacion personalDscto);

    void edit(PeriodoDepreciacion personalDscto);

    void remove(PeriodoDepreciacion personalDscto);

    PeriodoDepreciacion find(Object id);

    List<PeriodoDepreciacion> findAll();

    List<PeriodoDepreciacion> findRange(int[] range);
    
    

    int count();

    public Object[] find(int first, int pageSize, String dni);

    public void procesar(PeriodoDepreciacion selected);

    public void cerrar(PeriodoDepreciacion selected);
    
}
