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
public class OficinaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codarea")
    private String codarea;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codoficina")
    private String codoficina;

    public OficinaPK() {
    }

    public OficinaPK(String codarea, String codoficina) {
        this.codarea = codarea;
        this.codoficina = codoficina;
    }

    public String getCodarea() {
        return codarea;
    }

    public void setCodarea(String codarea) {
        this.codarea = codarea;
    }

    public String getCodoficina() {
        return codoficina;
    }

    public void setCodoficina(String codoficina) {
        this.codoficina = codoficina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codarea != null ? codarea.hashCode() : 0);
        hash += (codoficina != null ? codoficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OficinaPK)) {
            return false;
        }
        OficinaPK other = (OficinaPK) object;
        if ((this.codarea == null && other.codarea != null) || (this.codarea != null && !this.codarea.equals(other.codarea))) {
            return false;
        }
        if ((this.codoficina == null && other.codoficina != null) || (this.codoficina != null && !this.codoficina.equals(other.codoficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.munisoft.model.OficinaPK[ codarea=" + codarea + ", codoficina=" + codoficina + " ]";
    }
    
}
