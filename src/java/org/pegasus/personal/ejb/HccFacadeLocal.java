package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Hcc;

@Local
public interface HccFacadeLocal {

    void create(Hcc hcc);

    void edit(Hcc hcc);

    void remove(Hcc hcc);

    Hcc find(Object id);

    List<Hcc> findAll();

    List<Hcc> findRange(int[] range);

    int count();
    
}
