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
public class AmbientePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "codlocal")
    private String codlocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codambiente")
    private String codambiente;

    public AmbientePK() {
    }

    public AmbientePK(String codlocal, String codambiente) {
        this.codlocal = codlocal;
        this.codambiente = codambiente;
    }

    public String getCodlocal() {
        return codlocal;
    }

    public void setCodlocal(String codlocal) {
        this.codlocal = codlocal;
    }

    public String getCodambiente() {
        return codambiente;
    }

    public void setCodambiente(String codambiente) {
        this.codambiente = codambiente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codlocal != null ? codlocal.hashCode() : 0);
        hash += (codambiente != null ? codambiente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AmbientePK)) {
            return false;
        }
        AmbientePK other = (AmbientePK) object;
        if ((this.codlocal == null && other.codlocal != null) || (this.codlocal != null && !this.codlocal.equals(other.codlocal))) {
            return false;
        }
        if ((this.codambiente == null && other.codambiente != null) || (this.codambiente != null && !this.codambiente.equals(other.codambiente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.AmbientePK[ codlocal=" + codlocal + ", codambiente=" + codambiente + " ]";
    }
    
}
