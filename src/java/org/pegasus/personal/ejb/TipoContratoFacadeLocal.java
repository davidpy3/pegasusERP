package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.TipoContrato;

@Local
public interface TipoContratoFacadeLocal {

    void create(TipoContrato tipoContrato);

    void edit(TipoContrato tipoContrato);

    void remove(TipoContrato tipoContrato);

    TipoContrato find(Object id);

    List<TipoContrato> findAll();

    List<TipoContrato> findRange(int[] range);

    int count();
    
}
