package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Orden;
import org.pegasus.patrimonio.jpa.Proveedor;

@Stateless
public class OrdenFacade extends AbstractFacade<Orden> implements OrdenFacadeLocal{

    @Override
    public List<Orden> findAll() {
        
//        this.getEntityManager().createQuery("SELECT DISTINCT o,SUM(o.ordenDetCollection.precioAdj*o.ordenDetCollection.saldo) s FROM Orden o ").getResultList();
        EntityManager em=getEntityManager();
        List<Object[]> l=em.createQuery("SELECT DISTINCT o,SUM(d.precioAdj*d.saldo) FROM Orden o LEFT JOIN o.ordenDetCollection d WHERE o.ordenPK.tipo=:tipo AND o.ordenPK.anoEje=:anoEje GROUP BY o").setParameter("tipo",'B').setParameter("anoEje","2014").getResultList();
        for(Object[] r:l){
//        l.stream().forEach((r) -> {
            Orden o=(Orden)r[0];
            
            Proveedor p=em.find(Proveedor.class,o.getRUCprov());
            o.setProveedor(p);
            System.out.println(r[0]+"=>"+r[1]+"="+o.getProveedor());
//        });
        }
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

}
