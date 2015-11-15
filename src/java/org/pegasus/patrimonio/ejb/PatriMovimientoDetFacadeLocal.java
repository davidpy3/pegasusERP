package org.pegasus.patrimonio.ejb;

import java.util.List;
import org.pegasus.patrimonio.jpa.PatriMovimientoDet;

public interface PatriMovimientoDetFacadeLocal {

    void create(PatriMovimientoDet pais);

    void edit(PatriMovimientoDet pais);

    void remove(PatriMovimientoDet pais);

    PatriMovimientoDet find(Object id);

    List<PatriMovimientoDet> findAll();

    List<PatriMovimientoDet> findRange(int[] range);

    List<PatriMovimientoDet> findRange(int first, int max);

    int count();
}
