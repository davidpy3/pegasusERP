/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscSuscdiploma;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscSuscdiplomaFacadeLocal {

    void create(EscSuscdiploma escSuscdiploma);

    void edit(EscSuscdiploma escSuscdiploma);

    void remove(EscSuscdiploma escSuscdiploma);

    EscSuscdiploma find(Object id);

    List<EscSuscdiploma> findAll();

    List<EscSuscdiploma> findRange(int[] range);

    int count();
    
}
