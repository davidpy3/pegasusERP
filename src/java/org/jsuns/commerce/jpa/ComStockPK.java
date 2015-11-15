/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsuns.commerce.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jorik
 */
@Embeddable
public class ComStockPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private int idDep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_articulo")
    private int idArticulo;

    public ComStockPK() {
    }

    public ComStockPK(int idDep, int idArticulo) {
        this.idDep = idDep;
        this.idArticulo = idArticulo;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDep;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComStockPK)) {
            return false;
        }
        ComStockPK other = (ComStockPK) object;
        if (this.idDep != other.idDep) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComStockPK[ idDep=" + idDep + ", idArticulo=" + idArticulo + " ]";
    }
    
}
