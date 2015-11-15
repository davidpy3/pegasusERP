package org.pegasus.personal.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.Func;
import org.pegasus.personal.jpa.Papeleta;

@Stateless
public class PapeletaFacade extends AbstractFacade<Papeleta> implements PapeletaFacadeLocal{

    @Override
    public void create(Papeleta entity) {
        EntityManager em=getEntityManager();
        String anoEje=entity.getPapeletaPK().getAnoEje();
        int np=((Number)em.createQuery("SELECT COUNT(p) from Papeleta p WHERE p.papeletaPK.anoEje=:anoEje "
                + "AND (p.estado='2' OR p.estado='3')")
                .setParameter("anoEje",anoEje)
                .getSingleResult()).intValue();
        if(np>0)
            throw new PapeletaPendienteException();
        np=((Number)em.createQuery("SELECT MAX(p.papeletaPK.nPapeleta) from Papeleta p WHERE p.papeletaPK.anoEje=:anoEje")
                .setParameter("anoEje",anoEje)
                .getSingleResult()).intValue();
        entity.getPapeletaPK().setNPapeleta(String.format("%06d",np));
        entity.setFechaPape(Func.getServerDate());
        entity.setEstado('0');
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

}
