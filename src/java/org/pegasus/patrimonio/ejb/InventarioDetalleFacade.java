package org.pegasus.patrimonio.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import org.jsuns.util.AbstractFacade;
import org.pegasus.patrimonio.jpa.Bien;
import org.pegasus.patrimonio.jpa.InventarioDetalle;
import org.pegasus.patrimonio.jpa.InventarioDetallePK;
import org.pegasus.patrimonio.jpa.BienPK;

@Stateless
public class InventarioDetalleFacade extends AbstractFacade<InventarioDetalle> implements InventarioDetalleFacadeLocal {

    @Override
    public void edit(InventarioDetalle entity) {
        Bien b=entity.getBien();
        if(b!=null){
            this.getEntityManager().merge(b);
            entity.setFechaVerifica(new Date());
            entity.setFlgVerificado('S');
            entity.setGrupo(new Date().toString().substring(0,20));
        }
        super.edit(entity);
        
    }

    @Override
    public void create(InventarioDetalle entity) {
        super.create(entity);

//      MessageBox("AVISO", "Se Generó el Invenatrio Nº " + string(dw_1.object.num_inv[1]))
//      w_bandeja_inventario.pb_refresca.triggerevent(clicked!)
    }

    public InventarioDetalleFacade() {
        super(InventarioDetalle.class);
    }

    @Override
    public List<InventarioDetalle> findRange(int first, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepare(InventarioDetalle selected) {

    }

    @Override
    public List<InventarioDetalle> findAll() {
        List<InventarioDetalle> l= super.findAll(); //To change body of generated methods, choose Tools | Templates.
        EntityManager em=getEntityManager();
        for (InventarioDetalle id : l) {
            InventarioDetallePK pk = id.getInventarioDetallePK();
            id.setBien(em.find(Bien.class, new BienPK(pk.getCodbien(), pk.getCorrela())));
        }
        return l;
    }

    @Override
    public void inventariar(InventarioDetalle i) {
        InventarioDetallePK pk = i.getInventarioDetallePK();
        i.setBien(getEntityManager().find(Bien.class, new BienPK(pk.getCodbien(), pk.getCorrela())));
    }

}
