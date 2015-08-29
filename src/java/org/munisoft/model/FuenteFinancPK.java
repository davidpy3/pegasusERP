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
public class FuenteFinancPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fuente_financ")
    private String fuenteFinanc;

    public FuenteFinancPK() {
    }

    public FuenteFinancPK(String anoEje, String fuenteFinanc) {
        this.anoEje = anoEje;
        this.fuenteFinanc = fuenteFinanc;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getFuenteFinanc() {
        return fuenteFinanc;
    }

    public void setFuenteFinanc(String fuenteFinanc) {
        this.fuenteFinanc = fuenteFinanc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (fuenteFinanc != null ? fuenteFinanc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuenteFinancPK)) {
            return false;
        }
        FuenteFinancPK other = (FuenteFinancPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.fuenteFinanc == null && other.fuenteFinanc != null) || (this.fuenteFinanc != null && !this.fuenteFinanc.equals(other.fuenteFinanc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.FuenteFinancPK[ anoEje=" + anoEje + ", fuenteFinanc=" + fuenteFinanc + " ]";
    }
    
}
