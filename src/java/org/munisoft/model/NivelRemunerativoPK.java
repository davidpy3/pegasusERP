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
public class NivelRemunerativoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_trab")
    private String tipoTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "nivel_rem")
    private String nivelRem;

    public NivelRemunerativoPK() {
    }

    public NivelRemunerativoPK(String tipoTrab, String nivelRem) {
        this.tipoTrab = tipoTrab;
        this.nivelRem = nivelRem;
    }

    public String getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public String getNivelRem() {
        return nivelRem;
    }

    public void setNivelRem(String nivelRem) {
        this.nivelRem = nivelRem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoTrab != null ? tipoTrab.hashCode() : 0);
        hash += (nivelRem != null ? nivelRem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelRemunerativoPK)) {
            return false;
        }
        NivelRemunerativoPK other = (NivelRemunerativoPK) object;
        if ((this.tipoTrab == null && other.tipoTrab != null) || (this.tipoTrab != null && !this.tipoTrab.equals(other.tipoTrab))) {
            return false;
        }
        if ((this.nivelRem == null && other.nivelRem != null) || (this.nivelRem != null && !this.nivelRem.equals(other.nivelRem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.NivelRemunerativoPK[ tipoTrab=" + tipoTrab + ", nivelRem=" + nivelRem + " ]";
    }
    
}
