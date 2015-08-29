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
public class ArchiDetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_archivador")
    private int nArchivador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_siaf")
    private int nSiaf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fto_financ")
    private String ftoFinanc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ano_comprob")
    private String anoComprob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_comprob")
    private int nComprob;

    public ArchiDetallePK() {
    }

    public ArchiDetallePK(String anoEje, int nArchivador, int nSiaf, String ftoFinanc, String anoComprob, int nComprob) {
        this.anoEje = anoEje;
        this.nArchivador = nArchivador;
        this.nSiaf = nSiaf;
        this.ftoFinanc = ftoFinanc;
        this.anoComprob = anoComprob;
        this.nComprob = nComprob;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public int getNArchivador() {
        return nArchivador;
    }

    public void setNArchivador(int nArchivador) {
        this.nArchivador = nArchivador;
    }

    public int getNSiaf() {
        return nSiaf;
    }

    public void setNSiaf(int nSiaf) {
        this.nSiaf = nSiaf;
    }

    public String getFtoFinanc() {
        return ftoFinanc;
    }

    public void setFtoFinanc(String ftoFinanc) {
        this.ftoFinanc = ftoFinanc;
    }

    public String getAnoComprob() {
        return anoComprob;
    }

    public void setAnoComprob(String anoComprob) {
        this.anoComprob = anoComprob;
    }

    public int getNComprob() {
        return nComprob;
    }

    public void setNComprob(int nComprob) {
        this.nComprob = nComprob;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (int) nArchivador;
        hash += (int) nSiaf;
        hash += (ftoFinanc != null ? ftoFinanc.hashCode() : 0);
        hash += (anoComprob != null ? anoComprob.hashCode() : 0);
        hash += (int) nComprob;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchiDetallePK)) {
            return false;
        }
        ArchiDetallePK other = (ArchiDetallePK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.nArchivador != other.nArchivador) {
            return false;
        }
        if (this.nSiaf != other.nSiaf) {
            return false;
        }
        if ((this.ftoFinanc == null && other.ftoFinanc != null) || (this.ftoFinanc != null && !this.ftoFinanc.equals(other.ftoFinanc))) {
            return false;
        }
        if ((this.anoComprob == null && other.anoComprob != null) || (this.anoComprob != null && !this.anoComprob.equals(other.anoComprob))) {
            return false;
        }
        if (this.nComprob != other.nComprob) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.ArchiDetallePK[ anoEje=" + anoEje + ", nArchivador=" + nArchivador + ", nSiaf=" + nSiaf + ", ftoFinanc=" + ftoFinanc + ", anoComprob=" + anoComprob + ", nComprob=" + nComprob + " ]";
    }
    
}
