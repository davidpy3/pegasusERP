package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Sector;

@Local
public interface SectorFacadeLocal {

    void create(Sector tipoBien);

    void edit(Sector tipoBien);

    void remove(Sector tipoBien);

    Sector find(Object id);

    List<Sector> findAll();

    int count();
    
}
