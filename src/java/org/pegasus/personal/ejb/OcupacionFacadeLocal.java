package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Ocupacion;

@Local
public interface OcupacionFacadeLocal {

    void create(Ocupacion ocupacion);

    void edit(Ocupacion ocupacion);

    void remove(Ocupacion ocupacion);

    Ocupacion find(Object id);

    List<Ocupacion> findAll();

    List<Ocupacion> findRange(int[] range);

    int count();
    
    public List<Ocupacion> load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
