package edu.uns.ocid.ejb;

import java.util.List;
import javax.ejb.Local;
import org.jsuns.ocid.DrtPersonaJuridica;

@Local
public interface DrtPersonaJuridicaFacadeLocal {

    void create(DrtPersonaJuridica drtPersonaJuridica);

    void edit(DrtPersonaJuridica drtPersonaJuridica);

    void remove(DrtPersonaJuridica drtPersonaJuridica);

    DrtPersonaJuridica find(Object id);

    List<DrtPersonaJuridica> findAll();

    List<DrtPersonaJuridica> findRange(int[] range);

    int count();
    
}
