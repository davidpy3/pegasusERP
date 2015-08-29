/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class Prueba1PK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_serie")
    private int nSerie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "recibo")
    private String recibo;

    public Prueba1PK() {
    }

    public Prueba1PK(String dni, int nSerie, String recibo) {
        this.dni = dni;
        this.nSerie = nSerie;
        this.recibo = recibo;
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

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        hash += (int) nSerie;
        hash += (recibo != null ? recibo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba1PK)) {
            return false;
        }
        Prueba1PK other = (Prueba1PK) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        if (this.nSerie != other.nSerie) {
            return false;
        }
        if ((this.recibo == null && other.recibo != null) || (this.recibo != null && !this.recibo.equals(other.recibo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.Prueba1PK[ dni=" + dni + ", nSerie=" + nSerie + ", recibo=" + recibo + " ]";
    }
    
}
