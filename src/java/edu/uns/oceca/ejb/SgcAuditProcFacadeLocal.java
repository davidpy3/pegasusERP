/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAuditProc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcAuditProcFacadeLocal {

    void create(SgcAuditProc sgcAuditProc);

    void edit(SgcAuditProc sgcAuditProc);

    void remove(SgcAuditProc sgcAuditProc);

    SgcAuditProc find(Object id);

    List<SgcAuditProc> findAll();

    List<SgcAuditProc> findRange(int[] range);

    int count();
    
}
