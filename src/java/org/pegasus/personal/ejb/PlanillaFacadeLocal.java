package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Planilla;

@Local
public interface PlanillaFacadeLocal {

    void create(Planilla planilla);

    void edit(Planilla planilla);

    void remove(Planilla planilla);

    Planilla find(Object id);

    List<Planilla> findAll();

    List<Planilla> findRange(int first,int max);

    int count();
    
    public List<Planilla> load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
    public List getResultList(int first, int pageSize, String sortField, Map<String, Object> filters); 
            
    public void prepare(Planilla entity);
            
}
