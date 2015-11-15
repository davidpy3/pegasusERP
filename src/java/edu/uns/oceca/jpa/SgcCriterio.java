/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "sgc_criterio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcCriterio.findAll", query = "SELECT s FROM SgcCriterio s"),
    @NamedQuery(name = "SgcCriterio.findByIdCriterio", query = "SELECT s FROM SgcCriterio s WHERE s.sgcCriterioPK.idCriterio = :idCriterio"),
    @NamedQuery(name = "SgcCriterio.findByIdDimension", query = "SELECT s FROM SgcCriterio s WHERE s.idDimension = :idDimension"),
    @NamedQuery(name = "SgcCriterio.findByIdFactor", query = "SELECT s FROM SgcCriterio s WHERE s.sgcCriterioPK.idFactor = :idFactor"),
    @NamedQuery(name = "SgcCriterio.findByCriterio", query = "SELECT s FROM SgcCriterio s WHERE s.criterio = :criterio")})
public class SgcCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgcCriterioPK sgcCriterioPK;
    @Basic(optional = false)
    @Column(name = "id_dimension")
    private int idDimension;
    @Basic(optional = false)
    @Column(name = "criterio")
    private String criterio;
    @Basic(optional = false)
    @Lob
    @Column(name = "descripcion")
    private String descripcion;

    public SgcCriterio() {
    }

    public SgcCriterio(SgcCriterioPK sgcCriterioPK) {
        this.sgcCriterioPK = sgcCriterioPK;
    }

    public SgcCriterio(SgcCriterioPK sgcCriterioPK, int idDimension, String criterio, String descripcion) {
        this.sgcCriterioPK = sgcCriterioPK;
        this.idDimension = idDimension;
        this.criterio = criterio;
        this.descripcion = descripcion;
    }

    public SgcCriterio(int idCriterio, int idFactor) {
        this.sgcCriterioPK = new SgcCriterioPK(idCriterio, idFactor);
    }

    public SgcCriterioPK getSgcCriterioPK() {
        return sgcCriterioPK;
    }

    public void setSgcCriterioPK(SgcCriterioPK sgcCriterioPK) {
        this.sgcCriterioPK = sgcCriterioPK;
    }

    public int getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(int idDimension) {
        this.idDimension = idDimension;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgcCriterioPK != null ? sgcCriterioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcCriterio)) {
            return false;
        }
        SgcCriterio other = (SgcCriterio) object;
        if ((this.sgcCriterioPK == null && other.sgcCriterioPK != null) || (this.sgcCriterioPK != null && !this.sgcCriterioPK.equals(other.sgcCriterioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.sgc.estandar.SgcCriterio[ sgcCriterioPK=" + sgcCriterioPK + " ]";
    }
    
}
