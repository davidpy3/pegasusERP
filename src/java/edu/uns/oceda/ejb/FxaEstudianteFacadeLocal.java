package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.FxaEstudiante;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

@Local
public interface FxaEstudianteFacadeLocal {

    void create(FxaEstudiante area);

    void edit(FxaEstudiante area);

    void remove(FxaEstudiante area);

    FxaEstudiante find(Object id);

    List<FxaEstudiante> findAll();

    List<FxaEstudiante> findRange(int[] range);

    int count();

    public List<FxaEstudiante> load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
