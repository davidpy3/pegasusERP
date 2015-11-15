/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscDejuPersonaPeriodo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscDejuPersonaPeriodoFacadeLocal {

    void create(EscDejuPersonaPeriodo escDejuPersonaPeriodo);

    void edit(EscDejuPersonaPeriodo escDejuPersonaPeriodo);

    void remove(EscDejuPersonaPeriodo escDejuPersonaPeriodo);

    EscDejuPersonaPeriodo find(Object id);

    List<EscDejuPersonaPeriodo> findAll();

    List<EscDejuPersonaPeriodo> findRange(int[] range);

    int count();
    
}
