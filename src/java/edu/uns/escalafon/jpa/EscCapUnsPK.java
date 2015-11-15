/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uns.escalafon.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jorik
 */
@Embeddable
public class EscCapUnsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cap")
    private int idCap;
    @Basic(optional = false)
    @Column(name = "id_dep")
    private int idDep;
    @Basic(optional = false)
    @Column(name = "tipo_cap")
    private boolean tipoCap;

    public EscCapUnsPK() {
    }

    public EscCapUnsPK(int idCap, int idDep, boolean tipoCap) {
        this.idCap = idCap;
        this.idDep = idDep;
        this.tipoCap = tipoCap;
    }

    public int getIdCap() {
        return idCap;
    }

    public void setIdCap(int idCap) {
        this.idCap = idCap;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public boolean getTipoCap() {
        return tipoCap;
    }

    public void setTipoCap(boolean tipoCap) {
        this.tipoCap = tipoCap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCap;
        hash += (int) idDep;
        hash += (tipoCap ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscCapUnsPK)) {
            return false;
        }
        EscCapUnsPK other = (EscCapUnsPK) object;
        if (this.idCap != other.idCap) {
            return false;
        }
        if (this.idDep != other.idDep) {
            return false;
        }
        if (this.tipoCap != other.tipoCap) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscCapUnsPK[ idCap=" + idCap + ", idDep=" + idDep + ", tipoCap=" + tipoCap + " ]";
    }
    
}
