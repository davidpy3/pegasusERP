package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Marcacion;

@Local
public interface MarcacionFacadeLocal {

    void create(Marcacion marcacion);

    void edit(Marcacion marcacion);

    void remove(Marcacion marcacion);

    Marcacion find(Object id);

    List<Marcacion> findAll();

    List<Marcacion> findRange(int[] range);

    int count();
    
    public List<Marcacion> load(int first, int pageSize, String sortField, Map<String, Object> filters);
        
}
