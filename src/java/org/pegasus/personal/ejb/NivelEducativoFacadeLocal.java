package org.pegasus.personal.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.NivelEducativo;

@Local
public interface NivelEducativoFacadeLocal {

    void create(NivelEducativo nivelEducativo);

    void edit(NivelEducativo nivelEducativo);

    void remove(NivelEducativo nivelEducativo);

    NivelEducativo find(Object id);

    List<NivelEducativo> findAll();

    List<NivelEducativo> findRange(int[] range);

    int count();
    
}
