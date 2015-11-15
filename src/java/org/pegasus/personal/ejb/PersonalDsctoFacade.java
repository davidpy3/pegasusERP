package org.pegasus.personal.ejb;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.pegasus.personal.jpa.Personal;
import org.pegasus.personal.jpa.PersonalDscto;

@Stateless
public class PersonalDsctoFacade extends AbstractFacade<PersonalDscto> implements PersonalDsctoFacadeLocal {

    @Override
    public List<PersonalDscto> load(int i, int i0, Object object, HashMap params) {
        Personal p=(Personal) params.get("personal");
        if(p!=null){
            return getEntityManager().createQuery("SELECT pd FROM PersonalDscto pd WHERE pd.personalDsctoPK.dni=:dni")
                    .setParameter("dni",p.getDni()).getResultList();
        }else
            return getEntityManager().createQuery("SELECT pd FROM PersonalDscto pd")
                    .getResultList();
    }

}
