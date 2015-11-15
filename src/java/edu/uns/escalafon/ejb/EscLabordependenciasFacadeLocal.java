/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscLabordependencias;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscLabordependenciasFacadeLocal {

    void create(EscLabordependencias escLabordependencias);

    void edit(EscLabordependencias escLabordependencias);

    void remove(EscLabordependencias escLabordependencias);

    EscLabordependencias find(Object id);

    List<EscLabordependencias> findAll();

    List<EscLabordependencias> findRange(int[] range);

    int count();
    
}
