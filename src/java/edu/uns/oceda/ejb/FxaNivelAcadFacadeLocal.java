/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.FxaNivelAcad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface FxaNivelAcadFacadeLocal {

    void create(FxaNivelAcad fxaNivelAcad);

    void edit(FxaNivelAcad fxaNivelAcad);

    void remove(FxaNivelAcad fxaNivelAcad);

    FxaNivelAcad find(Object id);

    List<FxaNivelAcad> findAll();

    List<FxaNivelAcad> findRange(int[] range);

    int count();
    
}
