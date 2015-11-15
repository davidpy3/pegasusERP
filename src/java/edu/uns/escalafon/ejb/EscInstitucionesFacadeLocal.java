/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscInstituciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscInstitucionesFacadeLocal {

    void create(EscInstituciones escInstituciones);

    void edit(EscInstituciones escInstituciones);

    void remove(EscInstituciones escInstituciones);

    EscInstituciones find(Object id);

    List<EscInstituciones> findAll();

    List<EscInstituciones> findRange(int[] range);

    int count();
    
}
