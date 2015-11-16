package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizEncuesta;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

@Local
public interface QuizEncuestaEspecialidadFacadeLocal {

    void create(QuizEncuesta svaEncuestaEspecialidad);

    void edit(QuizEncuesta svaEncuestaEspecialidad);

    void remove(QuizEncuesta svaEncuestaEspecialidad);

    QuizEncuesta find(Object id);

    List<QuizEncuesta> findAll();

    List<QuizEncuesta> findRange(int[] range);

    int count();

    public QuizEncuesta load(QuizEncuesta selected);

    public List<QuizEncuesta> load(int first, int pageSize, String sortField, Map<String, Object> filters);  
    
}
