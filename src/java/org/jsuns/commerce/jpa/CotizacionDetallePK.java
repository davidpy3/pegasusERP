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
public class CotizacionDetallePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_cotizacion")
    private int idCotizacion;
    @Basic(optional = false)
    @Column(name = "id_articulo")
    private int idArticulo;

    public CotizacionDetallePK() {
    }

    public CotizacionDetallePK(int idCotizacion, int idArticulo) {
        this.idCotizacion = idCotizacion;
        this.idArticulo = idArticulo;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
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
        hash += (int) idCotizacion;
        hash += (int) idArticulo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CotizacionDetallePK)) {
            return false;
        }
        CotizacionDetallePK other = (CotizacionDetallePK) object;
        if (this.idCotizacion != other.idCotizacion) {
            return false;
        }
        if (this.idArticulo != other.idArticulo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jsuns.commerce.model2.CotizacionDetallePK[ idCotizacion=" + idCotizacion + ", idArticulo=" + idArticulo + " ]";
    }
    
}
