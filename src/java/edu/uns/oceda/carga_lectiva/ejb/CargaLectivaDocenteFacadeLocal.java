/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.carga_lectiva.ejb;

import edu.uns.oceda.carga_lectiva.jpa.CargaLectivaDocente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface CargaLectivaDocenteFacadeLocal {

    void create(CargaLectivaDocente cargaLectivaDocente);

    void edit(CargaLectivaDocente cargaLectivaDocente);

    void remove(CargaLectivaDocente cargaLectivaDocente);

    CargaLectivaDocente find(Object id);

    List<CargaLectivaDocente> findAll();

    List<CargaLectivaDocente> findRange(int[] range);

    int count();
    
}
