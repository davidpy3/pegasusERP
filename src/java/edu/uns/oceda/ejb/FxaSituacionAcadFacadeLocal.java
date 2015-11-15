/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.FxaSituacionAcad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface FxaSituacionAcadFacadeLocal {

    void create(FxaSituacionAcad fxaSituacionAcad);

    void edit(FxaSituacionAcad fxaSituacionAcad);

    void remove(FxaSituacionAcad fxaSituacionAcad);

    FxaSituacionAcad find(Object id);

    List<FxaSituacionAcad> findAll();

    List<FxaSituacionAcad> findRange(int[] range);

    int count();
    
}
