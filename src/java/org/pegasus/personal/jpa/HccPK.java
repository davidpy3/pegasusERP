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
public class HccPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ano_eje")
    private String anoEje;
    @Basic(optional = false)
    @Column(name = "n_hcc")
    private int nHcc;

    public HccPK() {
    }

    public HccPK(String anoEje, int nHcc) {
        this.anoEje = anoEje;
        this.nHcc = nHcc;
    }

    public String getAnoEje() {
        return anoEje;
    }

    public void setAnoEje(String anoEje) {
        this.anoEje = anoEje;
    }

    public int getNHcc() {
        return nHcc;
    }

    public void setNHcc(int nHcc) {
        this.nHcc = nHcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (anoEje != null ? anoEje.hashCode() : 0);
        hash += (int) nHcc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HccPK)) {
            return false;
        }
        HccPK other = (HccPK) object;
        if ((this.anoEje == null && other.anoEje != null) || (this.anoEje != null && !this.anoEje.equals(other.anoEje))) {
            return false;
        }
        if (this.nHcc != other.nHcc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication1.HccPK[ anoEje=" + anoEje + ", nHcc=" + nHcc + " ]";
    }
    
}
