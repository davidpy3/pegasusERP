package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizPregunta;
import edu.uns.oceca.jpa.QuizEncuesta;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.jsuns.X;
import org.jsuns.util.AbstractFacade;

@Stateless
public class QuizEncuestaEspecialidadFacade extends AbstractFacade<QuizEncuesta> implements QuizEncuestaEspecialidadFacadeLocal {

    @Override
    public QuizEncuesta load(QuizEncuesta selected) {
        EntityManager em = getEntityManager();
        selected.setPreguntaList(
                em.createQuery("SELECT p FROM QuizPregunta p WHERE p.idCuestionario=:idCuestionario", QuizPregunta.class)
                .setParameter("idCuestionario", selected.getQuizCuestionario()).getResultList());
//        for (QuizPregunta p : selected.getPreguntaList()) {
//            p.getOpcionListCollection().size();
//        }
        Query q2 = em.createQuery("SELECT q FROM QuizOpcionLista q WHERE q.idLista=:idLista");
        for (QuizPregunta p : selected.getPreguntaList()) {
            List l = q2.setParameter("idLista", p.getIdLista()).getResultList();
            if (l.size() > 0) {
                p.setOpcionListCollection(l);
            }
        }
        return selected;
    }

        @Override
    public List<QuizEncuesta> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        return getEntityManager().createQuery("SELECT p FROM QuizEncuesta p WHERE "
                + "(p.apsEspecialidad.especialidad LIKE :objeto OR p.apsEspecialidad IS NULL) "
                + "")
                .setParameter("objeto", "%"+X.toText(filters.get("objeto")).toUpperCase()+"%")
                .getResultList();
    }
}
