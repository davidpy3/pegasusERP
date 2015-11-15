/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscDejuPeriodo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscDejuPeriodoFacadeLocal {

    void create(EscDejuPeriodo escDejuPeriodo);

    void edit(EscDejuPeriodo escDejuPeriodo);

    void remove(EscDejuPeriodo escDejuPeriodo);

    EscDejuPeriodo find(Object id);

    List<EscDejuPeriodo> findAll();

    List<EscDejuPeriodo> findRange(int[] range);

    int count();
    
}
