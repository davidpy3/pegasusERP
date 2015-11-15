/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.ejb;

import edu.uns.escalafon.jpa.EscTipoCap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface EscTipoCapFacadeLocal {

    void create(EscTipoCap escTipoCap);

    void edit(EscTipoCap escTipoCap);

    void remove(EscTipoCap escTipoCap);

    EscTipoCap find(Object id);

    List<EscTipoCap> findAll();

    List<EscTipoCap> findRange(int[] range);

    int count();
    
}
