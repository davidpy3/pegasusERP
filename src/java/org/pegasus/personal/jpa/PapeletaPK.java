/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pegasus.personal.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Erick alarcon
 */
@Embeddable
public class PapeletaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "n_papeleta")
    private String nPapeleta;

    public PapeletaPK() {
    }

    public PapeletaPK(String anoEje, String nPapeleta) {
        this.anoEje = anoEje;
        this.nPapeleta = nPapeleta;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public String getNPapeleta() {
        return nPapeleta;
    }

    public void setNPapeleta(String nPapeleta) {
        this.nPapeleta = nPapeleta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (nPapeleta != null ? nPapeleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PapeletaPK)) {
            return false;
        }
        PapeletaPK other = (PapeletaPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if ((this.nPapeleta == null && other.nPapeleta != null) || (this.nPapeleta != null && !this.nPapeleta.equals(other.nPapeleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.PapeletaPK[ anoEje=" + anoEje + ", nPapeleta=" + nPapeleta + " ]";
    }
    
}
