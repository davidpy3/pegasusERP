/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless ;import org.jsuns.util.AbstractFacade;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jsuns.util.XDate;
import org.jsuns.util.XUtil;
import org.pegasus.patrimonio.jpa.Bien;
import org.pegasus.patrimonio.jpa.Inventario;
import org.pegasus.patrimonio.jpa.InventarioDetalle;
import org.pegasus.patrimonio.jpa.InventarioPK;

/**
 *
 * @author TOSHIBA
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal{
    @PersistenceContext(unitName = "siigaa")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Inventario entity) {
        super.create(entity); 
        for(Bien b:em.createQuery("SELECT b FROM Bien b WHERE b.clasifica=:clasifica AND YEAR(b.fecReg)<=:year",Bien.class)
                .setParameter("clasifica", '1')
                .setParameter("year",XDate.getYear(entity.getPeriodo()))
                .getResultList()){
            InventarioDetalle d=new InventarioDetalle(entity.getInventarioPK().getAnoEje(),entity.getInventarioPK().getNumInv(),b.getBienPK().getCodbien(),b.getBienPK().getCorrela());
            d.setFlgVerificado('N');
            em.persist(d);
        }
//      MessageBox("AVISO", "Se Generó el Invenatrio Nº " + string(dw_1.object.num_inv[1]))
//      w_bandeja_inventario.pb_refresca.triggerevent(clicked!)
    }

    public InventarioFacade() {
        super(Inventario.class);
    }

    @Override
    public List<Inventario> findRange(int first, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepare(Inventario selected) {
        String anoEje=XUtil.toString(XDate.getYear(new Date()));
        selected.setInventarioPK(new org.pegasus.patrimonio.jpa.InventarioPK(anoEje,getEntityManager().createQuery("SELECT count(i)+1 FROM Inventario i WHERE i.inventarioPK.anoEje=:anoEje")
                .setParameter("anoEje",anoEje).getSingleResult().toString()));
        selected.setEstado('0');
    }
    
}
