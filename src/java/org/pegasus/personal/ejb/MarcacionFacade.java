package org.pegasus.personal.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.Query;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Marcacion;

@Stateless
public class MarcacionFacade extends AbstractFacade<Marcacion> implements MarcacionFacadeLocal {

    @Override
    public List<Marcacion> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        String dni=(String) filters.get("dni");
        Query q=getEntityManager().createQuery("SELECT m FROM Marcacion m "
        +(dni!=null?"m.marcacionPK.dni=:dni ":"")
        +"ORDER BY m.personal.nombComp,m.marcacionPK.fechaHora");
        if(dni!=null)
            q.setParameter("dni", dni);
        return q.getResultList();
    }
  
}
