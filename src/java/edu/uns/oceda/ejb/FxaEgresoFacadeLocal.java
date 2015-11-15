/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.FxaEgreso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface FxaEgresoFacadeLocal {

    void create(FxaEgreso fxaEgreso);

    void edit(FxaEgreso fxaEgreso);

    void remove(FxaEgreso fxaEgreso);

    FxaEgreso find(Object id);

    List<FxaEgreso> findAll();

    List<FxaEgreso> findRange(int[] range);

    int count();
    
}
