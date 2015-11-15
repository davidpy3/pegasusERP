package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.RegimenPensionario;

@Local
public interface RegimenPensionarioFacadeLocal {

    void create(RegimenPensionario regimenPensionario);

    void edit(RegimenPensionario regimenPensionario);

    void remove(RegimenPensionario regimenPensionario);

    RegimenPensionario find(Object id);

    List<RegimenPensionario> findAll();

    List<RegimenPensionario> findRange(int[] range);

    int count();
    
}
