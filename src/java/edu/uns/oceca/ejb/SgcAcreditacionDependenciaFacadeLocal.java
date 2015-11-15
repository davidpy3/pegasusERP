package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAcreditacionDependencia;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SgcAcreditacionDependenciaFacadeLocal {

    void create(SgcAcreditacionDependencia sgcAcreditacionDependencia);

    void edit(SgcAcreditacionDependencia sgcAcreditacionDependencia);

    void remove(SgcAcreditacionDependencia sgcAcreditacionDependencia);

    SgcAcreditacionDependencia find(Object id);

    List<SgcAcreditacionDependencia> findAll();

    List<SgcAcreditacionDependencia> findRange(int[] range);

    int count();
    
}
