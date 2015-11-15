package org.pegasus.patrimonio.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Pais;

@Local
public interface PaisFacadeLocal {

    void create(Pais pais);

    void edit(Pais pais);

    void remove(Pais pais);

    Pais find(Object id);

    List<Pais> findAll();

    List<Pais> findRange(int[] range);
    
    List<Pais> findRange(int first,int max);
    
    int count();
    
    public List load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
