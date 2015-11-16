package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizCategoria;
import java.util.List;
import javax.ejb.Local;

@Local
public interface QuizCategoriaPreguntaFacadeLocal {

    void create(QuizCategoria sgcAudit);

    void edit(QuizCategoria sgcAudit);

    void remove(QuizCategoria sgcAudit);

    QuizCategoria find(Object id);

    List<QuizCategoria> findAll();

    List<QuizCategoria> findRange(int[] range);

    int count();
    
}
