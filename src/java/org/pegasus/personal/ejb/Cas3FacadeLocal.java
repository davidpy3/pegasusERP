package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Cas3;

@Local
public interface Cas3FacadeLocal {

    void create(Cas3 cas3);

    void edit(Cas3 cas3);

    void remove(Cas3 cas3);

    Cas3 find(Object id);

    List<Cas3> findAll();

    List<Cas3> findRange(int[] range);

    int count();
    
}
