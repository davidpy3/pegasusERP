/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.munisoft.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class TurnosVigilantesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNI")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_hor")
    private Character tipoHor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    public TurnosVigilantesPK() {
    }

    public TurnosVigilantesPK(String dni, Character tipoHor, Date fechaIni, Date fechaFin) {
        this.dni = dni;
        this.tipoHor = tipoHor;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Character getTipoHor() {
        return tipoHor;
    }

    public void setTipoHor(Character tipoHor) {
        this.tipoHor = tipoHor;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        hash += (tipoHor != null ? tipoHor.hashCode() : 0);
        hash += (fechaIni != null ? fechaIni.hashCode() : 0);
        hash += (fechaFin != null ? fechaFin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosVigilantesPK)) {
            return false;
        }
        TurnosVigilantesPK other = (TurnosVigilantesPK) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        if ((this.tipoHor == null && other.tipoHor != null) || (this.tipoHor != null && !this.tipoHor.equals(other.tipoHor))) {
            return false;
        }
        if ((this.fechaIni == null && other.fechaIni != null) || (this.fechaIni != null && !this.fechaIni.equals(other.fechaIni))) {
            return false;
        }
        if ((this.fechaFin == null && other.fechaFin != null) || (this.fechaFin != null && !this.fechaFin.equals(other.fechaFin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TurnosVigilantesPK[ dni=" + dni + ", tipoHor=" + tipoHor + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + " ]";
    }
    
}
