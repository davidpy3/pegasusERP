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
public class PatriMovimientoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_mov")
    private Character tipoMov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "num_mov")
    private String numMov;

    public PatriMovimientoPK() {
    }

    public PatriMovimientoPK(String anoEje, Character tipoMov, String numMov) {
        this.anoEje = anoEje;
        this.tipoMov = tipoMov;
        this.numMov = numMov;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public Character getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(Character tipoMov) {
        this.tipoMov = tipoMov;
    }

    public String getNumMov() {
        return numMov;
    }

    public void setNumMov(String numMov) {
        this.numMov = numMov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (tipoMov != null ? tipoMov.hashCode() : 0);
        hash += (numMov != null ? numMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatriMovimientoPK)) {
            return false;
        }
        PatriMovimientoPK other = (PatriMovimientoPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.tipoMov == null && other.tipoMov != null) || (this.tipoMov != null && !this.tipoMov.equals(other.tipoMov))) {
            return false;
        }
        if ((this.numMov == null && other.numMov != null) || (this.numMov != null && !this.numMov.equals(other.numMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.PatriMovimientoPK[ anoEje=" + anoEje + ", tipoMov=" + tipoMov + ", numMov=" + numMov + " ]";
    }
    
}
