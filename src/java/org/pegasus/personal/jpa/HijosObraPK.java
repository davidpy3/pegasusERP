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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author TOSHIBA
 */
@Embeddable
public class HijosObraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "docuiden")
    private String docuiden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nhijo")
    private int nhijo;

    public HijosObraPK() {
    }

    public HijosObraPK(String docuiden, int nhijo) {
        this.docuiden = docuiden;
        this.nhijo = nhijo;
    }

    public String getDocuiden() {
        return docuiden;
    }

    public void setDocuiden(String docuiden) {
        this.docuiden = docuiden;
    }

    public int getNhijo() {
        return nhijo;
    }

    public void setNhijo(int nhijo) {
        this.nhijo = nhijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docuiden != null ? docuiden.hashCode() : 0);
        hash += (int) nhijo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HijosObraPK)) {
            return false;
        }
        HijosObraPK other = (HijosObraPK) object;
        if ((this.docuiden == null && other.docuiden != null) || (this.docuiden != null && !this.docuiden.equals(other.docuiden))) {
            return false;
        }
        if (this.nhijo != other.nhijo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.HijosObraPK[ docuiden=" + docuiden + ", nhijo=" + nhijo + " ]";
    }
    
}
