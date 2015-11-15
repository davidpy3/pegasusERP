package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizCuestionario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface QuizCuestionarioFacadeLocal {

    void create(QuizCuestionario sgcAudit);

    void edit(QuizCuestionario sgcAudit);

    void remove(QuizCuestionario sgcAudit);

    QuizCuestionario find(Object id);

    List<QuizCuestionario> findAll();

    List<QuizCuestionario> findRange(int[] range);

    int count();
    
}
