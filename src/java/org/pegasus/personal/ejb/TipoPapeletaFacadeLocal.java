package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.TipoPapeleta;

@Local
public interface TipoPapeletaFacadeLocal {

    void create(TipoPapeleta tipoPapeleta);

    void edit(TipoPapeleta tipoPapeleta);

    void remove(TipoPapeleta tipoPapeleta);

    TipoPapeleta find(Object id);

    List<TipoPapeleta> findAll();

    List<TipoPapeleta> findRange(int[] range);

    int count();
    
}
