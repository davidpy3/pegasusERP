/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.ejb;

import java.util.List;
import javax.ejb.Local;
import org.pegasus.patrimonio.jpa.OrdenDet;

/**
 *
 * @author TOSHIBA
 */
@Local
public interface OrdenDetFacadeLocal {

    void create(OrdenDet orden);

    void edit(OrdenDet orden);

    void remove(OrdenDet orden);

    OrdenDet find(Object id);

    List<OrdenDet> findAll();

    List<OrdenDet> findRange(int[] range);
    
    List<OrdenDet> findRange(int first,int max);
    
    int count();
    
}
