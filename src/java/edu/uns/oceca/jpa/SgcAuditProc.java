/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_audit_proc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAuditProc.findAll", query = "SELECT s FROM SgcAuditProc s"),
    @NamedQuery(name = "SgcAuditProc.findByIdAudproc", query = "SELECT s FROM SgcAuditProc s WHERE s.idAudproc = :idAudproc"),
    @NamedQuery(name = "SgcAuditProc.findByIdAudit", query = "SELECT s FROM SgcAuditProc s WHERE s.idAudit = :idAudit"),
    @NamedQuery(name = "SgcAuditProc.findByIdProc", query = "SELECT s FROM SgcAuditProc s WHERE s.idProc = :idProc")})
public class SgcAuditProc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_audproc")
    private Integer idAudproc;
    @Basic(optional = false)
    @Column(name = "id_audit")
    private int idAudit;
    @Basic(optional = false)
    @Column(name = "id_proc")
    private int idProc;

    public SgcAuditProc() {
    }

    public SgcAuditProc(Integer idAudproc) {
        this.idAudproc = idAudproc;
    }

    public SgcAuditProc(Integer idAudproc, int idAudit, int idProc) {
        this.idAudproc = idAudproc;
        this.idAudit = idAudit;
        this.idProc = idProc;
    }

    public Integer getIdAudproc() {
        return idAudproc;
    }

    public void setIdAudproc(Integer idAudproc) {
        this.idAudproc = idAudproc;
    }

    public int getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(int idAudit) {
        this.idAudit = idAudit;
    }

    public int getIdProc() {
        return idProc;
    }

    public void setIdProc(int idProc) {
        this.idProc = idProc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAudproc != null ? idAudproc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAuditProc)) {
            return false;
        }
        SgcAuditProc other = (SgcAuditProc) object;
        if ((this.idAudproc == null && other.idAudproc != null) || (this.idAudproc != null && !this.idAudproc.equals(other.idAudproc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAuditProc[ idAudproc=" + idAudproc + " ]";
    }
    
}
