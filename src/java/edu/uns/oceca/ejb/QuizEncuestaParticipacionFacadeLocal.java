package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizEncuestaParticipacion;
import java.util.List;
import java.util.Map;
import javax.ejb.Local;

@Local
public interface QuizEncuestaParticipacionFacadeLocal {

    void create(QuizEncuestaParticipacion sgcDocRevision);

    void edit(QuizEncuestaParticipacion sgcDocRevision);

    void remove(QuizEncuestaParticipacion sgcDocRevision);

    QuizEncuestaParticipacion find(Object id);

    List<QuizEncuestaParticipacion> findAll();

    List<QuizEncuestaParticipacion> findRange(int[] range);

    int count();

    public List<QuizEncuestaParticipacion> load(int first, int pageSize, String sortField, Map<String, Object> filters);

    public Map responder(QuizEncuestaParticipacion selected);

}
