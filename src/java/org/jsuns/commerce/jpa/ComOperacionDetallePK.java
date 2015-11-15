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
public class ComOperacionDetallePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_item")
    private int idItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_operacion")
    private int idOperacion;

    public ComOperacionDetallePK() {
    }

    public ComOperacionDetallePK(int idItem, int idOperacion) {
        this.idItem = idItem;
        this.idOperacion = idOperacion;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idItem;
        hash += (int) idOperacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComOperacionDetallePK)) {
            return false;
        }
        ComOperacionDetallePK other = (ComOperacionDetallePK) object;
        if (this.idItem != other.idItem) {
            return false;
        }
        if (this.idOperacion != other.idOperacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.ComOperacionDetallePK[ idItem=" + idItem + ", idOperacion=" + idOperacion + " ]";
    }
    
}
