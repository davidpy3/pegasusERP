/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscServicios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscServiciosFacadeLocal {

    void create(EscServicios escServicios);

    void edit(EscServicios escServicios);

    void remove(EscServicios escServicios);

    EscServicios find(Object id);

    List<EscServicios> findAll();

    List<EscServicios> findRange(int[] range);

    int count();
    
}
