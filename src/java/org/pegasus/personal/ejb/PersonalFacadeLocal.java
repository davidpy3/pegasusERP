package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.personal.jpa.Personal;

@Local
public interface PersonalFacadeLocal{

    void create(Personal personal);

    void edit(Personal personal);

    void remove(Personal personal);

    Personal find(Object id);

    List<Personal> findAll();

    List<Personal> findRange(int first,int max);

    int count();
    
    List<Personal> getResultList(String jpql,Object[] extra,int first,int max);
    
    public List load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
