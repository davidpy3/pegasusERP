package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.TurnosVigilantes;

@Local
public interface TurnosVigilantesFacadeLocal {

    void create(TurnosVigilantes turnosVigilantes);

    void edit(TurnosVigilantes turnosVigilantes);

    void remove(TurnosVigilantes turnosVigilantes);

    TurnosVigilantes find(Object id);

    List<TurnosVigilantes> findAll();

    List<TurnosVigilantes> findRange(int[] range);

    int count();
    
}
