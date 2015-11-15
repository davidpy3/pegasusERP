/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.SRequerimiento;

/**
 *
 * @author Jorik
 */
@Local
public interface SRequerimientoFacadeLocal {

    void create(SRequerimiento sRequerimiento);

    void edit(SRequerimiento sRequerimiento);

    void remove(SRequerimiento sRequerimiento);

    SRequerimiento find(Object id);

    List<SRequerimiento> findAll();

    List<SRequerimiento> findRange(int[] range);

    int count();
    
}
