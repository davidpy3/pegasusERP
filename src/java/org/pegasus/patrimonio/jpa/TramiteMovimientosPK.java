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
public class TramiteMovimientosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_expediente")
    private long nExpediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "num_mov")
    private String numMov;

    public TramiteMovimientosPK() {
    }

    public TramiteMovimientosPK(String anoEje, long nExpediente, String numMov) {
        this.anoEje = anoEje;
        this.nExpediente = nExpediente;
        this.numMov = numMov;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public long getNExpediente() {
        return nExpediente;
    }

    public void setNExpediente(long nExpediente) {
        this.nExpediente = nExpediente;
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
        hash += (int) nExpediente;
        hash += (numMov != null ? numMov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TramiteMovimientosPK)) {
            return false;
        }
        TramiteMovimientosPK other = (TramiteMovimientosPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.nExpediente != other.nExpediente) {
            return false;
        }
        if ((this.numMov == null && other.numMov != null) || (this.numMov != null && !this.numMov.equals(other.numMov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.TramiteMovimientosPK[ anoEje=" + anoEje + ", nExpediente=" + nExpediente + ", numMov=" + numMov + " ]";
    }
    
}
