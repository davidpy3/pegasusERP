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
import javax.validation.constraints.NotNull;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class HorarioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_hor")
    private Character tipoHor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Turno")
    private Character turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Registro")
    private Character registro;

    public HorarioPK() {
    }

    public HorarioPK(Character tipoHor, Character turno, Character registro) {
        this.tipoHor = tipoHor;
        this.turno = turno;
        this.registro = registro;
    }

    public Character getTipoHor() {
        return tipoHor;
    }

    public void setTipoHor(Character tipoHor) {
        this.tipoHor = tipoHor;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    public Character getRegistro() {
        return registro;
    }

    public void setRegistro(Character registro) {
        this.registro = registro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoHor != null ? tipoHor.hashCode() : 0);
        hash += (turno != null ? turno.hashCode() : 0);
        hash += (registro != null ? registro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioPK)) {
            return false;
        }
        HorarioPK other = (HorarioPK) object;
        if ((this.tipoHor == null && other.tipoHor != null) || (this.tipoHor != null && !this.tipoHor.equals(other.tipoHor))) {
            return false;
        }
        if ((this.turno == null && other.turno != null) || (this.turno != null && !this.turno.equals(other.turno))) {
            return false;
        }
        if ((this.registro == null && other.registro != null) || (this.registro != null && !this.registro.equals(other.registro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.HorarioPK[ tipoHor=" + tipoHor + ", turno=" + turno + ", registro=" + registro + " ]";
    }
    
}
