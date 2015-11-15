/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.oceca.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author USER
 */
@Embeddable
public class SgcCriterioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_criterio")
    private int idCriterio;
    @Basic(optional = false)
    @Column(name = "id_factor")
    private int idFactor;

    public SgcCriterioPK() {
    }

    public SgcCriterioPK(int idCriterio, int idFactor) {
        this.idCriterio = idCriterio;
        this.idFactor = idFactor;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public int getIdFactor() {
        return idFactor;
    }

    public void setIdFactor(int idFactor) {
        this.idFactor = idFactor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCriterio;
        hash += (int) idFactor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcCriterioPK)) {
            return false;
        }
        SgcCriterioPK other = (SgcCriterioPK) object;
        if (this.idCriterio != other.idCriterio) {
            return false;
        }
        if (this.idFactor != other.idFactor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.sgc.estandar.SgcCriterioPK[ idCriterio=" + idCriterio + ", idFactor=" + idFactor + " ]";
    }
    
}
