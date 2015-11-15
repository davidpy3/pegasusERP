/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.JudicialObra;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface JudicialObraFacadeLocal {

    void create(JudicialObra almMovimiento);

    void edit(JudicialObra almMovimiento);

    void remove(JudicialObra almMovimiento);

    JudicialObra find(Object id);

    List<JudicialObra> findAll();

    List<JudicialObra> findRange(int[] range);

    int count();
    
}
