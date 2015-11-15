/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscDejuDeclaracion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscDejuDeclaracionFacadeLocal {

    void create(EscDejuDeclaracion escDejuDeclaracion);

    void edit(EscDejuDeclaracion escDejuDeclaracion);

    void remove(EscDejuDeclaracion escDejuDeclaracion);

    EscDejuDeclaracion find(Object id);

    List<EscDejuDeclaracion> findAll();

    List<EscDejuDeclaracion> findRange(int[] range);

    int count();
    
}
