package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Concepto;

@Local
public interface ConceptoFacadeLocal {

    void create(Concepto concepto);

    void edit(Concepto concepto);

    void remove(Concepto concepto);

    Concepto find(Object id);

    List<Concepto> findAll();

    List<Concepto> findRange(int[] range);

    int count();
    
    public List load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
