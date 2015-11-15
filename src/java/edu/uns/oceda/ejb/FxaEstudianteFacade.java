package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.FxaEstudiante;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.XUtil;

@Stateless
public class FxaEstudianteFacade extends AbstractFacade<FxaEstudiante> implements FxaEstudianteFacadeLocal{

    @Override
    public List<FxaEstudiante> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        String nombreCompleto=(String)XUtil.toString(filters.get("nombreCompleto"));
        EntityManager em=this.getEntityManager();
        String q="FROM FxaEstudiante e WHERE e.personaNatural.nombreCompleto"
                + " LIKE :nombreCompleto";
        List l=em.createQuery("SELECT e "+q)
                .setParameter("nombreCompleto",nombreCompleto)
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .getResultList();
        filters.put("size",
                em.createQuery("SELECT COUNT(e) "+q)
                .setParameter("nombreCompleto",nombreCompleto)
                .getSingleResult());
        return l;
    }

}
