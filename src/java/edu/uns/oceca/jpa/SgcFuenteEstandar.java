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
@Table(name = "sgc_fuente_estandar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgcFuenteEstandar.findAll", query = "SELECT s FROM SgcFuenteEstandar s"),
    @NamedQuery(name = "SgcFuenteEstandar.findByIdFuente", query = "SELECT s FROM SgcFuenteEstandar s WHERE s.sgcFuenteEstandarPK.idFuente = :idFuente"),
    @NamedQuery(name = "SgcFuenteEstandar.findByIdEstandar", query = "SELECT s FROM SgcFuenteEstandar s WHERE s.sgcFuenteEstandarPK.idEstandar = :idEstandar")})
public class SgcFuenteEstandar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SgcFuenteEstandarPK sgcFuenteEstandarPK;

    public SgcFuenteEstandar() {
    }

    public SgcFuenteEstandar(SgcFuenteEstandarPK sgcFuenteEstandarPK) {
        this.sgcFuenteEstandarPK = sgcFuenteEstandarPK;
    }

    public SgcFuenteEstandar(int idFuente, int idEstandar) {
        this.sgcFuenteEstandarPK = new SgcFuenteEstandarPK(idFuente, idEstandar);
    }

    public SgcFuenteEstandarPK getSgcFuenteEstandarPK() {
        return sgcFuenteEstandarPK;
    }

    public void setSgcFuenteEstandarPK(SgcFuenteEstandarPK sgcFuenteEstandarPK) {
        this.sgcFuenteEstandarPK = sgcFuenteEstandarPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sgcFuenteEstandarPK != null ? sgcFuenteEstandarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuenteEstandar)) {
            return false;
        }
        SgcFuenteEstandar other = (SgcFuenteEstandar) object;
        if ((this.sgcFuenteEstandarPK == null && other.sgcFuenteEstandarPK != null) || (this.sgcFuenteEstandarPK != null && !this.sgcFuenteEstandarPK.equals(other.sgcFuenteEstandarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuenteEstandar[ sgcFuenteEstandarPK=" + sgcFuenteEstandarPK + " ]";
    }
    
}
