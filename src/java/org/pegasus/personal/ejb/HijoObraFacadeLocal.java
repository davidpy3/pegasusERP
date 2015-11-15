/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.HijosObra;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface HijoObraFacadeLocal {

    void create(HijosObra entidad);

    void edit(HijosObra entidad);

    void remove(HijosObra entidad);

    HijosObra find(Object id);

    List<HijosObra> findAll();

    List<HijosObra> findRange(int first,int max);

    int count();
    
}
