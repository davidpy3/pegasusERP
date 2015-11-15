/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAudit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcAuditFacadeLocal {

    void create(SgcAudit sgcAudit);

    void edit(SgcAudit sgcAudit);

    void remove(SgcAudit sgcAudit);

    SgcAudit find(Object id);

    List<SgcAudit> findAll();

    List<SgcAudit> findRange(int[] range);

    int count();
    
}
