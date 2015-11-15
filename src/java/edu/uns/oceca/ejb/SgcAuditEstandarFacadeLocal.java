/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.ejb;

import edu.uns.oceca.jpa.SgcAuditEstandar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jorik
 */
@Local
public interface SgcAuditEstandarFacadeLocal {

    void create(SgcAuditEstandar sgcAuditEstandar);

    void edit(SgcAuditEstandar sgcAuditEstandar);

    void remove(SgcAuditEstandar sgcAuditEstandar);

    SgcAuditEstandar find(Object id);

    List<SgcAuditEstandar> findAll();

    List<SgcAuditEstandar> findRange(int[] range);

    int count();
    
}
