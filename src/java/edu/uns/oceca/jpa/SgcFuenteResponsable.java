/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "sgc_fuente_responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcFuenteResponsable.findAll", query = "SELECT s FROM SgcFuenteResponsable s"),
    @NamedQuery(name = "SgcFuenteResponsable.findByIdFuente", query = "SELECT s FROM SgcFuenteResponsable s WHERE s.sgcFuenteResponsablePK.idFuente = :idFuente"),
    @NamedQuery(name = "SgcFuenteResponsable.findByIdDir", query = "SELECT s FROM SgcFuenteResponsable s WHERE s.sgcFuenteResponsablePK.idDir = :idDir")})
public class SgcFuenteResponsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgcFuenteResponsablePK sgcFuenteResponsablePK;

    public SgcFuenteResponsable() {
    }

    public SgcFuenteResponsable(SgcFuenteResponsablePK sgcFuenteResponsablePK) {
        this.sgcFuenteResponsablePK = sgcFuenteResponsablePK;
    }

    public SgcFuenteResponsable(int idFuente, int idDir) {
        this.sgcFuenteResponsablePK = new SgcFuenteResponsablePK(idFuente, idDir);
    }

    public SgcFuenteResponsablePK getSgcFuenteResponsablePK() {
        return sgcFuenteResponsablePK;
    }

    public void setSgcFuenteResponsablePK(SgcFuenteResponsablePK sgcFuenteResponsablePK) {
        this.sgcFuenteResponsablePK = sgcFuenteResponsablePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgcFuenteResponsablePK != null ? sgcFuenteResponsablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuenteResponsable)) {
            return false;
        }
        SgcFuenteResponsable other = (SgcFuenteResponsable) object;
        if ((this.sgcFuenteResponsablePK == null && other.sgcFuenteResponsablePK != null) || (this.sgcFuenteResponsablePK != null && !this.sgcFuenteResponsablePK.equals(other.sgcFuenteResponsablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuenteResponsable[ sgcFuenteResponsablePK=" + sgcFuenteResponsablePK + " ]";
    }
    
}
