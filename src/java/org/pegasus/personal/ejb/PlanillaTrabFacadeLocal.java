package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.personal.jpa.PlanillaTrab;

@Local
public interface PlanillaTrabFacadeLocal {

    void create(PlanillaTrab planillaTrab);

    void edit(PlanillaTrab planillaTrab);

    void remove(PlanillaTrab planillaTrab);

    PlanillaTrab find(Object id);

    List<PlanillaTrab> findAll();

    List<PlanillaTrab> findRange(int[] range);

    int count();
    
    
    public List load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
