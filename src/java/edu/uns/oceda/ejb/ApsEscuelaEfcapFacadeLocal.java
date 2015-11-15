/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsEscuelaEfcap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsEscuelaEfcapFacadeLocal {

    void create(ApsEscuelaEfcap apsEscuelaEfcap);

    void edit(ApsEscuelaEfcap apsEscuelaEfcap);

    void remove(ApsEscuelaEfcap apsEscuelaEfcap);

    ApsEscuelaEfcap find(Object id);

    List<ApsEscuelaEfcap> findAll();

    List<ApsEscuelaEfcap> findRange(int[] range);

    int count();
    
}
