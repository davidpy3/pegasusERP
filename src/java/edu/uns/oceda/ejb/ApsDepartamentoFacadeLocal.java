/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsDepartamentoFacadeLocal {

    void create(ApsDepartamento apsDepartamento);

    void edit(ApsDepartamento apsDepartamento);

    void remove(ApsDepartamento apsDepartamento);

    ApsDepartamento find(Object id);

    List<ApsDepartamento> findAll();

    List<ApsDepartamento> findRange(int[] range);

    int count();
    
}
