/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Grupo;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface GrupoFacadeLocal {

    void create(Grupo entidad);

    void edit(Grupo entidad);

    void remove(Grupo entidad);

    Grupo find(Object id);

    List<Grupo> findAll();

    List<Grupo> findRange(int first,int max);

    int count();
    
}
