/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import java.util.Map;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.Bien;
import org.pegasus.personal.jpa.Personal;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface BienFacadeLocal {

    void create(Bien mBienes0);

    void edit(Bien mBienes0);

    void remove(Bien mBienes0);

    Bien find(Object id);

    List<Bien> findAll();

    List<Bien> findRange(int[] range);
    List<Bien> getResultList(String jpql,Object[] extra,int first,int max);
    int count();

    public List<Bien> load(int first, int pageSize, String sortField, Map<String, Object> filters);
    
}
