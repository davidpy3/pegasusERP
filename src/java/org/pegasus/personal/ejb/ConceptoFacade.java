package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import org.jsuns.X;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Concepto;

@Stateless
public class ConceptoFacade extends AbstractFacade<Concepto> implements ConceptoFacadeLocal{
@Override
    public List load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        return getEntityManager().createQuery("SELECT c FROM Concepto c WHERE c.codigo LIKE :q OR c.concepto LIKE :q")
                .setParameter("q", "%" + X.toText(filters.get("q")).toUpperCase() + "%")
                .getResultList();
    }
}
