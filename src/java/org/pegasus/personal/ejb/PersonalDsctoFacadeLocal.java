package org.pegasus.personal.ejb;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;
import org.pegasus.personal.jpa.PersonalDscto;

@Local
public interface PersonalDsctoFacadeLocal {

    void create(PersonalDscto personalDscto);

    void edit(PersonalDscto personalDscto);

    void remove(PersonalDscto personalDscto);

    PersonalDscto find(Object id);

    List<PersonalDscto> findAll();

    List<PersonalDscto> findRange(int[] range);

    int count();

    public List<PersonalDscto> load(int i, int i0, Object object, HashMap params);
    
}
