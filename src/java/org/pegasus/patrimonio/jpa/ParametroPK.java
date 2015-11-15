/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class ParametroPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_param")
    private int idParam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIni;

    public ParametroPK() {
    }

    public ParametroPK(int idParam, Date fechaIni) {
        this.idParam = idParam;
        this.fechaIni = fechaIni;
    }

    public int getIdParam() {
        return idParam;
    }

    public void setIdParam(int idParam) {
        this.idParam = idParam;
    }

    public Date getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idParam;
        hash += (fechaIni != null ? fechaIni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParametroPK)) {
            return false;
        }
        ParametroPK other = (ParametroPK) object;
        if (this.idParam != other.idParam) {
            return false;
        }
        if ((this.fechaIni == null && other.fechaIni != null) || (this.fechaIni != null && !this.fechaIni.equals(other.fechaIni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ParametroPK[ idParam=" + idParam + ", fechaIni=" + fechaIni + " ]";
    }
    
}
