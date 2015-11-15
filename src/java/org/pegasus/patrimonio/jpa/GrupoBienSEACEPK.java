/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.patrimonio.jpa;

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
public class GrupoBienSEACEPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_bien")
    private Character tipoBien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "grupo_bien")
    private String grupoBien;

    public GrupoBienSEACEPK() {
    }

    public GrupoBienSEACEPK(Character tipoBien, String grupoBien) {
        this.tipoBien = tipoBien;
        this.grupoBien = grupoBien;
    }

    public Character getTipoBien() {
        return tipoBien;
    }

    public void setTipoBien(Character tipoBien) {
        this.tipoBien = tipoBien;
    }

    public String getGrupoBien() {
        return grupoBien;
    }

    public void setGrupoBien(String grupoBien) {
        this.grupoBien = grupoBien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoBien != null ? tipoBien.hashCode() : 0);
        hash += (grupoBien != null ? grupoBien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoBienSEACEPK)) {
            return false;
        }
        GrupoBienSEACEPK other = (GrupoBienSEACEPK) object;
        if ((this.tipoBien == null && other.tipoBien != null) || (this.tipoBien != null && !this.tipoBien.equals(other.tipoBien))) {
            return false;
        }
        if ((this.grupoBien == null && other.grupoBien != null) || (this.grupoBien != null && !this.grupoBien.equals(other.grupoBien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.GrupoBienSEACEPK[ tipoBien=" + tipoBien + ", grupoBien=" + grupoBien + " ]";
    }
    
}
