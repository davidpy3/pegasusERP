/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscEstadoTrabajador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscEstadoTrabajadorFacadeLocal {

    void create(EscEstadoTrabajador escEstadoTrabajador);

    void edit(EscEstadoTrabajador escEstadoTrabajador);

    void remove(EscEstadoTrabajador escEstadoTrabajador);

    EscEstadoTrabajador find(Object id);

    List<EscEstadoTrabajador> findAll();

    List<EscEstadoTrabajador> findRange(int[] range);

    int count();
    
}
