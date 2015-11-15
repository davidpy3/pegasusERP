package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Unidad;

@Local
public interface UnidadFacadeLocal {

    void create(Unidad unidad);

    void edit(Unidad unidad);

    void remove(Unidad unidad);

    Unidad find(Object id);

    List<Unidad> findAll();

    List<Unidad> findRange(int[] range);

    int count();
    
}
