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

/**
 *
 * @author Jorik
 */
@Embeddable
public class CompraDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_compra")
    private int idCompra;
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;

    public CompraDetallePK() {
    }

    public CompraDetallePK(int idCompra, int idArticulo) {
        this.idCompra = idCompra;
        this.idArticulo = idArticulo;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
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
        hash += (int) idCompra;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraDetallePK)) {
            return false;
        }
        CompraDetallePK other = (CompraDetallePK) object;
        if (this.idCompra != other.idCompra) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.CompraDetallePK[ idCompra=" + idCompra + ", idArticulo=" + idArticulo + " ]";
    }
    
}
