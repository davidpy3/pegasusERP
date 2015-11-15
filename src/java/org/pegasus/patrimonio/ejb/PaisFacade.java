package org.pegasus.patrimonio.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless ;import org.jsuns.X;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Pais;

@Stateless
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal{

    @Override
    public List<Pais> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        return this.getEntityManager().createQuery("SELECT p FROM Pais p WHERE p.nombre LIKE :q")
                .setParameter("q","%"+X.toText(filters.get("q")).toUpperCase()+"%").getResultList();
    }
    
}
