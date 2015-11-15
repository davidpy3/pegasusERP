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
public class SgcFuenteResponsablePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_fuente")
    private int idFuente;
    @Basic(optional = false)
    @Column(name = "id_dir")
    private int idDir;

    public SgcFuenteResponsablePK() {
    }

    public SgcFuenteResponsablePK(int idFuente, int idDir) {
        this.idFuente = idFuente;
        this.idDir = idDir;
    }

    public int getIdFuente() {
        return idFuente;
    }

    public void setIdFuente(int idFuente) {
        this.idFuente = idFuente;
    }

    public int getIdDir() {
        return idDir;
    }

    public void setIdDir(int idDir) {
        this.idDir = idDir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFuente;
        hash += (int) idDir;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SgcFuenteResponsablePK)) {
            return false;
        }
        SgcFuenteResponsablePK other = (SgcFuenteResponsablePK) object;
        if (this.idFuente != other.idFuente) {
            return false;
        }
        if (this.idDir != other.idDir) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.uns.oceca.jpa.SgcFuenteResponsablePK[ idFuente=" + idFuente + ", idDir=" + idDir + " ]";
    }
    
}
