package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscMeritos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscMeritosFacadeLocal {

    void create(EscMeritos escMeritos);

    void edit(EscMeritos escMeritos);

    void remove(EscMeritos escMeritos);

    EscMeritos find(Object id);

    List<EscMeritos> findAll();

    List<EscMeritos> findRange(int[] range);

    int count();
    
}
