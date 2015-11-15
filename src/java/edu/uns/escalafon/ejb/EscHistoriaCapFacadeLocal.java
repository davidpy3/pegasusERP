/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscHistoriaCap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscHistoriaCapFacadeLocal {

    void create(EscHistoriaCap escHistoriaCap);

    void edit(EscHistoriaCap escHistoriaCap);

    void remove(EscHistoriaCap escHistoriaCap);

    EscHistoriaCap find(Object id);

    List<EscHistoriaCap> findAll();

    List<EscHistoriaCap> findRange(int[] range);

    int count();
    
}
