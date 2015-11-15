/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.TipoBien;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface TipoBienFacadeLocal {

    void create(TipoBien tipoBien);

    void edit(TipoBien tipoBien);

    void remove(TipoBien tipoBien);

    TipoBien find(Object id);

    List<TipoBien> findAll();

    List<TipoBien> findRange(int[] range);

    int count();
    
}
