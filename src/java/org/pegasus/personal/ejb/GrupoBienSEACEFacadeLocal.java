package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.GrupoBienSEACE;

@Local
public interface GrupoBienSEACEFacadeLocal {

    void create(GrupoBienSEACE entidad);

    void edit(GrupoBienSEACE entidad);

    void remove(GrupoBienSEACE entidad);

    GrupoBienSEACE find(Object id);

    List<GrupoBienSEACE> findAll();

    List<GrupoBienSEACE> findRange(int first,int max);

    int count();
    
}
