package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscMovmodalidad;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EscMovmodalidadFacadeLocal {

    void create(EscMovmodalidad escMovmodalidad);

    void edit(EscMovmodalidad escMovmodalidad);

    void remove(EscMovmodalidad escMovmodalidad);

    EscMovmodalidad find(Object id);

    List<EscMovmodalidad> findAll();

    List<EscMovmodalidad> findRange(int[] range);

    int count();
    
}
