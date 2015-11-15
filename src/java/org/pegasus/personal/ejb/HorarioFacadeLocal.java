package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Horario;

@Local
public interface HorarioFacadeLocal {

    void create(Horario horario);

    void edit(Horario horario);

    void remove(Horario horario);

    Horario find(Object id);

    List<Horario> findAll();

    List<Horario> findRange(int[] range);

    int count();
    
}
