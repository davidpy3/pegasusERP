/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceda.ejb;

import edu.uns.oceda.jpa.ApsFacultadEfcap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface ApsFacultadEfcapFacadeLocal {

    void create(ApsFacultadEfcap apsFacultadEfcap);

    void edit(ApsFacultadEfcap apsFacultadEfcap);

    void remove(ApsFacultadEfcap apsFacultadEfcap);

    ApsFacultadEfcap find(Object id);

    List<ApsFacultadEfcap> findAll();

    List<ApsFacultadEfcap> findRange(int[] range);

    int count();
    
}
