/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Entity
@Table(name = "com_unidad_conversion")
@NamedQueries({
    @NamedQuery(name = "ComUnidadConversion.findAll", query = "SELECT c FROM ComUnidadConversion c")})
public class ComUnidadConversion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComUnidadConversionPK comUnidadConversionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "factor")
    private float factor;

    public ComUnidadConversion() {
    }

    public ComUnidadConversion(ComUnidadConversionPK comUnidadConversionPK) {
        this.comUnidadConversionPK = comUnidadConversionPK;
    }

    public ComUnidadConversion(ComUnidadConversionPK comUnidadConversionPK, float factor) {
        this.comUnidadConversionPK = comUnidadConversionPK;
        this.factor = factor;
    }

    public ComUnidadConversion(int idUnidadA, int idUnidadB) {
        this.comUnidadConversionPK = new ComUnidadConversionPK(idUnidadA, idUnidadB);
    }

    public ComUnidadConversionPK getComUnidadConversionPK() {
        return comUnidadConversionPK;
    }

    public void setComUnidadConversionPK(ComUnidadConversionPK comUnidadConversionPK) {
        this.comUnidadConversionPK = comUnidadConversionPK;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comUnidadConversionPK != null ? comUnidadConversionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComUnidadConversion)) {
            return false;
        }
        ComUnidadConversion other = (ComUnidadConversion) object;
        if ((this.comUnidadConversionPK == null && other.comUnidadConversionPK != null) || (this.comUnidadConversionPK != null && !this.comUnidadConversionPK.equals(other.comUnidadConversionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComUnidadConversion[ comUnidadConversionPK=" + comUnidadConversionPK + " ]";
    }
    
}
