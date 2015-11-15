package org.pegasus.personal.ejb;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Personal;
import org.pegasus.personal.jpa.PlanillaTrab;

@Stateless
public class PlanillaTrabFacade extends AbstractFacade<PlanillaTrab> implements PlanillaTrabFacadeLocal{

    
    @Override
    public List load(int first, int pageSize, String sortField, Map<String, Object> filters){
        Personal p=(Personal) filters.get("personal");
        if(p!=null){
            return getEntityManager().createQuery("SELECT p FROM PlanillaTrab p WHERE p.planillaTrabPK.dni=:dni")
                .setParameter("dni",p.getDni())
                .getResultList();
        }else{
            return Collections.EMPTY_LIST;
        }
    }
    
    
}
