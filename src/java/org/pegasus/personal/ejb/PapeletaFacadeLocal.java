/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Papeleta;

/**
 *
 * @author Jorik
 */
@Local
public interface PapeletaFacadeLocal {

    public class PapeletaPendienteException extends RuntimeException{}
   
    void create(Papeleta papeleta);

    void edit(Papeleta papeleta);

    void remove(Papeleta papeleta);

    Papeleta find(Object id);

    List<Papeleta> findAll();

    List<Papeleta> findRange(int[] range);

    int count();
    
}
