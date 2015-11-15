/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.commerce.jpa.AdelantoEmpleado;

/**
 *
 * @author Jorik
 */
@Local
public interface AdelantoEmpleadoFacadeLocal {

    void create(AdelantoEmpleado adelantoEmpleado);

    void edit(AdelantoEmpleado adelantoEmpleado);

    void remove(AdelantoEmpleado adelantoEmpleado);

    AdelantoEmpleado find(Object id);

    List<AdelantoEmpleado> findAll();

    List<AdelantoEmpleado> findRange(int[] range);

    int count();
    
}
