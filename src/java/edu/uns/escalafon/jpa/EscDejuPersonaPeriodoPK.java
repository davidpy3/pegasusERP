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
public class EscDejuPersonaPeriodoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_esc")
    private int idEsc;
    @Basic(optional = false)
    @Column(name = "id_periodo")
    private int idPeriodo;

    public EscDejuPersonaPeriodoPK() {
    }

    public EscDejuPersonaPeriodoPK(int idEsc, int idPeriodo) {
        this.idEsc = idEsc;
        this.idPeriodo = idPeriodo;
    }

    public int getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(int idEsc) {
        this.idEsc = idEsc;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEsc;
        hash += (int) idPeriodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EscDejuPersonaPeriodoPK)) {
            return false;
        }
        EscDejuPersonaPeriodoPK other = (EscDejuPersonaPeriodoPK) object;
        if (this.idEsc != other.idEsc) {
            return false;
        }
        if (this.idPeriodo != other.idPeriodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.escalafon.jpa.EscDejuPersonaPeriodoPK[ idEsc=" + idEsc + ", idPeriodo=" + idPeriodo + " ]";
    }
    
}
