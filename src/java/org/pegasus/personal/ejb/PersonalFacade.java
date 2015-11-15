package org.pegasus.personal.ejb;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import org.jsuns.X;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.XDate;
import org.pegasus.personal.jpa.Personal;

@Stateless
public class PersonalFacade extends AbstractFacade<Personal> implements PersonalFacadeLocal{

    @Override
    public List load(int first, int pageSize,String sortField, Map<String, Object> filters) {
        String q=(String)filters.get("q");
        if(q!=null){
            return this.getEntityManager()
                .createQuery("SELECT p FROM Personal p WHERE p.nombComp LIKE :q OR p.dni like :q")
                .setParameter("q","%"+q.toUpperCase()+"%")
                .getResultList();
        }
        Object nombComp=filters.get("nombComp");
        Object mes=filters.get("mes");
        if(mes==null){
            return this.getEntityManager()
                .createQuery("SELECT p FROM Personal p WHERE p.nombComp LIKE :nombComp AND p.dni LIKE :dni")
                .setParameter("nombComp","%"+X.toText(nombComp).toUpperCase()+"%")
                .setParameter("dni","%"+X.toText(filters.get("dni")).toUpperCase()+"%")
                .getResultList();
        }
        return this.getEntityManager()
                .createQuery("SELECT p FROM Personal p "
                        + "WHERE MONTH(p.fechaNac)=:mes "
                        + "AND p.situacion='11' AND (NOT p.modLaboral.id='4' OR (p.modLaboral.id='4' AND p.codlocal='001'))"
                )
                .setParameter("mes",XDate.getMonth(new Date()))
                .getResultList();
    }
    
}
