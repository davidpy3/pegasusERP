package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import org.jsuns.X;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Ocupacion;

@Stateless
public class OcupacionFacade extends AbstractFacade<Ocupacion> implements OcupacionFacadeLocal {

    @Override
    public List<Ocupacion> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        String q=X.toText(filters.get("q")).toUpperCase();
        return this.getEntityManager().createQuery("SELECT o FROM Ocupacion o WHERE o.nombre LIKE :nombre")
                .setParameter("nombre","%"+q+"%").getResultList();
    }

}
