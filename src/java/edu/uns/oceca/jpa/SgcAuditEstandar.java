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
@Table(name = "sgc_audit_estandar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcAuditEstandar.findAll", query = "SELECT s FROM SgcAuditEstandar s"),
    @NamedQuery(name = "SgcAuditEstandar.findByIdAudest", query = "SELECT s FROM SgcAuditEstandar s WHERE s.idAudest = :idAudest"),
    @NamedQuery(name = "SgcAuditEstandar.findByIdAudit", query = "SELECT s FROM SgcAuditEstandar s WHERE s.idAudit = :idAudit"),
    @NamedQuery(name = "SgcAuditEstandar.findByIdTipoEstandar", query = "SELECT s FROM SgcAuditEstandar s WHERE s.idTipoEstandar = :idTipoEstandar"),
    @NamedQuery(name = "SgcAuditEstandar.findByIdEstandar", query = "SELECT s FROM SgcAuditEstandar s WHERE s.idEstandar = :idEstandar")})
public class SgcAuditEstandar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_audest")
    private Integer idAudest;
    @Basic(optional = false)
    @Column(name = "id_audit")
    private int idAudit;
    @Basic(optional = false)
    @Column(name = "id_tipo_estandar")
    private int idTipoEstandar;
    @Basic(optional = false)
    @Column(name = "id_estandar")
    private int idEstandar;

    public SgcAuditEstandar() {
    }

    public SgcAuditEstandar(Integer idAudest) {
        this.idAudest = idAudest;
    }

    public SgcAuditEstandar(Integer idAudest, int idAudit, int idTipoEstandar, int idEstandar) {
        this.idAudest = idAudest;
        this.idAudit = idAudit;
        this.idTipoEstandar = idTipoEstandar;
        this.idEstandar = idEstandar;
    }

    public Integer getIdAudest() {
        return idAudest;
    }

    public void setIdAudest(Integer idAudest) {
        this.idAudest = idAudest;
    }

    public int getIdAudit() {
        return idAudit;
    }

    public void setIdAudit(int idAudit) {
        this.idAudit = idAudit;
    }

    public int getIdTipoEstandar() {
        return idTipoEstandar;
    }

    public void setIdTipoEstandar(int idTipoEstandar) {
        this.idTipoEstandar = idTipoEstandar;
    }

    public int getIdEstandar() {
        return idEstandar;
    }

    public void setIdEstandar(int idEstandar) {
        this.idEstandar = idEstandar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAudest != null ? idAudest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcAuditEstandar)) {
            return false;
        }
        SgcAuditEstandar other = (SgcAuditEstandar) object;
        if ((this.idAudest == null && other.idAudest != null) || (this.idAudest != null && !this.idAudest.equals(other.idAudest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcAuditEstandar[ idAudest=" + idAudest + " ]";
    }
    
}
