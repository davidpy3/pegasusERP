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

@Embeddable
public class JudicialObraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "docuiden")
    private String docuiden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "docudem")
    private String docudem;

    public JudicialObraPK() {
    }

    public JudicialObraPK(String docuiden, String docudem) {
        this.docuiden = docuiden;
        this.docudem = docudem;
    }

    public String getDocuiden() {
        return docuiden;
    }

    public void setDocuiden(String docuiden) {
        this.docuiden = docuiden;
    }

    public String getDocudem() {
        return docudem;
    }

    public void setDocudem(String docudem) {
        this.docudem = docudem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docuiden != null ? docuiden.hashCode() : 0);
        hash += (docudem != null ? docudem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JudicialObraPK)) {
            return false;
        }
        JudicialObraPK other = (JudicialObraPK) object;
        if ((this.docuiden == null && other.docuiden != null) || (this.docuiden != null && !this.docuiden.equals(other.docuiden))) {
            return false;
        }
        if ((this.docudem == null && other.docudem != null) || (this.docudem != null && !this.docudem.equals(other.docudem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.JudicialObraPK[ docuiden=" + docuiden + ", docudem=" + docudem + " ]";
    }
    
}
