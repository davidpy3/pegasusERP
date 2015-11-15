package org.pegasus.patrimonio.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.PatriMovimiento;

@Local
public interface PatriMovimientoFacadeLocal {
    
    void create(PatriMovimiento pais);

    void edit(PatriMovimiento pais);

    void remove(PatriMovimiento pais);

    PatriMovimiento find(Object id);

    List<PatriMovimiento> findAll();

    List<PatriMovimiento> findRange(int[] range);
    
    List<PatriMovimiento> findRange(int first,int max);
    
    int count();

    public void autorizar(PatriMovimiento m);

    public void anular(PatriMovimiento m);

    public PatriMovimiento prepareEdit(PatriMovimiento s);
    
    public List<PatriMovimiento> load(int first, int pageSize, String sortField, Map<String, Object> filters);

}
