/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.carga_lectiva.ejb;

import edu.uns.oceda.carga_lectiva.jpa.CargaLectiva;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface CargaLectivaFacadeLocal {

    void create(CargaLectiva cargaLectiva);

    void edit(CargaLectiva cargaLectiva);

    void remove(CargaLectiva cargaLectiva);

    CargaLectiva find(Object id);

    List<CargaLectiva> findAll();

    List<CargaLectiva> findRange(int[] range);

    int count();
    
}
