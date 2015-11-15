package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.HccDetalle;

@Local
public interface HccDetalleFacadeLocal {

    void create(HccDetalle hccDetalle);

    void edit(HccDetalle hccDetalle);

    void remove(HccDetalle hccDetalle);

    HccDetalle find(Object id);

    List<HccDetalle> findAll();

    List<HccDetalle> findRange(int[] range);

    int count();
    
}
