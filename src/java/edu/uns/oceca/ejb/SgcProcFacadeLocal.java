/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcProc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcProcFacadeLocal {

    void create(SgcProc sgcProc);

    void edit(SgcProc sgcProc);

    void remove(SgcProc sgcProc);

    SgcProc find(Object id);

    List<SgcProc> findAll();

    List<SgcProc> findRange(int[] range);

    int count();
    
}
