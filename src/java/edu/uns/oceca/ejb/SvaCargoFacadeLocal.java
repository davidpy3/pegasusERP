/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SvaCargo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SvaCargoFacadeLocal {

    void create(SvaCargo svaCargo);

    void edit(SvaCargo svaCargo);

    void remove(SvaCargo svaCargo);

    SvaCargo find(Object id);

    List<SvaCargo> findAll();

    List<SvaCargo> findRange(int[] range);

    int count();
    
}
