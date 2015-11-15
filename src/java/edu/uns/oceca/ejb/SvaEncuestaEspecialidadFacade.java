package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizPregunta;
import edu.uns.oceca.jpa.SvaEncuestaEspecialidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.jsuns.util.AbstractFacade;

@Stateless
public class SvaEncuestaEspecialidadFacade extends AbstractFacade<SvaEncuestaEspecialidad> implements SvaEncuestaEspecialidadFacadeLocal {

    @Override
    public SvaEncuestaEspecialidad load(SvaEncuestaEspecialidad selected) {
        EntityManager em = getEntityManager();
        selected.setPreguntaList(
                em.createQuery("SELECT p FROM QuizPregunta p "
                        + "WHERE p.idCuestionario=:idCuestionario", QuizPregunta.class)
                .setParameter("idCuestionario", selected.getIdCuestionario()).getResultList());
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

}
