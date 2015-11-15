package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Mes;

@Local
public interface MesFacadeLocal {

    void create(Mes mes);

    void edit(Mes mes);

    void remove(Mes mes);

    Mes find(Object id);

    List<Mes> findAll();

    List<Mes> findRange(int[] range);

    int count();
    
}
