/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Erick alarcon
 */
@Embeddable
public class Cas3PK implements Serializable {
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @Column(name = "n_serie")
    private int nSerie;
    @Basic(optional = false)
    @Column(name = "n_recibo")
    private int nRecibo;

    public Cas3PK() {
    }

    public Cas3PK(String dni, int nSerie, int nRecibo) {
        this.dni = dni;
        this.nSerie = nSerie;
        this.nRecibo = nRecibo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getNSerie() {
        return nSerie;
    }

    public void setNSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    public int getNRecibo() {
        return nRecibo;
    }

    public void setNRecibo(int nRecibo) {
        this.nRecibo = nRecibo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        hash += (int) nSerie;
        hash += (int) nRecibo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cas3PK)) {
            return false;
        }
        Cas3PK other = (Cas3PK) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        if (this.nSerie != other.nSerie) {
            return false;
        }
        if (this.nRecibo != other.nRecibo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.Cas3PK[ dni=" + dni + ", nSerie=" + nSerie + ", nRecibo=" + nRecibo + " ]";
    }
    
}
