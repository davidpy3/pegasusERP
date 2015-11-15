package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Estante;

@Local
public interface EstanteFacadeLocal {

    void create(Estante entidad);

    void edit(Estante entidad);

    void remove(Estante entidad);

    Estante find(Object id);

    List<Estante> findAll();

    List<Estante> findRange(int first,int max);

    int count();
    
}
