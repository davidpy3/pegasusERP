/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscContratos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscContratosFacadeLocal {

    void create(EscContratos escContratos);

    void edit(EscContratos escContratos);

    void remove(EscContratos escContratos);

    EscContratos find(Object id);

    List<EscContratos> findAll();

    List<EscContratos> findRange(int[] range);

    int count();
    
}
