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
public class EscPersHorarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_esc")
    private int idEsc;
    @Basic(optional = false)
    @Column(name = "dia")
    private short dia;
    @Basic(optional = false)
    @Column(name = "jornada")
    private short jornada;

    public EscPersHorarioPK() {
    }

    public EscPersHorarioPK(int idEsc, short dia, short jornada) {
        this.idEsc = idEsc;
        this.dia = dia;
        this.jornada = jornada;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public short getDia() {
        return dia;
    }

    public void setDia(short dia) {
        this.dia = dia;
    }

    public short getJornada() {
        return jornada;
    }

    public void setJornada(short jornada) {
        this.jornada = jornada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEsc;
        hash += (int) dia;
        hash += (int) jornada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscPersHorarioPK)) {
            return false;
        }
        EscPersHorarioPK other = (EscPersHorarioPK) object;
        if (this.idEsc != other.idEsc) {
            return false;
        }
        if (this.dia != other.dia) {
            return false;
        }
        if (this.jornada != other.jornada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscPersHorarioPK[ idEsc=" + idEsc + ", dia=" + dia + ", jornada=" + jornada + " ]";
    }
    
}
