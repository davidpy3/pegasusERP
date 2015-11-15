package org.pegasus.patrimonio.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import org.jsuns.util.AbstractFacade;
import org.jsuns.util.XUtil;
import org.pegasus.patrimonio.jpa.Bien;

@Stateless
public class BienFacade extends AbstractFacade<Bien> implements BienFacadeLocal{

    @Override
    public List<Bien> load(int first, int pageSize, String sortField, Map<String, Object> filters) {
        String tipoBien="%";
        String usuario="%";
        if(filters!=null){
            tipoBien=XUtil.toString(filters.get("tipoBien"));
            usuario=XUtil.toString(filters.get("usuario"));
        }
        return getEntityManager().createQuery("SELECT b FROM Bien b WHERE b.codusuario LIKE :usuario AND b.tipoBien.descripcion LIKE :tipoBien")
                .setParameter("usuario", usuario)
                .setParameter("tipoBien", tipoBien)
                .getResultList();
    }
    
}
