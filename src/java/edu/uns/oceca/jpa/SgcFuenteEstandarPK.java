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
 * @author Jorik
 */
@Embeddable
public class SgcFuenteEstandarPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_fuente")
    private int idFuente;
    @Basic(optional = false)
    @Column(name = "id_estandar")
    private int idEstandar;

    public SgcFuenteEstandarPK() {
    }

    public SgcFuenteEstandarPK(int idFuente, int idEstandar) {
        this.idFuente = idFuente;
        this.idEstandar = idEstandar;
    }

    public int getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(int idFuente) {
        this.idFuente = idFuente;
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
        hash += (int) idFuente;
        hash += (int) idEstandar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuenteEstandarPK)) {
            return false;
        }
        SgcFuenteEstandarPK other = (SgcFuenteEstandarPK) object;
        if (this.idFuente != other.idFuente) {
            return false;
        }
        if (this.idEstandar != other.idEstandar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuenteEstandarPK[ idFuente=" + idFuente + ", idEstandar=" + idEstandar + " ]";
    }
    
}
