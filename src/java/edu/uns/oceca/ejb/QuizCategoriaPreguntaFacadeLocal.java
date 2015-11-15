package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizCategoriaPregunta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface QuizCategoriaPreguntaFacadeLocal {

    void create(QuizCategoriaPregunta sgcAudit);

    void edit(QuizCategoriaPregunta sgcAudit);

    void remove(QuizCategoriaPregunta sgcAudit);

    QuizCategoriaPregunta find(Object id);

    List<QuizCategoriaPregunta> findAll();

    List<QuizCategoriaPregunta> findRange(int[] range);

    int count();
    
}
