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
public class AfectacionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipo_trab")
    private String tipoTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "codigo")
    private String codigo;

    public AfectacionesPK() {
    }

    public AfectacionesPK(String tipoTrab, String codigo) {
        this.tipoTrab = tipoTrab;
        this.codigo = codigo;
    }

    public String getTipoTrab() {
        return tipoTrab;
    }

    public void setTipoTrab(String tipoTrab) {
        this.tipoTrab = tipoTrab;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoTrab != null ? tipoTrab.hashCode() : 0);
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AfectacionesPK)) {
            return false;
        }
        AfectacionesPK other = (AfectacionesPK) object;
        if ((this.tipoTrab == null && other.tipoTrab != null) || (this.tipoTrab != null && !this.tipoTrab.equals(other.tipoTrab))) {
            return false;
        }
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.AfectacionesPK[ tipoTrab=" + tipoTrab + ", codigo=" + codigo + " ]";
    }
    
}
