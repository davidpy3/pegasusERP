package org.pegasus.patrimonio.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.XUtil;
import org.pegasus.patrimonio.jpa.PatriMovimiento;
import org.pegasus.patrimonio.jpa.PatriMovimientoDet;
import org.pegasus.patrimonio.jpa.Bien;

@Stateless
public class PatriMovimientoFacade extends AbstractFacade<PatriMovimiento> implements PatriMovimientoFacadeLocal {

    @Override
    public void autorizar(PatriMovimiento m) {
        m.setEstado(PatriMovimiento.AUTORIZADO);
        EntityManager em = this.getEntityManager();
        for (PatriMovimientoDet d : m.getPatriMovimientoDetCollection()) {
            Bien b = d.getBien();
            b.setCodusuario("");
            b.setCodlocal("");
            b.setCodarea("");
            b.setCodoficina("");
            b.setFlgEstado('P');
            em.merge(b);
        }
        em.merge(m);
    }

    @Override
    public void anular(PatriMovimiento m) {
        EntityManager em = this.getEntityManager();
        m.setEstado(PatriMovimiento.BUENA_PRO);
        for (PatriMovimientoDet d : m.getPatriMovimientoDetCollection()) {
            Bien b = d.getBien();
            b.setCodusuario(m.getEmplOrigen());
            String ub = d.getUbicaBien();
            b.setCodlocal(ub.substring(0, 2));//ls_codlocal = mid(ds_fudb_det.object.ubica_bien[i], 1, 3)
            b.setCodarea(ub.substring(3, 4));//mid(ds_fudb_det.object.ubica_bien[i], 4, 5)
            b.setCodoficina(ub.substring(9, 4));//ls_codoficina = mid(ds_fudb_det.object.ubica_bien[i], 9, 5)
            b.setFlgEstado('U');
            em.merge(b);						
        }
        em.merge(m);
    }

    @Override
    public PatriMovimiento prepareEdit(PatriMovimiento s) {
        if(s.getPatriMovimientoPK()!=null&&s.getPatriMovimientoPK().getNumMov()!=null){
            EntityManager em = this.getEntityManager();
            s=em.find(PatriMovimiento.class,s.getPatriMovimientoPK());
            for(PatriMovimientoDet d:s.getPatriMovimientoDetCollection()){
                d.getBien().getTipoBien();
            }
        }
        return s;
    }

    
    @Override
    public List<PatriMovimiento> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        Object estado=filters.get("estado");
        Object anoEje=filters.get("anoEje");
        System.out.println(filters);
        Query q=getEntityManager().createQuery("SELECT m FROM PatriMovimiento m "
                + "WHERE m.patriMovimientoPK.tipoMov=:tipoMov "
                + (estado!=null?"AND m.estado=:estado ":"")
                + (anoEje!=null?"AND m.patriMovimientoPK.anoEje=:anoEje ":"")
        );
        if(estado!=null)q.setParameter("estado", estado);
        if(anoEje!=null)q.setParameter("anoEje", anoEje);
        q.setParameter("tipoMov",(""+XUtil.intValue(filters.get("tipoMov"))).charAt(0));
        return q.getResultList();
    }
    
}
