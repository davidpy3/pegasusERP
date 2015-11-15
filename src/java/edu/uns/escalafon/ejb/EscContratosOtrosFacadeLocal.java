/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscContratosOtros;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscContratosOtrosFacadeLocal {

    void create(EscContratosOtros escContratosOtros);

    void edit(EscContratosOtros escContratosOtros);

    void remove(EscContratosOtros escContratosOtros);

    EscContratosOtros find(Object id);

    List<EscContratosOtros> findAll();

    List<EscContratosOtros> findRange(int[] range);

    int count();
    
}
