package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizPregunta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface QuizPreguntaFacadeLocal {

    void create(QuizPregunta sgcAudit);

    void edit(QuizPregunta sgcAudit);

    void remove(QuizPregunta sgcAudit);

    QuizPregunta find(Object id);

    List<QuizPregunta> findAll();

    List<QuizPregunta> findRange(int[] range);

    int count();
    
}
