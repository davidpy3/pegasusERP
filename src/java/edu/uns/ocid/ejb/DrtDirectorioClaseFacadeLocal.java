/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.ocid.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.ocid.DrtDirectorioClase;

/**
 *
 * @author Jorik
 */
@Local
public interface DrtDirectorioClaseFacadeLocal {

    void create(DrtDirectorioClase drtDirectorioClase);

    void edit(DrtDirectorioClase drtDirectorioClase);

    void remove(DrtDirectorioClase drtDirectorioClase);

    DrtDirectorioClase find(Object id);

    List<DrtDirectorioClase> findAll();

    List<DrtDirectorioClase> findRange(int[] range);

    int count();
    
}
