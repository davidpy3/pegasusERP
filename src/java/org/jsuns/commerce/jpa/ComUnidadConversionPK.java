/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Embeddable
public class ComUnidadConversionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unidad_a")
    private int idUnidadA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_unidad_b")
    private int idUnidadB;

    public ComUnidadConversionPK() {
    }

    public ComUnidadConversionPK(int idUnidadA, int idUnidadB) {
        this.idUnidadA = idUnidadA;
        this.idUnidadB = idUnidadB;
    }

    public int getIdUnidadA() {
        return idUnidadA;
    }

    public void setIdUnidadA(int idUnidadA) {
        this.idUnidadA = idUnidadA;
    }

    public int getIdUnidadB() {
        return idUnidadB;
    }

    public void setIdUnidadB(int idUnidadB) {
        this.idUnidadB = idUnidadB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUnidadA;
        hash += (int) idUnidadB;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComUnidadConversionPK)) {
            return false;
        }
        ComUnidadConversionPK other = (ComUnidadConversionPK) object;
        if (this.idUnidadA != other.idUnidadA) {
            return false;
        }
        if (this.idUnidadB != other.idUnidadB) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComUnidadConversionPK[ idUnidadA=" + idUnidadA + ", idUnidadB=" + idUnidadB + " ]";
    }
    
}
