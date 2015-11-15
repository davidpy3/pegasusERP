package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.TipoTrabajador;

@Local
public interface TipoTrabajadorFacadeLocal {

    void create(TipoTrabajador tipoTrabajador);

    void edit(TipoTrabajador tipoTrabajador);

    void remove(TipoTrabajador tipoTrabajador);

    TipoTrabajador find(Object id);

    List<TipoTrabajador> findAll();

    List<TipoTrabajador> findRange(int[] range);

    int count();
    
}
