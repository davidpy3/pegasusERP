/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.ocid.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.ocid.DrtPersonaNatural;

/**
 *
 * @author Jorik
 */
@Local
public interface DrtPersonaNaturalFacadeLocal {

    void create(DrtPersonaNatural drtPersonaNatural);

    void edit(DrtPersonaNatural drtPersonaNatural);

    void remove(DrtPersonaNatural drtPersonaNatural);

    DrtPersonaNatural find(Object id);

    List<DrtPersonaNatural> findAll();

    List<DrtPersonaNatural> findRange(int[] range);

    int count();
    
}
