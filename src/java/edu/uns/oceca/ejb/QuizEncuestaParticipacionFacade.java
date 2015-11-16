package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.QuizCategoria;
import edu.uns.oceca.jpa.QuizEncuesta;
import edu.uns.oceca.jpa.QuizEncuestaParticipacion;
import edu.uns.oceca.jpa.QuizPregunta;
import edu.uns.oceca.jpa.QuizRespuesta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.XUtil;

@Stateless
public class QuizEncuestaParticipacionFacade extends AbstractFacade<QuizEncuestaParticipacion> implements QuizEncuestaParticipacionFacadeLocal {

    @Override
    public List<QuizEncuestaParticipacion> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        Object personaNatural=filters.get("personaNatural");
        if(personaNatural!=null){
            return getEntityManager().createQuery("SELECT p FROM QuizEncuestaParticipacion p WHERE p.personaNatural=:personaNatural")
                .setParameter("personaNatural",personaNatural)
                .getResultList();
           
        }else return getEntityManager().createQuery("SELECT p FROM QuizEncuestaParticipacion p WHERE p.idEncuesta=:idEncuesta")
                .setParameter("idEncuesta", XUtil.intValue(filters.get("idEncuesta")))
                .getResultList();
    }

    @Override
    public Map responder(QuizEncuestaParticipacion selected) {
        EntityManager em=getEntityManager();
        String s=selected.getFlags();
        if(!s.contains(""+selected.getFlag())){
            s+=selected.getFlag();
        }
        String s2="";
        for(char c:s.toCharArray()){
            s2+=" OR f.flag LIKE '%"+c+"%'";
        }
        QuizEncuesta e=selected.getQuizEncuesta();
        List<QuizRespuesta> lr=em.createQuery("SELECT r FROM QuizRespuesta r WHERE r.svaRespuestaPK.idParticipacion=:idParticipacion")
                .setParameter("idParticipacion",selected.getIdParticipacion()).getResultList();
        List<QuizPregunta> lp=em.createQuery("SELECT p FROM QuizPregunta p,QuizFuentePregunta f WHERE p.idCuestionario=:idCuestionario AND f.idPregunta=p.idPregunta"+(s2.length()>0?" AND ("+s2.substring(4)+")":"")
                +" ORDER BY p.categoria.numero,p.numero")
                .setParameter("idCuestionario",e.getQuizCuestionario().getIdCuestionario())
                .getResultList();
        List<QuizCategoria> lc=new ArrayList();
        Query q2 = em.createQuery("SELECT q FROM QuizOpcionLista q WHERE q.idLista=:idLista");
        for(QuizPregunta p:lp){
            if(!lc.contains(p.getCategoria())){
                lc.add(p.getCategoria());
                p.getCategoria().setPreguntaCollection(new ArrayList<QuizPregunta>());
            }
            List l = q2.setParameter("idLista", p.getIdLista()).getResultList();
            if (l.size() > 0) {
                p.setOpcionListCollection(l);
            }
            p.getCategoria().getPreguntaCollection().add(p);
        }
        HashMap m=new HashMap();
        m.put(QuizCategoria.class.getName(),lc);
        m.put(QuizRespuesta.class.getName(), lr);
        return m;
    }

    
}
