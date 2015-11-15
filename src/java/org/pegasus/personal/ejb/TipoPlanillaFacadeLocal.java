package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.TipoPlanilla;

@Local
public interface TipoPlanillaFacadeLocal {

    void create(TipoPlanilla tipoPlanilla);

    void edit(TipoPlanilla tipoPlanilla);

    void remove(TipoPlanilla tipoPlanilla);

    TipoPlanilla find(Object id);

    List<TipoPlanilla> findAll();

    List<TipoPlanilla> findRange(int[] range);

    int count();
    
}
