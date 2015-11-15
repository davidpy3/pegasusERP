package edu.uns.ocid.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.ocid.DrtDirectorio;

@Local
public interface DrtDirectorioFacadeLocal {

    void create(DrtDirectorio drtDirectorio);

    void edit(DrtDirectorio drtDirectorio);

    void remove(DrtDirectorio drtDirectorio);

    DrtDirectorio find(Object id);

    List<DrtDirectorio> findAll();

    List<DrtDirectorio> findRange(int[] range);

    int count();
    
}
