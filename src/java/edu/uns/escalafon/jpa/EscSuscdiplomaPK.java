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
public class EscSuscdiplomaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "cargo_sus")
    private String cargoSus;

    public EscSuscdiplomaPK() {
    }

    public EscSuscdiplomaPK(int id, String cargoSus) {
        this.id = id;
        this.cargoSus = cargoSus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoSus() {
        return cargoSus;
    }

    public void setCargoSus(String cargoSus) {
        this.cargoSus = cargoSus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (cargoSus != null ? cargoSus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscSuscdiplomaPK)) {
            return false;
        }
        EscSuscdiplomaPK other = (EscSuscdiplomaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.cargoSus == null && other.cargoSus != null) || (this.cargoSus != null && !this.cargoSus.equals(other.cargoSus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscSuscdiplomaPK[ id=" + id + ", cargoSus=" + cargoSus + " ]";
    }
    
}
