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
public class AlmacenArticuloPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;
    @Basic(optional = false)
    @Column(name = "id_almacen")
    private int idAlmacen;

    public AlmacenArticuloPK() {
    }

    public AlmacenArticuloPK(int idAlmacen,int idArticulo) {
        this.idArticulo = idArticulo;
        this.idAlmacen = idAlmacen;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArticulo;
        hash += (int) idAlmacen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlmacenArticuloPK)) {
            return false;
        }
        AlmacenArticuloPK other = (AlmacenArticuloPK) object;
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        if (this.idAlmacen != other.idAlmacen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.AlmacenArticuloPK[ idArticulo=" + idArticulo + ", idAlmacen=" + idAlmacen + " ]";
    }
    
}
