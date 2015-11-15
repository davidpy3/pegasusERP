/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.carga_lectiva.ejb;

import edu.uns.oceda.carga_lectiva.jpa.CargaLectivaAsignatura;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface CargaLectivaAsignaturaFacadeLocal {

    void create(CargaLectivaAsignatura cargaLectivaAsignatura);

    void edit(CargaLectivaAsignatura cargaLectivaAsignatura);

    void remove(CargaLectivaAsignatura cargaLectivaAsignatura);

    CargaLectivaAsignatura find(Object id);

    List<CargaLectivaAsignatura> findAll();

    List<CargaLectivaAsignatura> findRange(int[] range);

    int count();
    
}
