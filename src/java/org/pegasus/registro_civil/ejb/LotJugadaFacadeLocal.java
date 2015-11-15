package org.pegasus.registro_civil.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.registro_civil.LotJugada;

@Local
public interface LotJugadaFacadeLocal {

    void create(LotJugada tipoVia);

    void edit(LotJugada tipoVia);

    void remove(LotJugada tipoVia);

    LotJugada find(Object id);

    List<LotJugada> findAll();

    List<LotJugada> findRange(int[] range);

    int count();
    
}
